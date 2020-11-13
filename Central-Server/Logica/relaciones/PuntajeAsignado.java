package relaciones;

import clases.Espectaculo;
import clases.Espectador;

public class PuntajeAsignado {
	private Espectador espectador;
	private Espectaculo espectaculo;
	private int puntaje;
	
	
	public Espectador getEspectador() {
		return espectador;
	}
	public void setEspectador(Espectador espectador) {
		this.espectador = espectador;
	}

	public Espectaculo getEspectaculo() {
		return espectaculo;
	}
	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}
