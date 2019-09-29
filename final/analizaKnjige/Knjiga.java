package analizaKnjige;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Knjiga {
	private String knjiga;
	private HashMap<String, Integer> rjecnik;
	private HashMap<String, Integer> prosirenRjecnik = new HashMap<String, Integer>();

	public Knjiga(String knjiga) {
		super();
		this.knjiga = knjiga;

	}

	public HashMap<String, Integer> getProsirenRjecnik() {
		return prosirenRjecnik;
	}

	public void analizaKnjige(HashMap<String, Integer> rjecnik) {
		this.rjecnik = rjecnik;
		analizaKnjige();

	}

	private void analizaKnjige() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(knjiga));
			String linija = br.readLine();
			while (linija != null) {
				linija = linija.replaceAll("[^A-Za-z -]", ""); // brise sve sto nisu slova i crtice
				if (linija.isEmpty()) {
					linija = br.readLine();
					continue;
				}
				if (linija.matches(".*((- )|(-))$")) { // ako je crtica na kraju(prenosenje rijeci u novi red), zalijepi
														// sljedeci red na to
					linija = linija.replaceAll("(- )$|(-)$", "");
					linija += br.readLine();
					continue;
				}
				analizaLinije(linija);
				linija = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void analizaLinije(String linija) {
		String[] nizRijeci = linija.split(" ");
		if (nizRijeci.length == 0)
			return;
		for (String rijec : nizRijeci) {
			if (rijec.equals("") || rijec.equals("s") || rijec.equals("-")) // zbog loseg formatiranja brisati sljedece
																			// stvari
				continue;
			if (rijec.charAt(0) == '-') // crtica na pocetku reda
				rijec = rijec.substring(1);
			rijec = rijec.substring(0, 1).toUpperCase() + rijec.substring(1).toLowerCase(); // da bude prvo veliko slovo
																							// svake rijeci u rjecniku
			analizaRijeci(rijec);
		}

	}

	private void analizaRijeci(String rijec) {
		if (rjecnik.containsKey(rijec)) { // rijec se nalazi u osnovnoj verziji rjecnika
			int broj = rjecnik.get(rijec) + 1;
			rjecnik.replace(rijec, broj);
		} else if (prosirenRjecnik.isEmpty()) { // nova verzija rjecnika je prazna( da ne izbacuje NULLpointer ex
			prosirenRjecnik.put(rijec, 1);
		} else if (prosirenRjecnik.containsKey(rijec)) { // rijec se vec nalazi u rjecniku
			int broj = prosirenRjecnik.get(rijec) + 1;
			prosirenRjecnik.replace(rijec, broj);
		} else // rijec se ne nalazi ni u osnovnoj, ni u prosirenoj verziji rjecnika
			prosirenRjecnik.put(rijec, 1);
	}

}
