package pozoristance;

public abstract class Zaposleni {
	private String ime;
	private Pozoriste p;
	public Zaposleni(String ime, Pozoriste p) {
		super();
		this.ime = ime;
		this.p = p;
	}
	public String getIme() {
		return ime;
	}
	public Pozoriste getP() {
		return p;
	}

	public abstract String imePosla();
	
	
	

}
