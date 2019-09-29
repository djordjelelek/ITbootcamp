package zadaca6;

import java.util.Scanner;

public class Trougao2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite broj n: ");
		int n = sc.nextInt();
		System.out.print("Unesite simbol koji zelite da se nadje u trouglu: ");
		char simbol = sc.next().charAt(0);
		ispisifiguru(n, simbol);
		sc.close();

		
	}
	static void ispisifiguru(int n, char simbol) {
		String figura = "";
		for (int i = 1; i <= n; i++) {
			figura += praznine(n, i) + znakovi(i, simbol) + " " + znakovi(i, simbol) + "\n";
		}
		System.out.println(figura);

	}
	static String praznine(int n, int i) {
		String praznine = "";
		for (int j = i; j < n; j++) {
			praznine += " ";
		}
		return praznine;
		
	}
	static String znakovi(int i, char s) {
		String znakovi = "";
		for (int j = 1; j <= i; j++) {
			znakovi += s;
		}
		return znakovi;
	}

}
