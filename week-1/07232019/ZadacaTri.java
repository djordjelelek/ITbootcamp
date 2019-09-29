package prvipaket;

import java.util.Scanner;

public class ZadacaTri {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite trocifreni broj:");
		int a, s, d, j, z;
		a = sc.nextInt();
		s = a / 100;
		d = (a % 100) / 10;
		j = a % 10;
		z = s + d + j;
		System.out.println("Zbir cifara unijetog trocifrenog broja je: " + z);
		sc.close();

	}

}
