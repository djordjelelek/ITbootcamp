package Zadaca1;

public class GlavniProgram {

	public static void main(String[] args) {
		Pravougaonik prvi = new Pravougaonik(3, 2, "Srdjo");
		Pravougaonik drugi = new Pravougaonik(5, "Aco");

		System.out.println("Prva stranica prvog pravougaonika je: " + prvi.getA() + "\n"
				+ "Druga stranica prvog pravougaonika je: " + prvi.getB());
		System.out.println("Stranica Kvadrata je: " + drugi.getB());

		System.out.println("-------------------------");
		System.out.println("Povrsina pravougaonika je: " + prvi.getPovrsina() + "\n" + "Povrsina kvadrata je: "
				+ drugi.getPovrsina());

		System.out.println("------------------------");
		System.out.println(
				"Obim pravougaonika je: " + prvi.getObim() + "\n" + "Povrsina kvadrata je: " + drugi.getObim());

		System.out.println("-------------------------");
		System.out.println(prvi.ispisiPravougaonik());
		System.out.println("------------------------");
		System.out.println(drugi.ispisiPravougaonik());

	}

}
