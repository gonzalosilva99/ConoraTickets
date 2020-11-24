package datatypes;

import java.util.Date;

public class DtPaquete {


private
String nombre;

private
String descripcion;
private
String imagen;
private
Double descuento;
private
Date inicio;
private
Date fin;
public DtPaquete(String nombre, String descripcion, String imagen, Double descuento, Date inicio, Date fin) {
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.descuento = descuento;
	this.imagen = imagen;
	this.inicio = inicio;
	this.fin = fin;
}
public String getNombre() {
	return nombre;
}
public String getDescripcion() {
	return descripcion;
}
public String getImagen() {
	return imagen;
}
public Double getDescuento() {
	return descuento;
}
public Date getInicio() {
	return inicio;
}
public Date getFin() {
	return fin;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public void setImagen(String imagen) {
	this.imagen = imagen;
}
public void setDescuento(Double descuento) {
	this.descuento = descuento;
}
public void setInicio(Date inicio) {
	this.inicio = inicio;
}
public void setFin(Date fin) {
	this.fin = fin;
}
}
