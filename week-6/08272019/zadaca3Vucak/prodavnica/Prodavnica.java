package zadaca3Vucak.prodavnica;

public class Prodavnica {
	private String ime, lokacija;
	private Artikal[] inventar = new Artikal[10];
	private int brojac = 0;

	public Prodavnica(String ime, String lokacija) {
		this.ime = ime;
		this.lokacija = lokacija;
	}

	public String getIme() {
		return ime;
	}

	public String getLokacija() {
		return lokacija;
	}

	public void dodaj(Artikal a) {
		if (brojac < inventar.length) {
			inventar[brojac++] = a;
		} else {
			Artikal[] prelazni = new Artikal[inventar.length * 2];
			for (int i = 0; i < inventar.length; i++) {
				prelazni[i] = inventar[i];
			}
			inventar = prelazni;
			inventar[brojac++] = a;

		}

	}

	public Artikal[] pretrazi(String tekst) {
		Artikal[] niz;
		int brojac = 0;
		tekst = tekst.toLowerCase();
		for (int i = 0; i < inventar.length; i++) {
			if (inventar[i] == null)
				continue;
			else {
				String p = inventar[i].ime().toLowerCase();
				if (p.contains(tekst))
					brojac++;
			}
		}
		niz = new Artikal[brojac];
		for (int i = 0, j = 0; i < inventar.length; i++) {
			if (inventar[i] == null)
				continue;
			else {
				String p = inventar[i].ime().toLowerCase();
				if (p.contains(tekst))
					niz[j++] = inventar[i];
			}

		}

		return niz;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ime + ": " + lokacija);
		for (Artikal artikal : inventar) {
			if (artikal == null)
				continue;
			sb.append("\n\t" + artikal);
		}
		return sb.toString();
	}

}
