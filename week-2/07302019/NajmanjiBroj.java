package zadaca6;

import java.util.Scanner;

public class NajmanjiBroj {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Upisite 3 broja: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println("Najmanji broj je: " + (najmanjibroj(a, b, c)));
		sc.close();

	}

	static int najmanjibroj(int a, int b, int c) {
		int nb = 0;
		if (a < b) {
			nb = a;
		} else {
			nb = b;
		}
		if (nb > c) {
			nb = c;
		}
		return nb;
	}

}
