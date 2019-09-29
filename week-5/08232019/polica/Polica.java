package zadaca1.knjiga;

public class Polica {
	private Knjiga[] niz = new Knjiga[10];

	public Polica() {
	}

	public void dodavanjeKnjiga(Knjiga x) {
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] == null) {
				niz[i] = x;
				break;
			}

		}
	}

	public void uzimanjeKnjige(String s) {
		for (int i = 0; i < niz.length; i++) {
			if (niz[i].getNaziv().equals(s)) {
				niz[i] = null;
				break;
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Knjiga knjiga : niz) {
			if (knjiga == null)
				break;
			sb.append(knjiga);
			sb.append("---------------" + "\n");
		}

		return sb.toString();
	}

}
