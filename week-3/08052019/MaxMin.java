package zadacanova10;

import java.util.Scanner;

public class MaxMin {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = brojElemenata();
		int[] niz = ucitavanjeNiza(n);
		int[] min_max = minMax(niz);
		System.out.println("Minimalni broj niza je: " + min_max[0] + 
							" , a maksimalni: " + min_max[1]);

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

	static int[] minMax(int[] niz) {
		int min = niz[0];
		int maks = niz[0];
		for (int i = 1; i < niz.length; i++) {
			if (niz[i] < min) {
				min = niz[i];
			} else if (niz[i] > maks) {
				maks = niz[i];
			}
		}
		int[] niz2 = new int[2];
		niz2[0] = min;
		niz2[1] = maks;
		return niz2;

	}

}
