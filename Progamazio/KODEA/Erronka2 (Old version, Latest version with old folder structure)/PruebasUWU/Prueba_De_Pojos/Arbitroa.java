package Prueba_De_Pojos;

public class Arbitroa extends Pertsona {

	private String mota;

	public Arbitroa(String izena, String abz1, int adina, String mota) {
		super(izena, abz1, adina);
		this.mota = mota;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	@Override
	public String toString() {
		return "Arbitroa [mota=" + mota + ", izena=" + izena + ", abz1=" + abz1 + ", adina=" + adina + "]";
	}

}