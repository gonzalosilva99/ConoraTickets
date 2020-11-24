package datatypes;

import java.util.ArrayList;

public class ArrayArtistas {
	private ArrayList<DtArtista> artistas;
	
	
	
	public ArrayArtistas() {
	}

	public ArrayArtistas(ArrayList<DtArtista> artistas) {
		super();
		this.artistas = artistas;
	}

	public ArrayList<DtArtista> getArtistas() {
		return artistas;
	}

	public void setArtistas(ArrayList<DtArtista> artistas) {
		this.artistas = artistas;
	}
	
	
}
