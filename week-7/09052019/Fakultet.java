package fakultet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fakultet {
	String string;
	Connection konekcija;

	public Fakultet(String string) {
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

	public void dodajStudenta(int indeks, String ime, String prezime, String datumUpisa, String datumRodjenja,
			String mestoRodjenja) {
		try {
			String upit = "INSERT INTO dosije(indeks,ime,prezime,datum_upisa,datum_rodjenja,mesto_rodjenja) "
					+ " VALUES (" + indeks + ", '" + ime + "', '" + prezime + "', '" + datumUpisa + "', '"
					+ datumRodjenja + "', '" + mestoRodjenja + "')";
			Statement st = konekcija.createStatement();
			st.executeUpdate(upit);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void brisanjeIspita() {
		try {
			String upit = "DELETE FROM ispit " + "WHERE ocena NOT BETWEEN 5 and 10";
			Statement st = konekcija.createStatement();
			st.executeUpdate(upit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setDatumRodjenja(int indeks, String datumRodjenja) {
		try {
			String upit = "UPDATE dosije " + "SET datum_rodjenja ='" + datumRodjenja + "' WHERE indeks =" + indeks;
			Statement st = konekcija.createStatement();
			st.executeUpdate(upit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ispisPredmeti() {
		try {
			String upit = "SELECT * " + "FROM predmet";
			Statement st = konekcija.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				int idPredmeta = rs.getInt(1);
				String sifra = rs.getString("sifra");
				String naziv = rs.getString("naziv");
				int bodovi = rs.getInt(4);
				System.out.println(idPredmeta + "   " + sifra + "   " + naziv + "   " + bodovi);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void studentiIzBeograda() {
		try {
			String upit = "SELECT * " + "FROM dosije " + "WHERE mesto_rodjenja = \"Beograd\"";
			Statement st = konekcija.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				int indeks = rs.getInt(1);
				String ime = rs.getString(2);
				String prezime = rs.getString(3);
				String datumUpisa = rs.getString(4);
				String datumRodjenja = rs.getString(5);
				String mjesto = rs.getString(6);
				System.out.println(indeks + " " + ime + " " + prezime + " " + datumUpisa + " " + datumRodjenja + " " + mjesto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mjestaRodjenja() {
		try {
			String upit = "SELECT DISTINCT (mesto_rodjenja)" + "FROM dosije " + "WHERE mesto_rodjenja IS NOT NULL;";
			Statement st = konekcija.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				String mjestoRodjenja = rs.getString(1);
				System.out.println(mjestoRodjenja);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void predmetiViseOd6Bodova() {
		try {
			String upit = "SELECT naziv " + "FROM predmet " + "WHERE bodovi>6;";
			Statement st = konekcija.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				String naziv = rs.getString(1);
				System.out.println(naziv);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void predmetiizmedju6i15() {
		try {
			String upit = "SELECT sifra, naziv " + "FROM predmet " + "WHERE bodovi BETWEEN 8 and 15;";
			Statement st = konekcija.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				String sifra = rs.getString(1);
				String naziv = rs.getString(2);

				System.out.println(sifra + " " + naziv);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void cijenaIspita() {
		try {
			String upit = "SELECT naziv, bodovi, bodovi*1500 as \"Cijena ispita\"" + "FROM predmet";
			Statement st = konekcija.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				String naziv = rs.getString(1);
				int bodovi = rs.getInt(2);
				int cijena = rs.getInt(3);

				System.out.println(naziv + " " + bodovi + " " + cijena);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void bodovi81i76i59() {
		try {
			String upit = "SELECT * " + "FROM ispit " + "WHERE bodovi=81 or bodovi=76 or bodovi=59";
			Statement st = konekcija.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				int indeks = rs.getInt(1);
				int id = rs.getInt(2);
				int godina = rs.getInt(3);
				String oznaka = rs.getString(4);
				int ocjena = rs.getInt(5);
				String datumIspita = rs.getString(6);
				int bodovi = rs.getInt(7);
				System.out.println(indeks + " " + id + " " + godina + " " + oznaka + " " + ocjena + " " + datumIspita
						+ " " + bodovi);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void bodoviNisu81i76i59() {
		try {
			String upit = "SELECT * " + "FROM ispit " + "WHERE bodovi!=81 AND bodovi!=76 AND bodovi!=59;";
			Statement st = konekcija.createStatement();
			ResultSet rs = st.executeQuery(upit);
			while (rs.next()) {
				int indeks = rs.getInt(1);
				int id = rs.getInt(2);
				int godina = rs.getInt(3);
				String oznaka = rs.getString(4);
				int ocjena = rs.getInt(5);
				String datumIspita = rs.getString(6);
				int bodovi = rs.getInt(7);
				System.out.println(indeks + " " + id + " " + godina + " " + oznaka + " " + ocjena + " " + datumIspita
						+ " " + bodovi);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
