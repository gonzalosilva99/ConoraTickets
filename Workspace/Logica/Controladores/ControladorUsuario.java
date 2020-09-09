package Controladores;

import java.util.Date;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import DataTypes.DtFuncion;
import DataTypes.DtUsuario;
import Interfaces.IUsuario;
import Manejadores.ManejadorPlataforma;
import Manejadores.ManejadorUsuario;

public class ControladorUsuario implements IUsuario{
	
	public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String Descripcion, String Biografia, String Link) {
		try {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();	
		manusu.confirmarAltaArtista(Nickname,Nombre,Apellido,Email,Nacimiento,Descripcion,Biografia,Link);
		}
		catch(Exception e) {
			
		}
	}
	
	public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento) {
		try {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();	
		manusu.confirmarAltaEspectador(Nickname,Nombre,Apellido,Email,Nacimiento);
		}
		catch(Exception e) {
		}
	}
	
	public Set<DtUsuario> listarUsuarios(){
		
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		HashSet<DtUsuario> h = manusu.listarUsuarios();
		return h;
	}
}
