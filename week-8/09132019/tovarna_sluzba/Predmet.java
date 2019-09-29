package tovarna_sluzba;

public class Predmet extends Tovar {
	private String vrsta;
	private Double tezina;

	public Predmet(String vrsta, Double tezina) {
		super();
		this.vrsta = vrsta;
		this.tezina = tezina;
	}

	@Override
	public String vrsta() {

		return vrsta;
	}

	@Override
	public double tezina() {
		return tezina;
	}

}
