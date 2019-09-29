package zadacaPonedjeljak;

import java.util.ArrayList;
import java.util.HashMap;

public class ZadatakTreci {

	public static void main(String[] args) {
		ArrayList<String> svaDjeca = new ArrayList<String>();
		svaDjeca.add("Bojan Bosnjak");
		svaDjeca.add("Stefan Davidovic");
		svaDjeca.add("Cvijan Peranovic");
		svaDjeca.add("Nedjeljko Nedjeljkovic");
		ArrayList<String> dobra = new ArrayList<String>();
		dobra.add("Nedjeljko Nedjeljkovic");
		dobra.add("Stefan Davidovic");
		dobra.add("Cvijan Peranovic");
		dobra.add("Nedjeljko Nedjeljkovic");
		dobra.add("Cvijan Peranovic");
		dobra.add("Cvijan Peranovic");

		HashMap<String, Integer> hm = brojDobrihDijela(svaDjeca, dobra);
		System.out.println("Djeca sa vise od jednog dobrog djela:");
		for (String s : hm.keySet()) {
			if (hm.get(s) > 1)
				System.out.println(s);

		}

	}

	static HashMap<String, Integer> brojDobrihDijela(ArrayList<String> svaDjeca, ArrayList<String> dobra) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (String s : svaDjeca) {
			hm.put(s, 0);
		}
		for (String s : dobra) {
			int i = hm.get(s);
			hm.put(s, i + 1);
		}
		return hm;

	}

}
