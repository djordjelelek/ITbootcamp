package zadaca1.fakultet;

import java.time.LocalDate;

public class Covjek {
	private String ime;
	private String prezime;
	private LocalDate datumRodjenja;

	public Covjek(String ime, String prezime, LocalDate datumRodjenja) {
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public String toString() {
		return "ime: " + ime + ", prezime: " + prezime + ", datum rodjenja: " + datumRodjenja + "\n";
	}

}
