package truogao.tacke;

public class Tacka {
	private double x;
	private double y;

	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x1) {
		x = x1;
	}

	public void setY(double y1) {
		y = y1;
	}

	public void ispisTacke() {
		String s = ("Koordinata tacka x je: " + x + "\n" + "Kordinata tacke y je: " + y);
		System.out.println(s);
	}

}
