package pozoristance;

public class Reditelj extends Zaposleni{

	public Reditelj(String ime, Pozoriste p) {
		super(ime, p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String imePosla() {
		StringBuilder sb = new StringBuilder();
		sb = sb.append(getIme() + "(");
		sb.append("reditelj," + super.getP().getSkraceniNaziv() + ")");
		return sb.toString();
	}

}
