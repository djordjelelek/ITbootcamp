package zadacaOsobe;

public class OsobaDatum extends Osoba {
	protected Datum datum = new Datum();

	public OsobaDatum(String ime, String prezime, String adresa, Datum datum) {
		super(ime, prezime, adresa);
		this.datum = datum;
	}

	public OsobaDatum(OsobaDatum o) {
		super(o);
		this.datum = o.datum;
	}

	public Datum getDatum() {
		return datum;
	}

	@Override
	public int numeroloskiBroj() { // 18 3 1994
		int numeroloski = 0;
		int dan = datum.getDan();
		int mjesec = datum.getMjesec();
		int godina = datum.getGodina();
		String d = Integer.toString(dan);
		String m = Integer.toString(mjesec);
		String g = Integer.toString(godina);
		String s = d + m + g;
		int i = Integer.parseInt(s);
		boolean b = false;
		while (b == false) {
			while (i != 0) {
				numeroloski += (i % 10);
				i /= 10;
			}
			if (numeroloski > 9) {
				i = numeroloski;
				numeroloski = 0;

			} else
				b = true;
		}

		return numeroloski;
	}

	@Override
	public String metabolizam(Datum datum) {
		String met = "";

		int dan1 = datum.getDan();
		int mjesec1 = datum.getMjesec();
		int godina1 = datum.getGodina();
		String d1 = Integer.toString(dan1);
		String m1 = Integer.toString(mjesec1);
		String g1 = Integer.toString(godina1);
		if (d1.length() == 1)
			d1 = "0" + d1;
		if (m1.length() == 1)
			m1 = "0" + m1;
		String rodjenje = d1 + m1 + g1;

		int dan = datum.getDan();
		int mjesec = datum.getMjesec();
		int godina = datum.getGodina();
		String d = Integer.toString(dan);
		String m = Integer.toString(mjesec);
		String g = Integer.toString(godina);
		if (d.length() == 1)
			d = "0" + d;
		if (m.length() == 1)
			m = "0" + m;
		String danas = d + m + g;

		int rodj = Integer.parseInt(rodjenje);
		int dana = Integer.parseInt(danas);

		int zbir = rodj + dana;
		met = Integer.toString(zbir);
		if (met.length() == 7)
			met = "0" + met;

		return met;
	}

	@Override
	public String toString() {
		return "IME I PREZIME: " + ime + " " + prezime + ", ADRESA: " + adresa + ", DATUM: " + datum;
	}

}
