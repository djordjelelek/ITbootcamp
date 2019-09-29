package zadaca1.knjiga;

public class Test {

	public static void main(String[] args) {
		ListPapira lp1 = new ListPapira("Ovo su srpske zemlje:", 1);
		ListPapira lp2 = new ListPapira("Srbija, Crna Gora i Republika Srpska,", 2);
		ListPapira lp3 = new ListPapira("Okupirana Republika Srpska Krajina,", 3);
		ListPapira lp4 = new ListPapira("Bice opet jedna drzava.", 4);
		ListPapira lp5 = new ListPapira("Okupirana, ali nikad zaboravljena Republika Srpska Krajina,", 3);
		Knjiga k1 = new Knjiga("SRPSKE ZEMLJE");
		k1.dodavanjeListova(lp1);
		k1.dodavanjeListova(lp2);
		k1.dodavanjeListova(lp3);
		k1.dodavanjeListova(lp4);
		k1.dodavanjeListova(lp5);

		ListPapira lpn1 = new ListPapira("Ovo je hrvatska istorija.", 1);
		ListPapira lpn2 = new ListPapira("hahahahahahahah", 2);
		ListPapira lpn3 = new ListPapira("Nema je!", 3);
		ListPapira lpn4 = new ListPapira("PRAZNA KNJIGA!", 4);
		Knjiga k2 = new Knjiga("HRVATSKA ISTORIJA");
		k2.dodavanjeListova(lpn1);
		k2.dodavanjeListova(lpn2);
		k2.dodavanjeListova(lpn3);
		k2.dodavanjeListova(lpn4);

		ListPapira lpnn1 = new ListPapira("Bosna i Hercegovina su srpske zemlje!", 1);
		ListPapira lpnn2 = new ListPapira("Bosna je srpska zemlja!", 2);
		ListPapira lpnn3 = new ListPapira("Hercegovina je hrvatska zemlja!", 3);
		ListPapira lpnn4 = new ListPapira("Hercegovina je srpska zemlja!", 3);
		Knjiga k3 = new Knjiga("ISTORIJA BOSNE I HERCEGOVINE");

		k3.dodavanjeListova(lpnn1);
		k3.dodavanjeListova(lpnn2);
		k3.dodavanjeListova(lpnn3);
		k3.dodavanjeListova(lpnn4);

		Polica p = new Polica();
		p.dodavanjeKnjiga(k1);
		p.dodavanjeKnjiga(k2);
		p.uzimanjeKnjige("HRVATSKA ISTORIJA");
		p.dodavanjeKnjiga(k3);
		System.out.println(p);

	}

}
