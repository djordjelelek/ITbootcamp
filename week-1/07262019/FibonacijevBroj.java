package zadacacetiri;

import java.util.Scanner;

public class FibonacijevBroj {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int f = 0, fp = 1, fz = 1;
		System.out.println("Unesite koji Fionacijev broj zelite:");
		int x = sc.nextInt();
		for (int i = 3; i <= x; i++) {
			f = fp + fz;
			fp = fz;
			fz = f;
		}
		if (x == 1 | x == 2) {
			System.out.print(x + ". Fibonacijev broj je: 1");  //izuzetak prva dva//
		}else {
			System.out.print(x + ". Fibonacijev broj je: " + f);
		}

		sc.close();

	}

}
