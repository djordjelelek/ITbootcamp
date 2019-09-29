package zadaca1.knjiga;

public class Knjiga {
	private String naziv;
	private ListPapira[] niz;
	private int brojac = 0;

	public Knjiga(String naziv) {
		this.naziv = naziv;
	}

	public ListPapira getNiz(int redniBroj) {
		return niz[redniBroj - 1];
	}

	public void dodavanjeListova(ListPapira x) {
		if (brojac == 0) {
			niz = new ListPapira[1];
			niz[brojac++] = x;
		}
		boolean b = false;
		for (int i = 0; i < niz.length; i++) {
			if (x.poredjenjeListova(niz[i]) == true) {
				b = true;
				niz[i] = x;
				break;
			}
		}
		if (b == false) {
			ListPapira[] prelazni = new ListPapira[brojac + 1];
			for (int i = 0; i < niz.length; i++) {
				prelazni[i] = niz[i];
			}
			niz = prelazni;
			niz[brojac++] = x;
		}
	}

	public int brojListova() {
		return niz.length + 1;
	}

	public String getNaziv() {
		return naziv;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv + "\n");
		for (ListPapira listPapira : niz) {
			if (listPapira == null)
				break;
			sb.append("\t" + listPapira + "\n");
		}
		return sb.toString();
	}

}
