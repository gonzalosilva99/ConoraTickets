package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import Controladores.Fabrica;
import Excepciones.Identidad;
import Interfaces.IUsuario;

public class TestIUsuario {

	@Test
	public void test() {
		Fabrica fab = Fabrica.getInstancia();
		IUsuario iusuario = fab.getIUsuario();
		SimpleDateFormat FormatoNacimiento = new SimpleDateFormat("dd/MM/yyyy");
		try {
			iusuario.confirmarAltaArtista("NickNameArtista", "NombreArtista", "ApellidoArtista", "EmailArtista", FormatoNacimiento.parse("15/01/1990"), "Esta es la descripción de un artista", "Biografia del artista", "Link del artista");
		} catch (Identidad e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue("",iusuario.EsArtista("NickNameArtista"));
	}

}
