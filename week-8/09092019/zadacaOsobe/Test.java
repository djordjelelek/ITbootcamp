package zadacaOsobe;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Koliko objekata klase zelite?");
		int i = sc.nextInt();
		Osoba[] nizOsoba = new Osoba[i];
		for (int j = 0; j < i; j++) {
			System.out.println("Unesite ime i prezime osobe:");
			String ime = sc.nextLine();
			String prezime = sc.nextLine();
			System.out.println("Unesite adresu osobe:");
			String adresa = sc.nextLine();
			System.out.println("Izaberite jednu od dvije opcije:" + "\n\t1.datum" + "\n\t2.JMBG");
			int opcija = sc.nextInt();
			if (opcija == 1) {
				boolean b = false;
				while (b == false) {
					System.out.println("Unesite datum rodjenja:");
					String datum = sc.next();
					Datum date = new Datum();
					b = date.provjeraDatuma(datum);
					if (b == false)
						continue;
					date.setDatum(datum);
					OsobaDatum od = new OsobaDatum(ime, prezime, adresa, date);
					nizOsoba[j] = od;
				}

			} else if (opcija == 2) {
				boolean b = false;
				while (b == false) {
					System.out.println("Unesite JMBG:");
					String jmbg = sc.next();
					OsobaJMBG o = new OsobaJMBG(ime, prezime, adresa);
					b = o.setJMBG(jmbg);
					if (b == false)
						continue;
					nizOsoba[j] = o;

				}

			}
		}
		boolean b = false;
		Datum danasnji = new Datum();
		while (b == false) {
			System.out.println("Unesite danasnji datum u obliku dd.mm.gggg. : ");
			String datum = sc.next();
			b = danasnji.provjeraDatuma(datum);
			if (b == false)
				continue;
			else
				danasnji.setDatum(datum);
			;

		}
		for (Osoba osoba : nizOsoba) {
			System.out.println(osoba);
			if (osoba.numeroloskiBroj() != 7) {
				System.out.print("NUMEROLOSKI BROJ: ");
				System.out.println(osoba.numeroloskiBroj());
			}
			String met = osoba.metabolizam(danasnji);
			boolean bul = true;
			for (int k = 0; k < met.length(); k++) {
				if (met.charAt(k) == '0') {
					bul = false;
					break;
				}
			}
			System.out.print("METABOLIZAM: ");
			if (bul == true)
				System.out.println(osoba.metabolizam(danasnji));
			else
				System.out.println("U metabolizmu se nalazi nula");
			System.out.println(osoba.metabolizam(danasnji));
		}

		sc.close();

	}

}
