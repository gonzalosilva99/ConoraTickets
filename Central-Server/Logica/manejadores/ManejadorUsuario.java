	package manejadores;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import clases.Artista;
import clases.Espectaculo;
import clases.Espectador;
import clases.Paquete;
import clases.Usuario;
import controladores.Fabrica;
import datatypes.DtArtista;
import datatypes.DtArtistaConsulta;
import datatypes.DtArtistaPerfil;
import datatypes.DtEspectador;
import datatypes.DtEspectadorConsulta;
import datatypes.DtEspectadorPerfil;
import datatypes.DtPaquete;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
import excepciones.Identidad;
public class ManejadorUsuario {
	private 
		static ManejadorUsuario instancia;
		Map<String, Artista> artistas;
		Map<String, Espectador> espectadores;
		private ManejadorUsuario() {
			artistas = new HashMap<String, Artista>();
			espectadores = new HashMap<String, Espectador>();
		};
	public 
		static ManejadorUsuario getInstancia() {
			if (instancia==null) {
				instancia=new ManejadorUsuario();		
			}
			return instancia;
		}
	
	
	
	
	public	Boolean logueoCorrecto(String login, String password) {
			if (login.contains("@")) {
				DtUsuario useremail = this.getUsuarioEmail(login);
				if (useremail!=null && useremail.getContrasena().equals(password)) {
					return true;
				}
			}
			else {
				DtUsuario usernickname = this.getUsuarioNickname(login);
				if (usernickname != null && usernickname.getContrasena().equals(password)) {
					return true;
				}
			}
			return false;
			}
		public DtUsuario getUsuarioEmail(String email) {
			DtUsuario ret=null;
			for (Map.Entry<String, Artista> entry : artistas.entrySet()) {
	            if (entry.getValue().getEmail().equals(email)) {
	            	return entry.getValue().getDtUsuario();
	            }           
			}
			for (Map.Entry<String, Espectador> entry : espectadores.entrySet()) {
	            if (entry.getValue().getEmail().equals(email)) {
	            	return entry.getValue().getDtUsuario();
	            }           
			}
			return ret;
		}
		
		public DtUsuario getUsuarioNickname(String nickname) {
			DtUsuario ret=null;
			for (Map.Entry<String, Artista> entry : artistas.entrySet()) {
	            if (entry.getValue().getNickname().equals(nickname)) {
	            	return entry.getValue().getDtUsuario();
	            }           
			}
			for (Map.Entry<String, Espectador> entry : espectadores.entrySet()) {
	            if (entry.getValue().getNickname().equals(nickname)) {
	            	return entry.getValue().getDtUsuario();
	            }           
			}
			return ret;
		}

		public void actualizarUltimoIngreso(String nickname) {
			if (artistas.containsKey(nickname)) {
				artistas.get(nickname).setUltimoIngreso(new Date());
			}
			else if (espectadores.containsKey(nickname)) {
				espectadores.get(nickname).setUltimoIngreso(new Date());
			}
		}
		
		Map<String, Artista> getArtistas() {
			return artistas;
		}
		void setArtistas(Map<String, Artista> artistas) {
			this.artistas = artistas;
		}
		Map<String, Espectador> getEspectadores() {
			return espectadores;
		}
		void setEspectadores(Map<String, Espectador> espectadores) {
			this.espectadores = espectadores;
		}
			
		public Set<DtEspectador> listarEspectadores() {
			HashSet<DtEspectador> ret = new HashSet<DtEspectador>();
			for (Map.Entry<String, Espectador> entry : espectadores.entrySet()) {
	            DtEspectador nuevo = entry.getValue().getDtEspectador();
	            ret.add(nuevo);            
			}
			return ret;
		}
		
		Set<DtRegistro> listarResgistrosSinCanjear(String nickname) {
			return new HashSet<DtRegistro>();
		}
		
		
		public Espectador getEspectador(String nickname) {
			Espectador espec = espectadores.get(nickname);
			return espec;
		}
		
		Boolean existeUsuarioConNickname(String Nickname) {
			for (Map.Entry<String, Artista> entry : artistas.entrySet()) {
	            if (entry.getValue().getNickname().equalsIgnoreCase(Nickname)) {
	            	return true;
	            }           
			}
			for (Map.Entry<String, Espectador> entry : espectadores.entrySet()) {
	            if (entry.getValue().getNickname().equalsIgnoreCase(Nickname)) {
	            	return true;
	            }           
			}
			return false;
		}
		
