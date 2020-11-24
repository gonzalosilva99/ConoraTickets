package datatypes;

import java.util.List;

public class ArrayCategorias {
	


	private List<DtCategoria> Categorias;
	

	public ArrayCategorias(List<DtCategoria> categorias) {
		super();
		Categorias = categorias;
	}

	public ArrayCategorias() {
		super();
	}
	
	public List<DtCategoria> getCategorias() {
		return Categorias;
	}

	public void setCategorias(List<DtCategoria> categorias) {
		Categorias = categorias;
	}

	

}
