package zadacanova13;

import java.util.Scanner;

public class Zadatak2 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string = unosenjeStringa();
		String niz_samoglasnika = najduziNizSam(string);
		System.out.println("Najduzi podniz samoglasnika je: " + niz_samoglasnika);
		sc.close();

	}

	public static String unosenjeStringa() {
		sc = new Scanner(System.in);
		System.out.print("Unesite vas string: ");
		String s = sc.nextLine();
		s = s.toLowerCase();
		return s;
	}

	public static String najduziNizSam(String s) {
		String najduzi = "";
		String kontrolni = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o'
					&& s.charAt(i) != 'u') {
				continue;

			}
			kontrolni += s.charAt(i);
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u') {
					kontrolni += s.charAt(j);
				} else
					break;

			}
			if (kontrolni.length() > najduzi.length()) {
				najduzi = kontrolni;
				i += kontrolni.length();
				kontrolni = "";
				continue;
			}
			kontrolni = "";
		}

		return najduzi;
	}

}
