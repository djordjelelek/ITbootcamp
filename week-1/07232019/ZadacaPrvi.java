package prvipaket;

import java.util.Scanner;

public class ZadacaPrvi {

	public static void main(String[] args) {
		Scanner skener = new Scanner(System.in);
		Double a, b, c, s;
		System.out.println("Unesite prvi broj:");
		a = skener.nextDouble();
		System.out.println("Unesite drugi broj:");
		b = skener.nextDouble();
		System.out.println("Unesite treci broj:");
		c = skener.nextDouble();
		s = (a + b + c) / 3;
		System.out.println("Srednja vrijednost unijetih brojeva je " + s);
		skener.close();
		

	}

}
