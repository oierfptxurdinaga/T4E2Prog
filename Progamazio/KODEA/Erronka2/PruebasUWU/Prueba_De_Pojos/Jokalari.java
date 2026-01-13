package Prueba_De_Pojos;

public class Jokalari extends Pertsona {

	private int dortsala;
	private String posizioa;
	private String taldea;

	public Jokalari(String izena, String abz1, int adina, int dortsala, String posizioa, String taldea) {
		super(izena, abz1, adina);
		this.dortsala = dortsala;
		this.posizioa = posizioa;
		this.taldea = taldea;
	}

	public String getIzena() {
		return izena;
	}

	public int getDortsala() {
		return dortsala;
	}

	public void setDortsala(int dortsala) {
		this.dortsala = dortsala;
	}

	public String getPosizioa() {
		return posizioa;
	}

	public void setPosizioa(String posizioa) {
		this.posizioa = posizioa;
	}

	public String getTaldea() {
		return taldea;
	}

	public void setTaldea(String taldea) {
		this.taldea = taldea;
	}

	@Override
	public String toString() {
		return "Jokalari [dortsala=" + dortsala + ", posizioa=" + posizioa + ", taldea=" + taldea + ", izena=" + izena
				+ ", abz1=" + abz1 + ", adina=" + adina + "]";
	}

}