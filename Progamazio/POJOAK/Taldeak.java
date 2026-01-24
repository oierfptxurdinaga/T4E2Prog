package Prueba_De_Pojos;

import java.util.ArrayList;

public class Taldeak {
	
	private String izena;
	private String prezidentea;
	private String fundazioa;
	private ArrayList<Jokalari> jokalaria;
	
	public Taldeak(String izena, String prezidentea, String fundazioa, ArrayList<Jokalari> jokalaria) {
		super();
		this.izena = izena;
		this.prezidentea = prezidentea;
		this.fundazioa = fundazioa;
		this.jokalaria = jokalaria;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getPrezidentea() {
		return prezidentea;
	}

	public void setPrezidentea(String prezidentea) {
		this.prezidentea = prezidentea;
	}

	public String getFundazioa() {
		return fundazioa;
	}

	public void setFundazioa(String fundazioa) {
		this.fundazioa = fundazioa;
	}

	public ArrayList<Jokalari> getJokalaria() {
		return jokalaria;
	}

	public void setJokalaria(ArrayList<Jokalari> jokalaria) {
		this.jokalaria = jokalaria;
	}

	@Override
	public String toString() {
		return "Taldeak [izena=" + izena + ", prezidentea=" + prezidentea + ", fundazioa=" + fundazioa + ", jokalaria="
				+ jokalaria + ", getIzena()=" + getIzena() + ", getPrezidentea()=" + getPrezidentea()
				+ ", getFundazioa()=" + getFundazioa() + ", getJokalaria()=" + getJokalaria() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}
