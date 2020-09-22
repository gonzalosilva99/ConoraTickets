package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import Clases.Espectador;
import Clases.Paquete;
import Controladores.Fabrica;
import DataTypes.DtArtista;
import DataTypes.DtArtistaConsulta;
import DataTypes.DtFuncionDatos;
import DataTypes.TipoRegistro;
import Excepciones.Identidad;
import Interfaces.IPaquete;
import Interfaces.IPlataforma;
import Interfaces.IUsuario;
import Relaciones.CompraPaquete;

public class TestCompraPaquete {

	@Test
	public void test() {
		try {	
			//CompraPaquete
			Espectador espectador = new Espectador(null,null,null,null,null);
			Paquete paquete = new Paquete(null,null,null,null,null,null);
			CompraPaquete comprapaquete = new CompraPaquete(null,null,null);
			comprapaquete.TieneEspectaculo("");
			DtFuncionDatos dtfuncion = new DtFuncionDatos();
			dtfuncion.getAlta();
			dtfuncion.getArtistas();
			dtfuncion.getEspectaculo();
			dtfuncion.getInicio();
			dtfuncion.getNombre();
		}
		catch(Exception e) {
		}
}
	}
