package zadacanova12;

import java.util.Scanner;

public class Zadatak4 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vel_niza = brojElemenata();
		int[][] niz = ucitavanjeNiza(vel_niza);
		int suma = sumaKolone(niz);
		System.out.println("Suma zadate kolone je: " + suma);

		sc.close();

	}

	static int brojElemenata() {
		sc = new Scanner(System.in);
		System.out.print("Koliki zelite da vas dvodimenzionalni niz sadrzi redova: ");
		int m = sc.nextInt();
		return m;
	}

	static int[][] ucitavanjeNiza(int m) {
		sc = new Scanner(System.in);
		int[][] niz = new int[m][];
		for (int i = 0; i < m; i++) {
			System.out.print("Koliki zelite da " + i + ". red vaseg dvodimenzionalnog niza sadrzi kolona: ");
			int n = sc.nextInt();
			niz[i] = new int[n];
			System.out.println("Unesite elemente " + i + ". reda: ");
			for (int j = 0; j < n; j++) {
				int element = sc.nextInt();
				niz[i][j] = element;
			}
		}
		return niz;
	}

	static int sumaKolone(int[][] niz) {
		sc = new Scanner(System.in);
		System.out.print("Kojoj koloni zelite da izracunate sumu: ");
		int x = sc.nextInt();
		int suma = 0;
		for (int i = 0; i < niz.length; i++) {
			if (niz[i].length < x + 1)
				continue;
			suma += niz[i][x];
		}
		return suma;

	}
}
