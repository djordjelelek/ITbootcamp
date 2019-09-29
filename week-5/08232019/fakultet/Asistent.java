package zadaca1.fakultet;

import java.time.LocalDate;

public class Asistent extends Nastavnik {
	String smjerDoktorskih;

	public Asistent(String ime, String prezime, LocalDate datumRodjenja, int godinaZaposlenja, double plata,
			String smjerDoktorskih) {
		super(ime, prezime, datumRodjenja, godinaZaposlenja, plata);
		this.smjerDoktorskih = smjerDoktorskih;
	}

	public String getSmjerDoktorskih() {
		return smjerDoktorskih;
	}

	public String toString() {
		return super.toString() + "smjer doktorskih asistenta: " + smjerDoktorskih + "\n";
	}

}
