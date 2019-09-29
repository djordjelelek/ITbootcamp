package zadaca2energija;

public class Pice extends Namirnica {
	private double kolicina;
	private double enVr;

	public Pice(String ime, double kolicina, double enVr) {
		super(ime);
		this.kolicina = kolicina;
		this.enVr = enVr;
	}

	public double getKolicina() {
		return kolicina;
	}

	public double enVr() {
		return enVr * kolicina;
	}

	public String toString() {
		return super.toString() + " (" + kolicina + "l, " + enVr() + "kJ)";
	}

}
