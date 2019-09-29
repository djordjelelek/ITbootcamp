package zadacanova11;

import java.util.Scanner;

public class Zadatak1 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = brojElemenata();
		int[] niz = ucitavanjeNiza(n);
		provjeraBroja(niz);
		sc.close();

	}

	static int brojElemenata() {
		sc = new Scanner(System.in);
		System.out.print("Koliki zelite da vas niz sadrzi elemenata: ");
		int n = sc.nextInt();
		return n;
	}

	static int[] ucitavanjeNiza(int n) {
		sc = new Scanner(System.in);
		int[] a = new int[n];
		int broj_elementa = 1;
		for (int i = 0; i < n; i++, broj_elementa++) {
			System.out.print("Unesi " + broj_elementa + ". element niza: ");
			a[i] = sc.nextInt();
		}
		return a;

	}

	static void provjeraBroja(int[] niz) {
		sc = new Scanner(System.in);
		System.out.print("Unesite broj za provjeru: ");
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
