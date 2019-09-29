package pozoristance;

import java.util.ArrayList;

public class Repertoar {
	Pozoriste p;
	ArrayList<Predstava> predstave = new ArrayList<Predstava>();

	public Repertoar(Pozoriste p) {
		super();
		this.p = p;
	}

	public void dodaj(Predstava predstava) {
		predstave.add(predstava);
	}

	public void ukoloni(String naziv) {
		for (Predstava predstava : predstave) {
			if (predstava.getNaziv().equals(naziv))
				predstave.remove(predstava);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(p.getNaziv() + ": [\n");
		for (Predstava p : predstave) {
			sb.append(p + "\n");
		}
		sb.append("]");
		return sb.toString();
	}

}
