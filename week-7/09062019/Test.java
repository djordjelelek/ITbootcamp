package fudbal;


public class Test {

	public static void main(String[] args) {
		FudbalskaLiga f = new FudbalskaLiga("jdbc:sqlite:C:\\Users\\Djordje\\Downloads\\FudbalskiSavez.db");
		f.connect();
		
		f.igraciTimovi();
		System.out.println();
		f.igraciMancestera();
		System.out.println();
		f.brojGolova();
		System.out.println();
		f.najviseGolova();
		System.out.println();
		f.kartoni();
		System.out.println();
		f.gradovi(12);
		
		f.ubacivanjeTima("Mladost", "Rogatica");
		f.ubacivanjeIgraca("Miroslav Radovic Coma", "Mladost");
		f.ubacivanjeUtakmice("Mladost", "Arsenal", 3, "1", 2019);
		
		f.brisanjeTima("Barselona");
		
		f.disconnect();

	}

}
