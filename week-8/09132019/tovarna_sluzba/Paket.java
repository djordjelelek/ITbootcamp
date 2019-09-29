package tovarna_sluzba;

import java.util.ArrayList;

public class Paket extends Tovar {
	private ArrayList<Tovar> tovar = new ArrayList<Tovar>();

	@Override
	public String vrsta() {
		StringBuilder sb = new StringBuilder();
		sb.append("paket[");

		for (Tovar t : tovar) {
			sb.append(t.vrsta() + ",");
		}
		sb.deleteCharAt(14);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public double tezina() {
		double q = 0;
		for (Tovar t : tovar) {
			q += t.tezina();
		}
		return q;
	}

	public void dodaj(Tovar t) {
		tovar.add(t);
	}

}
