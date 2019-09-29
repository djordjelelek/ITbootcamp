package titlovi;

public abstract class Titl {
	private String titl;
	private int brojTitla;

	public Titl(String titl, int brojTitla) {
		super();
		this.titl = titl;
		this.brojTitla = brojTitla;
	}
	

	public String getTitl() {
		return titl;
	}


	public int getBrojTitla() {
		return brojTitla;
	}


	public abstract void pretvaranje();

	public abstract void stampanje(int i);

}
