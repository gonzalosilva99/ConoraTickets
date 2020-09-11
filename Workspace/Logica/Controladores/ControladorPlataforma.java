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
import Clases.Espectaculo;

public class ControladorPlataforma implements IPlataforma{

	public Set<DtEspectaculo> listarEspectaculosDePlataforma(String Nombre) {
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
	public DtEspectaculoDatos listarDtEspectaculoDatos(String nomPlat, String NombreEspectaculo) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarDtEspectaculoDatos(nomPlat, NombreEspectaculo);
	};
	public void AltaPlataforma(String nombre, String Descripcion,String Url) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		manplat.AltaPlataforma(nombre, Descripcion, Url);
	}
	
	public Map<String, DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp,String nombrePlat){
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarFuncionesVigentesEspectaculo(nombreEsp, nombrePlat);
	};
	public void altaEspectaculo(String nomPlat, String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion) {
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		manplat.altaEspectaculo(nomPlat, nickArtista, nomEspectaculo, descripcion, minEsp, maxEsp, url, costo, fecha, duracion);
	};
	
	
	public Funcion getFuncion(String nombreEspectaculo, String NomFuncion) {
		Funcion ret = new Funcion(NomFuncion, null, null);
		return ret;
	};
	public Set<DtPlataforma> listarPlataformas(){
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();	
		return manplat.listarPlataformas();
	}
	public Set<DtEspectaculo> listarEspectaculos(String nombrePlataforma){
		ManejadorPlataforma manplat = Manejadores.ManejadorPlataforma.getInstancia();
		return manplat.listarEspectaculos(nombrePlataforma);
	}
	public void ConfirmarAltaFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nombre,Date fecha, Date inicio,Set<String> artistas, Date alta) {
		
	}
}


