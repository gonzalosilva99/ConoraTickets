package Persistencia;

import java.util.ArrayList;

import datatypes.DtEspectaculo;

public class SetEspectaculoPersistencia {
	private ArrayList<EspectaculoPersistencia> espectaculos;
	
	
	public SetEspectaculoPersistencia() {
	}

	public SetEspectaculoPersistencia(ArrayList<EspectaculoPersistencia> espectaculos) {
		this.espectaculos = espectaculos;
	}

	public ArrayList<EspectaculoPersistencia> getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(ArrayList<EspectaculoPersistencia> espectaculos) {
		this.espectaculos = espectaculos;
	}
}
