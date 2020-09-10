	package Manejadores;
import java.util.*;
import Clases.Espectador;
import Clases.Artista;
import DataTypes.DtPaquete;
import DataTypes.DtArtista;
import DataTypes.DtArtistaConsulta;
import DataTypes.DtFuncion;
import DataTypes.DtUsuario;
import DataTypes.DtRegistro;
import DataTypes.DtEspectador;
import DataTypes.DtEspectadorConsulta;



import javax.swing.JOptionPane;
public class ManejadorUsuario {
	private 
		static ManejadorUsuario instancia;
		HashMap<String,Artista> Artistas;
		HashMap<String,Espectador> Espectadores;
		private ManejadorUsuario() {
			Artistas = new HashMap<String,Artista>();
			Espectadores = new HashMap<String,Espectador>();
		};
	public 
		static ManejadorUsuario getInstancia() {
			if(instancia==null) {
				instancia=new ManejadorUsuario();		
			}
			return instancia;
		}
	
		
		Map<String, Artista> getArtistas() {
			return Artistas;
		}
		void setArtistas(HashMap<String, Artista> artistas) {
			Artistas = artistas;
		}
		Map<String, Espectador> getEspectadores() {
			return Espectadores;
		}
		void setEspectadores(HashMap<String, Espectador> espectadores) {
			Espectadores = espectadores;
		}
			
		Set<DtEspectador> listarEspectadores() {
			return new HashSet<DtEspectador>();
		}

		Set<DtPaquete> listarPaquetesCanjeables(String nickname, String espectaculo) {
			return new HashSet<DtPaquete>();
		}
		
		Set<DtRegistro> listarResgistrosSinCanjear(String nickname) {
			return new HashSet<DtRegistro>();
		}
		
		
		Espectador getEspectador(String nickname) {
			Date fecha = new Date();
			return new Espectador("","","","",fecha);
		}
		
		Boolean ExisteUsuarioConNickname(String Nickname) {
			return Artistas.containsKey(Nickname) || Espectadores.containsKey(Nickname);
		}
		
		Boolean ExisteUsuarioConEmail(String email) {
			for (Map.Entry<String,Artista> entry : Artistas.entrySet()) {
	            if(entry.getValue().getEmail().equals(email)) {
	            	return true;
	            }           
			}
			for (Map.Entry<String,Espectador> entry : Espectadores.entrySet()) {
	            if(entry.getValue().getEmail().equals(email)) {
	            	return true;
	            }           
			}
			return false;
		}
		
		public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String Descripcion, String Biografia, String Link) {
			if (ExisteUsuarioConNickname(Nickname)) {
				//ERROR
			}
			else if(ExisteUsuarioConEmail(Email)){
				
				//ERROR
			}	
			else {
				Artista nuevo = new Artista(Nickname,Nombre,Apellido,Email,Nacimiento,Descripcion,Biografia,Link);
				Artistas.put(Nickname, nuevo);		
			}
		}
		
	
		public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento) {
			if (ExisteUsuarioConNickname(Nickname)) {
				//ERROR
			}
			else if(ExisteUsuarioConEmail(Email)){
				JOptionPane.showMessageDialog(null, "ERROR");
				//ERROR
			}
			else {
				Espectador nuevo = new Espectador(Nickname,Nombre,Apellido,Email,Nacimiento);
				Espectadores.put(Nickname, nuevo);			
			}
		}
		public HashSet<DtUsuario> listarUsuarios(){
			HashSet<DtUsuario> ret = new HashSet<DtUsuario>();
			for (Map.Entry<String,Artista> entry : Artistas.entrySet()) {
	            DtUsuario nuevo = entry.getValue().getDtUsuario();
	            ret.add(nuevo);            
			}
			for (Map.Entry<String,Espectador> entry : Espectadores.entrySet()) {
	            DtUsuario nuevo = entry.getValue().getDtUsuario();
	            ret.add(nuevo);            
			}
			return ret;
		}
		public Set<DtArtista> listarArtistas() {
			HashSet<DtArtista> ret = new HashSet<DtArtista>();
			for (Map.Entry<String, Artista> entry : Artistas.entrySet()) {
	            DtArtista nuevo = entry.getValue().getDtArtista();
	            ret.add(nuevo);            
			}
			return ret;
		}
		
		public Boolean EsArtista(String nickname) {
			return Artistas.containsKey(nickname);
		}
		
		public DtArtistaConsulta MostrarArtista(String nickname) {
			return Artistas.get(nickname).getDtArtistaConsulta();
		}
		
		public DtEspectadorConsulta MostrarEspectador(String nickname) {
			return Espectadores.get(nickname).getDtEspectadorConsulta();
		}
		
		
}
