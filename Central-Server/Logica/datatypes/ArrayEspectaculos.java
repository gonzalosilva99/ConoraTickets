package datatypes;

import java.util.ArrayList;

public class ArrayEspectaculos {
	private ArrayList<DtEspectaculo> espectaculos;
	
	
	public ArrayEspectaculos() {
	}

	public ArrayEspectaculos(ArrayList<DtEspectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}

	public ArrayList<DtEspectaculo> getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(ArrayList<DtEspectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}
	
	
}
