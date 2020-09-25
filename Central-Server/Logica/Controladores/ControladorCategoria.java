package Controladores;
import java.util.Date;
import java.util.HashSet;

import DataTypes.DtCategoria;
import DataTypes.DtEspectaculo;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtFuncion;
import DataTypes.DtFuncionDatos;
import DataTypes.TipoRegistro;
import Excepciones.Identidad;
import Interfaces.ICategoria;
import Manejadores.ManejadorCategoria;
public class ControladorCategoria implements ICategoria{
	public void AltaCategoria(String Nombre) throws Identidad{		
		ManejadorCategoria mancat = Manejadores.ManejadorCategoria.getInstancia();
		mancat.AltaCategoria(Nombre);
	}
	public HashSet<DtEspectaculo> listarEspectaculosAceptadosDeCategoria(String nombreCat){return null;}
	public DtEspectaculoDatos mostrarDatosEspectaculoPorCategoria(String nombreEspectaulo, String nombreCat) {return null;}
	public DtCategoria listarCategorias(){return null;}
	public HashSet<DtFuncion> ListarFuncionesDeEspectaculoDesdeCategoria(String NombreEspectaculo, String NombreCategoria){return null;}
	public DtFuncionDatos MostrarFuncionDesdeCategoria(String NombreFuncion,String NombreEspectaculo,String NombreCategoria){return null;}
	public HashSet<DtFuncion> ListarFuncionesVigentesDeEspectaculoDesdeCategoria(){return null;}
	public void ConfirmarRegistroFuncionEspectaculoDesdeCategoria(String nombreCateogoria, String nombreEspectaculo, String nickname, String nombreFuncion,
				Date fecha,TipoRegistro registro, Integer Registro1, Integer Registro2, Integer Registro3, String NombrePaquete, Double costo){}

}
