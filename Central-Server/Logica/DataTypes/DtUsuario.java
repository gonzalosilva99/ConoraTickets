package DataTypes;

import java.util.Date;
import java.util.HashSet;

public class DtUsuario {
	private
		String Nickname;
		String Nombre;
		String Apellido;
		String Contrasena;
		String Email;
		String Imagen;
		Date Nacimiento;
		
		public DtUsuario(String nickname, String nombre, String apellido, String contrasena, String email,
				String imagen, Date nacimiento) {
			super();
			Nickname = nickname;
			Nombre = nombre;
			Apellido = apellido;
			Contrasena = contrasena;
			Email = email;
			Imagen = imagen;
			Nacimiento = nacimiento;
		}

		public String getNickname() {
			return Nickname;
		}

		public String getNombre() {
			return Nombre;
		}

		public String getApellido() {
			return Apellido;
		}

		public String getContrasena() {
			return Contrasena;
		}

		public String getEmail() {
			return Email;
		}

		public String getImagen() {
			return Imagen;
		}

		public Date getNacimiento() {
			return Nacimiento;
		}
		
		
}
