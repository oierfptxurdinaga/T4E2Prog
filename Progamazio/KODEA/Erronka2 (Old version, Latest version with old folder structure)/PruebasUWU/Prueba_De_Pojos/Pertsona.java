package Prueba_De_Pojos;

public abstract class Pertsona {

	protected String izena;
	protected String abz1;
	protected int adina;

	public Pertsona(String izena, String abz1, int adina) {
		super();
		this.izena = izena;
		this.abz1 = abz1;
		this.adina = adina;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbz1() {
		return abz1;
	}

	public void setAbz1(String abz1) {
		this.abz1 = abz1;
	}

	public int getAdina() {
		return adina;
	}

	public void setAdina(int adina) {
		this.adina = adina;
	}

	@Override
	public String toString() {
		return "Pertsona [izena=" + izena + ", abz1=" + abz1 + ", adina=" + adina + ", getIzena()=" + getIzena()
				+ ", getAbz1()=" + getAbz1() + ", getAdina()=" + getAdina() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
