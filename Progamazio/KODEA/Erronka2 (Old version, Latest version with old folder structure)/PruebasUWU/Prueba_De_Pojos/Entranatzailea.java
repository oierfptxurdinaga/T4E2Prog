package Prueba_De_Pojos;

import java.util.ArrayList;

public class Entranatzailea extends Pertsona {

	private ArrayList<Pertsona> taldea;

	public Entranatzailea(String izena, String abz1, int adina, ArrayList<Pertsona> taldea) {
		super(izena, abz1, adina);
		this.taldea = taldea;
	}

	public ArrayList<Pertsona> getTaldea() {
		return taldea;
	}

	public void setTaldea(ArrayList<Pertsona> taldea) {
		this.taldea = taldea;
	}

	@Override
	public String toString() {
		return "Entranatzailea [taldea=" + taldea + ", izena=" + izena + ", abz1=" + abz1 + ", adina=" + adina + "]";
	}

}