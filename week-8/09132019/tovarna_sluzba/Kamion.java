package tovarna_sluzba;

import java.util.ArrayList;

public class Kamion {
	private final String regBroj;
	private ArrayList<Tovar> tovar = new ArrayList<Tovar>();
	private final double nosivost;
	private double teret = 0;

	public Kamion(String regBroj, double nosivost) {
		super();
		this.regBroj = regBroj;
		this.nosivost = nosivost;
	}

	public boolean stavi(Tovar t) {
		if ((teret + t.tezina()) > nosivost)
			return false;
		else {
			tovar.add(t);
			teret += t.tezina();
			return true;
		}
	}

	public boolean skini() {
		if (tovar.size() == 0)
			return false;
		else {
			tovar.remove(tovar.size() - 1);
			teret -= tovar.get(tovar.size() - 1).tezina();
			return true;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(regBroj + "(" + teret + "/" + nosivost + ")");
		for (Tovar t : tovar) {
			sb.append("\n\t" + t);
		}
		return sb.toString();
	}

}
