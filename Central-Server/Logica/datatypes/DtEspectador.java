package datatypes;

import java.util.Date;

public class DtEspectador {
	public DtEspectador(String nickname, String nombre, String apellido, String email, Date nacimiento) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.nacimiento = nacimiento;
	}
	private
	String nickname;
	private
	String nombre;
	private
	String apellido;
	private
	String email;
	private
	Date nacimiento;
	public String getNickname() {
		return nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getEmail() {
		return email;
	}
	public Date getNacimiento() {
		return nacimiento;
	}


}
