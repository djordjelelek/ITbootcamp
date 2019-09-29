package zadaca2energija;

public abstract class Namirnica extends Energent {
	protected String ime;
	protected int id;
	protected static int globalId = 1;

	public Namirnica(String ime) {
		super();
		this.ime = ime;
		id = globalId++;
	}

	public String getIme() {
		return ime;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "[" + id + "]" + ime;
	}

}
