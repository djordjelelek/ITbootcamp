package student;

public class Student {
	private String potpis;
	private String jmbg;
	private Ocjena[] upisaneOcjene;
	private static int brOcjena = 0;

	public Student(String potpis, String jmbg, Ocjena[] upisaneOcjene) {
		this.potpis = potpis;
		this.jmbg = jmbg;
		this.upisaneOcjene = upisaneOcjene;
	}

	public String getPotpis() {
		return potpis;
	}

	public void setPotpis(String potpis) {
		this.potpis = potpis;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void upisOcjene(Ocjena a) {
		upisaneOcjene[brOcjena] = a;
		brOcjena++;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Ocjena[] getUpisaneOcjene() {
		return upisaneOcjene;
	}

	public double getProsecnaOcena() {
		double zbir = 0;
		int brojac = 0;
		for (Ocjena i : upisaneOcjene) {
			int ocjena = i.getOcjena();
			if (ocjena != 5) {
				zbir += ocjena;
				brojac++;
			}

		}
		return zbir / brojac;
	}

	public String getDatumRodjenja() {
		String rodjenje;
		String s = jmbg.substring(0, 7);
		rodjenje = s.substring(0, 2) + ". " + s.substring(2, 4) + ". ";
		if (s.charAt(4) == '9')
			rodjenje += "1";
		else
			rodjenje += "2";
		rodjenje += s.substring(4, 7) + ".";

		return rodjenje;
	}

	public String getIme() {
		String ime = "";
		String[] imePrezime = potpis.split(" ");
		ime = imePrezime[0];
		return ime;
	}

	public String getPrezime() {
		String prezime = "";
		String[] imePrezime = potpis.split(" ");
		prezime = imePrezime[1];
		return prezime;
	}

	public String najboljaOcena() {
		int najBodovi = 0;
		String ime = "";
		for (Ocjena ocjena : upisaneOcjene) {
			if (ocjena.getBodovi() > najBodovi) {
				najBodovi = ocjena.getOcjena();
				ime = ocjena.getPr().getIme();
			}
		}
		return ime;
	}

	public static Student[] prosekVeciOd(Student[] nizStudenata, double ocena) {
		int brojac = 0;
		int k = 0;
		for (int i = 0; i < nizStudenata.length; i++) {
			if (nizStudenata[i].getProsecnaOcena() >= ocena)
				brojac++;
		}
		Student[] boljiStudenti = new Student[brojac];
		for (int i = 0; i < nizStudenata.length; i++) {
			if (nizStudenata[i].getProsecnaOcena() >= ocena) {
				boljiStudenti[k] = nizStudenata[i];
				k++;
			}
		}

		return boljiStudenti;
	}

	static boolean starijiOd(Student s, int god) {
		boolean b = false;
		String str = s.getDatumRodjenja();
		str = str.substring(8, 12);
		int x = Integer.parseInt(str);
		if ((2019 - x) >= 21)
			b = true;
		return b;
	}
}
