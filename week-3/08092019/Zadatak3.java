package zadacanova13;

import java.util.Scanner;

public class Zadatak3 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = unosenjeStringa();
		kompresijaStr(s);
		sc.close();

	}

	public static String unosenjeStringa() {
		sc = new Scanner(System.in);
		System.out.print("Unesite vas string: ");
		String s = sc.nextLine();
		return s;
	}

	public static void kompresijaStr(String s) {
		String kompr = "";
		int brojac = 0;
		for (int i = 0; i < s.length(); i++) {
			kompr += s.charAt(i);
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(j) == s.charAt(i)) {
					brojac++;
				} else
					break;

			}
			if (brojac >= 3) {
				kompr += "(" + (brojac+1) + ")";
				i += brojac;
				brojac = 0;
				continue;
			}
			brojac = 0;
		}

		System.out.println(kompr);
	}

}
