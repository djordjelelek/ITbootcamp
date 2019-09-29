package zadacanova11;

import java.util.Scanner;

public class Zadatak3 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = brojElemenata();
		int[] niz = ucitavanjeNiza(n);
		double srednja_vr = srednjaVrijednost(niz);
		najblizaVrijednost(niz, srednja_vr);
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

	static double srednjaVrijednost(int[] niz) {
		double suma = 0;
		for (int i = 0; i < niz.length; i++) {
			suma += niz[i];
		}
		suma /= niz.length;
		System.out.println("Srednja vrijednost u nizu je: " + suma);
		return suma;
	}

	static void najblizaVrijednost(int[] niz, double srednja_vr) {
		double razlika = srednja_vr - niz[0];
		if (razlika < 0) {
			razlika *= (-1);
		}
		int najmanji = niz[0];
		for (int i = 1; i < niz.length; i++) {
			double razlika2 = srednja_vr - niz[i];
			if (razlika2 < 0) {
				razlika2 *= (-1);
			}
			if (razlika2 < razlika) {
				razlika = razlika2;
				najmanji = niz[i];
			}
		}
		System.out.println("Najblizi broj srednje vrijednosi je: " + najmanji);
	}

}
