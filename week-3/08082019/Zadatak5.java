package zadacanova12;

import java.util.Scanner;

public class Zadatak5 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = ucitavanjeStringa();
		int[] niz = alfabet(s);
		for (int i = 0; i < niz.length; i++) {
			System.out.print(niz[i] + " ");
		}
		sc.close();

	}

	public static String ucitavanjeStringa() {
		sc = new Scanner(System.in);
		System.out.print("Unesite vas String: ");
		String s = sc.nextLine();
		s = s.toLowerCase();
		return s;
	}

	public static int[] alfabet(String s) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] niz = new int[26];
		int brojac = 0;
		for (int i = 0; i < alphabet.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == alphabet.charAt(i)) {
					brojac++;
				}
			}
			niz[i] = brojac;
			brojac = 0;
		}

		return niz;
	}

}
