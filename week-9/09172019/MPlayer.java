package titlovi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MPlayer extends Titl {
	private int kontrolor = 1;
	private double brojac = 0;
	private int brojanjeTitlova = 1;

	public MPlayer(String text, int brojTitla) {
		super(text, brojTitla);
	}

	public void pretvaranje() {
		if (getBrojTitla() == 0) {
			citanje();
		} else if (getBrojTitla() == 1) {
			citanje();
		}

	}

	private void citanje() {
		BufferedReader br = null;
		FileWriter fw = null;
		try {
			br = new BufferedReader(new FileReader(getTitl()));
			if (getBrojTitla() == 0)
				fw = new FileWriter("src\\titlovi\\izlaz.txt");
			else if (getBrojTitla() == 1)
				fw = new FileWriter("src\\titlovi\\izlaz.srt");

			String s = br.readLine(); // citam fajl
			while (s != null) {
				if (getBrojTitla() == 0)
					pretvaranjeMicroDVD(s);
				else if (getBrojTitla() == 1)
					pretvaranjeSubRip(s);
				s = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void pretvaranjeMicroDVD(String s) {
		FileWriter fr = null;
		try {
			fr = new FileWriter("src\\titlovi\\izlaz.txt", true);
			if (kontrolor > 2 && !s.equals("")) {
				fr.write("|" + s);
			} else if (kontrolor == 2) {
				fr.write(s);
				kontrolor++;
			} else if (kontrolor == 1) {
				String[] niz = s.split(" ");
				double pocetak = Double.parseDouble(niz[0]);
				double kraj = Double.parseDouble(niz[1]);
				brojac += pocetak;
				fr.write("{" + (int) Math.round(brojac * 25) + "}{" + (int) Math.round((brojac + kraj) * 25) + "}");
				brojac += kraj;
				kontrolor++;
			} else if (s.equals("")) {
				fr.write("\n");
				kontrolor = 1;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void pretvaranjeSubRip(String s) {
		FileWriter fr = null;
		try {
			fr = new FileWriter("src\\titlovi\\izlaz.srt", true);
			if (kontrolor == 2 && !s.equals("")) {
				fr.write(s + "\n");
			} else if (kontrolor == 1) {
				fr.write(brojanjeTitlova++ + "\n");
				String[] niz = s.split(" ");
				double po = Double.parseDouble(niz[0]);
				double kr = Double.parseDouble(niz[1]);

				brojac += po;
				String pocetak = promjenaFormata();
				fr.write(pocetak + " --> ");

				brojac += kr;
				String kraj = promjenaFormata();
				fr.write(kraj + "\n");

				kontrolor++;

			} else if (s.equals("")) {
				fr.write("\n");
				kontrolor = 1;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private String promjenaFormata() {

		double prelazni = brojac;
		int sati = (int) (prelazni / 3600);
		prelazni = prelazni % 3600;
		int minuti = (int) (prelazni / 60);
		prelazni = prelazni % 60;

		String sa = Integer.toString(sati);
		if (sa.length() == 1)
			sa = "0" + sa;
		String min = Integer.toString(minuti);
		if (min.length() == 1)
			min = "0" + min;
		prelazni = Math.round(prelazni * 1000.0) / 1000.0;

		String sekunde = Double.toString(prelazni);
		sekunde = sekunde.replace('.', ',');
		if (sekunde.charAt(1) == ',')
			sekunde = "0" + sekunde;
		if (sekunde.length() == 4)
			sekunde = sekunde + "00";
		if (sekunde.length() == 5)
			sekunde = sekunde + "0";
		String s = sa + ":" + min + ":" + sekunde;

		return s;
	}

	public void stampanje(int i) {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			if (getBrojTitla() == 0) {
				fr = new FileReader("src\\titlovi\\izlaz.txt");
				br = new BufferedReader(fr);
			} else if (getBrojTitla() == 1) {
				fr = new FileReader("src\\titlovi\\izlaz.srt");
				br = new BufferedReader(fr);
			}

			String s = br.readLine();
			while (s != null) {
				System.out.println(s);
				s = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
