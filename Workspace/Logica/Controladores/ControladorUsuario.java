package Controladores;

import java.util.Date;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import DataTypes.DtFuncion;
import DataTypes.DtUsuario;
import DataTypes.DtArtista;
import DataTypes.DtEspectador;
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
		Set<DtUsuario> h = manusu.listarUsuarios();
		return h;
	}
	public Set<DtArtista> listarArtistas(){
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		Set<DtArtista> h = manusu.listarArtistas();
		return h;
	}
	
	public Boolean EsArtista(String nickname) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		Boolean h = manusu.EsArtista(nickname);
		return h;
	}
	
	public DtArtista MostrarArtista(String nickname) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		DtArtista h = manusu.MostrarArtista(nickname);
		return h;
	}
	
	public DtEspectador MostrarEspectador(String nickname) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		DtEspectador h = manusu.MostrarEspectador(nickname);
		return h;
	}
}
