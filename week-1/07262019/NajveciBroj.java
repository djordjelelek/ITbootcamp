package zadacacetiri;

import java.util.Scanner;

public class NajveciBroj {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int x, y, n = 0;
		System.out.println("Unesite broj");
		x = sc.nextInt();
		int x2 = x;
		while (x>0) {
			y = x%10;
			if (y>n) {
				n=y;
			}else if (n==9) {
				break;
			}
			x = x/10;
		}
		System.out.printf("Najveca cifra broja " + x2 + " je broj: " + n);
		
		
		sc.close();
		

	}

}
