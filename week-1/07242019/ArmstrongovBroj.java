package zadaca;

import java.util.Scanner;

public class ArmstrongovBroj {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, s, y;
		System.out.println("Napisite broj:");
		x = sc.nextInt();
		int x2 = x;
		int l = String.valueOf(x).length(); // pretvaranje broja u string//
		s = 0;
		while (x2 > 0) {
			y = x2 % 10;
			s = (int) (s + Math.pow(y, l));
			x2 = x2 / 10;
		}
		if (x == s) {
			System.out.println(x + " JE Armstrongov broj");
		} else {
			System.out.println(x + " NIJE Armstrongov broj");
		}

		sc.close();

	}

}
