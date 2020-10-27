	package Manejadores;
import java.util.*;
import Clases.Espectador;
import Clases.Paquete;
import Controladores.Fabrica;
import Clases.Artista;
import Clases.Espectaculo;
import Clases.Usuario;
import DataTypes.DtPaquete;
import DataTypes.DtArtista;
import DataTypes.DtArtistaConsulta;
import DataTypes.DtArtistaPerfil;
import DataTypes.DtFuncion;
import DataTypes.DtUsuario;
import Excepciones.Identidad;
import DataTypes.DtRegistro;
import DataTypes.DtEspectador;
import DataTypes.DtEspectadorConsulta;
import DataTypes.DtEspectadorPerfil;
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
	
	public	Boolean LogueoCorrecto(String login, String password) {
			if(login.contains("@")) {
				DtUsuario useremail = this.getUsuarioEmail(login);
				if(useremail!=null && useremail.getContrasena().equals(password)) {
					return true;
				}
			}
			else {
				DtUsuario usernickname = this.getUsuarioNickname(login);
				if(usernickname != null && usernickname.getContrasena().equals(password)) {
					return true;
				}
			}
			return false;
			}
		public DtUsuario getUsuarioEmail(String email) {
			DtUsuario ret=null;
			for (Map.Entry<String,Artista> entry : Artistas.entrySet()) {
	            if(entry.getValue().getEmail().equals(email)) {
	            	return entry.getValue().getDtUsuario();
	            }           
			}
			for (Map.Entry<String,Espectador> entry : Espectadores.entrySet()) {
	            if(entry.getValue().getEmail().equals(email)) {
	            	return entry.getValue().getDtUsuario();
	            }           
			}
			return ret;
		}
		
		public DtUsuario getUsuarioNickname(String nickname) {
			DtUsuario ret=null;
			for (Map.Entry<String,Artista> entry : Artistas.entrySet()) {
	            if(entry.getValue().getNickname().equals(nickname)) {
	            	return entry.getValue().getDtUsuario();
	            }           
			}
			for (Map.Entry<String,Espectador> entry : Espectadores.entrySet()) {
	            if(entry.getValue().getNickname().equals(nickname)) {
	            	return entry.getValue().getDtUsuario();
	            }           
			}
			return ret;
		}

		public void actualizarUltimoIngreso(String nickname) {
			if(Artistas.containsKey(nickname)) {
				Artistas.get(nickname).setUltimoIngreso(new Date());
			}
			else if(Espectadores.containsKey(nickname)) {
				Espectadores.get(nickname).setUltimoIngreso(new Date());
			}
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
		
		
		public Espectador getEspectador(String nickname) {
			Espectador espec = Espectadores.get(nickname);
			return espec;
		}
		
		Boolean ExisteUsuarioConNickname(String Nickname) {
			for (Map.Entry<String,Artista> entry : Artistas.entrySet()) {
	            if(entry.getValue().getNickname().equalsIgnoreCase(Nickname)) {
	            	return true;
	            }           
			}
			for (Map.Entry<String,Espectador> entry : Espectadores.entrySet()) {
	            if(entry.getValue().getNickname().equalsIgnoreCase(Nickname)) {
	            	return true;
	            }           
			}
			return false;
		}
		
		Boolean ExisteUsuarioConEmail(String email) {
			for (Map.Entry<String,Artista> entry : Artistas.entrySet()) {
	            if(entry.getValue().getEmail().equalsIgnoreCase(email)) {
	            	return true;
	            }           
			}
			for (Map.Entry<String,Espectador> entry : Espectadores.entrySet()) {
	            if(entry.getValue().getEmail().equalsIgnoreCase(email)) {
	            	return true;
	            }           
			}
			return false;
		}
		
		public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String imagen, String contrasena, String Descripcion, String Biografia, String Link) throws Identidad {
			if (ExisteUsuarioConNickname(Nickname)) {
				throw new Identidad("Ya Existe un Usuario con este Nickname");
			}
			else if(ExisteUsuarioConEmail(Email)){
				throw new Identidad("Ya Existe un Usuario con este Email");
			}	
			else {
				Artista nuevo = new Artista(Nickname,Nombre,Apellido,Email.toLowerCase(),Nacimiento,imagen,contrasena,Descripcion,Biografia,Link);
				Artistas.put(Nickname, nuevo);		
			}
		}
		
		public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String imagen, String contrasena) throws Identidad{
			if (ExisteUsuarioConNickname(Nickname)) {
				throw new Identidad("Ya Existe un Usuario con este Nickname");
			}
			else if(ExisteUsuarioConEmail(Email)){
				throw new Identidad("Ya Existe un Usuario con este Email");
			}
			else {
				Espectador nuevo = new Espectador(Nickname,Nombre,Apellido,Email.toLowerCase(),Nacimiento,imagen,contrasena);
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
		
		public DtArtistaPerfil PerfilArtista(String nickname) {
			return Artistas.get(nickname).getDtArtistaPerfil();
		}
		
		public DtEspectadorPerfil PerfilEspectador(String nickname) {
			return Espectadores.get(nickname).getDtEspectadorPerfil();
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
		public Integer getUltimoCodigo(String nickname) {
			Espectador espec = Espectadores.get(nickname);
			return espec.getUltimoCodigo();
		}
		public Set<DtRegistro> listarRegistrosSinCanjeaer(String nickname){
			Espectador espec = Espectadores.get(nickname);
			return espec.listarRegistrosSinCanjeaer();
		}
		
		public Set<DtPaquete> listarPaquetesCanjeables(String nickname, String nombreEspectaculo){
			Espectador espec = Espectadores.get(nickname);
			return espec.listarPaquetesCanjeables(nombreEspectaculo);
		}
		
		public Boolean ExisteRegistroaFuncion(String nickname,String nombreFuncion) {
			Espectador espec = Espectadores.get(nickname);
			return espec.ExisteRegistroaFuncion(nombreFuncion);
		}
		public void comprarPaquete(String nickname, String nombrePaquete, Date fecha) {
			Espectador espec = Espectadores.get(nickname);
			Fabrica fab = Fabrica.getInstancia();
			Paquete paquete = fab.getIPaquete().getPaquete(nombrePaquete);
			espec.anadirPaquete(paquete, fecha);
		}
		
		public void SeguirUsuario(String NickSeguidor, String NickASeguir) {
			Usuario seguidor;
			Usuario aseguir;
			if(EsArtista(NickSeguidor)) {
				seguidor = Artistas.get(NickSeguidor);
			}
			else {
				seguidor = Espectadores.get(NickSeguidor);
			}
			if(EsArtista(NickASeguir)) {
				aseguir = Artistas.get(NickASeguir);
			}
			else {
				aseguir = Espectadores.get(NickASeguir);
			}
			seguidor.AgregarSeguido(NickASeguir,aseguir);
			aseguir.AgregarSeguidor(NickSeguidor,seguidor);
		}
		
		
}
