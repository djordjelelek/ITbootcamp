package zadaca2energija;

public class Hrana extends Namirnica {
	private double tezina;
	private double bjelancevine;// procenti odavde
	private double masti;
	private double ugljHidr;

	public Hrana(String ime, double tezina, double bjelancevine, double masti, double ugljHidr) {
		super(ime);
		if (bjelancevine + masti + ugljHidr <= 100) {
			this.tezina = tezina;
			this.bjelancevine = bjelancevine;
			this.masti = masti;
			this.ugljHidr = ugljHidr;
		}
	}

	@Override
	public double enVr() {
		double uk = 0;
		uk += (16.7 * (bjelancevine * tezina / 100));
		uk += (37.6 * (masti * tezina / 100));
		uk += (17.2 * (ugljHidr * tezina / 100));
		return uk;
	}

	public double getTezina() {
		return tezina;
	}

	public double getBjelancevine() {
		return bjelancevine;
	}

	public double getMasti() {
		return masti;
	}

	public double getUgljHidr() {
		return ugljHidr;
	}

	@Override
	public String toString() {
		return super.toString() + " (" + tezina + "g, " + enVr() + "kJ)";
	}

}
