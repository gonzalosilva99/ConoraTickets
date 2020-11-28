package datatypes;

import java.util.ArrayList;

public class ArrayPremios {
	private ArrayList<DtPremio> premios;
	
	
	
	public ArrayPremios() {
	}

	public ArrayPremios(ArrayList<DtPremio> premios) {
		super();
		this.premios = premios;
	}

	public ArrayList<DtPremio> getPremios() {
		return premios;
	}

	public void setPremios(ArrayList<DtPremio> premios) {
		this.premios = premios;
	}


	
	
}
