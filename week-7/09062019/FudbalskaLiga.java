package fudbal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FudbalskaLiga {
	String string;
	Connection konekcija;

	public FudbalskaLiga(String string) {
		super();
		this.string = string;
	}

	public void connect() {
		try {
			konekcija = DriverManager.getConnection(string);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (konekcija != null && !konekcija.isClosed())
				konekcija.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void igraciTimovi() {
		try {
			String upit = "SELECT f.Ime, t.Naziv " + "FROM Fudbaler f, Tim t " + "WHERE f.IdTim = t.IdTim";
			Statement st = konekcija.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				String igrac = rs.getString(1);
				String klub = rs.getString(2);

				System.out.println(igrac + " :  " + klub);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void igraciMancestera() {
		try {
			System.out.println("IGRACI MANCESTERA SU:");
			String upit = "SELECT f.Ime " + "FROM Fudbaler f, Tim t "
					+ "WHERE f.IdTim = t.IdTim AND t.Naziv = \"Manchester United\"";
			Statement st = konekcija.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				String klub = rs.getString(1);
				System.out.println(klub);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void brojGolova() {
		System.out.println("BROJ GOLOVA PO IGRACU: ");
		try {
			String upit = "SELECT f.Ime, count(g.IdFud) " + "FROM Fudbaler f LEFT JOIN Gol g ON (f.IdFud = g.IdFud) "
					+ "GROUP BY f.IdFud";
			Statement st = konekcija.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				String igrac = rs.getString(1);
				int golovi = rs.getInt(2);
				System.out.println(igrac + ": " + golovi);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void najviseGolova() {
		try {
			System.out.println("Najvise golova je postogao igrac:");
			String upit = "SELECT ime, max (BrPostignutih) "
					+ "FROM (SELECT f.Ime as \"ime\", count(g.IdFud) as \"BrPostignutih\" FROM Fudbaler f, Gol g " + 
									"WHERE f.IdFud = g.IdFud  GROUP BY g.IdFud)";
			Statement st = konekcija.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				String igrac = rs.getString(1);
				int golovi = rs.getInt(2);
				System.out.println(igrac + ": " + golovi + " gola");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void kartoni() {
		try {
			System.out.println("IME IGRACA     ZUTI  CRVENI");
			String upit = "SELECT f1.Ime, BrZutih, BrCrvenih FROM Fudbaler f1 " +
							"LEFT JOIN (SELECT f.IdFud as \"id\", count(k.IdFud) as \"BrZutih\" " + 
							"FROM Fudbaler f, Karton k WHERE f.IdFud = k.IdFud AND k.Tip = \"zuti karton\" GROUP BY k.IdFud) ON (f1.IdFud = id)"+
							"LEFT JOIN (SELECT f.IdFud as \"id2\", count(k.IdFud) as \"BrCrvenih\" " + 
							"FROM Fudbaler f, Karton k WHERE f.IdFud = k.IdFud AND k.Tip = \"crveni karton\" " + 
							"GROUP BY k.IdFud) ON (f1.IdFud = id2)";
			Statement st = konekcija.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				String ime = rs.getString(1);
				int crveni = rs.getInt(2);
				int zuti = rs.getInt(3);
				System.out.println(ime + " " + crveni + " " + zuti);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void ubacivanjeIgraca(String fudbaler, String tim) {
		try {
			String upit = "INSERT INTO Fudbaler (IdFud, Ime, IdTim) "
					+ "VALUES ((SELECT  max(IdFud) FROM Fudbaler)+1, \"" + fudbaler
					+ "\", (SELECT IdTim FROM Tim WHERE Naziv = \"" + tim + "\"))";
			Statement st = konekcija.createStatement();
			st.executeUpdate(upit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ubacivanjeTima(String naziv, String mjesto) {
		try {
			String upit = "INSERT INTO Tim (IdTim, Naziv, Mesto) " + "VALUES ((SELECT  max(IdTim) FROM Fudbaler)+1, \""
					+ naziv + "\", \"" + mjesto + "\")";
			Statement st = konekcija.createStatement();
			st.executeUpdate(upit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ubacivanjeUtakmice(String domacin, String gost, int kolo, String ishod, int godina) {
		try {
			String upit = "INSERT INTO Utakmica (IdUta, IdDomacin, IdGost, Kolo, Ishod, Godina) "
					+ "VALUES ((SELECT  max(IdUta) FROM Utakmica)+1, (SELECT IdTim FROM Tim WHERE Naziv =  \"" + domacin
					+ "\"), (SELECT IdTim FROM Tim WHERE Naziv = \"" + gost + "\"), \"" + kolo + "\", \"" + ishod
					+ "\", " + godina + ")";
			Statement st = konekcija.createStatement();
			st.executeUpdate(upit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void gradovi(int id) {
		try {
			System.out.println("IGRAC I GRADOVI U KOJIMA JE IGRAC IGRAO:");
			Statement st = konekcija.createStatement();
			String upit1 = "Select Ime FROM Fudbaler " + "WHERE IdFud = " + id;
			ResultSet rs = st.executeQuery(upit1);
			String ime = rs.getString("Ime");
			System.out.print(ime + ": ");

			String upit2 = "SELECT Tim.Mesto, Tim.IdTim  FROM Tim JOIN (Fudbaler) ON (Tim.IdTim = Fudbaler.IdTim) WHERE IdFud =  "
					+ id;
			rs = st.executeQuery(upit2);

			String grad = "";
			int idTima = 0;
			while (rs.next()) {
				grad = rs.getString("Mesto");
				idTima = rs.getInt("IdTim");
				System.out.print(grad + "(grad u kojem igrac igra)");
			}
			String upit3 = "SELECT B.Mesto FROM " + "(SELECT IdDomacin "
					+ "FROM Tim JOIN (Utakmica) ON (Tim.IdTim = Utakmica.IdGost) " + "WHERE Tim.IdTim = " + idTima
					+ ") as a " + "JOIN Tim AS B\r\n" + "ON A.IdDomacin = B.IdTim";
			rs = st.executeQuery(upit3);
			while (rs.next()) {
				String gosti = rs.getString("Mesto");
				if (grad.equals(gosti))
					continue;
				System.out.print(", " + gosti);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void brisanjeTima(String imeTima) {
		try {
			Statement st = konekcija.createStatement();
			String upit1 = "SELECT IdFud FROM Tim JOIN (Fudbaler) USING (IdTim) WHERE Naziv = \"" + imeTima + "\"";
			ResultSet rs = st.executeQuery(upit1);
			int[] niz = new int[10];
			int i = 0;
			while (rs.next()) {
				niz[i++] = rs.getInt(1);
			}

			for (int j = 0; j < niz.length; j++) {
				if (niz[j] <= 0)
					continue;
				String upitGol = "DELETE FROM Gol WHERE IdFud = " + niz[j];
				st.executeUpdate(upitGol);
				String upitIgrao = "DELETE FROM Igrao WHERE IdFud = " + niz[j];
				st.executeUpdate(upitIgrao);
				String upitKarton = "DELETE FROM Karton WHERE IdFud = " + niz[j];
				st.executeUpdate(upitKarton);
				String upitFudbaler = "DELETE FROM Fudbaler WHERE IdFud = " + niz[j];
				st.executeUpdate(upitFudbaler);
			}
			String upitId = "SELECT IdTim FROM Tim WHERE Naziv = \"" + imeTima + "\"";
			rs = st.executeQuery(upitId);
			int id = rs.getInt(1);
			String upitUtakmica = "DELETE FROM Utakmica WHERE IdDomacin = " + id + " OR IdGost = " + id;
			st.executeUpdate(upitUtakmica);
			String upitTim = "DELETE FROM Tim WHERE IdTim = " + id;
			st.executeUpdate(upitTim);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
