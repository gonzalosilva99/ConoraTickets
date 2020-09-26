package Interfaces;


import DataTypes.DtEspectaculo;
import DataTypes.DtCategoria;
import DataTypes.DtFuncion;
import DataTypes.DtFuncionDatos;
import DataTypes.TipoRegistro;
import Excepciones.Identidad;
import DataTypes.DtEspectaculoDatos;
import Clases.Categoria;

import java.util.Date;
import java.util.HashSet;

public interface ICategoria {
	public void AltaCategoria(String Nombre) throws Identidad;
	public Categoria getCategoria(String nombre);
	public HashSet<DtEspectaculo> listarEspectaculosAceptadosDeCategoria(String nombreCat);
	public DtEspectaculoDatos mostrarDatosEspectaculoPorCategoria(String nombreEspectaulo, String nombreCat);
	public HashSet<DtCategoria> listarCategorias();
	public HashSet<DtFuncion> ListarFuncionesDeEspectaculoDesdeCategoria(String NombreEspectaculo, String NombreCategoria);
	public DtFuncionDatos MostrarFuncionDesdeCategoria(String NombreFuncion,String NombreEspectaculo,String NombreCategoria);
	public HashSet<DtFuncion> ListarFuncionesVigentesDeEspectaculoDesdeCategoria();
	public void ConfirmarRegistroFuncionEspectaculoDesdeCategoria(String nombreCateogoria, String nombreEspectaculo, String nickname, String nombreFuncion,
				Date fecha,TipoRegistro registro, Integer Registro1, Integer Registro2, Integer Registro3, String NombrePaquete, Double costo);
}
