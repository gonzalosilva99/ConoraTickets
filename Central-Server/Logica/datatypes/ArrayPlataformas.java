package datatypes;

import java.util.ArrayList;

public class ArrayPlataformas {
	private ArrayList<DtPlataforma> plats;
	
	
	
	public ArrayPlataformas() {
	}

	public ArrayPlataformas(ArrayList<DtPlataforma> plats) {
		super();
		this.plats = plats;
	}

	public ArrayList<DtPlataforma> getPlats() {
		return plats;
	}

	public void setPlats(ArrayList<DtPlataforma> plats) {
		this.plats = plats;
	}
	
	
}
