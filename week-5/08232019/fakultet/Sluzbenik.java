package zadaca1.fakultet;

import java.time.LocalDate;

public class Sluzbenik extends Zaposleni {
	private String odsjek;

	public Sluzbenik(String ime, String prezime, LocalDate datumRodjenja, int godinaZaposlenja, double plata,
			String odsjek) {
		super(ime, prezime, datumRodjenja, godinaZaposlenja, plata);
		this.odsjek = odsjek;
	}

	public String getOdsjek() {
		return odsjek;
	}

	public void setOdsjek(String odsjek) {
		this.odsjek = odsjek;
	}

	@Override
	public String toString() {
		return super.toString() + "odsjek sluzbenika: " + odsjek + "\n";
	}

}
