package DataTypes;

import java.util.Date;

public class DtPaquete {


private
String Nombre;
private
String Descripcion;
private
String Imagen;
private
Double Descuento;
private
Date Inicio;
private
Date Fin;
public DtPaquete(String nombre, String descripcion, String imagen, Double descuento, Date inicio, Date fin) {
	Nombre = nombre;
	Descripcion = descripcion;
	Descuento = descuento;
	Imagen = imagen;
	Inicio = inicio;
	Fin = fin;
}
public String getNombre() {
	return Nombre;
}
public String getDescripcion() {
	return Descripcion;
}
public String getImagen() {
	return Imagen;
}
public Double getDescuento() {
	return Descuento;
}
public Date getInicio() {
	return Inicio;
}
public Date getFin() {
	return Fin;
}
}
