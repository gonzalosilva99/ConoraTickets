package Clases;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import DataTypes.DtEspectaculo;
import DataTypes.DtFuncion;
import DataTypes.DtFuncionDatos;
import DataTypes.DtPlataforma;
import DataTypes.DtEspectaculo;
public class Plataforma {
	private String Nombre;
	private String Descripcion;
	private String Url;
	private Map<String,Espectaculo> Espectaculos;
		public Plataforma(String nombre, String descripcion, String Url) {
			super();
			Nombre = nombre;
			Descripcion = descripcion;
			Espectaculos = new HashMap<String,Espectaculo>();
		}
		public Map<String,DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp){
			Espectaculo espec = Espectaculos.get(nombreEsp);
			return espec.getFuncionesVigentes();
		}
		public String getUrl() {
			return Url;
		}
		public void setUrl(String url) {
			Url = url;
		}
		public Map<String, Espectaculo> getEspectaculos() {
			return Espectaculos;
		}
		public void setEspectaculos(Map<String, Espectaculo> espectaculos) {
			Espectaculos = espectaculos;
		}
		public String getNombre() {
			return Nombre;
		}
		public void setNombre(String nombre) {
			Nombre = nombre;
		}
		public String getDescripcion() {
			return Descripcion;
		}
		public void setDescripcion(String descripcion) {
			Descripcion = descripcion;
		}
		public Funcion getFuncion(String nombreEspectaculo, String nomFuncion) {
			Espectaculo esp = Espectaculos.get(nombreEspectaculo);
			return esp.getFuncion(nomFuncion);
		}
		public DtFuncionDatos mostrarFuncion(String NombreEsp, String NombreFun) {
			Espectaculo esp = Espectaculos.get(NombreEsp);
			return esp.mostrarFuncion(NombreFun);
		}
		public DtPlataforma getDtPlataforma() {
			DtPlataforma dtplat = new DtPlataforma(Nombre, Descripcion, Url);
			return dtplat;
		}
		
		public Set<DtEspectaculo> listarEspectaculosDePlataforma(){
			Set<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
			for (Map.Entry<String,Espectaculo> entry : Espectaculos.entrySet()) {
					DtEspectaculo nuevo = entry.getValue().getDatosEspectaculo();
					ret.add(nuevo);
			}
			return ret;
		}

		public Set<DtEspectaculo> listarEspectaculos(){
		Set<DtEspectaculo> ret = new HashSet<DtEspectaculo>();		
		for (Map.Entry<String, Espectaculo> entry : Espectaculos.entrySet()) {
			JOptionPane.showMessageDialog(null, "ok");
			DtEspectaculo nueva = entry.getValue().getDatosEspectaculo();
			ret.add(nueva);            
		}
		return ret;
		}	
		public Set<DtFuncion> listarFuncionesDeEspectaculo(String NombreEsp){
			Espectaculo espec = Espectaculos.get(NombreEsp);
			return espec.listarFunciones();
		}
		
		public void altaEspectaculo(String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion) {
			Espectaculo nuevo = new Espectaculo(nomEspectaculo, fecha, costo, url , maxEsp, minEsp, duracion, descripcion);
			Espectaculos.put(nomEspectaculo, nuevo);
		}
}
		

 


