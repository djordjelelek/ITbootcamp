package analizaKnjige;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Analiza {
	private Knjiga knjiga;
	private Rjecnik rjecnik;
	private HashMap<String, Integer> rjecnikMapa = null, prosirenRjecnik = null, cijeli = null;
	private Scanner sc;

	public Analiza(Knjiga knjiga, Rjecnik rjecnik) {
		super();
		this.knjiga = knjiga;
		this.rjecnik = rjecnik;
		cijeli = new HashMap<String, Integer>();
	}

	public void analiziranje() {
		sc = new Scanner(System.in);
		System.out.println("PROGRAM ZA ANALIZU KNJIGE I RJECNIKA\n");

		rjecnik.connection();
		rjecnikMapa = rjecnik.citanjeRjecnika(); // pretvaranje rjecnika u Hash mapu

		knjiga.analizaKnjige(rjecnikMapa); // analiziranje knjige i rjecnika; salje se Hash mapa preuzetog rjecnika

		prosirenRjecnik = knjiga.getProsirenRjecnik(); // preuzimanje prosirenog rjecnika
		rjecnik.prosirivanjeRjecnika(prosirenRjecnik); // ubacivanje prosirenog rjecnika u bazu
		rjecnik.disconnect();

		System.out.println("Uspjesno zavrsena analiza koja je omogucila sljedece stvari:"
				+ "\n\t 1. prosirivanje rjecnika sa rijecima iz knjige, a koje se ne nalaze u rjecniku;"
				+ "\n\t 2. unosenje u bazu podataka takvih rijeci;"
				+ "\n\t 3. broj ponavljanja svake rijeci iz rjecnika u datoj knjizi"
				+ "\n\t 4. upisivanje u fajl svih rijeci (i iz osnovne i iz prosirene verzije rjecnika" + "\n\n");

		cijeli.putAll(rjecnikMapa);
		cijeli.putAll(prosirenRjecnik);

		ispisNajcescihRijeci();
		ispisRijeci();
		upisSveRijeci();
		System.out.println("KRAJ RADA PROGRAMA ZA ANALIZU\n");
		sc.close();

	}

	private void ispisNajcescihRijeci() { // Stampanje broja ponavljanja najcescih rijeci u nizi
		sc = new Scanner(System.in);
		System.out.println(
				"Omoguceno vam je da vidite rijeci koje se najveci broj puta ponavljaju. Koliko najcescih rijeci zelite da vidite?");
		String odgovor = sc.next();
		while (!odgovor.matches("\\d+")) {
			System.out.println("Pogresan unos! Molimo vas unesite samo brojeve." + "\nUnesite broj:");
			odgovor = sc.next();
		}

		int broj = Integer.parseInt(odgovor);

		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(cijeli.entrySet()); // soritranje
																												// HashMap
																												// po
																												// vrijednosti
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		for (int i = list.size() - 1; i > list.size() - broj - 1; i--) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("\n\n");

	}

	private void ispisRijeci() {
		sc = new Scanner(System.in);
		System.out.println("Kojoj rijeci zelite da radite provjeru? Pritisnite 0 za kraj rada.");

		String rijec = sc.next();
		while (!rijec.equals("0")) {
			rijec = rijec.toLowerCase();
			rijec = rijec.substring(0, 1).toUpperCase() + rijec.substring(1).toLowerCase();
			if (!rjecnikMapa.containsKey(rijec) && !prosirenRjecnik.containsKey(rijec)) // rijeci nema ni u osnovnoj ni
																						// u prosirenoj verziji rjecnika
				System.out.println(
						"Rijec \"" + rijec + "\" se ne nalazi ni u osnovnoj verziji rjecnika, ali ni u prosirenoj");
			else if (rjecnikMapa.containsKey(rijec) && rjecnikMapa.get(rijec) == 0) // rijeci ima u osnovnoj verziji
																					// rjecnika, ali se ne pojavljuje u
																					// knjizi
				System.out.println("Rijec \"" + rijec
						+ "\" se nalazi u osnovnoj verziji rjecniku, a u analiziranoj knjizi se ta rijec ne pojavljuje");
			else if (rjecnikMapa.containsKey(rijec) && rjecnikMapa.get(rijec) != 0) // rijec se nalazi u osnovnoj
																					// verziji rjecnika i pojavljuje se
																					// u knjizi
				System.out.println("Rijec \"" + rijec
						+ "\" se nalazi u osnovnoj verziji rjecniku, a u analiziranoj knjizi se ta rijec pojavljuje "
						+ rjecnikMapa.get(rijec) + " puta");
			else
				System.out.println("Rijec \"" + rijec // rijec se uvrstila u prosirenu verziju rjecnika, a pronajdena je
														// u knjizi
						+ "\" se nalazi u prosirenoj verziji rjecnika, a u analiziranoj knjizi se ta rijec pojavljuje "
						+ prosirenRjecnik.get(rijec) + " puta");

			System.out.println("\nIzaberite novu rijec ili unesite 0 za kraj programa.");
			rijec = sc.next();
		}

	}

	private void upisSveRijeci() {
		ArrayList<String> zaUpis = new ArrayList<>(cijeli.keySet());
		Collections.sort(zaUpis);
		FileWriter fw = null;
		try {
			fw = new FileWriter("src\\analizaKnjige\\DopunjenRjecnik", true);
			for (String s : zaUpis) {
				fw.write(s + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
