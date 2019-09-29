package zadacanova12;

import java.util.Scanner;

public class Zadatak1 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vel_niza = brojElemenata();
		int[][] niz = ucitavanjeNiza(vel_niza);
		int[] min_max = minMax(niz);
		System.out.println("Minimalni broj niza je: " + min_max[0] + " , a maksimalni: " + min_max[1]);

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

	static int[] minMax(int[][] niz) {
		int min = niz[0][0];
		int maks = niz[0][0];
		int[] min_maks = new int[2];
		for (int i = 1; i < niz.length; i++) {
			for (int j = 0; j < niz[i].length; j++) {
				if (niz[i][j] < min) {
					min = niz[i][j];
				} else if (niz[i][j] > maks) {
					maks = niz[i][j];
				}

			}

		}
		min_maks[0] = min;
		min_maks[1] = maks;
		return min_maks;

	}

}
