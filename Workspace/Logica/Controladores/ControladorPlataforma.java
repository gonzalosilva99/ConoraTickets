package Controladores;

import Interfaces.IPlataforma;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import Clases.Funcion;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtFuncion;
import DataTypes.DtEspectaculo;
import DataTypes.DtFuncionDatos;

public class ControladorPlataforma implements IPlataforma{
	Set<DtEspectaculo> listarEspectaculosDePlataforma() {
		Set<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
		return ret;
	};
	Set<DtFuncion> listarFuncionesDeEspectaculo(String NombreEsp) {
		Set<DtFuncion> ret = new HashSet<DtFuncion>();
		return ret;
	};
	DtFuncionDatos MostrarFuncion(String NombreEsp, String NombreFun) {
		DtFuncionDatos ret = new DtFuncionDatos();
		return ret;
	};
	DtEspectaculoDatos listarDtEspectaculoDatos(String NombreEspectaculo) {
		DtEspectaculoDatos ret = new DtEspectaculoDatos();
		return ret;
	};
	Set<DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp){
		Set<DtFuncion> ret = new HashSet<DtFuncion>();
		return ret;
	};
	void altaEspectaculo(String nickname, String nombre,String descripcion,Integer cantespmin, Integer cantmaxesp,String url,Integer costo,Date fecha) {};
	Funcion getFuncion(String nombreEspectaculo, String NomFuncion) {
		Date fecha1 = new Date();
		Funcion ret = new Funcion("",fecha1,fecha1);
		return ret;
		
	};
}
