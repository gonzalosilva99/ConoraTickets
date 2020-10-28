package DataTypes;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;


public class DtEspectaculoDatos {
	
public DtEspectaculoDatos(String nombre, String descripcion, Integer duracion, Integer cantMin, Integer cantMax,String uRL, Float costo, Date registro, Set<DtFuncionDatos> funciones, Set<DtPaquete> paquetes, DtArtista organizador, String imagen, HashSet<DtCategoria> categorias) {
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
		Categorias = categorias;
		Imagen = imagen;
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
	HashSet<DtCategoria> Categorias;
private
Float Costo;
private
Date Registro;
private String Imagen;
private
Set<DtFuncionDatos> Funciones;
private
Set<DtPaquete> Paquetes;
public String getNombre() {
	return Nombre;
}

public String getImagen() {
	return Imagen;
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
public Set<DtFuncionDatos> getFunciones() {
	return Funciones;
}
public Set<DtPaquete> getPaquetes() {
	return Paquetes;
}
public DtArtista getOrganizador() {
	return Organizador;
}
public HashSet<DtCategoria> getCategorias() {
	return Categorias;
}




}
