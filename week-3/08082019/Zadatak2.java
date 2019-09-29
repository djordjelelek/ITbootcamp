package zadacanova12;

import java.util.Scanner;

public class Zadatak2 {

	private static Scanner sc;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vel_niza = brojElemenata();
		int[][] niz = ucitavanjeNiza(vel_niza);
		int suma = sumaNiza(niz);
		System.out.println("Suma zadatog niza je: " + suma);

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


	static int sumaNiza(int[][] niz) {
		sc = new Scanner (System.in);
		System.out.print("Kom redu zelite da izracunate sumu: ");
		int x = sc.nextInt();
		int suma = 0;
		for (int i = 0; i < niz[x].length; i++) {
			
			suma += niz[x][i];
		}
		return suma;
		
	}
}
