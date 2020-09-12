package Clases;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Manejadores.ManejadorPaquetes;

import javax.swing.JOptionPane;

import DataTypes.DtEspectaculo;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtFuncion;
import DataTypes.DtFuncionDatos;
import DataTypes.DtPlataforma;
import DataTypes.DtEspectaculo;
import Controladores.Fabrica;
import Interfaces.IUsuario;

public class Plataforma {
	private String Nombre;
	private String Descripcion;
	private String Url;
	private HashMap<String,Espectaculo> Espectaculos;

		public Plataforma(String nombre, String descripcion, String Url) {
			super();
			Nombre = nombre;
			Descripcion = descripcion;
			Espectaculos = new HashMap<String,Espectaculo>();
		}
		public Set<DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp){
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
		public void setEspectaculos(HashMap<String, Espectaculo> espectaculos) {
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
			Fabrica fabric = Fabrica.getInstancia();
			IUsuario iusuario = fabric.getIUsuario();
			Espectaculos.put(nomEspectaculo, nuevo);
			iusuario.RelacionarArtistaEspectaculo(nickArtista,nuevo);
		}
		public DtEspectaculoDatos getDtEspectaculoDatos(String NombreEspectaculo) {
			Espectaculo esp = Espectaculos.get(NombreEspectaculo);
			return esp.getDtEspectaculoDatos();
		}
		

		public Boolean ExisteEspectaculo(String nomEspectaculo) {
			return Espectaculos.containsKey(nomEspectaculo);
		}
		public Set<DtEspectaculo> listarEspectaculosEnPlataformaNoPaquete(String NombrePaquete){
			
			ManejadorPaquetes manpaq = Manejadores.ManejadorPaquetes.getInstancia();
			Paquete p = manpaq.getPaquete(NombrePaquete);
			
			Set<DtEspectaculo> set = new HashSet<DtEspectaculo>();
			for (Map.Entry<String,Espectaculo> entry : Espectaculos.entrySet()) {
				DtEspectaculo nuevo = entry.getValue().getDatosEspectaculo();
				if (!p.tieneEspectaculo(entry.getValue().getNombre())) set.add(nuevo);
				
			}
			return set;
		}
		public Espectaculo getEspectaculo(String NombreEspectaculo) {
			return Espectaculos.get(NombreEspectaculo);
		}
		
		public Set<DtEspectaculoDatos> listarEspectaculoDatos(){
			Set<DtEspectaculoDatos> ret = new HashSet<DtEspectaculoDatos>();		
			for (Map.Entry<String, Espectaculo> entry : Espectaculos.entrySet()) {
				DtEspectaculoDatos nueva = entry.getValue().getDtEspectaculoDatos();
				ret.add(nueva);            
			}
			return ret;
		}
}
		

 


