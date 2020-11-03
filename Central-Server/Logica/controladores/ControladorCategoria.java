package controladores;
import java.util.Set;

import clases.Categoria;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoDatos;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import excepciones.Identidad;
import interfaces.ICategoria;
import manejadores.ManejadorCategoria;
public class ControladorCategoria implements ICategoria{
	public void altaCategoria(String Nombre) throws Identidad{		
		ManejadorCategoria mancat = manejadores.ManejadorCategoria.getInstancia();
		mancat.altaCategoria(Nombre);
	}
	public Categoria getCategoria(String nombre) {
		ManejadorCategoria mancat = manejadores.ManejadorCategoria.getInstancia();
		return mancat.getCategoria(nombre);
	}
	public Set<DtEspectaculo> listarEspectaculosAceptadosDeCategoria(String nombreCat){
		ManejadorCategoria mancat = manejadores.ManejadorCategoria.getInstancia();	
		return mancat.listarEspectaculosAceptadosDeCategoria(nombreCat); }
	public DtEspectaculoDatos mostrarDatosEspectaculoPorCategoria(String nombreEspectaulo, String nombreCat) {
		return null; }
	public Set<DtCategoria> listarCategorias(){
		ManejadorCategoria mancat = manejadores.ManejadorCategoria.getInstancia();	
		return mancat.listarCategorias();
	}
	public Set<DtFuncion> listarFuncionesDeEspectaculoDesdeCategoria(String NombreEspectaculo, String NombreCategoria){
		return null; }
	public DtFuncionDatos mostrarFuncionDesdeCategoria(String NombreFuncion, String NombreEspectaculo, String NombreCategoria){
		return null; }
	public Set<DtFuncion> listarFuncionesVigentesDeEspectaculoDesdeCategoria(){
		return null; }
	public Set<DtEspectaculo> listarEspectaculosDeCategoria(String Nombre){
		ManejadorCategoria mancat = manejadores.ManejadorCategoria.getInstancia();	
		return mancat.listarEspectaculosDeCategoria(Nombre);
	}
	//public void ConfirmarRegistroFuncionEspectaculoDesdeCategoria(String nombreCateogoria, String nombreEspectaculo, String nickname, String nombreFuncion,
				//Date fecha,TipoRegistro registro, Integer Registro1, Integer Registro2, Integer Registro3, String NombrePaquete, Double costo){}

}
