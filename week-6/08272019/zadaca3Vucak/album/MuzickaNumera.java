package zadaca3Vucak.album;

public class MuzickaNumera {
	private String izvodjac;
	private String naziv;
	private String trajanje;

	public MuzickaNumera(String izvodjac, String naziv, String trajanje) {
		this.izvodjac = izvodjac;
		this.naziv = naziv;
		this.trajanje = trajanje;
	}

	public String getIzvodjac() {
		return izvodjac;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getTrajanje() {
		return trajanje;
	}

	public String toString() {
		String s = izvodjac + " - " + naziv + ": " + trajanje;
		return s;
	}

}