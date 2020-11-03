package interfaces;


import clases.Categoria;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoDatos;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import datatypes.TipoRegistro;
import excepciones.Identidad;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public interface ICategoria {
	public void altaCategoria(String Nombre) throws Identidad;
	public Categoria getCategoria(String nombre);
	public HashSet<DtEspectaculo> listarEspectaculosAceptadosDeCategoria(String nombreCat);
	public DtEspectaculoDatos mostrarDatosEspectaculoPorCategoria(String nombreEspectaulo, String nombreCat);
	public HashSet<DtCategoria> listarCategorias();
	public HashSet<DtFuncion> listarFuncionesDeEspectaculoDesdeCategoria(String NombreEspectaculo, String NombreCategoria);
	public DtFuncionDatos mostrarFuncionDesdeCategoria(String NombreFuncion, String NombreEspectaculo, String NombreCategoria);
	public HashSet<DtFuncion> listarFuncionesVigentesDeEspectaculoDesdeCategoria();
	public Set<DtEspectaculo> listarEspectaculosDeCategoria(String Nombre);
	//public void ConfirmarRegistroFuncionEspectaculoDesdeCategoria(String nombreCateogoria, String nombreEspectaculo, String nickname, String nombreFuncion,
				//Date fecha,TipoRegistro registro, Integer Registro1, Integer Registro2, Integer Registro3, String NombrePaquete, Double costo);
}
