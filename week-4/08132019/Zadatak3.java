package zadacanova15;

import java.util.Scanner;

public class Zadatak3 {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] niz = upisivanjeNiza();
		int[] sredjeni = sredjivanjeNiza(niz);
		System.out.print("Sredjeni niz: ");
		for (int element: sredjeni) {
			System.out.print(element + " ");
		}
		sc.close();

	}

	public static int[] upisivanjeNiza() {
		sc = new Scanner(System.in);
		System.out.print("Koliko zelite da vas niz ima elemenata? ");
		int broj = sc.nextInt();
		int[] niz = new int[broj];
		System.out.print("Unesite elemente vasega niza: ");
		for (int i = 0; i < niz.length; i++) {
			int element = sc.nextInt();
			niz[i] = element;
		}
		return niz;
	}

	public static int[] sredjivanjeNiza(int[] niz) {
		int[] sredjeni = new int[niz.length];
		int brojac = 0;
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] % 2 == 0) {
				sredjeni[brojac] = niz[i];
				brojac++;
			}
		}
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] % 2 != 0) {
				sredjeni[brojac] = niz[i];
				brojac++;
			}
		}

		return sredjeni;
	}

}
