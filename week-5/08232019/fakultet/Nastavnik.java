package zadaca1.fakultet;

import java.time.LocalDate;
import java.util.Arrays;

public class Nastavnik extends Zaposleni {
	private String omiljeniPr;
	private String[] predmeti;

	public Nastavnik(String ime, String prezime, LocalDate datumRodjenja, int godinaZaposlenja, double plata) {
		super(ime, prezime, datumRodjenja, godinaZaposlenja, plata);
	}

	public String[] getPredmeti() {
		return predmeti;
	}

	public String getPredmeti(int x) {
		return predmeti[x];
	}

	public void setPredmeti(String[] predmeti) {
		this.predmeti = predmeti;
	}

	public void dodajPredmet(String predmet) {
		boolean b = true;
		for (int i = 0; i < predmeti.length; i++) {
			if (predmeti[i] == null) {
				predmeti[i] = predmet;
				b = false;
				break;
			}
		}
		if (b) {
			String[] prelazni = new String[predmeti.length + 1];
			for (int i = 0; i < predmeti.length; i++) {
				prelazni[i] = predmeti[i];
			}
			predmeti = prelazni;
			predmeti[predmeti.length - 1] = predmet;
		}
	}

	public void oduzmiPredmet(String s) {
		for (int i = 0; i < predmeti.length; i++) {
			if (s.equals(predmeti[i])) {
				predmeti[i] = null;
				break;
			}
		}
	}

	public String getOmiljeniPr() {
		return omiljeniPr;
	}

	public void setOmiljeniPr(String pr) {
		this.omiljeniPr = pr;
	}

	public String toString() {
		return super.toString() + "omiljeni predmet nastavnika: " + omiljeniPr + "\npredmeti: " + Arrays.toString(predmeti) + "\n";
	}

}
