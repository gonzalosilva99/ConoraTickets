package DataTypes;

public class DtPaquete {

public DtPaquete(String nombre, String descripcion) {
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
