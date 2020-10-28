package Controladores;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Clases.Categoria;
import DataTypes.DtCategoria;
import DataTypes.DtEspectaculo;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtFuncion;
import DataTypes.DtFuncionDatos;
import DataTypes.TipoRegistro;
import Excepciones.Identidad;
import Interfaces.ICategoria;
import Manejadores.ManejadorCategoria;
import Manejadores.ManejadorPlataforma;
public class ControladorCategoria implements ICategoria{
	public void AltaCategoria(String Nombre) throws Identidad{		
		ManejadorCategoria mancat = Manejadores.ManejadorCategoria.getInstancia();
		mancat.AltaCategoria(Nombre);
	}
	public Categoria getCategoria(String nombre) {
		ManejadorCategoria mancat = Manejadores.ManejadorCategoria.getInstancia();
		return mancat.getCategoria(nombre);
	}
	public HashSet<DtEspectaculo> listarEspectaculosAceptadosDeCategoria(String nombreCat){
		ManejadorCategoria mancat = Manejadores.ManejadorCategoria.getInstancia();	
		return mancat.listarEspectaculosAceptadosDeCategoria(nombreCat);}
	public DtEspectaculoDatos mostrarDatosEspectaculoPorCategoria(String nombreEspectaulo, String nombreCat) {return null;}
	public HashSet<DtCategoria> listarCategorias(){
		ManejadorCategoria mancat = Manejadores.ManejadorCategoria.getInstancia();	
		return mancat.listarCategorias();
	}
	public HashSet<DtFuncion> ListarFuncionesDeEspectaculoDesdeCategoria(String NombreEspectaculo, String NombreCategoria){return null;}
	public DtFuncionDatos MostrarFuncionDesdeCategoria(String NombreFuncion,String NombreEspectaculo,String NombreCategoria){return null;}
	public HashSet<DtFuncion> ListarFuncionesVigentesDeEspectaculoDesdeCategoria(){return null;}
	public Set<DtEspectaculo> listarEspectaculosDeCategoria(String Nombre){
		ManejadorCategoria mancat = Manejadores.ManejadorCategoria.getInstancia();	
		return mancat.listarEspectaculosDeCategoria(Nombre);
	}
	//public void ConfirmarRegistroFuncionEspectaculoDesdeCategoria(String nombreCateogoria, String nombreEspectaculo, String nickname, String nombreFuncion,
				//Date fecha,TipoRegistro registro, Integer Registro1, Integer Registro2, Integer Registro3, String NombrePaquete, Double costo){}

}
