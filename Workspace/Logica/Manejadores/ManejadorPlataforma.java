package Manejadores;
import Clases.Plataforma;
import Clases.Artista;
import Clases.Espectaculo;
import Clases.Espectador;
import Clases.Funcion;
import java.util.*;

import javax.swing.JOptionPane;

import DataTypes.*;

public class ManejadorPlataforma {
	private 
		static ManejadorPlataforma instancia;
		HashMap<String,Plataforma> Plataformas;
	public 
		static ManejadorPlataforma getInstancia() {
			if(instancia==null)
				instancia=new ManejadorPlataforma();
			return instancia;
				
		}
	
		private ManejadorPlataforma() {
			Plataformas = new HashMap<String,Plataforma>();
		}

		ManejadorPlataforma(HashMap<String,Plataforma> Plats){
			super();
			Plataformas = Plats;
		}

		Map<String, Plataforma> getPlataformas() {
			return Plataformas;
		}

		void setPlataformas(HashMap<String, Plataforma> plataformas) {
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
			Plataforma plat = Plataformas.get(Nombre);
			return plat.listarEspectaculosDePlataforma();
		}
		
		
		Set<DtFuncion> listarFuncionesDeEspectaculo(String NombrePlat, String NombreEsp){
			Plataforma plat = Plataformas.get(NombrePlat);
			return plat.listarFuncionesDeEspectaculo(NombreEsp);
		}
		
		DtFuncionDatos MostrarFuncion(String NombrePlat, String NombreEsp, String NombreFun) {
			Plataforma plat = Plataformas.get(NombrePlat);
			return plat.mostrarFuncion(NombreEsp, NombreFun);
		}
		
		DtEspectaculoDatos listarDtEspectaculoDatos(String NombreEspectaculo, String NombrePlataforma ) {
			return new DtEspectaculoDatos();
		}
				
		public Map<String,DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp, String nombrePlat) {
			Plataforma plat = Plataformas.get(nombrePlat);
			return plat.listarFuncionesVigentesEspectaculo(nombreEsp);
		}
		
		Plataforma getPlataforma(String nomPlataforma) {
			return Plataformas.get(nomPlataforma);
			
		}
		
		Funcion getFuncion(String nombrePlataforma, String nombreEspectaculo, String nomFuncion) {
			Plataforma plat = Plataformas.get(nombrePlataforma);
			return plat.getFuncion(nombreEspectaculo, nomFuncion);
		}
		public Set<DtPlataforma> listarPlataformas() {
			Set<DtPlataforma> ret = new HashSet<DtPlataforma>();		
			for (Map.Entry<String, Plataforma> entry : Plataformas.entrySet()) {
				JOptionPane.showMessageDialog(null, "ok");
	            DtPlataforma nueva = entry.getValue().getDtPlataforma();
	            ret.add(nueva);            
			}
			return ret;
		}
		public Set<DtEspectaculo> listarEspectaculos(String nombrePlataforma){
			Plataforma plat = Plataformas.get(nombrePlataforma);
			return plat.listarEspectaculos();
		}
		public void altaEspectaculo(String nomPlat, String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion) {
			Plataforma plat = Plataformas.get(nomPlat);
			plat.altaEspectaculo(nickArtista, nomEspectaculo, descripcion, minEsp, maxEsp, url, costo, fecha, duracion);
		}
}
		

		

		
		
		



