package zadaca4tetris;

public class Tester {

	public static void main(String[] args) {
		Linija l = new Linija();
		l.okreniLijevo();
		System.out.print(l);
		System.out.println();

		LijeviL ll = new LijeviL();
		ll.okreniDesno();
		ll.okreniDesno();
		ll.okreniLijevo();
		System.out.print(ll);
		System.out.println();

		DesniL dl = new DesniL();
		dl.okreniDesno();
		dl.okreniDesno();
		dl.okreniLijevo();
		System.out.println(dl);
		System.out.println();

		Kocka k = new Kocka();
		System.out.println(k);
		System.out.println();

		LijeviZ zl = new LijeviZ();
		zl.okreniDesno();
		System.out.println(zl);
		System.out.println();

		DesniZ zd = new DesniZ();
		zd.okreniDesno();
		zd.okreniLijevo();
		zd.okreniDesno();
		System.out.println(zd);
		System.out.println();

		ObrnutoT t = new ObrnutoT();
		t.okreniLijevo();
		System.out.println(t);
		System.out.println();

	}

}
