package zadaca4izraz;

public class Sabiranje extends BinarnaOperacija {
	public Sabiranje(Izraz levi, Izraz desni) {
		super(levi, desni);
		// TODO Auto-generated constructor stub
	}

	public double izracunaj() {
		double vrednostLevogIzraza = levi.izracunaj();
		double vrednostDesnogIzraza = desni.izracunaj();
		return vrednostLevogIzraza + vrednostDesnogIzraza;
	}
}