package Interfaces;

import java.util.Date;
import java.util.Set;
import java.util.Map;

import Clases.Funcion;
import DataTypes.DtEspectaculo;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtFuncion;
import DataTypes.DtFuncionDatos;
import DataTypes.DtPlataforma;

public interface IPlataforma {
	public 
		Set<DtEspectaculo> listarEspectaculosDePlataforma(String Nombre);
		Set<DtFuncion> listarFuncionesDeEspectaculo(String NombreEsp);
		DtFuncionDatos MostrarFuncion(String NombreEsp, String NombreFun);
		DtEspectaculoDatos listarDtEspectaculoDatos(String NombreEspectaculo);
		void AltaPlataforma(String nombre, String Descripcion,String Url);
		Map<String,DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp,String nombrePlat);
		void altaEspectaculo(String nickname, String nombre,String descripcion,Integer cantespmin, Integer cantmaxesp,String url,Integer costo,Date fecha);
		Funcion getFuncion(String nombreEspectaculo, String NomFuncion);
		Set<DtPlataforma> listarPlataformas();

}
