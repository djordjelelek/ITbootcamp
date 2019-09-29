package zadacanova15;

import java.util.Scanner;

public class Zadatak2 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean bul;
		char a = 'A';
		char b = 'B';
		int[] niz_a = ucitavanjeNiza(a);
		int[] niz_b = ucitavanjeNiza(b);
		bul = provjeraPodskupa(niz_a, niz_b);
		if (bul == true)
			System.out.println("Niz A jeste podskup niza B!");
		else
			System.out.println("Niz A nije podskup niza B!");
		sc.close();

	}

	public static int[] ucitavanjeNiza(char c) {
		sc = new Scanner(System.in);
		int br;
		int el;
		int[] niz;
		System.out.print("Koliko elemenata zelite da ima niz " + c + " ? ");
		br = sc.nextInt();
		niz = new int[br];
		System.out.print("Unesite elemente niza " + c + ": ");
		for (int i = 0; i < br; i++) {

			el = sc.nextInt();
			niz[i] = el;

		}

		return niz;

	}

	public static boolean provjeraPodskupa(int[] a, int[] b) {
		boolean bul = true;
		for (int i = 0; i < a.length; i++) {
			bul = false;
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					bul = true;
					break;
				}
			}
			if (bul == false)
				break;

		}

		return bul;
	}

}
