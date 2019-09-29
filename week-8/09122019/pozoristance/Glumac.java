package pozoristance;

public class Glumac extends Zaposleni {

	public Glumac(String ime, Pozoriste p) {
		super(ime, p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String imePosla() {
		StringBuilder sb = new StringBuilder();
		sb = sb.append(getIme() + "(");
		sb.append("glumac, " + super.getP().getSkraceniNaziv() + ")");
		return sb.toString();
	}

}
