package Manejadores;
import java.util.*;
import Clases.Espectador;
import Clases.Artista;
import DataTypes.DtPaquete;
import DataTypes.DtArtista;
import DataTypes.DtFuncion;
import DataTypes.DtUsuario;
import DataTypes.DtRegistro;

import javax.swing.JOptionPane;
public class ManejadorUsuario {
	private 
		static ManejadorUsuario instancia;
		Map<String,Artista> Artistas;
		Map<String,Espectador> Espectadores;
		
	public 
		static ManejadorUsuario getInstancia() {
			if(instancia==null)
				instancia=new ManejadorUsuario();
			return instancia;
		}
		Map<String, Artista> getArtistas() {
			return Artistas;
		}
		void setArtistas(Map<String, Artista> artistas) {
			Artistas = artistas;
		}
		Map<String, Espectador> getEspectadores() {
			return Espectadores;
		}
		void setEspectadores(Map<String, Espectador> espectadores) {
			Espectadores = espectadores;
		}
		
		Set<DtArtista> listarArtistas(){
			return new HashSet<DtUsuario>();
		}
		
		Set<DtEspectador> listarEspectadores() {
			return new HashSet<DtEspectador>();
		}
		
		Set<DtPaquete> listarPaquetesCanjeables(String nickname, String espectaculo) {
			return new HashSet<DtPaquete>();
		}
		
		Set<DtRegistro> listarResgistrosSinCanjear(String nickname) {
			return HashSet<DtRegistro>();
		}
		
		
		Espectador getEspectador(String nickname) {
			Date fecha = new Date();
			return new Espectador("","","","",fecha);
		}
		
		Boolean ExisteUsuarioConNickname(String Nickname, Map Usuarios) {
			return Usuarios.containsKey(Nickname);
			
		}
		
		Boolean ExisteUsuarioConEmail(String Nickname, Map Usuarios) {
			//FALTA
			return false;
		}
		
		public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String Descripcion, String Biografia, String Link) {
			//if (ExisteUsuarioConNickname(Nickname,Artistas)) {
				//ERROR
			//}
			//else if(ExisteUsuarioConEmail(Email,Artistas)){
				//ERROR
			//}		
				Artista nuevo = new Artista(Nickname,Nombre,Apellido,Email,Nacimiento,Descripcion,Biografia,Link);
				Artistas.put(Nickname, nuevo);
		}
		

		
		public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento) {
			if (ExisteUsuarioConNickname(Nickname,Espectadores)) {

			}
			else if(ExisteUsuarioConEmail(Email,Espectadores)){

			}
			else {
				Espectador nuevo = new Espectador(Nickname,Nombre,Apellido,Email,Nacimiento);
				Espectadores.put(Nickname, nuevo);			
			}
		}
		public Set<DtUsuario> listarUsuarios(){
			Set<DtUsuario> ret = new HashSet<DtUsuario>();
			//Artistas.forEach((k,v) -> JOptionPane.showMessageDialog(null, "BIEN"));
			for (Map.Entry<String,Artista> entry : Artistas.entrySet()) {
				JOptionPane.showMessageDialog(null, "BIEN");
	            DtUsuario nuevo = entry.getValue().getDtUsuario();
	            ret.add(nuevo);            
			}
			for (Map.Entry<String,Espectador> entry : Espectadores.entrySet()) {
	            DtUsuario nuevo = entry.getValue().getDtUsuario();
	            ret.add(nuevo);            
			}
			return ret;
		}
		
		
}
