package pozoristance;

import java.util.ArrayList;

public class Predstava {
	String naziv;
	Pozoriste p;
	ArrayList<Zaposleni> zaposleni = new ArrayList<Zaposleni>();

	public Predstava(String naziv, Pozoriste p, Reditelj r) {
		super();
		this.naziv = naziv;
		this.p = p;
		zaposleni.add(r);
	}

	public String getNaziv() {
		return naziv;
	}

	public Pozoriste getP() {
		return p;
	}

	public boolean dodaj(Glumac g) {
		zaposleni.add(g);
		return true;
	}

	public boolean dodaj(Kostimograf k) {
		int brojac = 0;
		for (Zaposleni z : zaposleni) {
			if (z.equals(k))
				brojac++;
		}
		if (brojac <= 2) {
			zaposleni.add(k);
			return true;
		} else
			return false;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv + ":");
		for (Zaposleni z : zaposleni) {
			sb.append("\n\t" + z.imePosla() + "");
		}
		return sb.toString();
	}

}
