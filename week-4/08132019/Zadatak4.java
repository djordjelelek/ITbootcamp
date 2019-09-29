package zadacanova15;

import java.util.Scanner;

public class Zadatak4 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = ucitavanjeStringa();
		char[] karakteri = provjeraStringa(s);

		System.out.print("Zajednicki karakteri su: ");
		if (karakteri.length == 0)
			System.out.print("nema zajednickih karaktera!");
		for (char element: karakteri) {
			System.out.print(element + " ");

		}

		sc.close();

	}

	public static String[] ucitavanjeStringa() {
		sc = new Scanner(System.in);
		System.out.print("Koliko zelite da imate elemenata u nizu stringova? ");
		int x = sc.nextInt();
		String[] s = new String[x];
		System.out.print("Unesite stringove: ");
		for (int i = 0; i < s.length; i++) {
			String element = sc.next();
			s[i] = element;

		}
		return s;
	}

	public static char[] provjeraStringa(String[] s) {
		String prvi = s[0];

		char[] prelazni = new char[prvi.length()];
		char[] konacni = null;
		int brojac = 0;
		boolean b = true;
		for (int i = 0; i < prvi.length(); i++) {
			b = provjeraElemenata(s, prvi.charAt(i));
			if (b == true) {
				prelazni[brojac] = prvi.charAt(i);
				brojac++;
			} else
				b = true;
		}
		konacni = new char[brojac];
		for (int i = 0; i < brojac; i++) {
			konacni[i] = prelazni[i];
		}

		return konacni;

	}

	public static boolean provjeraElemenata(String[] s, char c) {
		boolean b = true;
		for (int i = 1; i < s.length; i++) {
			b = false;
			for (int j = 0; j < s[i].length(); j++) {
				if (c == s[i].charAt(j)) {
					b = true;
					break;
				}
			}
			if (b == false)
				break;

		}
		return b;
	}

}
