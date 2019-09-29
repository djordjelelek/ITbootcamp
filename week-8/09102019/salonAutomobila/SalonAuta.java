package salonAutomobila;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class SalonAuta {
	String cs;
	Connection co;
	private Scanner sc;

	public SalonAuta(String cs) {
		super();
		this.cs = cs;
	}

	public void connection() {
		try {
			co = DriverManager.getConnection(cs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void disconnect() {
		try {
			if (co != null && !co.isClosed())
				co.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void meniUlazni() {
		Scanner sc = new Scanner(System.in);
		System.out.println("DOBRODOSLI U PRODAVNICU AUTOMOBILA MISELINKO SRBIJA" + "\n");
		System.out.println("Prijava/Registacija: ");
		System.out
				.println("\t 1.Prijava" + "\n\t 2.Registracija\n" + "Molimo vas izaberite jednu od ove dvije opcije.");
		boolean b = false;
		while (b == false) {
			String i = sc.nextLine();
			if (i.equals("1")) {
				prijavaKorisnika();
				break;
			} else if (i.equals("2")) {
				registracijaKorisnika();
				prijavaKorisnika();
				break;
			} else
				System.out.println("Pogresan unos! Molimo vas izaberite jednu od ove dvije ponudjene opcije.");
		}
		System.out.println("\n \n \n");
		System.out.println("\nHVALA VAM NA KORISCENJU NASEG SERVISA.....MISELIN SRBIJA");

	}

	private void meniKorisnik(String user) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Molimo vas izaberite jednu od ove dvije opcije:");
		System.out.println("\t 1.Kupovina auta" + "\n\t 2.Uplata novca");
		boolean b = false;
		while (b == false) {
			String i = sc.nextLine();
			if (i.equals("1")) {
				kupovinaAutomobila(user);
				break;
			} else if (i.equals("2")) {
				uplataNovca(user);
				break;
			} else
				System.out.println("Pogresan unos! Molimo vas izaberite jednu od ove dvije ponudjene opcije.");
		}

	}

	private void meniRadnik() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Molimo vas izaberite jednu od ove dvije opcije:");
		System.out.println("\t 1.Promjena cijene" + "\n\t 2.Nabavka");
		boolean b = false;
		while (b == false) {
			String i = sc.nextLine();
			if (i.equals("1")) {
				promjenaCijene();
				break;
			} else if (i.equals("2")) {
				nabavka();
				break;
			} else
				System.out.println("Pogresan unos! Molimo vas izaberite jednu od ove dvije ponudjene opcije.");
		}

	}

	private void nabavka() {
		Scanner sc = new Scanner(System.in);
		try {
			Statement stm = co.createStatement();
			String upit = "SELECT m.IdModel, Naziv, Cena "
					+ "FROM Model m LEFT JOIN (Automobil) ON (m.IdModel = Automobil.IdModel) "
					+ "WHERE Naziv IS NOT NULL " + "GROUP BY m.IdModel";
			ResultSet rs = stm.executeQuery(upit);
			int idModel = 0;
			int cijena = 0;
			String naziv = "";
			ArrayList<Integer> lista = new ArrayList<Integer>();
			while (rs.next()) {
				idModel = rs.getInt(1);
				lista.add(idModel);
				naziv = rs.getString(2);
				cijena = rs.getInt(3);
				System.out.println("ID: " + idModel + ", Naziv automobila: \"" + naziv + "\"" + ", CIJENA: " + cijena);

			}
			System.out.println("IZABERITE ID AUTOMOBILA ZA NABAVKU");
			int i = 0;
			boolean b = false;
			while (b == false) {
				i = sc.nextInt();
				for (Integer in : lista) {
					if (in == i) {
						b = true;
						break;
					}
				}
				if (b == true) {
					break;
				} else {
					System.out.println(
							"Ne postoji automobil koji mozete kupiti sa tim ID-om! Izaberite automobil s pravilnim ID-om!");
					continue;
				}
			}
			String upit2 = "SELECT max(idAuto) FROM Automobil ";
			rs = stm.executeQuery(upit2);
			int idAuto = rs.getInt(1);
			String upit3 = "INSERT INTO Automobil (IdModel, Cena, IdDob, Status) " + "VALUES( " + i + ", " + cijena
					+ ", 2, " + "'n'); " + "INSERT INTO Nabavka(IdAuto, NabavnaCena) " + "VALUES( " + (idAuto + 1)
					+ ", " + cijena + ");";
			stm.executeUpdate(upit3);
			String upit4 = "UPDATE Model SET BrNabavljenih =  BrNabavljenih + 1 WHERE IdModel = " + i;
			stm.executeUpdate(upit4);
			System.out.println("USpjesno ste kupili automobil!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void promjenaCijene() {
		Scanner sc = new Scanner(System.in);
		try {
			Statement stm = co.createStatement();
			String upit = "SELECT IdAuto, Cena, BrNabavljenih-BrProdatih, Naziv "
					+ "FROM Automobil a LEFT JOIN (Model) ON (a.IdModel = Model.IdModel) ";
			ResultSet rs = stm.executeQuery(upit);
			int id = 0;
			int cijena = 0;
			int brojStanje = 0;
			ArrayList<Integer> lista = new ArrayList<Integer>();
			while (rs.next()) {
				id = rs.getInt(1);
				lista.add(id);
				cijena = rs.getInt(2);
				brojStanje = rs.getInt(3);
				String naziv = rs.getString(4);
				System.out.println("ID: " + id + ", CIJENA: " + cijena + ", Na stanju: " + brojStanje
						+ ", Naziv automobila: \"" + naziv + "\"");

			}
			System.out.println("IZABERITE ID AUTOMOBILA ZA PROMJENU CIJENE");
			int i = 0;
			boolean b = false;
			while (b == false) {
				i = sc.nextInt();
				for (Integer in : lista) {
					if (in == i) {
						b = true;
						break;
					}
				}
				if (b == true) {
					break;
				} else {
					System.out.println("Niste kupili automobil sa tim ID-om! Izaberite automobil s pravilnim ID-om!");
					continue;
				}
			}
			System.out.println("Koliku cijenu zelite da postavite za izabrani automobil?");
			int novaCijena = sc.nextInt();
			String upit2 = "UPDATE Automobil " + "SET Cena =  " + novaCijena + " WHERE IdAuto =  " + i;
			stm.executeUpdate(upit2);
			System.out.println("Uspjesno ste promijenili cijenu automobilu!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void prijavaKorisnika() {

		try {
			String user = "";
			boolean b = false;
			while (b == false) {
				Scanner sc = new Scanner(System.in);
				System.out.println("PRIJAVA KORISNIKA");
				System.out.println("Unijeti username: ");
				user = sc.nextLine();
				String upit = "select COUNT(*) " + "from Korisnik k " + " where k.Username = \"" + user + "\"";
				Statement stm = co.createStatement();
				ResultSet rs = stm.executeQuery(upit);
				int i = rs.getInt(1);
				if (i == 0) {
					System.out.println("Ne postoji korisnik pod tim imenom!");
					continue;
				}
				int j = 0;
				while (j < 3) {
					b = provjeraSifre(user);
					if (b == true) {
						break;
					} else
						j++;
				}
				if (b == true) {
					if (user.equals("admin")) {
						System.out.println("Uspjesna prijava radnika");
						meniRadnik();
						break;
					} else {
						System.out.println("Uspjesna prijava korisnika!");
						meniKorisnik(user);
						break;
					}
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private boolean provjeraSifre(String user) {
		boolean b = false;
		try {
			Scanner sc = new Scanner(System.in);
			Statement stm = co.createStatement();
			System.out.println("Sifra: ");
			String pass = sc.nextLine();
			String upit = "select COUNT(*) " + "FROM Korisnik k " + "WHERE k.Username = \"" + user
					+ "\" AND k.Password = \"" + pass + "\"";
			ResultSet rs = stm.executeQuery(upit);
			b = rs.getBoolean(1);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (b == true)
			return true;
		else
			return false;

	}

	private void registracijaKorisnika() {

		try {
			Scanner sc = new Scanner(System.in);
			String user = "";
			boolean b = false;
			while (b == false) {
				System.out.println("REGISTRACIJA KORISNIKA");
				System.out.println("Unesite koje korisnicko ime zelite: ");
				user = sc.nextLine();
				for (int j = 0; j < user.length(); j++) {
					if (user.charAt(j) == ' ') {
						System.out.println("Ne moze se imati blanko znak u vasem imenu!");
						b = false;
						break;
					} else
						b = true;
				}
				if (b == false)
					continue;
				String upit = "select COUNT(*) " + "from Korisnik k " + " where k.Username = \"" + user + "\"";
				Statement stm = co.createStatement();
				ResultSet rs = stm.executeQuery(upit);
				int i = rs.getInt(1);
				if (i == 1) {
					System.out.println("Username vec postoji!");
					b = false;
				} else
					b = true;
				sifra(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void sifra(String user) {
		sc = new Scanner(System.in);
		boolean b = false;
		String sifra = "";
		while (b == false) {
			System.out.println("Unesite koju sifru zelite: ");
			sifra = sc.nextLine();
			for (int i = 0; i < sifra.length(); i++) {
				if (sifra.charAt(i) == ' ') {
					System.out.println("Blanko znak");
					b = false;
					break;
				} else
					b = true;
			}
			if (b == false)
				continue;
			if (sifra.length() < 5) {
				System.out.println("Prekratka sifra");
				b = false;
			}
			if (b == false)
				continue;
			else {
				try {
					String upit = "INSERT INTO Korisnik (Username, Password) " + "VALUES (\"" + user + "\", \"" + sifra
							+ "\")";
					Statement stm = co.createStatement();
					stm.executeUpdate(upit);

				} catch (SQLException e) {
					e.printStackTrace();
				}

				System.out.println("Uspjesna registracija");
			}

		}

	}

	private void kupovinaAutomobila(String user) {
		Scanner sc = new Scanner(System.in);
		try {
			Statement stm = co.createStatement();
			String upit = "SELECT a.IdAuto, Naziv, Cena, count(BrNabavljenih), a.IdMODEL "
					+ "FROM Automobil a LEFT JOIN (Model) ON (a.IdModel = Model.IdModel) "
					+ "WHERE Status = 'n' AND Model.BrNabavljenih > Model.BrProdatih " + "GROUP BY a.IdModel";
			ResultSet rs = stm.executeQuery(upit);
			ArrayList<Integer> listaID = new ArrayList<Integer>();
			int model = 0;
			boolean b1 = true;
			while (rs.next()) {
				int id = rs.getInt(1);
				listaID.add(id);
				String naziv = rs.getString(2);
				int cijena = rs.getInt(3);
				int nabavljeni = rs.getInt(4);
				model = rs.getInt(5);
				System.out.println("ID: " + id + ", MODEL: " + naziv + ", CIJENA: " + cijena
						+ ", BROJ AUTOMOBILA NA STANJU: " + nabavljeni);
				System.out.println("IZABERITE ID AUTOMOBILA KOJEG ZELITE DA KUPITE");
				b1 = false;
			}
			if (b1 == true) {
				System.out.println("Nema automobila za prodaju!");
				return;
			}
			boolean b = false;
			while (b == false) {
				int kupovina = sc.nextInt();
				for (Integer i : listaID) {
					if (i == kupovina) {
						b = true;
						break;
					}
				}
				if (b == false) {
					System.out.println("Ne postoji automobil sa tim ID-om! Molimo vas unesite ponovo!");
					continue;
				} else {
					String upit2 = "UPDATE Model " + "SET BrProdatih = BrProdatih + 1 " + "WHERE IdModel =  " + model;
					stm.executeUpdate(upit2);
					String upit3 = "UPDATE Automobil " + "SET Status = 'p' " + "WHERE IdAuto =  " + kupovina;
					stm.executeUpdate(upit3);
					java.sql.Date datum = new java.sql.Date(System.currentTimeMillis());
					String upit4 = "INSERT INTO Prodaja (IdAuto, Username, Datum) " + "VALUES( " + kupovina + ", \""
							+ user + "\", " + datum + ")";
					stm.executeUpdate(upit4);
					System.out.println("Uspjesno ste kupili automobil!");

				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void uplataNovca(String user) {
		try {
			Scanner sc = new Scanner(System.in);
			Statement stm = co.createStatement();
			String upit = "SELECT p.IdAuto, Naziv, Cena, Profit, Model.IdModel "
					+ "FROM Prodaja p LEFT JOIN (Automobil) ON (p.IdAuto = Automobil.IdAuto) "
					+ "LEFT JOIN (Model) ON (Automobil.IdModel = Model.IdModel) " + "WHERE Username = \"" + user + "\"";
			ResultSet rs = stm.executeQuery(upit);
			int id = 0;
			int dug = 0;
			int idModel = 0;
			while (rs.next()) {
				id = rs.getInt(1);
				String naziv = rs.getString(2);
				int cijena = rs.getInt(3);
				dug = rs.getInt(4);
				idModel = rs.getInt(5);

				System.out.println("ID: " + id + ", MODEL: " + naziv + ", CIJENA: " + cijena + ", DUG: " + dug);
				System.out.println("IZABERITE ID AUTOMOBILA ZA UPLATU");
			}
			int i = sc.nextInt();
			while (i != id) {
				System.out.println("NIste kupili automobil sa tim ID-om");
				i = sc.nextInt();
			}
			System.out.println("Koliko novca zelite da uplatite");
			int uplata = sc.nextInt();
			if ((uplata + dug) > 0) {
				System.out.println(
						"Uplatili ste vise nego sto je potrebno, vraceno ce vam biti: " + (uplata + dug) + " evra!");
				dug = 0;
			} else {
				dug = dug + uplata;
			}
			java.sql.Date datum = new java.sql.Date(System.currentTimeMillis());
			String upit2 = "INSERT INTO Uplata (IdAuto, Iznos, Datum) " + "VALUES( " + id + ", " + uplata + ", " + datum
					+ ")";
			stm.executeUpdate(upit2);
			String upit3 = "UPDATE Model " + "SET Profit =  " + dug + " WHERE IdModel =  " + idModel;
			stm.executeUpdate(upit3);
			System.out.println("Uspjesno ste izvrsili uplatu!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
