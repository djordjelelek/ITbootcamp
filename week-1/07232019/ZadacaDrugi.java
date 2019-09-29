package prvipaket;

import java.util.Scanner;

public class ZadacaDrugi {

	public static void main(String[] args) {
		Scanner skener = new Scanner(System.in);
		double r, v;
		System.out.println("Unesite poluprecnik r:");
		r = skener.nextDouble();
		v = (4 * Math.pow(r, 3) * Math.PI) / 3;
		System.out.println("Zapremina lopte je: " + v);
		skener.close();

	}

}
