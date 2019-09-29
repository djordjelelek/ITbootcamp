package titlovi;

import java.util.Scanner;

public class GlavniProgram {

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		System.out.println("NE RADI ZA 4 i 5. Pri kraju je zavrsetak i te dvije, ali nisam stigao veceras da zavrsim");
		System.out.println(
				"Izaberite koju konverziju zelite:" + "\n\t0 MPlayer ----> MicroDVD" + "\n\t1 MPlayer ----> SubRip"
						+ "\n\t2 SubRip ----> MicroDVD" + "\n\t3 SubRip ----> MPlayer" + "\n\t4 MicroDVD ----> SubRip"
						+ "\n\t5 MicroDVD ----> MPlayer" + "\nIZABERITE JEDNU OD PUNUDJENIH OPCIJA:");
		int i = sc.nextInt();
		while (i < 0 || i > 5) {
			System.out.println("Izabrali ste pogresnu naredbu! Molimo vas izaberite ponovo");
			i = sc.nextInt();
		}
		Titl t = null;
		switch (i) {
		case 0:
			t = new MPlayer(arg[2], 0);
			t.pretvaranje();
			break;
		case 1:
			t = new MPlayer(arg[2], 1);
			t.pretvaranje();
			break;
		case 2:
			t = new SubRip(arg[1], 2);
			t.pretvaranje();
			break;
		case 3:
			t = new SubRip(arg[1], 3);
			t.pretvaranje();
			break;
		case 4:
			t = new MicroDVD(arg[0], 4);
			t.pretvaranje();
			break;
		case 5:
			t = new MicroDVD(arg[0], 5);
			t.pretvaranje();
			break;
		}
		System.out.println("Da li zelite da vas titl bude stampan u konzoli?");
		String s = sc.next();
		while (!s.equals("da") && !s.equals("ne")) {
			System.out.println("Izabrali ste pogresnu naredbu! Molimo vas izaberite ponovo");
			s = sc.next();
		}
		if (s.equals("da"))
			t.stampanje(i);
		System.out.println("KRAJ RADA!!!");
		sc.close();

	}

}
