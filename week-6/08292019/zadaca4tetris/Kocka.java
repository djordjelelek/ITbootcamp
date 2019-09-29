package zadaca4tetris;

public class Kocka extends Blok {
	String[][] niz;

	public Kocka() {
		niz = kreiranjeNiza();
	}

	private String[][] kreiranjeNiza() {
		String[][] s = new String[2][2];
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				s[i][j] = "#";
			}
		}
		return s;

	}

	@Override
	public void okreniLijevo() {
	}

	@Override
	public void okreniDesno() {
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
