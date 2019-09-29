package zadaca1.fakultet;

import java.time.LocalDate;

public class Student extends Covjek {
	private int godStudija;
	private double prosjek;

	public Student(String ime, String prezime, LocalDate datumRodjenja, int godStudija, double prosjek) {
		super(ime, prezime, datumRodjenja);
		this.godStudija = godStudija;
		this.prosjek = prosjek;
	}

	public int getGodStudija() {
		return godStudija;
	}

	public double getProsjek() {
		return prosjek;
	}

	@Override
	public String toString() {
		return super.toString() + "godina studija: " + godStudija + ".\nprosjek: " + prosjek + "\n";
	}

}
