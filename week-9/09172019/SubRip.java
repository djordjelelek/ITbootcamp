package titlovi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SubRip extends Titl {
	private int kontrolor = 1;
	private double zadnjaRazlika = 0;

	public SubRip(String titl, int brojTitla) {

		super(titl, brojTitla);
		// TODO Auto-generated constructor stub
	}

	public void pretvaranje() {
		if (getBrojTitla() == 2) {
			citanje();
		} else if (getBrojTitla() == 3) {
			citanje();
		}

	}

	private void citanje() {
		BufferedReader br = null;
		FileWriter fw = null;
		try {
			br = new BufferedReader(new FileReader(getTitl()));
			if (getBrojTitla() == 2)
				fw = new FileWriter("src\\titlovi\\izlaz.txt");
			else if (getBrojTitla() == 3)
				fw = new FileWriter("src\\titlovi\\izlaz.sub");

			String s = br.readLine(); // citam fajl
			while (s != null) {
				if (getBrojTitla() == 2)
					pretvaranjeMicroDVD(s);
				else if (getBrojTitla() == 3)
					pretvaranjeMPlayer(s);
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
			if (kontrolor > 3 && !s.equals("")) {
				fr.write("|" + s);
			} else if (kontrolor == 3) {
				fr.write(s);
				kontrolor++;
			} else if (kontrolor == 2) {
				String[] niz = s.split(" --> ");
				int pocetak = promjenaFormata(niz[0]);
				int kraj = promjenaFormata(niz[1]);
				fr.write("{" + pocetak + "}{" + kraj + "}");
				kontrolor++;
			} else if (kontrolor == 1) {
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

	private int promjenaFormata(String s) {
		int slanje = 0;
		String[] obrada = s.split(":");
		int sati = Integer.parseInt(obrada[0]);
		slanje += sati * 3600;
		int minuti = Integer.parseInt(obrada[1]);
		slanje += minuti * 60;
		double sekunda = Double.parseDouble(obrada[2].replace(',', '.'));
		sekunda = Math.round(sekunda);
		slanje += sekunda;
		return slanje * 25;

	}

	private void pretvaranjeMPlayer(String s) {
		FileWriter fr = null;
		try {
			fr = new FileWriter("src\\titlovi\\izlaz.sub", true);

			if (kontrolor == 3 && !s.equals("")) {
				fr.write(s + "\n");
			} else if (kontrolor == 2) {
				String[] niz = s.split(" --> ");
				String pocetak = promjenaFormata2(niz[0]);
				String kraj = promjenaFormata2(niz[1]);
				fr.write(pocetak + " " + kraj + "\n");
				kontrolor++;
			} else if (kontrolor == 1) {
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

	private String promjenaFormata2(String s) {
		double slanje;
		String[] obrada = s.split(":");
		double poredjenje = 0;
		int sati = Integer.parseInt(obrada[0]);
		poredjenje += sati * 3600;
		int minuti = Integer.parseInt(obrada[1]);
		poredjenje += minuti * 60;
		double sekunda = Double.parseDouble(obrada[2].replace(',', '.'));
		poredjenje += sekunda;
		slanje = poredjenje - zadnjaRazlika;
		slanje = Math.round(slanje * 100.0) / 100.0;
		zadnjaRazlika = poredjenje;
		return Double.toString(slanje);
	}

	public void stampanje(int i) {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			if (getBrojTitla() == 2) {
				fr = new FileReader("src\\titlovi\\izlaz.txt");
				br = new BufferedReader(fr);
			} else if (getBrojTitla() == 3) {
				fr = new FileReader("src\\titlovi\\izlaz.sub");
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
