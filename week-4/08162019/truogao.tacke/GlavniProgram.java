package truogao.tacke;

import java.util.concurrent.ThreadLocalRandom;

public class GlavniProgram {

	public static void main(String[] args) {

		Tacka[] niz_tacaka = new Tacka[10];
		for (int i = 0; i < niz_tacaka.length; i++) {
			double r = ThreadLocalRandom.current().nextDouble(1, 10);
			double r2 = ThreadLocalRandom.current().nextDouble(1, 10);
			niz_tacaka[i] = new Tacka(r, r2);
		}

		Trougao tr1 = new Trougao(4.0, 3.0, 8.0);
		tr1.setTacka(niz_tacaka[3]);

		Trougao tr2 = new Trougao(2.1, 2.1, 6.0);
		tr2.setTacka(niz_tacaka[6]);

		Trougao tr3 = new Trougao(5.2, 2.1, 10.7);
		tr3.setTacka(niz_tacaka[8]);

		System.out.println("Ispis tougla tr1: " + "\n");
		tr1.ispisTrougla();
		System.out.println("Ispis tougla tr2: " + "\n");
		tr2.ispisTrougla();

		System.out.print("Trougao tr2 ");
		tr2.jednokraki();
		System.out.print("Trougao tr3 ");
		tr3.jednokraki();

		Trougao tr4 = new Trougao(1.2, 3.5, 6.0);
		tr4.setTacka(niz_tacaka[3]);

		System.out.print("Trouglovi tr4 i tr1 ");
		tr4.poredjenjeTacaka(tr1.getTacka());

	}

}
