package zadacaOsobe;

public class Datum {
	private int dan, mjesec, godina;

	public Datum() {

	}

	public Datum(Datum d) {
		this.dan = d.getDan();
		this.mjesec = d.getMjesec();
		this.godina = d.getMjesec();
	}

	public int getDan() {
		return dan;
	}

	public int getMjesec() {
		return mjesec;
	}

	public int getGodina() {
		return godina;
	}

	public void setDatum(String god) {
		String[] nizStringova = god.split("\\.");
		int d = Integer.parseInt(nizStringova[0]);
		int m = Integer.parseInt(nizStringova[1]);
		int g = Integer.parseInt(nizStringova[2]);
		dan = d;
		mjesec = m;
		godina = g;
	}

	public boolean provjeraDatuma(String god) { // dd.mm.gggg.
		if (god.length() != 11) {
			System.out.println("Nepravilan unos datuma");
			return false;
		}
		if (god.charAt(2) != '.' || god.charAt(5) != '.' || god.charAt(god.length() - 1) != '.') {
			System.out.println("Nepravilan oblik unosa datuma!");
			return false;
		}
		String regex = "[0-9]+";
		String[] nizStringova = god.split("\\.");
		for (int i = 0; i < nizStringova.length; i++) {
			if (!nizStringova[i].matches(regex)) {
				System.out.println("Datum mora da sadrzi cifre!");
				return false;
			}
		}
		// uslovi za godinu i mjesece
		int d = Integer.parseInt(nizStringova[0]);
		int m = Integer.parseInt(nizStringova[1]);
		int g = Integer.parseInt(nizStringova[2]);

		if (g > 2019 && m > 9 && d > 10) {
			System.out.println("Ova osoba jos nije rodjena!");
			return false;
		} else if (m == 0 || m > 12) {
			System.out.println("Ne postoji mjesec koji je broj 0 ili redni broj veci od 12!");
			return false;
		}

		// uslovi za mjesece i dane
		boolean prestupna;
		if (g % 400 == 0)
			prestupna = true;
		else if (g % 4 == 0 && g % 100 != 0)
			prestupna = true;
		else
			prestupna = false;

		if (m == 2 && prestupna != true && (d >= 29 || d == 0)) {
			System.out.println("Nepravilan unos broja dana u mjesecu!");
			return false;
		} else if (m == 2 && prestupna == true && (d > 29 || d == 0)) {
			System.out.println("Nepravilan unos broja dana u mjesecu!");
			return false;
		} else if ((m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) && (d > 31 || d == 0)) {
			System.out.println("Nepravilan unos broja dana u mjesecu!");
			return false;
		} else if ((m == 4 || m == 6 || m == 9 || m == 11) && (d > 30 || d == 0)) {
			System.out.println("Nepravilan unos broja dana u mjesecu!");
			return false;
		}
		return true;

	}

	@Override
	public String toString() {
		return dan + "." + mjesec + "." + godina + ".";
	}

}
