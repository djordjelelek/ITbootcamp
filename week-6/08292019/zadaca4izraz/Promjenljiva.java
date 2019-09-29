package zadaca4izraz;

public class Promjenljiva extends Izraz {
	private String ime;
	private int broj;

	public Promjenljiva(String ime, int broj) {
		this.ime = ime;
		this.broj = broj;
	}

	@Override
	public double izracunaj() {
		// TODO Auto-generated method stub
		return broj;
	}

}
