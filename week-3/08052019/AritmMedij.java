package zadacanova10;

import java.util.Scanner;

public class AritmMedij {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = brojElemenata();
		int[] niz = ucitavanjeNiza(n);
		double arit_sred = aritmetrickaSredina(niz);
		double medijana = medijana(niz);
		System.out.println(
				"Aritmetricka sredina zadatog niza je " + arit_sred + "\n" + "Medijana zadatog niza je: " + medijana);
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

	static double aritmetrickaSredina(int[] niz) {
		double suma = 0;
		for (int i = 0; i < niz.length; i++) {
			suma += niz[i];
		}
		suma /= niz.length;
		return suma;
	}

	static double medijana(int[] niz) {
		niz = sortiranjeNiz(niz);
		if (niz.length % 2 == 0) {
			int i = niz.length / 2;
			double j = 2;
			return (niz[i] + niz[i - 1]) / j;

		}
		int k = niz.length / 2;
		return niz[k];

	}

	static int[] sortiranjeNiz(int[] niz) {
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
}