		Boolean existeUsuarioConEmail(String email) {
			for (Map.Entry<String, Artista> entry : artistas.entrySet()) {
	            if (entry.getValue().getEmail().equalsIgnoreCase(email)) {
	            	return true;
	            }           
			}
			for (Map.Entry<String, Espectador> entry : espectadores.entrySet()) {
	            if (entry.getValue().getEmail().equalsIgnoreCase(email)) {
	            	return true;
	            }           
			}
			return false;
		}
		
		public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String imagen, String contrasena, String Descripcion, String Biografia, String Link) throws Identidad {
			if (existeUsuarioConNickname(Nickname)) {
				throw new Identidad("Ya Existe un Usuario con este Nickname");
			}
			else if (existeUsuarioConEmail(Email)){
				throw new Identidad("Ya Existe un Usuario con este Email");
			}	
			else {
				Artista nuevo = new Artista(Nickname, Nombre, Apellido, Email.toLowerCase(), Nacimiento, imagen, contrasena, Descripcion, Biografia, Link);
				artistas.put(Nickname, nuevo);		
			}
		}
		
		public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String imagen, String contrasena) throws Identidad{
			if (existeUsuarioConNickname(Nickname)) {
				throw new Identidad("Ya Existe un Usuario con este Nickname");
			}
			else if (existeUsuarioConEmail(Email)){
				throw new Identidad("Ya Existe un Usuario con este Email");
			}
			else {
				Espectador nuevo = new Espectador(Nickname, Nombre, Apellido, Email.toLowerCase(), Nacimiento, imagen, contrasena);
				espectadores.put(Nickname, nuevo);			
			}
		}
		public Set<DtUsuario> listarUsuarios(){
			HashSet<DtUsuario> ret = new HashSet<DtUsuario>();
			for (Map.Entry<String, Artista> entry : artistas.entrySet()) {
	            DtUsuario nuevo = entry.getValue().getDtUsuario();
	            ret.add(nuevo);            
			}
			for (Map.Entry<String, Espectador> entry : espectadores.entrySet()) {
	            DtUsuario nuevo = entry.getValue().getDtUsuario();
	            ret.add(nuevo);            
			}
			return ret;
		}
		public Set<DtArtista> listarArtistas() {
			HashSet<DtArtista> ret = new HashSet<DtArtista>();
			for (Map.Entry<String, Artista> entry : artistas.entrySet()) {
	            DtArtista nuevo = entry.getValue().getDtArtista();
	            ret.add(nuevo);            
			}
			return ret;
		}
		
		public Set<DtUsuario> filtrarUsuarios(String search){
			HashSet<DtUsuario> ret = new HashSet<DtUsuario>();
			for (Map.Entry<String, Artista> entry : artistas.entrySet()) {
	            DtUsuario nuevo = entry.getValue().getDtUsuario();
	            if (nuevo.getNickname().toLowerCase().contains(search))
	            	ret.add(nuevo);            
			}
			for (Map.Entry<String, Espectador> entry : espectadores.entrySet()) {
	            DtUsuario nuevo = entry.getValue().getDtUsuario();
	            if (nuevo.getNickname().toLowerCase().contains(search))
	            	ret.add(nuevo);            
			}
			return ret;
		}
		
		public Boolean esArtista(String nickname) {
			return artistas.containsKey(nickname);
		}
		
		public DtArtistaPerfil perfilArtista(String nickname) {
			return artistas.get(nickname).getDtArtistaPerfil();
		}
		
		public DtEspectadorPerfil perfilEspectador(String nickname) {
			return espectadores.get(nickname).getDtEspectadorPerfil();
		}
		
		public DtArtistaConsulta mostrarArtista(String nickname) {
			return artistas.get(nickname).getDtArtistaConsulta();
		}
		
		public DtEspectadorConsulta mostrarEspectador(String nickname) {
			return espectadores.get(nickname).getDtEspectadorConsulta();
		}
		
		public void modificarArtista(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Descripcion, String Biografia, String Link) {
			Artista mod = artistas.get(Nickname);
			mod.setNombre(Nombre);
			mod.setApellido(Apellido);
			mod.setNacimiento(Nacimiento);
			mod.setDescripcionGeneral(Descripcion);
			mod.setBiografia(Biografia);
			mod.setURL(Link);
		}
		
		public void modificarArtistaCompleto(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Descripcion, String Biografia, String Link, String Imagen) {
			Artista mod = artistas.get(Nickname);
			mod.setNombre(Nombre);
			mod.setApellido(Apellido);
			mod.setNacimiento(Nacimiento);
			mod.setDescripcionGeneral(Descripcion);
			mod.setBiografia(Biografia);
			mod.setURL(Link);
			mod.setImagen(Imagen);
		}
		public void modificarEspectador(String Nickname, String Nombre, String Apellido, Date Nacimiento) {
			Espectador mod = espectadores.get(Nickname);
			mod.setNombre(Nombre);
			mod.setApellido(Apellido);
			mod.setNacimiento(Nacimiento);
		}

		public void modificarEspectadorCompleto(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Imagen) {
			Espectador mod = espectadores.get(Nickname);
			mod.setNombre(Nombre);
			mod.setApellido(Apellido);
			mod.setNacimiento(Nacimiento);
			mod.setImagen(Imagen);
		}
		public void relacionarArtistaEspectaculo(String nickArtista, Espectaculo nuevo) {
			Artista Organizador = artistas.get(nickArtista);
			nuevo.setOrganizador(Organizador);
			Organizador.anadirEspectaculo(nuevo);
		}
		public Artista getArtista(String nickname) {
			return artistas.get(nickname);
		}
		public Set<DtArtista> listarArtistasNoEspectaculo(String nombreEspectaculo){
			HashSet<DtArtista> ret = new HashSet<DtArtista>();
			for (Map.Entry<String, Artista> entry : artistas.entrySet()) {
				if (!entry.getValue().participaEspectaculo(nombreEspectaculo)) {
		            DtArtista nuevo = entry.getValue().getDtArtista();
		            ret.add(nuevo);   
				}
			}
			return ret;
		}
		public Integer getUltimoCodigo(String nickname) {
			Espectador espec = espectadores.get(nickname);
			return espec.getUltimoCodigo();
		}
		public Set<DtRegistro> listarRegistrosSinCanjeaer(String nickname){
			Espectador espec = espectadores.get(nickname);
			return espec.listarRegistrosSinCanjeaer();
		}
		
		public Set<DtPaquete> listarPaquetesCanjeables(String nickname, String nombreEspectaculo){
			Espectador espec = espectadores.get(nickname);
			return espec.listarPaquetesCanjeables(nombreEspectaculo);
		}
		
		public Boolean existeRegistroaFuncion(String nickname, String nombreFuncion) {
			Espectador espec = espectadores.get(nickname);
			return espec.existeRegistroaFuncion(nombreFuncion);
		}
		public void comprarPaquete(String nickname, String nombrePaquete, Date fecha) {
			Espectador espec = espectadores.get(nickname);
			Fabrica fab = Fabrica.getInstancia();
			Paquete paquete = fab.getIPaquete().getPaquete(nombrePaquete);
			espec.anadirPaquete(paquete, fecha);
		}
		
		public void seguirUsuario(String NickSeguidor, String NickASeguir) {
			Usuario seguidor;
			Usuario aseguir;
			if (esArtista(NickSeguidor)) {
				seguidor = artistas.get(NickSeguidor);
			}
			else {
				seguidor = espectadores.get(NickSeguidor);
			}
			if (esArtista(NickASeguir)) {
				aseguir = artistas.get(NickASeguir);
			}
			else {
				aseguir = espectadores.get(NickASeguir);
			}
			seguidor.agregarSeguido(NickASeguir, aseguir);
			aseguir.agregarSeguidor(NickSeguidor, seguidor);
		}
		public Boolean existeNickname(String nickname) {
			return artistas.containsKey(nickname) || espectadores.containsKey(nickname);
		}
		
		public void dejarSeguirUsuario(String NickSeguidor, String NickDejarSeguir) {
			if (artistas.containsKey(NickSeguidor)) {
				artistas.get(NickSeguidor).eliminarSeguido(NickDejarSeguir);
			}
			if (espectadores.containsKey(NickSeguidor)) {
				espectadores.get(NickSeguidor).eliminarSeguido(NickDejarSeguir);
			}
			if (artistas.containsKey(NickDejarSeguir)) {
				artistas.get(NickDejarSeguir).eliminarSeguidor(NickSeguidor);
			}
			if (espectadores.containsKey(NickDejarSeguir)) {
				espectadores.get(NickDejarSeguir).eliminarSeguidor(NickSeguidor);
			}
		}
		
		public Boolean existeCompraPaquete(String nickname, String nombrePaquete) {
			Espectador espec = espectadores.get(nickname);
			return espec.existeCompraPaquete(nombrePaquete);
		}
		

		public Set<DtRegistro> listarRegistros(String Nickname){
			Espectador espec = espectadores.get(Nickname);
			return espec.listarRegistros();
		}

}
