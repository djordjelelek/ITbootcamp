package truogao.tacke;

public class Trougao {
	private Tacka pocetna;
	private double a;
	private double b;
	private double c;

	public Trougao(double a, double b, double c) {
		if (a + b < c && a > 0 && b > 0 && c > 0) {
			this.a = a;
			this.b = b;
			this.c = c;
			pocetna = null;

		} else
			System.out.println("Ovaj trougao nije validan!");

	}

	public void setStranice(double a, double b, double c) {
		if (a + b < c && a > 0 && b > 0 && c > 0) {
			this.a = a;
			this.b = b;
			this.c = c;
		} else
			System.out.println("Pogresan unos stranica");
	}

	public void setTacka(Tacka t) {
		pocetna = t;
	}

	public Tacka getTacka() {
		return pocetna;
	}

	public void jednokraki() {
		if (a == b)
			System.out.println("JESTE jednokraki!");
		else
			System.out.println("NIJE jednokraki!");
	}

	public double getPovrsina() {
		double s = (a + b + c) + 2;
		double p = s * (s - a) * (s - b) * (s - c);
		return Math.sqrt(p);
	}

	public double getObim() {
		double o = a + b + c;
		return o;
	}

	public void poredjenjeTacaka(Tacka m) {
		if ((pocetna.getX() == m.getX()) && (pocetna.getY() == m.getY()))
			System.out.println("IMAJU zajednicku pocetnu tacku!");
		else
			System.out.println("NEMAJU zajednicku pocetnu tacku!");

	}

	public void ispisTrougla() {
		String s = "";
		s += "Trougao sa pocetkom u tackama: x = " + pocetna.getX() + "; b = " + pocetna.getY() + "\n";
		s += "Stranicama: a = " + a + "; b = " + b + "; c = " + c + ";\n";
		s += "Povrinom i obimom: P = " + getPovrsina() + "; O = " + getObim() + "\n";
		s += ("-------------------------");

		System.out.println(s);
		;
	}

}
