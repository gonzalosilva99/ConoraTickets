package DataTypes;

import java.util.Date;
import java.util.Set;

public class DtFuncionDatos {
private String Nombre;
private	Date Inicio;
private	Date Alta;
private	Set<DtArtista> Artistas;
private	DtEspectaculo Espectaculo;	
private String Imagen;
private Integer Espectadores;
	
public DtFuncionDatos(String nombre, Date inicio, Date alta, Set<DtArtista> artistas, DtEspectaculo espectaculo, String imagen, Integer espectadores) {
		super();
		Nombre = nombre;
		Inicio = inicio;
		Alta = alta;
		Artistas = artistas;
		Espectaculo = espectaculo;
		Imagen = imagen;
		Espectadores = espectadores;
	}
public DtFuncionDatos() {}

public String getNombre() {
	return Nombre;
}
public String getImagen() {
	return Imagen;
}
public Integer getEspectadores() {
	return Espectadores;
}
public Date getInicio() {
	return Inicio;
}
public Date getAlta() {
	return Alta;
}
public Set<DtArtista> getArtistas() {
	return Artistas;
}
public DtEspectaculo getEspectaculo() {

	return Espectaculo;
}

}
