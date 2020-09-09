package DataTypes;

public class DtEspectaculo {
	
public DtEspectaculo(String nombre, String descripcion) {
		super();
		Nombre = nombre;
		Descripcion = descripcion;
	}
private
String Nombre;
private
String Descripcion;

public String getNombre() {
	return Nombre;
}
public String getDescripcion() {
	return Descripcion;
}

}
