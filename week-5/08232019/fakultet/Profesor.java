package zadaca1.fakultet;

import java.time.LocalDate;

public class Profesor extends Nastavnik {
	private String titula;

	public Profesor(String ime, String prezime, LocalDate datumRodjenja, int godinaZaposlenja, double plata) {
		super(ime, prezime, datumRodjenja, godinaZaposlenja, plata);
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		if (titula == "docent" || titula == "vanredni" || titula == "redovni" || titula == "dr")
			this.titula = titula;
	}

	public String toString() {
		return super.toString() + "titula profesora: " + titula + "\n";
	}

}
