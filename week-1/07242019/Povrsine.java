package zadaca;

import java.util.Scanner;

public class Povrsine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Koja je figura u pitanju?");
		String s = sc.nextLine();
		double a, b, r;
		switch (s) {
		case "kvadrat":
			System.out.println("Koja je duzina stranice?");
			a = sc.nextDouble();
			System.out.println("Povrsina kvadrata je: " + Math.pow(a, 2) + " , a obim je: " + 4 * a);
			break;
		case "pravougaonik":
			System.out.println("Koja je duzina stranice a?");
			a = sc.nextDouble();
			System.out.println("Koja je duzina stranice b?");
			b = sc.nextDouble();
			System.out.println("Povrsina pravougaonika je: " + a * b + " , a obim je: " + 2 * (a + b));
			break;
		case "krug":
			System.out.println("Koji je poluprecnik kruga?");
			r = sc.nextDouble();
			System.out.println("Povrsina kruga je: " + Math.pow(r, 2) * Math.PI + " , a obim je: " + 2 * r * Math.PI);
			break;
		default:
			System.out.println("Nije unijet tacan naziv figure");

		}
		sc.close();

	}

}
