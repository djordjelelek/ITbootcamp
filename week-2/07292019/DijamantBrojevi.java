package zadaca5;

import java.util.Scanner;

public class DijamantBrojevi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite broj: ");
		int x = sc.nextInt();
		String figura = "";
		int red = 1;
		for (int i = x; i > 0; i--) {
			for (int j = i - 1; j > 0; j--) { // j je broj razmaka
				figura += " ";
			}
			for (int k = red; k > 0; k--) {
				figura += k;
			}
			for (int l = 2; l <= red; l++) {
				figura += l;
			}

			figura += "\n";
			red++;
		}
		// System.out.println(figura);
		red -= 2;
		for (int i = 1; i < x; i++) {
			for (int j = 0; j < i; j++) { // j je broj razmaka
				figura += " ";
			}
			for (int k = red; k > 0; k--) {
				figura += k;
			}
			for (int l = 2; l <= red; l++) {
				figura += l;
			}
			figura += "\n";
			red--;
		}
		System.out.println(figura);
		sc.close();
	}

}
