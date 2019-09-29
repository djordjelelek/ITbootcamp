package zadaca3Vucak.album;

import java.util.Date;

public class Album {
	private String naziv;
	private String izvodjac;
	private Date datum;
	private MuzickaNumera[] nizPjesama;
	public static int brojPjesme;

	public Album(String naziv, String izvodjac, Date datum) {
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.datum = datum;
		nizPjesama = new MuzickaNumera[5];
		brojPjesme = 0;

	}

	public void dodaj(MuzickaNumera pjesma) {
		if (nizPjesama.length > brojPjesme) {
			nizPjesama[brojPjesme] = pjesma;
			brojPjesme++;
		} else {
			MuzickaNumera[] prelazni = new MuzickaNumera[nizPjesama.length * 2];
			for (int i = 0; i < nizPjesama.length; i++) {
				prelazni[i] = nizPjesama[i];
			}
			nizPjesama = null;
			nizPjesama = new MuzickaNumera[prelazni.length];
			for (int i = 0; i < prelazni.length; i++) {
				nizPjesama[i] = prelazni[i];
			}
			nizPjesama[brojPjesme] = pjesma;
			brojPjesme++;
		}

	}

	public void dodaj(String name, String trajanje) {
		if (nizPjesama.length > brojPjesme) {
			nizPjesama[brojPjesme] = new MuzickaNumera(izvodjac, name, trajanje);
			brojPjesme++;
		} else {
			MuzickaNumera[] prelazni = new MuzickaNumera[nizPjesama.length * 2];
			for (int i = 0; i < nizPjesama.length; i++) {
				prelazni[i] = nizPjesama[i];
			}
			nizPjesama = null;
			nizPjesama = new MuzickaNumera[prelazni.length];
			for (int i = 0; i < prelazni.length; i++) {
				nizPjesama[i] = prelazni[i];
			}
			nizPjesama[brojPjesme] = new MuzickaNumera(izvodjac, name, trajanje);
			brojPjesme++;
		}

	}

	public String getNaziv() {
		return naziv;
	}

	public String getIzvodjac() {
		return izvodjac;
	}

	public Date getDatum() {
		return datum;
	}

	public String getTrajanje() {
		int minuta = 0;
		int sekunda = 0;
		for (MuzickaNumera i : nizPjesama) {
			if (i == null)
				break;
			String s = i.getTrajanje();
			String[] s2 = s.split(":");
			minuta += Integer.parseInt(s2[0]);
			sekunda += Integer.parseInt(s2[1]);
		}
		minuta += sekunda / 60;
		sekunda = sekunda % 60;
		String trajanje = Integer.toString(minuta) + ":" + Integer.toString(sekunda);
		return trajanje;
	}

	public MuzickaNumera getMuzickaNumera(int i) {
		return nizPjesama[i];
	}

	public MuzickaNumera getMuzickaNumera(String ime) {
		for (MuzickaNumera i : nizPjesama) {
			if (ime.equals(i.getNaziv())) {
				return i;
			}

		}
		return null;

	}

	public String toString() {
		String s = "";
		s += izvodjac + " - " + naziv + " (" + datum + ") " + ":[" + "\n";
		for (int i = 0; i < nizPjesama.length; i++) {
			if (nizPjesama[i] == null)
				break;
			s += "\t" + nizPjesama[i].toString() + "\n";

		}
		s += "]: " + getTrajanje() + "\n";

		return s;
	}

}
