package tovarna_sluzba;

public class Test {

	public static void main(String[] args) {
		Kamion kam = new Kamion("BG 123-4567", 5000);
		kam.stavi(new Predmet("secer", 500.0));
		Paket p = new Paket();
		p.dodaj(new Predmet("radio", 3.0));
		p.dodaj(new Predmet("tv", 10.0));
		kam.stavi(p);
		kam.stavi(new Predmet("brasno", 300.0));
		System.out.println(kam);
	}
}
