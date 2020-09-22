package DataTypes;

public class DtUsuario {
	private
		String Nickname;
		String Nombre;
		String Apellido;
		public DtUsuario(String nickname, String nombre, String apellido) {
			super();
			Nickname = nickname;
			Nombre = nombre;
			Apellido = apellido;
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
	
}
