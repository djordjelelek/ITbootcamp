package analizaKnjige;

public class GlavniProgram {

	public static void main(String[] args) {

		Analiza analiza = new Analiza((new Knjiga(args[0])), (new Rjecnik(args[1])));
		analiza.analiziranje();

	}

}
