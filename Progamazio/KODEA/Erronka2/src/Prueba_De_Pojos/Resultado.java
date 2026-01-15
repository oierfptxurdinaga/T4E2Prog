package Prueba_De_Pojos;

public class Resultado {
	private String temporada;
	private int jornada;
	private String equipoLocal;
	private int golesLocal;
	private String equipoVisitante;
	private int golesVisitante;

	public Resultado(String temporada, int jornada, String equipoLocal, int golesLocal, String equipoVisitante,
			int golesVisitante) {
		this.temporada = temporada;
		this.jornada = jornada;
		this.equipoLocal = equipoLocal;
		this.golesLocal = golesLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesVisitante = golesVisitante;
	}

	@Override
	public String toString() {
		return temporada + "," + jornada + "," + equipoLocal + "," + golesLocal + "," + equipoVisitante + ","
				+ golesVisitante;
	}

	public String getTemporada() {
		return temporada;
	}

	public int getJornada() {
		return jornada;
	}

	public String getEquipoLocal() {
		return equipoLocal;
	}

	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public boolean involucraEquipo(String equipo) {
		return equipoLocal.equals(equipo) || equipoVisitante.equals(equipo);
	}
}
