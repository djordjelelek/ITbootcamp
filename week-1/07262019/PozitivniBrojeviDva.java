package zadacacetiri;

import java.util.Scanner;

public class PozitivniBrojeviDva {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, i, s=0;
		for (i=1; i<=5; i++) {
			System.out.printf("Unesite " + i + ". broj" + "\n");
			x = sc.nextInt();
			if (x<0) {
				continue;
			}
			s += x;
		}
		System.out.print("Suma unesenih pozitivnih brojeva je: " + s);
		sc.close();

	}

}
