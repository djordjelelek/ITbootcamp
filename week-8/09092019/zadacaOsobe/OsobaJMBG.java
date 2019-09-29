package zadacaOsobe;

public class OsobaJMBG extends Osoba{
	private String JMBG;

	public OsobaJMBG(String ime, String prezime, String adresa) {
		super(ime, prezime, adresa);
		
	}

	public OsobaJMBG(OsobaJMBG o) {
		super(o);
		this.JMBG = o.JMBG;
	}


	public String getJMBG() {
		return JMBG;
	}
	

	public boolean setJMBG(String JMBG) {
		boolean b;
		String god;
		if (JMBG.length() == 13) god = JMBG.substring(0, 2) + "." + JMBG.substring(2, 4) + ".1" + JMBG.substring(4, 7) + ".";
		else {
			System.out.println("Nepravilan unos JMBG! Molimo unesite ponovo!");
			return false;
		}
		Datum d = new Datum();
		b = d.provjeraDatuma(god);
		if (b == true) {
			this.JMBG = JMBG;
			return true;
		}
		else return false;
		
	}

	@Override
	public int numeroloskiBroj() {
		int numeroloski = 1;
		int i = Integer.parseInt(JMBG.substring(0, 7));
		boolean b = false;
		while (b == false) {
			while (i != 0) {
				numeroloski += (i % 10);
				i /= 10;
			}
			if (numeroloski > 9) {
				i = numeroloski;
				numeroloski = 0;

			} else b = true;
		}

		return numeroloski;
		
	}
	
	
	@Override
	public String metabolizam(Datum datum) {
		String met = "";
		String rodjenje = JMBG.substring(0, 4) + "1" + JMBG.substring(4, 7);

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
	
	
	
	
	
	public String toString() {
		return "IME I PREZIME: " + ime + " " + prezime + ", ADRESA: "+ adresa + ", JMBG: "  +  JMBG;
		
	}
	

}
