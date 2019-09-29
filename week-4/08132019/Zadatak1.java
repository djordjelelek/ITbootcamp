package zadacanova15;

import java.util.Scanner;

public class Zadatak1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Koji tribonacijev broj zelite? ");  //hahahahahha tribonacijev
		int x = sc.nextInt();
		System.out.println(tribonacijevNiz(x - 1));
		sc.close();

	}

	public static int tribonacijevNiz(int x) {
		if (x == 0)
			return 0;
		else if (x == 1)
			return 1;
		else if (x == 2)
			return 1;
		return tribonacijevNiz(x - 1) + tribonacijevNiz(x - 2) + tribonacijevNiz(x - 3);

	}

}
