package zadaca1.fakultet;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		Zaposleni z = new Zaposleni("Ivan", "Gutalj", LocalDate.of(1965, 7, 26), 2012, 48500.5);
		System.out.println(z);
		
		Profesor p = new Profesor("Marko", "Markovic", LocalDate.of(1955, 4, 24), 2000, 154000.00);
		p.setOmiljeniPr("SPT");
		String[]s = {"UPT", "SPT", "IPT"};
		p.setPredmeti(s);
		p.setTitula("dr");
		System.out.println(p);
		
		MasterStudije ms = new MasterStudije("Djordje", "Markovic", LocalDate.of(1994, 4, 18), 1, 9.12, "Politikologija");
		System.out.println(ms);
		
		

	}

}
