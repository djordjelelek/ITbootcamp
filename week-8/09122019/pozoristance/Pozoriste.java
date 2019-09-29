package pozoristance;

public class Pozoriste {
	private int id;
	private static int i = 1;
	String naziv;

	public Pozoriste(String naziv) {
		super();
		this.naziv = naziv;
		id = i++;
	}

	public int getId() {
		return id;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getSkraceniNaziv() {
		String skraceni = "";
		String[] niz = naziv.split(" ");
		for (String string : niz) {
			skraceni += string.charAt(0);
		}
		skraceni = skraceni.toUpperCase();
		return skraceni;
	}

	@Override
	public String toString() {
		return naziv + "[" + id + "]";
	}

}
