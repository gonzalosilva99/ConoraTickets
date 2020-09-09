package DataTypes;

import java.util.Date;
import java.util.Set;

public class DtFuncionDatos {
	
	
public DtFuncionDatos(String nombre, Date inicio, Date alta, Set<DtArtista> artistas, DtEspectaculo espectaculo) {
		super();
		Nombre = nombre;
		Inicio = inicio;
		Alta = alta;
		Artistas = artistas;
		Espectaculo = espectaculo;
	}
public DtFuncionDatos() {}
private
String Nombre;
private
Date Inicio;
private
Date Alta;
private
Set<DtArtista> Artistas;
private
DtEspectaculo Espectaculo;
public String getNombre() {
	return Nombre;
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
