package zadaca;

import java.util.Scanner;

public class PrestupneGodine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite godinu:");
		int a = sc.nextInt();
		if (a % 4 == 0 && (a % 100 != 0 | a % 400 == 0)) {
			System.out.println(a + " je prestupna godina");
		} else {
			System.out.println(a + " nije prestupna godina");
		}
		sc.close();

	}

}
