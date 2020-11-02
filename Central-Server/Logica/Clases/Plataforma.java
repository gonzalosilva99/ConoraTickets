package Clases;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Manejadores.ManejadorPaquetes;

import javax.swing.JOptionPane;

import DataTypes.DtCategoria;
import DataTypes.DtEspectaculo;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtFuncion;
import DataTypes.DtFuncionDatos;
import DataTypes.DtPlataforma;
import DataTypes.EstadoEspectaculo;
import DataTypes.DtEspectaculo;
import Controladores.Fabrica;
import Interfaces.IUsuario;
import Interfaces.ICategoria;

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
			Set<DtFuncion> ret = new HashSet<DtFuncion>();
			Espectaculo espec = Espectaculos.get(nombreEsp);
			if(espec != null)
				return espec.getFuncionesVigentes();
			else return ret;
		}
		public String getUrl() {
			return Url;
		}
		
		public void filtrarEspectaculos(HashSet<DtEspectaculoDatos> especs, String search) {
			for (Map.Entry<String, Espectaculo> entry : Espectaculos.entrySet()) {
				DtEspectaculoDatos espec = entry.getValue().getDtEspectaculoDatos();
				if(espec.getNombre().toLowerCase().contains(search.toLowerCase()))
					especs.add(espec);
			}
		}
		
		public Boolean EspectaculoinPlataforma(String nombreEspectaculo) {
			for (Map.Entry<String, Espectaculo> entry : Espectaculos.entrySet()) {
				if(entry.getValue().getNombre().equalsIgnoreCase(nombreEspectaculo))
					return true;
			}
			return false;
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
		
		public Set<DtEspectaculo> listarEspectaculosAceptadosDePlataforma(){
			Set<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
			for (Map.Entry<String,Espectaculo> entry : Espectaculos.entrySet()) {
					if(entry.getValue().getEstado()==EstadoEspectaculo.Aceptado) {
					DtEspectaculo nuevo = entry.getValue().getDatosEspectaculo();
					ret.add(nuevo);
					}
			}
			return ret;
		}
		
		public Set<DtEspectaculo> listarEspectaculosIngresadosDePlataforma(){
			Set<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
			for (Map.Entry<String,Espectaculo> entry : Espectaculos.entrySet()) {
				if(entry.getValue().getEstado().toString().equals("Ingresado")) {
					DtEspectaculo nuevo = entry.getValue().getDatosEspectaculo();
					ret.add(nuevo);
			}
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
		
		public void altaEspectaculo(String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion, String imagen, Set<String> categorias) {
			Fabrica fabric = Controladores.Fabrica.getInstancia();
			ICategoria icat = fabric.getICategoria();
			IUsuario iusuario = fabric.getIUsuario();
			Espectaculo nuevo = new Espectaculo(nomEspectaculo, fecha, costo, url , maxEsp, minEsp, duracion, descripcion, imagen);
			nuevo.setEstado(EstadoEspectaculo.Ingresado);
			if(categorias.size()>0) {
			Iterator<String> itercat = categorias.iterator();
			while(itercat.hasNext()) {
				Categoria aux = icat.getCategoria(itercat.next());
				nuevo.AnadirCategoria(aux);
				aux.anadirEspectaculo(nuevo);
			}
			}
			Espectaculos.put(nomEspectaculo, nuevo);
			iusuario.RelacionarArtistaEspectaculo(nickArtista,nuevo);
		}
		public DtEspectaculoDatos getDtEspectaculoDatos(String NombreEspectaculo) {
			Espectaculo esp = Espectaculos.get(NombreEspectaculo);
			return esp.getDtEspectaculoDatos();
		}
		public Boolean existeFuncion(String nombreFuncion) {
			boolean ret = false;
			for(Map.Entry<String, Espectaculo> entry : Espectaculos.entrySet()) {
				ret = entry.getValue().existeFuncion(nombreFuncion);
				if(ret){
					return ret;
				}
			}
			return ret;
		}

		public Boolean ExisteEspectaculo(String nomEspectaculo) {
			for (Map.Entry<String,Espectaculo> entry : Espectaculos.entrySet()) {
	            if(entry.getValue().getNombre().equalsIgnoreCase(nomEspectaculo)) {
	            	return true;
	            }           
			}
			return false;
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
		public DtFuncionDatos getFuncionDatos(String nombreEspectaculo, String nombreFuncion) {
			
			return Espectaculos.get(nombreEspectaculo).getFuncionDatos(nombreFuncion);
		}
		
		public String ExisteEspectaculoDeFuncion(String nombreFuncion){
			String ret = "";
			for (Map.Entry<String, Espectaculo> entry : Espectaculos.entrySet()) {
				if(entry.getValue().existeFuncion(nombreFuncion)) {
					ret = entry.getValue().getNombre();
					break;
				}           
			}
			return ret;
		}
		
		public Boolean PuedeAgregarEspectadores(String nombreEspectaculo,String nombreFuncion){
			Espectaculo espec = Espectaculos.get(nombreEspectaculo);
			return espec.PuedeAgregarEspectadores(nombreFuncion);
		}
		
		public HashSet<DtCategoria> ListarCategoriasDeEspectaculo(String Espectaculo) {
			Espectaculo espec = Espectaculos.get(Espectaculo);
			return espec.listarCategorias();
		}
		
		
}
		

 


