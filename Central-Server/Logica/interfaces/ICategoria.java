package interfaces;


import java.util.Set;

import clases.Categoria;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoDatos;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import excepciones.Identidad;

public interface ICategoria {
	public void altaCategoria(String Nombre) throws Identidad;
	public Categoria getCategoria(String nombre);
	public Set<DtEspectaculo> listarEspectaculosAceptadosDeCategoria(String nombreCat);
	public DtEspectaculoDatos mostrarDatosEspectaculoPorCategoria(String nombreEspectaulo, String nombreCat);
	public Set<DtCategoria> listarCategorias();
	public Set<DtFuncion> listarFuncionesDeEspectaculoDesdeCategoria(String NombreEspectaculo, String NombreCategoria);
	public DtFuncionDatos mostrarFuncionDesdeCategoria(String NombreFuncion, String NombreEspectaculo, String NombreCategoria);
	public Set<DtFuncion> listarFuncionesVigentesDeEspectaculoDesdeCategoria();
	public Set<DtEspectaculo> listarEspectaculosDeCategoria(String Nombre);
	//public void ConfirmarRegistroFuncionEspectaculoDesdeCategoria(String nombreCateogoria, String nombreEspectaculo, String nickname, String nombreFuncion,
				//Date fecha,TipoRegistro registro, Integer Registro1, Integer Registro2, Integer Registro3, String NombrePaquete, Double costo);
}
