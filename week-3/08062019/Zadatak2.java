package zadacanova11;

import java.util.Random;
import java.util.Scanner;

public class Zadatak2 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = brojElemenata();
		int gg = gornjaGranica();
		int[] niz = ucitavanjeNiza(n, gg);
		provjeraBroja(niz);
		sc.close();

	}

	static int brojElemenata() {
		sc = new Scanner(System.in);
		System.out.print("Koliki zelite da vas niz sadrzi elemenata: ");
		int n = sc.nextInt();
		return n;
	}

	static int gornjaGranica() {
		sc = new Scanner(System.in);
		System.out.print("Kolika je gornja granica niza: ");
		int x = sc.nextInt();
		return x;

	}

	static int[] ucitavanjeNiza(int n, int gg) {
		Random r = new Random();
		int[] niz = new int[n];
		for (int i = 0; i < niz.length; i++) {
			niz[i] = r.nextInt(gg);
		}
		for (int i = 0; i < niz.length; i++) {
			System.out.print(niz[i] + " ");
		}

		return niz;

	}

	static void provjeraBroja(int[] niz) {
		sc = new Scanner(System.in);
		System.out.print("\n" + "Unesite broj za provjeru: ");
		int x = sc.nextInt();
		boolean b = false;
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] == x) {
				b = true;
				break;
			}
		}
		if (b) {
			System.out.println("Ovaj broj se nalazi u nizu.");
		} else {
			System.out.println("Ovaj broj se ne nalazi u nizu.");
		}
	}

}