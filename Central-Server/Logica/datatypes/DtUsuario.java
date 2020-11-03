package datatypes;

import java.util.Date;

public class DtUsuario {
	private
		String nickname;
		String nombre;
		String apellido;
		String contrasena;
		String email;
		String imagen;
		Date nacimiento;
		
		public DtUsuario(String nickname, String nombre, String apellido, String contrasena, String email,
				String imagen, Date nacimiento) {
			super();
			this.nickname = nickname;
			this.nombre = nombre;
			this.apellido = apellido;
			this.contrasena = contrasena;
			this.email = email;
			this.imagen = imagen;
			this.nacimiento = nacimiento;
		}

		public String getNickname() {
			return nickname;
		}

		public String getNombre() {
			return nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public String getContrasena() {
			return contrasena;
		}

		public String getEmail() {
			return email;
		}

		public String getImagen() {
			return imagen;
		}

		public Date getNacimiento() {
			return nacimiento;
		}
		
		
}
