package zadaca1.knjiga;

public class ListPapira {
	private String teskt;
	private int redniBr;
	
	public ListPapira(String teskt, int redniBr) {
		this.teskt = teskt;
		if (redniBr>0) this.redniBr = redniBr;
	}

	public int getRedniBr() {
		return redniBr;
	}

	public void setTeskt(String teskt) {
		this.teskt = teskt;
	}
	public static boolean poredjenjeListova (ListPapira a, ListPapira b) {
		if (a.redniBr == b.redniBr) return true;
		else return false;
	}
	public boolean poredjenjeListova (ListPapira x) {
		if (this.redniBr == x.redniBr) return  true;
		else return false;
	}
	
	public String toString() {
		return teskt + " (" + redniBr + ".)";
	}
	
	
	
}
