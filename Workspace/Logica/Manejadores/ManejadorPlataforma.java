package Manejadores;
import Clases.Plataforma;
import Clases.Funcion;
import java.util.*;
import DataTypes.*;

public class ManejadorPlataforma {
	private 
		static ManejadorPlataforma instancia;
		Map<String,Plataforma> Plataformas;
	public 
		static ManejadorPlataforma getInstancia() {
			if(instancia==null)
				instancia=new ManejadorPlataforma();
			return instancia;
				
		}
	
		public ManejadorPlataforma() {
			super();
		}

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
		
		public void AltaPlataforma(String nombre, String Descripcion,String Url) {
			if(!ExistePlataforma(nombre)) {
				Plataforma plat = new Plataforma(nombre,Descripcion,Url);
				Plataformas.put(nombre, plat);
			}
		}
		
		Boolean ExistePlataforma(String nombre){
			return Plataformas.containsKey(nombre);
		}
		Set<DtEspectaculo>  listarEspectaculosDePlataforma(String Nombre){
			Set<DtEspectaculo> dtesp = new HashSet<DtEspectaculo>();
			return dtesp;
		}
		
		Set<DtFuncion> listarFuncionesDeEspectaculo(String NombrePlat, String NombreEsp){
			Set<DtFuncion> dtfun = new HashSet<DtFuncion>();
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
			return Plataformas.get(nomPlataforma);
			
		}
		
		Funcion getFuncion(String nombrePlataforma, String nombreEspectaculo, String nomFuncion) {
			Plataforma plat = Plataformas.get(nombrePlataforma);
			return plat.getFuncion(nombreEspectaculo, nomFuncion);
		}
		
}
		
		

		
		
		
}
