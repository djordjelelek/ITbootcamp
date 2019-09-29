package zadaca7i8;

import java.util.Scanner;

public class Alkotest {

	private static Scanner sc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodosli u alko aproksimator 1000");
		System.out.print("Unesite vasu tezinu(kg): ");
		double m = sc.nextDouble();
		m *= 1000;
		double r = (pol());
		double suma_alk = sumaAlkohola();
		//System.out.println(suma_alk);
		double bas = (suma_alk * 1000 /(m * r));
		//System.out.println(bas);
		ispis (bas);
		sc.close();

	}

	static double pol() {
		sc = new Scanner(System.in);
		int pol;
		double r;
		do {
			System.out.print("Unesite vas pol (ako ste musko unesite 1, "
							+ "a ako ste zensko unesite 0): ");
			pol = sc.nextInt();
		} while (pol != 1 && pol != 0);
		if (pol == 1) {
			r = 0.55;
		} else {
			r = 0.68;
		}
		return (r);
	}

	static double sumaAlkohola() {
		sc = new Scanner(System.in);
		double suma_alkohola = 0;
		int id = 1;
		double procenat = 0;
		double kolicina = 0;
		while (id != -1) {
			id = idPica();
			if (id == -1) {
				break;
			}
			procenat = procenatAlkohola(id);
			System.out.print("Koliko mililitara(ml) tog pica ste popili: ");
			kolicina = sc.nextDouble();
			
			suma_alkohola += (procenat*kolicina);
		
		}
		return suma_alkohola;
	}

	static int idPica() {
		sc = new Scanner(System.in);
		int id = 0;
		do {
			System.out.print(
					"Unesite id pica koje ste popili "
					+ "ili -1 ako ste unijeli sva pica koja ste popili: ");
			id = sc.nextInt();
			if (id != -1 && id != 1 && id != 2 && id != 3 && id != 4) {
				System.out.println("Greska u unosu (ne postoji pice sa tim id-om");
			}
		}while (id != -1 && id != 1 && id != 2 && id != 3 && id != 4);
		return (id);
	}
	static double procenatAlkohola(int id) {
		double procenat = 0;
		switch (id) {
		case 1: procenat = 0.5; break;
		case 2: procenat = 0.4; break;
		case 3: procenat = 0.047; break;
		case 4: procenat = 0.11;
		}
		return (procenat);
	}
	static void ispis(double bas) {
		if (bas <= 0.20) {
			System.out.println("------------------" + "\n" +
					"BAS = " + bas + " - dozvoljena alkoholisanost" + "\n" +
					"------------------" + "\n" + 
					"KAZNA: bez kazne" + "\n" + 
					"KAZNENI POENI: 0" + "\n" + 
					"ZABRANA VOZNJE: 0 mjeseci");
		} else if (bas <= 0.50) {
			System.out.println("------------------" + "\n" +
					"BAS = " + bas + " - umjerena alkoholisanost" + "\n" + 
					"------------------" + "\n" + 
					"KAZNA: 10 000 dinara" + "\n" + 
					"KAZNENI POENI: 0" + "\n" + 
					"ZABRANA VOZNJE: 0 mjeseci");
		}else if (bas <= 0.80) {
			System.out.println("------------------" + "\n" +
					"BAS = " + bas + " - srednja alkoholisanost" + "\n" + 
					"------------------" + "\n" + 
					"KAZNA: 10 000 - 20 000 dinara" + "\n" + 
					"KAZNENI POENI: 6" + "\n" + 
					"ZABRANA VOZNJE: 3 mjeseca");
		}else if (bas <= 1.2) {
			System.out.println("------------------" + "\n" +
					"BAS = " + bas + " - visoka alkoholisanost" + "\n" + 
					"------------------" + "\n" + 
					"KAZNA: 20 000 - 40 000 dinara" + "\n" + 
					"KAZNENI POENI: 8" + "\n" + 
					"ZABRANA VOZNJE: 4 mjeseca");
		}else if (bas <= 1.6) {
			System.out.println("------------------" + "\n" +
					"BAS = " + bas + " - teska alkoholisanost" + "\n" + 
					"------------------" + "\n" + 
					"KAZNA: 100 000 - 120 000 dinara" + "\n" + 
					"KAZNENI POENI: 9" + "\n" + 
					"ZABRANA VOZNJE: 8 mjeseca");
		}else if (bas <= 2.0) {
			System.out.println("------------------" + "\n" +
					"BAS = " + bas + " - teska visoka alkoholisanost" + "\n" + 
					"------------------" + "\n" + 
					"KAZNA: 100 000 - 120 000 dinara" + "\n" + 
					"KAZNENI POENI: 14" + "\n" + 
					"ZABRANA VOZNJE: 8 mjeseca");
		}else {
			System.out.println("------------------" + "\n" +
					"BAS = " + bas + " - potpuna alkoholisanost" + "\n" + 
					"------------------" + "\n" + 
					"KAZNA: 30 do 60 dana zatvora" + "\n" + 
					"KAZNENI POENI: 15" + "\n" + 
					"ZABRANA VOZNJE: 9 mjeseca");
		}
		
		
	}

}
