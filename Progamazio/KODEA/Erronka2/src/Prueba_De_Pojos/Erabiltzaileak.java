package Prueba_De_Pojos;

public class Erabiltzaileak extends Pertsona {

	private String email;
	private String erabiltzaileIzena;
	private String Pass;

	public Erabiltzaileak(String izena, String abz1, int adina, String email, String erabiltzaileIzena, String pass) {
		super(izena, abz1, adina);
		this.email = email;
		this.erabiltzaileIzena = erabiltzaileIzena;
		Pass = pass;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getErabiltzaileIzena() {
		return erabiltzaileIzena;
	}

	public void setErabiltzaileIzena(String erabiltzaileIzena) {
		this.erabiltzaileIzena = erabiltzaileIzena;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	@Override
	public String toString() {
		return "Erabiltzaileak [email=" + email + ", erabiltzaileIzena=" + erabiltzaileIzena + ", Pass=" + Pass + "]";
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

}
