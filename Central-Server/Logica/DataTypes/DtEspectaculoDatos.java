package DataTypes;

import java.util.Date;
import java.util.Set;


public class DtEspectaculoDatos {
	
public DtEspectaculoDatos(String nombre, String descripcion, Integer duracion, Integer cantMin, Integer cantMax,
			String uRL, Float costo, Date registro, Set<DtFuncion> funciones, Set<DtPaquete> paquetes, DtArtista organizador) {
		super();
		Nombre = nombre;
		Descripcion = descripcion;
		Duracion = duracion;
		CantMin = cantMin;
		CantMax = cantMax;
		URL = uRL;
		Costo = costo;
		Registro = registro;
		Funciones = funciones;
		Paquetes = paquetes;
		Organizador = organizador;
	}
public DtEspectaculoDatos() {
	
}
private
	String Nombre;
private
	DtArtista Organizador;
private
	String Descripcion;
private
	Integer Duracion;
private
	Integer CantMin;
private
Integer CantMax;
private
String URL;
private
Float Costo;
private
Date Registro;
private
Set<DtFuncion> Funciones;
private
Set<DtPaquete> Paquetes;
public String getNombre() {
	return Nombre;
}
public String getDescripcion() {
	return Descripcion;
}
public Integer getDuracion() {
	return Duracion;
}
public Integer getCantMin() {
	return CantMin;
}
public Integer getCantMax() {
	return CantMax;
}
public String getURL() {
	return URL;
}
public Float getCosto() {
	return Costo;
}
public Date getRegistro() {
	return Registro;
}
public Set<DtFuncion> getFunciones() {
	return Funciones;
}
public Set<DtPaquete> getPaquetes() {
	return Paquetes;
}
public DtArtista getOrganizador() {
	return Organizador;
}




}
