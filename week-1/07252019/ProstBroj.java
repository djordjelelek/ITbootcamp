package TrecaZadaca;

import java.util.Scanner;

public class ProstBroj {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, i, prost = 1;
		System.out.println("Unesite broj:");
		x = sc.nextInt();
		i = 2;
		while (i < x) {
			if (x % i != 0) {
				i++;
			} else {
				prost = 0;
				i = x;
			}
		}
		if (prost == 1) {
			System.out.println("ovo JESTE prost broj");
		} else {
			System.out.println("ovo NIJE prost broj");
		}

		sc.close();

	}

}
