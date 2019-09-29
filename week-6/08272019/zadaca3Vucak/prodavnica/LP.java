package zadaca3Vucak.prodavnica;

import zadaca3Vucak.album.Album;

public class LP extends AlbumArtikal {
	private int tezina;

	public LP(Album album, String izdavac, double cena, int kolicina, int tezina) {
		super(album, izdavac, cena, kolicina);
		this.tezina = tezina;
	}

	@Override
	public String ime() {
		StringBuilder sb = new StringBuilder();
		sb.append(album.getIzvodjac() + " - ");
		sb.append(album.getNaziv() + " (");
		sb.append(tezina + "[g] LP)");
		return sb.toString();
	}

}
