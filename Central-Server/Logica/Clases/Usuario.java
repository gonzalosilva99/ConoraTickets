package Clases;

import java.util.Date;

abstract class Usuario {
	private String Nickname;
	private String Nombre;
	private String Apellido;
	private String Email;
	private Date Nacimiento;
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
		public Usuario(String nickname, String nombre, String apellido, String email, Date nacimiento) {
			super();
			Nickname = nickname;
			Nombre = nombre;
			Apellido = apellido;
			Email = email;
			Nacimiento = nacimiento;
		}
	
		
}

