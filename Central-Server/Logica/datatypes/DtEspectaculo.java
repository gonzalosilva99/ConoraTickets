package datatypes;

public class DtEspectaculo {
	
public DtEspectaculo(String nombre, String descripcion, String imagen, EstadoEspectaculo estado, Integer costo, String urlVideo,
		String premio, int cantPremios, double puntajePromedio, int cantFavoritos, int duracion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.costo= costo;
		this.estado = estado;
		this.cantPremios = cantPremios;
		this.puntajePromedio = puntajePromedio;
		this.urlVideo = urlVideo;
		this.premio = premio;
		this.cantFavoritos = cantFavoritos;
		this.duracion = duracion;
		
	}
private EstadoEspectaculo estado;
private Integer costo;
private Integer duracion;
private Integer cantFavoritos;
private
String nombre;
private
String descripcion;
private
String imagen;
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

public EstadoEspectaculo getEstado() {
	return estado;
}
public Integer getCosto() {
	return costo;
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
public Integer getDuracion() {
	return duracion;
}

}
