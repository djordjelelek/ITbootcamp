package zadaca6;

import java.util.Scanner;

public class Razlomak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite parametar n: ");
		int n = sc.nextInt();
		System.out.print("Unesite parametar k: ");
		int k = sc.nextInt();
		System.out.print("Izlaz je: " + kolicnik(n, k));
		sc.close();
	}

	static double kolicnik(int x, int y) {
		double kc = 0;
		double y2 = y;
		for (int i = 1; i <= (x + 1); i++) {
			kc += i / y2;
			y2 = y + i;
		}
		return kc;
	}

}
