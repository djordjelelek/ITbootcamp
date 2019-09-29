package zadacaOsobe;

public abstract class Osoba {
	protected String ime, prezime, adresa;

	public Osoba(String ime, String prezime, String adresa) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
	}

	public Osoba(Osoba o) {
		this.ime = o.ime;
		this.prezime = o.prezime;
		this.adresa = o.adresa;

	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getAdresa() {
		return adresa;
	}

	public abstract int numeroloskiBroj();

	public abstract String metabolizam(final Datum d);

}
