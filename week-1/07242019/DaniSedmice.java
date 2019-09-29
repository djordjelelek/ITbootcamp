package zadaca;

import java.util.Scanner;

public class DaniSedmice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Broj dana u nedjelji:");
		int a = sc.nextInt();
		switch (a) {
		case 1:
			System.out.println("Ponedjeljak, do vikenda je ostalo cak 5 dana");
			break;
		case 2:
			System.out.println("Utorak, do vikenda je ostalo cak 4 dana");
			break;
		case 3:
			System.out.println("Srijeda, do vikenda je ostalo jos 3 dana");
			break;
		case 4:
			System.out.println("Cetvrtak, do vikenda je ostalo jos 2 dana");
			break;
		case 5:
			System.out.println("Petak, do vikenda je ostalo samo 1 dan");
			break;
		case 6:
			System.out.println("Subota, vikend je i vrijeme je za pivo");
			break;
		case 7:
			System.out.println("Nedjelja, vikend je, ali je sutra ponedjeljak :(");
			break;
		default:
			System.out.println("Pogresan unos broja");

		}
		sc.close();

	}

}
