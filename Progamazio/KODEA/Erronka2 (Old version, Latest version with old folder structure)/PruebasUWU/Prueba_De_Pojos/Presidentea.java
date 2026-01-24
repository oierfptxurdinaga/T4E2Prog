package Prueba_De_Pojos;

import java.util.ArrayList;

public class Presidentea extends Pertsona {

	private ArrayList<Pertsona> taldea;

	public Presidentea(String izena, String abz1, int adina) {
		super(izena, abz1, adina);
		this.taldea = new ArrayList<>();
	}

	public ArrayList<Pertsona> getTaldea() {
		return taldea;
	}

	public void setTaldea(ArrayList<Pertsona> taldea) {
		this.taldea = taldea;
	}

	@Override
	public String toString() {
		return "Presidentea [taldea=" + taldea + ", izena=" + izena + ", abz1=" + abz1 + ", adina=" + adina + "]";
	}

}