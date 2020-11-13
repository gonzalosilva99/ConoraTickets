package datatypes;

import java.util.Date;
import java.util.Set;


public class DtEspectaculoDatos {
	
public DtEspectaculoDatos(String nombre, String descripcion, Integer duracion, Integer cantmin, 
		Integer cantmax, String url, Float costo, Date registro, Set<DtFuncionDatos> funciones, 
		Set<DtPaquete> paquetes, DtArtista organizador, String imagen, Set<DtCategoria> categorias, 
		int cantPremios, double puntajePromedio, String urlVideo, String premio, int cantFavoritos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.cantmin = cantmin;
		this.cantmax = cantmax;
		this.url = url;
		this.costo = costo;
		this.registro = registro;
		this.funciones = funciones;
		this.paquetes = paquetes;
		this.organizador = organizador;
		this.categorias = categorias;
		this.imagen = imagen;
		this.cantPremios = cantPremios;
		this.puntajePromedio = puntajePromedio;
		this.urlVideo = urlVideo;
		this.premio = premio;
		this.cantFavoritos = cantFavoritos;
	}
public DtEspectaculoDatos() {
	
}
private
	String nombre;
private
	DtArtista organizador;
private
	String descripcion;
private
	Integer duracion;
private
	Integer cantmin;
private
	Integer cantFavoritos;
private
Integer cantmax;
private
String url;
private
	Set<DtCategoria> categorias;
private
Float costo;
private
Date registro;
private String imagen;
private
Set<DtFuncionDatos> funciones;
private
Set<DtPaquete> paquetes;
private String urlVideo;
public String getUrlVideo() {
	return urlVideo;
}
public void setUrlVideo(String urlVideo) {
	this.urlVideo = urlVideo;
}
private String premio;
private int cantPremios;
private double puntajePromedio;
public String getNombre() {
	return nombre;
}

public String getImagen() {
	return imagen;
}
public String getDescripcion() {
	return descripcion;
}
public Integer getDuracion() {
	return duracion;
}
public Integer getCantMin() {
	return cantmin;
}
public Integer getCantMax() {
	return cantmax;
}
public String getURL() {
	return url;
}
public Float getCosto() {
	return costo;
}
public Date getRegistro() {
	return registro;
}
public Set<DtFuncionDatos> getFunciones() {
	return funciones;
}
public Set<DtPaquete> getPaquetes() {
	return paquetes;
}
public DtArtista getOrganizador() {
	return organizador;
}
public Set<DtCategoria> getCategorias() {
	return categorias;
}
public String getPremio() {
	return premio;
}
public int getCantPremios() {
	return cantPremios;
}
public double getPuntajePromedio() {
	return puntajePromedio;
}
public Integer getCantFavoritos() {
	return cantFavoritos;
}





}
