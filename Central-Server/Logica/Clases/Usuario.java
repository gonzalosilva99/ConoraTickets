package Clases;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class Usuario {
	private String Nickname;
	private String Nombre;
	private String Apellido;
	private String Email;
	private String Imagen;
	private String Contrasena;
	private Date Nacimiento;
	private HashMap<String, Usuario> Seguidores;
	private HashMap<String, Usuario> Siguiendo;
		public String getNickname() {
			return Nickname;
		}
		public void setNickname(String nickname) {
			Nickname = nickname;
		}
		public String getNombre() {
			return Nombre;
		}
		public void setNombre(String nombre) {
			Nombre = nombre;
		}
		public String getApellido() {
			return Apellido;
		}
		public void setApellido(String apellido) {
			Apellido = apellido;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public Date getNacimiento() {
			return Nacimiento;
		}
		public void setNacimiento(Date nacimiento) {
			Nacimiento = nacimiento;
		}
		
		public String getImagen() {
			return Imagen;
		}
		public void setImagen(String imagen) {
			Imagen = imagen;
		}
		public String getContrasena() {
			return Contrasena;
		}
		public void setContrasena(String contrasena) {
			Contrasena = contrasena;
		}
		public Usuario(String nickname, String nombre, String apellido, String email,
				Date nacimiento, String imagen, String contrasena) {
			super();
			Nickname = nickname;
			Nombre = nombre;
			Apellido = apellido;
			Email = email;
			Imagen = imagen;
			Contrasena = contrasena;
			Nacimiento = nacimiento;
			Seguidores = new HashMap<String, Usuario>();
			Siguiendo = new HashMap<String, Usuario>();
		}
		public void AgregarSeguido(String nick,Usuario usu) {
			Siguiendo.put(nick, usu);
		}
		
		public void AgregarSeguidor(String nick,Usuario usu) {
			Seguidores.put(nick, usu);
		}
		
		
}

