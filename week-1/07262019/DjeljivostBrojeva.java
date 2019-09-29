package zadacacetiri;

import java.util.Scanner;

public class DjeljivostBrojeva {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int x = 1; x <= 100; x++) {
			int m = x % 3;
			int n = x % 5;
			if (m == 0 && n == 0) {
				System.out.print("FizzBuzz" + " ");
			} else if (m == 0) {
				System.out.print("Fizz" + " ");
			} else if (n == 0) {
				System.out.print("Buzz" + " ");
			} else {
				System.out.print(x + " ");
			}
		}
		sc.close();

	}

}
