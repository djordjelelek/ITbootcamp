package zadaca4tetris;

public class DesniL extends Blok {
	String[][] niz;

	public DesniL() {
		niz = kreiranjeNiza();
	}

	private String[][] kreiranjeNiza() {
		String[][] s = new String[2][3];
		for (int i = 0; i < s[1].length; i++) {
			if (i == 2)
				s[0][i] = "#";
			else
				s[0][i] = " ";
			s[1][i] = "#";
		}
		return s;

	}

	@Override
	public void okreniLijevo() {
		String[][] obrnut = new String[niz[0].length][niz.length];
		for (int i = 0, k = (niz[0].length - 1); i < obrnut.length; i++, k--) {
			for (int j = 0; j < obrnut[i].length; j++) {
				obrnut[i][j] = niz[j][k];

			}
		}
		niz = obrnut;
	}

	@Override
	public void okreniDesno() {
		String[][] obrnut = new String[niz[0].length][niz.length];
		for (int i = 0; i < obrnut.length; i++) {
			for (int j = 0, k = (niz.length - 1); j < obrnut[i].length; j++, k--) {
				obrnut[i][j] = niz[k][i];

			}
		}
		niz = obrnut;
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
