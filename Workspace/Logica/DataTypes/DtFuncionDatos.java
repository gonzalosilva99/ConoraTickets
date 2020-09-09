package DataTypes;

import java.util.Date;
import java.util.Set;

public class DtFuncionDatos {
	
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
