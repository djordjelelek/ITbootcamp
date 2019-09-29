package zadaca5;

import java.util.Scanner;

public class Kasirka {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int zbir = 0;
		int brojartikala = 1;
		System.out.printf("Unesite vrijednost 1. proizvoda: ");
		int vrijednost = sc.nextInt();
		System.out.printf("Unesite kolicinu 1. proizvoda: ");
		int kolicina = sc.nextInt();
		while (vrijednost > 0) {    //popust na 3. proizvod
			if (kolicina >= 3) {
				vrijednost -= (vrijednost / 10);
			}
			zbir += (vrijednost * kolicina);
			brojartikala++;
			System.out.printf("Unesite vrijednost " + brojartikala + ". prozivoda ili (-1) ako nema vise proizvoda: ");
			vrijednost = sc.nextInt();
			if (vrijednost == -1) {
				break;
			}
			System.out.printf("Unesite kolicinu " + brojartikala + ". prozivoda: ");
			kolicina = sc.nextInt();

		}
		System.out.println("Ukupan racun: " + zbir);
		
		System.out.print("Koliko je novca korisnik dao: ");
		int korisnik = sc.nextInt();
		int vratiti = korisnik - zbir;
		System.out.println("Kusur je: " + vratiti);
		System.out.println("Najmanji broj kovanica je: ");
		while (vratiti == 0)
			;
		{
			if (vratiti / 20 != 0) {
				System.out.println("Broj kovanica od 20 dinara je: " + (vratiti / 20));
				vratiti %= 20;
			}
			if (vratiti / 10 != 0) {
				System.out.println("Broj kovanica od 10 dinara je: " + (vratiti / 10));
				vratiti %= 10;
			}
			if (vratiti / 5 != 0) {
				System.out.println("Broj kovanica od 5 dinara je: " + (vratiti / 5));
				vratiti %= 5;
			}
			if (vratiti / 1 != 0) {
				System.out.println("Broj kovanica od 1 dinar je: " + (vratiti / 1));
				vratiti %= 1;
			}

		}

		sc.close();

	}

}
