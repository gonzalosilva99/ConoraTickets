package datatypes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DtFuncionDatos {

private String nombre;
private	Date inicio;
private	Date alta;
private	Set<DtArtista> artistas;
private	DtEspectaculo espectaculo;	
private String imagen;
private Integer espectadores;
private Set<DtRegistroFuncion> registros;
private Date fechaSorteo;
private Set<DtEspectador> ganadoresSorteo;

	
public DtFuncionDatos(String nombre, Date inicio, Date alta, Set<DtArtista> artistas,
		DtEspectaculo espectaculo, String imagen, Integer espectadores, Set<DtRegistroFuncion> registros, Date fechaSorteo, Set<DtEspectador> ganadoresSorteo) {
		super();
		this.nombre = nombre;
		this.inicio = inicio;
		this.alta = alta;
		this.artistas = artistas;
		this.espectaculo = espectaculo;
		this.imagen = imagen;
		this.espectadores = espectadores;
		this.registros = registros;
		this.fechaSorteo = fechaSorteo;
		this.ganadoresSorteo = ganadoresSorteo;
	}
public DtFuncionDatos() {
	registros = new HashSet<DtRegistroFuncion>();
	ganadoresSorteo = new HashSet<DtEspectador>();
	artistas = new HashSet<DtArtista>();
}

public String getNombre() {
	return nombre;
}
public Date getFechaSorteo() {
	return fechaSorteo;
}
public Set<DtEspectador> getGanadoresSorteo() {
	return ganadoresSorteo;
}
public String getImagen() {
	return imagen;
}
public Integer getEspectadores() {
	return espectadores;
}
public Date getInicio() {
	return inicio;
}
public Date getAlta() {
	return alta;
}
public Set<DtArtista> getArtistas() {
	return artistas;
}
public DtEspectaculo getEspectaculo() {

	return espectaculo;
}
public Set<DtRegistroFuncion> getRegistros() {
	return registros;
}
public void setRegistros(Set<DtRegistroFuncion> registros) {
	this.registros = registros;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setInicio(Date inicio) {
	this.inicio = inicio;
}
public void setAlta(Date alta) {
	this.alta = alta;
}
public void setArtistas(Set<DtArtista> artistas) {
	this.artistas = artistas;
}
public void setEspectaculo(DtEspectaculo espectaculo) {
	this.espectaculo = espectaculo;
}
public void setImagen(String imagen) {
	this.imagen = imagen;
}
public void setEspectadores(Integer espectadores) {
	this.espectadores = espectadores;
}
public void setFechaSorteo(Date fechaSorteo) {
	this.fechaSorteo = fechaSorteo;
}
public void setGanadoresSorteo(Set<DtEspectador> ganadoresSorteo) {
	this.ganadoresSorteo = ganadoresSorteo;
}
}
