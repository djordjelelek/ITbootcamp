package zadacaPonedjeljak;

import java.util.HashMap;

public class ZadatakDrugi {

	public static void main(String[] args) {
		/* [2,3,5,4,5,2,4,3,5,2,4,4,2] -> 5 */
		int[] niz = { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
		provjera(niz);

	}

	static void provjera(int[] niz) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i : niz) {
			if (!hm.containsKey(i)) {
				hm.put(i, 1);
			} else {
				int vrijednost = hm.get(i);
				hm.put(i, vrijednost + 1);
			}
		}
		for (int i : hm.keySet()) {
			if (hm.get(i) % 2 != 0)
				System.out.println(i + " ");
		}

	}

}
