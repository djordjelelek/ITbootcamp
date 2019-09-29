package TrecaZadaca;

import java.util.Scanner;

public class Palindrom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj:");
		int x, x2, m, s;
		x = sc.nextInt();
		int l = String.valueOf(x).length();
		l = l - 1;
		x2=x;
		s = 0;
		while (x2 > 0) {
			m = x2 % 10;
			s = (int) (s + m * Math.pow(10, l));
			l = l - 1;
			x2 = x2 / 10;
		}
		if (x==s) {
			System.out.println("ovaj broj JESTE palindrom");
		}else {
			System.out.println("ovaj broj NIJE palindrom");
		}

		sc.close();

	}

}
