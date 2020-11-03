package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import clases.Espectador;
import clases.Paquete;
import controladores.Fabrica;
import datatypes.DtArtista;
import datatypes.DtArtistaConsulta;
import datatypes.DtFuncionDatos;
import datatypes.TipoRegistro;
import excepciones.Identidad;
import interfaces.IPaquete;
import interfaces.IPlataforma;
import interfaces.IUsuario;
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
