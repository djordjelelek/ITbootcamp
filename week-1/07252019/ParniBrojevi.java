package TrecaZadaca;

import java.util.Scanner;

public class ParniBrojevi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, z, s;
		System.out.println("Unesite broj x:");
		x = sc.nextInt();
		System.out.println("Unesite broj y:");
		y = sc.nextInt();
		System.out.printf("Parni brojevi izmedju brojeva " + x + " i " + y + " su: ");
		if (x > y) {
			int c;
			c = x;
			x = y;
			y = c;
		}
		z = x;
		s = 0;
		while (z <= y) {
			if (z % 2 == 0) {
				System.out.print(z + " ");
				s += z;
			}
			z++;
		}
		System.out.println("\n" + "Zbir parnih brojeva je: " + s);
		sc.close();
	}
}
