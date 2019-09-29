package student;

public class Ocjena {      //!!!Pisao sam ijekvicom, pa mi je lakse bilo da mijenjam MAIN nego cijelu klasu!!!
	private int bodovi;
	private Predmet pr;

	public Ocjena(int bodovi, Predmet pr) {
		this.bodovi = bodovi;
		this.pr = pr;
	}

	public int getBodovi() {
		return bodovi;
	}

	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}

	public void setPr(Predmet pr) {
		this.pr = pr;
	}

	public Predmet getPr() {
		return pr;
	}

	public int getOcjena() {
		if (bodovi == 100)
			return 10;
		else if (bodovi < 50)
			return 5;
		else
			return (bodovi / 10 + 1);

	}

	public String ispis() {
		String s = "";
		s += "Predmet: " + pr.getIme() + "Ocjena: " + getOcjena();
		return s;
	}

}
