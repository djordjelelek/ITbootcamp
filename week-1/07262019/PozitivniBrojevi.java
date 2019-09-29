package zadacacetiri;

import java.util.Scanner;

public class PozitivniBrojevi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, i, s=0;
		boolean b = true;
		for (i=1; i<=5; i++) {
			System.out.printf("Unesite " + i + ". broj" + "\n");
			x = sc.nextInt();
			if (x<0) {
				b = false;
				break;
			}
			s += x;
		}
		if (b) {
			System.out.print("Suma pet pozitivnih brojeva je: " + s);
		}else {
			System.out.print("Suma pet pozitivnih brojeva je: " + s + "\n");
			System.out.printf("Sabiranje je stalo na " + i + ". broju, jer je taj broj negativan");
		}
		
		
		sc.close();


	}

}
