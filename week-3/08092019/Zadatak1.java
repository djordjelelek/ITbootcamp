package zadacanova13;

import java.util.Scanner;

public class Zadatak1 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string = unosenjeStringa();
		String obrnut_str = obrtanjeStringa(string);
		provjeraPalindroma(string, obrnut_str);
		sc.close();

	}

	public static String unosenjeStringa() {
		sc = new Scanner(System.in);
		System.out.print("Unesite vas string: ");
		String s = sc.nextLine();
		s = s.toLowerCase();
		String s2 = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				continue;
			}
			s2 += s.charAt(i);

		}
		return s2;
	}

	public static String obrtanjeStringa(String s) {
		String obrnut = "";
		for (int i = (s.length() - 1); i >= 0; i--) {
			obrnut += s.charAt(i);
		}
		return obrnut;
	}

	public static void provjeraPalindroma(String s, String o) {
		if (s.equals(o)) {
			System.out.println("Ovaj string JESTE palindrom");
		} else {
			System.out.println("Ovaj string NIJE palindrom");
		}

	}

}
