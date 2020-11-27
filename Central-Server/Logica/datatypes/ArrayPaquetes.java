package datatypes;

import java.util.ArrayList;

public class ArrayPaquetes {
private ArrayList<DtPaquete> paquetes;
	
	
	public ArrayPaquetes() {
	}

	public ArrayPaquetes(ArrayList<DtPaquete> paquetes) {
		this.paquetes = paquetes;
	}

	public ArrayList<DtPaquete> getPaquetes() {
		return this.paquetes;
	}

	public void setPaquetes(ArrayList<DtPaquete> paquetes) {
		this.paquetes = paquetes;
	}
	
	

	
	
}
