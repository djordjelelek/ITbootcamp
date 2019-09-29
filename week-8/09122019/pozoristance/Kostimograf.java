package pozoristance;

public class Kostimograf extends Zaposleni {

	public Kostimograf(String ime, Pozoriste p) {
		super(ime, p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String imePosla() {
		StringBuilder sb = new StringBuilder();
		sb = sb.append(getIme() + "(");
		sb.append("kostimograf, " + super.getP().getSkraceniNaziv() + ")");
		return sb.toString();
	}

}
