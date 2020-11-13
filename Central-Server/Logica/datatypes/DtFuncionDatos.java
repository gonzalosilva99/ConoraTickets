package datatypes;

import java.util.Date;
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

	
public DtFuncionDatos(String nombre, Date inicio, Date alta, Set<DtArtista> artistas,
		DtEspectaculo espectaculo, String imagen, Integer espectadores, Set<DtRegistroFuncion> registros) {
		super();
		this.nombre = nombre;
		this.inicio = inicio;
		this.alta = alta;
		this.artistas = artistas;
		this.espectaculo = espectaculo;
		this.imagen = imagen;
		this.espectadores = espectadores;
		this.setRegistros(registros);
	}
public DtFuncionDatos() {}

public String getNombre() {
	return nombre;
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


}
