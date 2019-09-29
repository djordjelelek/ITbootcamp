package zadaca7i8;

import java.util.Scanner;

public class Picerija {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodosli u SRBIJAKASA - pametnu kasu!");
		String dan = dani();
		int musterija = 1;
		int po_danu = 0;
		int po_osobi = 0;
		do {
			System.out.print("----------------------------" + "\n" + "RACUN" + 
								"\n" + "Musterija id#" + musterija + ": ");
			po_osobi = sc.nextInt();
			po_danu = narucivanje(po_osobi, po_danu, dan);
			musterija = noviMusterija(musterija);
		} while (musterija > 0);
		sc.close();

	}

	static String dani() {
		sc = new Scanner(System.in);
		System.out.print("Koji je danas dan: ");
		String dan = sc.nextLine();
		while (!dan.equals("pon") && !dan.equals("uto") && !dan.equals("sri") && !dan.equals("cet")
				&& !dan.equals("pet") && !dan.equals("sub") && !dan.equals("ned")) {

			System.out.println("Greska u unosu. Molimo vas unesite ponovo: ");
			dan = sc.nextLine();
		}
		System.out.println("\n" + "\n" + "\n");
		return dan;

	}

	static int narucivanje(int po_osobi, int po_danu, String dan) {
		sc = new Scanner(System.in);
		int suma_kapr = 0;
		int suma_vez = 0;
		int suma_pep = 0;
		int cijena_kapr = 320;
		int cijena_pep = 290;
		int cijena_vez = 310;
		int snizena_cijena = 0;
		String kapr = "Kapricoza";
		String vez = "Vezuvio";
		String pep = "Peperoni";
		int suma = 0;
		for (int i = 1; i <= po_osobi; i++) {
			po_danu++;
			int x = sc.nextInt();
			switch (x) {
			case 2:
				snizena_cijena = akcije4i7(cijena_kapr, kapr, i, po_danu);
				suma_kapr += snizena_cijena;
				break;
			case 3:
				snizena_cijena = akcije4i7(cijena_vez, vez, i, po_danu);
				suma_vez += snizena_cijena;
				break;
			case 5:
				snizena_cijena = akcije4i7(cijena_pep, pep, i, po_danu);
				suma_pep += snizena_cijena;
				break;
			default:
				System.out.print("Greska u unosu. Pokusajte ponovo: ");
				i--;
				po_danu--;
			}
			snizena_cijena = 0;
		}
		suma = suma_kapr + suma_vez + suma_pep;
		System.out.println("\t ukupno: " + suma);

		switch (dan) {
		case "uto":
			System.out
					.println("Dnevna 10% Vezuvio -" + (suma_vez / 10) + "\n" + "\t ukupno: " + (suma -= suma_vez / 10));
			break;
		case "cet":
			System.out.println(
					"Dnevna 10% Vezuvio -" + (suma_kapr / 10) + "\n" + "\t ukupno: " + (suma -= suma_kapr / 10));
			break;
		case "sub":
			System.out.println("Dnevna 15% sve -" + (suma / 10) + "\n" + "\t ukupno: " + (suma -= suma / 10));
			break;
		case "ned":
			System.out.println("Dnevna 15% sve -" + (suma / 10) + "\n" + "\t ukupno: " + (suma -= suma / 10));
			break;
		default:
			System.out.println("Dnevna snizenja: NEMA");
		}
		System.out.println("----------------------------");

		return (po_danu);

	}

	static int akcije4i7(int cijena, String naziv, int i, int po_danu) {
		if (i % 4 == 0) {
			System.out.print("Akcija 3+1 " + naziv + " 0" + "\n");
			cijena = 0;
		} else if (po_danu % 7 == 0) {
			System.out.print("Akcija #7 " + naziv + " 0" + "\n");
			cijena = 0;
		} else {
			System.out.println("Pica " + naziv + " " + cijena);
		}
		return (cijena);
	}

	static int noviMusterija(int musterija) {
		sc = new Scanner(System.in);
		int opcija = 1;
		while (opcija != 0) {
			System.out.println("Da li imate novog musteriju? " + "Pritisnite 1 ako imate ili -1 ako nemate");
			opcija = sc.nextInt();
			if (opcija == -1) {
				musterija = -1;
				break;
			} else if (opcija == 1) {
				musterija++;
				break;
			} else {
				System.out.println("Greska u unosu! Molimo Vas pokusajte ponovo: ");

			}
		}
		return (musterija);

	}

}
