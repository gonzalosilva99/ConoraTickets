package DataTypes;

public class DtPaquete {


private
String Nombre;
private
String Descripcion;
public DtPaquete(String nombre, String descripcion) {
	Nombre = nombre;
	Descripcion = descripcion;
}
public String getNombre() {
	return Nombre;
}
public String getDescripcion() {
	return Descripcion;
}

}
