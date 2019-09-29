package zadaca4tetris;

public class Linija extends Blok {
	String[][] niz;

	public Linija() {
		niz = kreiranjeNiza();
	}

	private String[][] kreiranjeNiza() {
		String[][] s = new String[1][4];
		for (int i = 0; i < s[0].length; i++) {
			s[0][i] = "#";
		}
		return s;

	}

	@Override
	public void okreniLijevo() {
		String[][] obrnut = new String[niz[0].length][niz.length];
		for (int i = 0; i < obrnut.length; i++) {
			for (int j = 0; j < obrnut[i].length; j++) {
				obrnut[i][j] = niz[j][i];

			}
		}
		niz = obrnut;
	}

	@Override
	public void okreniDesno() {
		okreniLijevo();

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < niz.length; i++) {
			for (int j = 0; j < niz[i].length; j++) {
				sb.append(niz[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
