package datatypes;

import java.util.ArrayList;
import java.util.List;

public class ArrayDtRegistros {
	private List<DtRegistro> registros;

	public ArrayDtRegistros() {
		registros = new ArrayList<DtRegistro>();
	}
	

	public ArrayDtRegistros(List<DtRegistro> registros) {
		super();
		this.registros = registros;
	}


	public List<DtRegistro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<DtRegistro> registros) {
		this.registros = registros;
	}
	
}
