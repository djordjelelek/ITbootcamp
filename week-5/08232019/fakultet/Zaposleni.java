package zadaca1.fakultet;

import java.time.LocalDate;

public class Zaposleni extends Covjek {
	private int godinaZaposlenja;
	private double plata;

	public Zaposleni(String ime, String prezime, LocalDate datumRodjenja, int godinaZaposlenja, double plata) {
		super(ime, prezime, datumRodjenja);
		this.godinaZaposlenja = godinaZaposlenja;
		this.plata = plata;
	}

	public int getGodinaZaposlenja() {
		return godinaZaposlenja;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String toString() {
		return super.toString() + "godina zaposlenja: " + godinaZaposlenja + ", plata: " + plata + "\n";
	}

}
