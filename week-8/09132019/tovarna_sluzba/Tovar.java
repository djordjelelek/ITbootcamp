package tovarna_sluzba;

public abstract class Tovar {

	public abstract String vrsta();

	public abstract double tezina();

	@Override
	public String toString() {
		return vrsta() + "(" + tezina() + ")";
	}

}
