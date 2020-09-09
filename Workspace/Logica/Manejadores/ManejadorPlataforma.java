package Manejadores;
import Clases.Plataforma;
import java.util.*;
import DataTypes.*;

public class ManejadorPlataforma {
	private 
		Map<String,Plataforma> Plataformas;
	public 
		ManejadorPlataforma(Map<String,Plataforma> Plats){
			super();
			Plataformas = Plats;
		}

		Map<String, Plataforma> getPlataformas() {
			return Plataformas;
		}

		void setPlataformas(Map<String, Plataforma> plataformas) {
			Plataformas = plataformas;
		}
		
		void AltaPlataforma(String nombre, String Descripcion,String Url) {
			if(!ExistePlataforma(nombre)) {
				Plataforma plat = new Plataforma(nombre,Descripcion,Url);
				Plataformas.put(nombre, plat);
			}
		}
		
		Boolean ExistePlataforma(String nombre){
			return Plataformas.containsKey(nombre);
		}
		Set<DtEspectaculo>  listarEspectaculosDePlataforma(String Nombre){
			set<DtEspectaculo> dtesp = new Set<DtEspectaculo>();
			return dtesp;
		}
		
		Set<DtFuncion> listarFuncionesDeEspectaculo(String NombrePlat, String NombreEsp){
			set<DtFuncion> dtfun = new Set<DtFuncion>();
			return dtfun;
		}
		
		DtFuncionDatos MostrarFuncion(String NombrePlat, String NombreEsp) {
			return new DtFuncionDatos;
		}
		
		DtEspectaculoDatos listarDtEspectaculoDatos(String NombreEspectaculo, String NombrePlataforma ) {
			return new DtEspectaculoDatos;
		}
		
		Set<DtPlataforma> listarPlataformas() {
			Set<DtPlataforma> plats = new HashSet<DtPlataforma>();
			return plats;
		}
		
		Set<DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp, string nombrePlat) {
			return new HashSet<DtFuncion>();
		}
		
		Plataforma getPlataforma(String nomPlataforma) {
			return new Plataforma();
		}
		
		Funcion getFuncion(String nombrePlataforma, String nombreEspectaculo, String nomFuncion) {
			return new Funcion();
		}
		
}
		
		

		
		
		
}
