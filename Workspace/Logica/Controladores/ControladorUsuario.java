package Controladores;

import java.util.Date;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import Clases.Espectaculo;
import DataTypes.DtFuncion;
import DataTypes.DtUsuario;
import DataTypes.DtArtista;
import DataTypes.DtEspectador;
import DataTypes.DtArtistaConsulta;
import DataTypes.DtEspectadorConsulta;
import Interfaces.IUsuario;
import Manejadores.ManejadorPlataforma;
import Manejadores.ManejadorUsuario;
import Excepciones.Identidad;

public class ControladorUsuario implements IUsuario{
	
	public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String Descripcion, String Biografia, String Link) throws Identidad {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();	
		manusu.confirmarAltaArtista(Nickname,Nombre,Apellido,Email,Nacimiento,Descripcion,Biografia,Link);
	}
		
	public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento) throws Identidad{
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();	
		manusu.confirmarAltaEspectador(Nickname,Nombre,Apellido,Email,Nacimiento);
	}
	

	public Set<DtEspectador> listarEspectadores(){
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		return manusu.listarEspectadores();
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
	
	public DtArtistaConsulta MostrarArtista(String nickname) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		DtArtistaConsulta h = manusu.MostrarArtista(nickname);
		return h;
	}
	
	public DtEspectadorConsulta MostrarEspectador(String nickname) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		DtEspectadorConsulta h = manusu.MostrarEspectador(nickname);
		return h;
	}
	
	public void ModificarArtista(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Descripcion, String Biografia, String Link) {
		try {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();	
		manusu.ModificarArtista(Nickname,Nombre,Apellido,Nacimiento,Descripcion,Biografia,Link);
		}
		catch(Exception e) {
			
		}
	}
		
	public void ModificarEspectador(String Nickname, String Nombre, String Apellido, Date Nacimiento) {
		try {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();	
		manusu.ModificarEspectador(Nickname,Nombre,Apellido,Nacimiento);
		}
		catch(Exception e) {
		}
	}
	
	public void RelacionarArtistaEspectaculo(String nickArtista,Espectaculo nuevo) {
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();	
		manusu.RelacionarArtistaEspectaculo(nickArtista,nuevo);
	}
	public Set<DtArtista> listarArtistasNoEspectaculo(String nombreEspectaculo){
		ManejadorUsuario manusu = Manejadores.ManejadorUsuario.getInstancia();
		Set<DtArtista> h = manusu.listarArtistas();
		return h;
	}
}
