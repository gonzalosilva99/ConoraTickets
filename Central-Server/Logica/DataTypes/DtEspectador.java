package DataTypes;

import java.util.Date;

public class DtEspectador {
	public DtEspectador(String nickname, String nombre, String apellido, String email, Date nacimiento) {
		super();
		Nickname = nickname;
		Nombre = nombre;
		Apellido = apellido;
		Email = email;
		Nacimiento = nacimiento;
	}
	private
	String Nickname;
	private
	String Nombre;
	private
	String Apellido;
	private
	String Email;
	private
	Date Nacimiento;
	public String getNickname() {
		return Nickname;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public String getEmail() {
		return Email;
	}
	public Date getNacimiento() {
		return Nacimiento;
	}


}
