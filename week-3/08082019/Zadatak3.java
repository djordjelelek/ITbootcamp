package zadacanova12;

import java.util.Scanner;

public class Zadatak3 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = ucitavanjeStringa();
		char c = ucitavanjeChara();
		int broj_c = brojacKarakteraC(s, c);
		System.out.println("Ukupan broj karaktera c je: " + broj_c);
		sc.close();

	}

	static String ucitavanjeStringa() {
		sc = new Scanner(System.in);
		System.out.print("Unesite vas String: ");
		String s = sc.nextLine();
		s = s.toLowerCase();
		return s;
	}

	static char ucitavanjeChara() {
		String s;
		System.out.print("Koji karakter zelite da provjeravate: ");
		s = sc.nextLine();
		char c = s.charAt(0);
		return c;
	}

	static int brojacKarakteraC(String s, char c) {
		int brojac = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == (c)) {
				brojac++;
			}
		}

		return brojac;
	}

}
