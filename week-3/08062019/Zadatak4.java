package zadacanova11;

import java.util.Scanner;

public class Zadatak4 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = brojElemenata();
		int[] niz = ucitavanjeNiza(n);
		duplikat(niz);
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

	static void duplikat(int[] niz) {
		boolean b = false;
		for (int i = 0; i < niz.length - 1; i++) {
			for (int j = i + 1; j < niz.length; j++) {
				if (niz[j] == niz[i]) {
					b = true;
					break;
				}
			}
		}
		if (b) {
			System.out.println("U ovom nizu se nalazi duplikat.");
		} else {
			System.out.println("U ovom nizu se NE nalazi duplikat.");
		}
	}

}
