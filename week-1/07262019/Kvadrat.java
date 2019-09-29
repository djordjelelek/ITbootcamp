package zadacacetiri;

import java.util.Scanner;

public class Kvadrat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite velicinu stranice kvadrata:");
		int x = sc.nextInt();
		double p = Math.pow(x, 2);
		String s = "";
		while (p > 0) {
			s += "*";
			p--;
			if (p % x == 0) {
				s += "\n";
			}
		}

		System.out.println(s);

		sc.close();

	}

}
