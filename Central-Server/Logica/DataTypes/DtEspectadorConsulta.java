package DataTypes;

import java.util.Date;
import java.util.HashSet;

public class DtEspectadorConsulta {
	public DtEspectadorConsulta(String nickname, String nombre, String apellido, String email, Date nacimiento,HashSet<DtFuncion> funciones) {
		super();
		Nickname = nickname;
		Nombre = nombre;
		Apellido = apellido;
		Email = email;
		Nacimiento = nacimiento;
		Funciones = funciones;
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
	private
	HashSet<DtFuncion> Funciones;
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
	public HashSet<DtFuncion> getFunciones() {
		return Funciones;
	}
	
	
}
