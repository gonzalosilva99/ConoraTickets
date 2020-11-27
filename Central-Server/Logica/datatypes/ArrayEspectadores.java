package datatypes;

import java.util.ArrayList;

public class ArrayEspectadores {
	
private ArrayList<DtEspectador> espectadores;
	
	
	public ArrayEspectadores() {
	}

	public ArrayEspectadores(ArrayList<DtEspectador> espectadores) {
		this.espectadores = espectadores;
	}

	public ArrayList<DtEspectador> getEspectaculos() {
		return espectadores;
	}

	public void setEspectaculos(ArrayList<DtEspectador> espectadores) {
		this.espectadores = espectadores;
	}
	
	

}
