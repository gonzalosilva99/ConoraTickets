package test;



import org.junit.Test;

import clases.Espectador;
import clases.Paquete;
import datatypes.DtFuncionDatos;
import relaciones.CompraPaquete;

public class TestCompraPaquete {

	@Test
	public void test() {
		try {	
			//CompraPaquete
			Espectador espectador = new Espectador(null, null, null, null, null, "", "");
			Paquete paquete = new Paquete(null, null, null, null, null, null, "");
			CompraPaquete comprapaquete = new CompraPaquete(null, null, null);
			comprapaquete.tieneEspectaculo("");
			DtFuncionDatos dtfuncion = new DtFuncionDatos();
			dtfuncion.getAlta();
			dtfuncion.getArtistas();
			dtfuncion.getEspectaculo();
			dtfuncion.getInicio();
			dtfuncion.getNombre();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
	}
