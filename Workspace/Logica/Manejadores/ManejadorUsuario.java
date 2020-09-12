	package Manejadores;
import java.util.*;
import Clases.Espectador;
import Clases.Artista;
import Clases.Espectaculo;
import DataTypes.DtPaquete;
import DataTypes.DtArtista;
import DataTypes.DtArtistaConsulta;
import DataTypes.DtFuncion;
import DataTypes.DtUsuario;
import Excepciones.Identidad;
import DataTypes.DtRegistro;
import DataTypes.DtEspectador;
import DataTypes.DtEspectadorConsulta;
import DataTypes.DtArtista;



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
			
		public Set<DtEspectador> listarEspectadores() {
			HashSet<DtEspectador> ret = new HashSet<DtEspectador>();
			for (Map.Entry<String,Espectador> entry : Espectadores.entrySet()) {
	            DtEspectador nuevo = entry.getValue().getDtEspectador();
	            ret.add(nuevo);            
			}
			return ret;
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
		
		public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String Descripcion, String Biografia, String Link) throws Identidad {
			if (ExisteUsuarioConNickname(Nickname)) {
				throw new Identidad("Ya Existe un Usuario con este Nickname");
			}
			else if(ExisteUsuarioConEmail(Email)){
				throw new Identidad("Ya Existe un Usuario con este Email");
			}	
			else {
				Artista nuevo = new Artista(Nickname,Nombre,Apellido,Email,Nacimiento,Descripcion,Biografia,Link);
				Artistas.put(Nickname, nuevo);		
			}
		}
		
		public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento) throws Identidad{
			if (ExisteUsuarioConNickname(Nickname)) {
				throw new Identidad("Ya Existe un Usuario con este Nickname");
			}
			else if(ExisteUsuarioConEmail(Email)){
				throw new Identidad("Ya Existe un Usuario con este Email");
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
		
		public void ModificarArtista(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Descripcion, String Biografia, String Link) {
			Artista mod = Artistas.get(Nickname);
			mod.setNombre(Nombre);
			mod.setApellido(Apellido);
			mod.setNacimiento(Nacimiento);
			mod.setDescripcionGeneral(Descripcion);
			mod.setBiografia(Biografia);
			mod.setURL(Link);
		}
		
		public void ModificarEspectador(String Nickname, String Nombre, String Apellido, Date Nacimiento) {
			Espectador mod = Espectadores.get(Nickname);
			mod.setNombre(Nombre);
			mod.setApellido(Apellido);
			mod.setNacimiento(Nacimiento);
		}
		
		public void RelacionarArtistaEspectaculo(String nickArtista,Espectaculo nuevo) {
			Artista Organizador = Artistas.get(nickArtista);
			nuevo.setOrganizador(Organizador);
			Organizador.AnadirEspectaculo(nuevo);
		}
		public Artista getArtista(String nickname) {
			return Artistas.get(nickname);
		}
		public Set<DtArtista> listarArtistasNoEspectaculo(String nombreEspectaculo){
			HashSet<DtArtista> ret = new HashSet<DtArtista>();
			for (Map.Entry<String, Artista> entry : Artistas.entrySet()) {
				if (!entry.getValue().participaEspectaculo(nombreEspectaculo)) {
		            DtArtista nuevo = entry.getValue().getDtArtista();
		            ret.add(nuevo);   
				}
			}
			return ret;
		}
		
		public Set<DtRegistro> listarRegistrosSinCanjeaer(String nickname){
			Espectador espec = Espectadores.get(nickname);
			return espec.listarRegistrosSinCanjeaer();
		}
		
		public Set<DtPaquete> listarPaquetesCanjeables(String nickname, String nombreEspectaculo){
			Espectador espec = Espectadores.get(nickname);
			return espec.listarPaquetesCanjeables(nombreEspectaculo);
		}
		
		
}
