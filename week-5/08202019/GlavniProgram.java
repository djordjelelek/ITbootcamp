package dzuboks;

import java.util.Date;
import java.lang.Object;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GlavniProgram {
	public static void main(String[] args) {

		Album love_supreme = new Album("A love Supreme", "John Coltrane",
				new GregorianCalendar(1965, Calendar.FEBRUARY, 12).getTime());
		love_supreme.dodaj("Part I: Acknowledgement", "7:42");
		love_supreme.dodaj("Part II: Resolution", "7:19");
		love_supreme.dodaj("Part III: Pursuance", "10:41");
		love_supreme.dodaj("Part IV: Psalm", "7:02");
		System.out.println(love_supreme);

		Album animals = new Album("Animals", "Pink Floyd", new GregorianCalendar(1977, Calendar.JANUARY, 23).getTime());
		animals.dodaj("Pigs on the wing 1", "1:25");
		animals.dodaj("Dogs", "17:05");
		animals.dodaj("Pigs (three different ones)", "11:26");
		animals.dodaj("Sheep", "10:18");
		animals.dodaj("Pigs on the wing 2", "1:28");
		System.out.println(animals);

	}
}
