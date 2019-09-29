package zadaca4izraz;

public abstract class BinarnaOperacija extends Izraz {
	protected Izraz levi, desni;

	public BinarnaOperacija(Izraz levi, Izraz desni) {
		this.levi = levi;
		this.desni = desni;
	}

}