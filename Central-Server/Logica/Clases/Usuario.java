package Clases;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import DataTypes.DtUsuario;

public abstract class Usuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private String imagen;
	private String contrasena;
	private Date nacimiento;
	protected HashMap<String, Usuario> seguidores;
	protected HashMap<String, Usuario> siguiendo;
	private Date ultimoIngreso;
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public Usuario(String nickname, String nombre, String apellido, String email, String imagen, String contrasena,
				Date nacimiento, HashMap<String, Usuario> seguidores, HashMap<String, Usuario> siguiendo,
				Date ultimoIngreso) {
			super();
			this.nickname = nickname;
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.imagen = imagen;
			this.contrasena = contrasena;
			this.nacimiento = nacimiento;
			this.seguidores = seguidores;
			this.siguiendo = siguiendo;
			this.ultimoIngreso = ultimoIngreso;
		}
		public Date getUltimoIngreso() {
			return ultimoIngreso;
		}
		public void setUltimoIngreso(Date ultimoIngreso) {
			this.ultimoIngreso = ultimoIngreso;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Date getNacimiento() {
			return nacimiento;
		}
		public void setNacimiento(Date nacimiento) {
			this.nacimiento = nacimiento;
		}
		
		public String getImagen() {
			return imagen;
		}
		public void setImagen(String imagen) {
			this.imagen = imagen;
		}
		public String getContrasena() {
			return contrasena;
		}
		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}
		public Usuario(String nickname, String nombre, String apellido, String email,
				Date nacimiento, String imagen, String contrasena) {
			super();
			this.nickname = nickname;
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.imagen = imagen;
			this.contrasena = contrasena;
			this.nacimiento = nacimiento;
			this.seguidores = new HashMap<String, Usuario>();
			this.siguiendo = new HashMap<String, Usuario>();
		}
		public void AgregarSeguido(String nick, Usuario usu) {
			siguiendo.put(nick, usu);
		}
		
		public void AgregarSeguidor(String nick, Usuario usu) {
			seguidores.put(nick, usu);
		}
		public HashMap<String, Usuario> getSeguidores() {
			return seguidores;
		}
		public void setSeguidores(HashMap<String, Usuario> seguidores) {
			this.seguidores = seguidores;
		}
		public HashMap<String, Usuario> getSiguiendo() {
			return siguiendo;
		}
		public void setSiguiendo(HashMap<String, Usuario> siguiendo) {
			this.siguiendo = siguiendo;
		}
		
		public DtUsuario getDtUsuario() {
			DtUsuario ret = new DtUsuario(this.getNickname(), this.getNombre(), this.getApellido(), this.getContrasena(), this.getEmail(), this.getImagen(), this.getNacimiento());
			return ret;
		}
		public void eliminarSeguido(String nickname){
			siguiendo.remove(nickname);
		}
		public void eliminarSeguidor(String nickname) {
			seguidores.remove(nickname);
		}
		
		
		
		
}

