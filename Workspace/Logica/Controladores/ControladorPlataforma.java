package Controladores;

import Interfaces.IPlataforma;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import Clases.Funcion;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtFuncion;
import DataTypes.DtEspectaculo;
import DataTypes.DtFuncionDatos;
import DataTypes.DtPlataforma;
import Manejadores.ManejadorPlataforma;
import Manejadores.ManejadorUsuario;

public class ControladorPlataforma implements IPlataforma{

	public Set<DtEspectaculo> listarEspectaculosDePlataforma() {
		Set<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
		return ret;
	};
	public Set<DtFuncion> listarFuncionesDeEspectaculo(String NombreEsp) {
		Set<DtFuncion> ret = new HashSet<DtFuncion>();
		return ret;
	};
	public DtFuncionDatos MostrarFuncion(String NombreEsp, String NombreFun) {
		DtFuncionDatos ret = new DtFuncionDatos(NombreFun, null, null, null, null);
		return ret;
	};
	public DtEspectaculoDatos listarDtEspectaculoDatos(String NombreEspectaculo) {
		DtEspectaculoDatos ret = new DtEspectaculoDatos(NombreEspectaculo, NombreEspectaculo, null, null, null, NombreEspectaculo, null, null, null, null);
		return ret;
	};
	public void AltaPlataforma(String nombre, String Descripcion,String Url) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		manplat.AltaPlataforma(nombre, Descripcion, Url);
	}
	
	public Map<String, DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp){
		Map<String,DtFuncion> ret = new HashMap<String,DtFuncion>();
		return ret;
	};
	public void altaEspectaculo(String nickname, String nombre,String descripcion,Integer cantespmin, Integer cantmaxesp,String url,Integer costo,Date fecha) {};
	public Funcion getFuncion(String nombreEspectaculo, String NomFuncion) {
		Funcion ret = new Funcion(NomFuncion, null, null);
		return ret;
	};
	public Set<DtPlataforma> listarPlataformas(){
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();	
		return manplat.listarPlataformas();
	}
}
