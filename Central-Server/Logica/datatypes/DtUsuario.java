package datatypes;

import java.util.Date;

public class DtUsuario {
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

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
