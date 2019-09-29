package zadaca1.fakultet;

import java.time.LocalDate;

public class OsnovneStudije extends Student {
	private String smjer;

	public OsnovneStudije(String ime, String prezime, LocalDate datumRodjenja, int godStudija, double prosjek,
			String smjer) {
		super(ime, prezime, datumRodjenja, godStudija, prosjek);
		this.smjer = smjer;
	}

	public String getSmjer() {
		return smjer;
	}

	@Override
	public String toString() {
		return super.toString() + "smjer osnovnih studija: " + smjer + "\n";
	}

}
