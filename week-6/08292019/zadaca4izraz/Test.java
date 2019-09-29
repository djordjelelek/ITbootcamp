package zadaca4izraz;

public class Test {

	public static void main(String[] args) {
		// 2 + 10 - 11 + 20 = 21
		Broj b2 = new Broj(2);
		Broj b10 = new Broj(10);
		Broj bn11 = new Broj(11);
		Broj b20 = new Broj(20);

		/*
		 * Sabiranje s1 = new Sabiranje(b2, b10); Oduzimanje o1 = new Oduzimanje(s1,
		 * bn11); Sabiranje s2 = new Sabiranje(o1, b20);
		 * 
		 * System.out.println("Rezultat: " + s2.izracunaj()); System.out.println();
		 */

		// 2 + x0 - 11 + x1 = 21

		Promjenljiva p0 = new Promjenljiva("x1", 10);

		Promjenljiva p1 = new Promjenljiva("x2", 20);

		Sabiranje s1 = new Sabiranje(b2, p0);
		Oduzimanje o1 = new Oduzimanje(s1, bn11);
		Sabiranje s2 = new Sabiranje(o1, p1);

		System.out.println("Rezultat: " + s2.izracunaj());
	}
}
