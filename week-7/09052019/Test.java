package fakultet;

public class Test {

	public static void main(String[] args) {
		Fakultet f = new Fakultet("jdbc:sqlite:C:\\Users\\Djordje\\Desktop\\studentskabaza.db");
		f.connect();
		
		f.dodajStudenta(20140038, "Djordje", "Lelek" , "06.07.2014", "18.03.1994", "Rogatica");
		f.brisanjeIspita();
		f.setDatumRodjenja(20130023, "08.02.1988");
		
		f.ispisPredmeti();
		System.out.println();
		f.studentiIzBeograda();
		System.out.println();
		f.mjestaRodjenja();
		System.out.println();
		f.predmetiViseOd6Bodova();
		System.out.println();
		f.predmetiizmedju6i15();
		System.out.println();
		f.cijenaIspita();
		System.out.println();
		f.bodovi81i76i59();
		System.out.println();
		f.bodoviNisu81i76i59();
		
		f.disconnect();

	}

}
