package zadacaPonedjeljak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class ZadatakPrvi {

	public static void main(String[] args) {
		// LinkedHashMap<String, Integer> mapa = new LinkedHashMap<String, Integer>();
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		mapa.put("Aleksa", 23);
		mapa.put("Bilja", 1);
		mapa.put("Jovica", 35);
		mapa.put("Katarina", 20);
		mapa.put("Svjetlana", 19);

		ispis(mapa);

	}

	public static void ispis(HashMap<String, Integer> mapa) {
		ArrayList<String> lista = new ArrayList<String>();
		for (String s : mapa.keySet()) {
			lista.add(s);
		}
		Collections.sort(lista);
		for (String s : lista) {
			System.out.println(s + ", " + mapa.get(s));
		}
	}

}
