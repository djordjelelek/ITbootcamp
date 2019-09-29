package salonAutomobila;

public class Test {

	public static void main(String[] args) {
		SalonAuta salon = new SalonAuta("jdbc:sqlite:C:\\Users\\Djordje\\Downloads\\Prodavnica.db");
		salon.connection();

		salon.meniUlazni();

		salon.disconnect();

	}

}
