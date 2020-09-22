package DataTypes;

public class DtPlataforma {
	
public DtPlataforma(String nombre, String descripcion, String uRL) {
		super();
		Nombre = nombre;
		Descripcion = descripcion;
		URL = uRL;
	}
private
String Nombre;
private
String Descripcion;
private
String URL;
public String getNombre() {
	return Nombre;
}
public String getDescripcion() {
	return Descripcion;
}
public String getURL() {
	return URL;
}

}
