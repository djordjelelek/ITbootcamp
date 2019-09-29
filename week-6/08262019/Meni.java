package zadaca2energija;

public class Meni {
	private int brNam;
	private Namirnica[] niz;

	public Meni(int brNam) {
		this.brNam = brNam;
		niz = new Namirnica[brNam];
	}

	public void dodaj(Namirnica n) {
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] == null && brNam > 0) {
				niz[i] = n;
				brNam--;
				break;
			}

		}
	}

	public double ukupnaEnVr() {
		double ukupno = 0;
		for (Namirnica namirnica : niz) {
			if (namirnica == null)
				continue;
			ukupno += namirnica.enVr();
		}
		return ukupno;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("MENI (" + ukupnaEnVr() + "kJ)\n");
		for (Namirnica namirnica : niz) {
			if (namirnica == null)
				break;
			sb.append("\t" + namirnica + "\n");
		}
		return sb.toString();
	}

	public Namirnica getNam(int i) {
		return niz[i];
	}
}
