package zadacanova10;

import java.util.Scanner;

public class ElementNedostaje {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = brojElemenata();
		int[] niz = ucitavanjeNiza(n);
		niz = sortiranjeNiza(niz);
		int x = elementNedostaje(niz);
		System.out.println("Element koji nedostaje je: " + x);
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

	static int[] sortiranjeNiza(int[] niz) {
		for (int i = 0; i < niz.length - 1; i++) {
			for (int j = i + 1; j < niz.length; j++) {
				if (niz[i] > niz[j]) {
					int a = niz[i];
					niz[i] = niz[j];
					niz[j] = a;
				}
			}
		}
		return (niz);

	}

	static int elementNedostaje(int[] niz) {
		for (int i = 1; i < niz.length; i++) {
			if (niz[i] != niz[i - 1] + 1) {
				return niz[i] - 1;
			}
		}
		return 0;
	}

}
