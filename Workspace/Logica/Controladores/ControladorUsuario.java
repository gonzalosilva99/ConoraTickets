package Controladores;

import java.util.Date;
import java.util.Map;
import Interfaces.IUsuario;
import Manejadores.ManejadorUsuario;

public class ControladorUsuario implements IUsuario{
	public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String Descripcion, String Biografia, String Link) {
		try {
		ManejadorUsuario.confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String Descripcion, String Biografia, String Link);
		}
		catch(Exception e) {
			
		}
	}
	
	public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento) {
		try {
		ManejadorUsuario.confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento);
		}
		catch(Exception e) {
			
		}
	}
}
