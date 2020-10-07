package DataTypes;

public class DtUsuario {
	private
		String Nickname;
		String Nombre;
		String Apellido;
		String Contrasena;
		String Email;
		
		public DtUsuario(String nickname, String nombre, String apellido, String contrasena, String email) {
			super();
			Nickname = nickname;
			Nombre = nombre;
			Apellido = apellido;
			Contrasena = contrasena;
			Email = email;
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
		
	
}
