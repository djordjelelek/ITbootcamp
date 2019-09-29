package Zadaca1;

public class Pravougaonik {
	private double a;
	private double b;
	private String ime;

	public Pravougaonik(double a, double b, String ime) {
		this.a = a;
		this.b = b;
		this.ime = ime;
	}

	public Pravougaonik(double x, String ime) {
		a = x;
		b = x;
		this.ime = ime;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public String getIme() {
		return ime;
	}

	public double getObim() {
		return 2 * (a + b);
	}

	public double getPovrsina() {
		return a * b;
	}

	public String ispisiPravougaonik() {
		String ispis = "";
		ispis += "Pravougaonik: " + ime + "\n";
		ispis += "Duzina prve stranice je: " + a + "\n";
		if (a != b)
			ispis += "Duzina druge stranice je " + b + "\n";
		ispis += "Povrsina pravougaonika je " + a * b + "\n";
		ispis += "Obim pravougaonika je " + (2 * (a + b));
		if (a == b)
			ispis += "\n" + "Aco je u stvari kvadrat!";
		return ispis;

	}

}
