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
	private String nombre;
	private String descripcion;
	private String url;
	private HashMap<String, Espectaculo> espectaculos;

		public Plataforma(String nombre, String descripcion, String url) {
			super();
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.espectaculos = new HashMap<String, Espectaculo>();
		}
		public Set<DtFuncion> listarFuncionesVigentesEspectaculo(String nombreEsp){
			Set<DtFuncion> ret = new HashSet<DtFuncion>();
			Espectaculo espec = espectaculos.get(nombreEsp);
			if (espec != null)
				return espec.getFuncionesVigentes();
			else return ret;
		}
		public String getUrl() {
			return url;
		}
		
		public void filtrarEspectaculos(HashSet<DtEspectaculoDatos> especs, String search) {
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
				DtEspectaculoDatos espec = entry.getValue().getDtEspectaculoDatos();
				if (espec.getNombre().toLowerCase().contains(search.toLowerCase()))
					especs.add(espec);
			}
		}
		
		public Boolean EspectaculoinPlataforma(String nombreEspectaculo) {
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
				if (entry.getValue().getNombre().equalsIgnoreCase(nombreEspectaculo))
					return true;
			}
			return false;
		}
			
		
		public void setUrl(String url) {
			this.url = url;
		}
		public Map<String, Espectaculo> getEspectaculos() {
			return espectaculos;
		}
		public void setEspectaculos(HashMap<String, Espectaculo> espectaculos) {
			this.espectaculos = espectaculos;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public Funcion getFuncion(String nombreEspectaculo, String nomFuncion) {
			Espectaculo esp = espectaculos.get(nombreEspectaculo);
			return esp.getFuncion(nomFuncion);
		}
		public DtFuncionDatos mostrarFuncion(String NombreEsp, String NombreFun) {
			Espectaculo esp = espectaculos.get(NombreEsp);
			return esp.mostrarFuncion(NombreFun);
		}
		public DtPlataforma getDtPlataforma() {
			DtPlataforma dtplat = new DtPlataforma(nombre, descripcion, url);
			return dtplat;
		}
		
		public Set<DtEspectaculo> listarEspectaculosDePlataforma(){
			Set<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
					DtEspectaculo nuevo = entry.getValue().getDatosEspectaculo();
					ret.add(nuevo);
			}
			return ret;
		}
		
		public Set<DtEspectaculo> listarEspectaculosAceptadosDePlataforma(){
			Set<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
					if (entry.getValue().getEstado()==EstadoEspectaculo.Aceptado) {
					DtEspectaculo nuevo = entry.getValue().getDatosEspectaculo();
					ret.add(nuevo);
					}
			}
			return ret;
		}
		
		public Set<DtEspectaculo> listarEspectaculosIngresadosDePlataforma(){
			Set<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
				if (entry.getValue().getEstado().toString().equals("Ingresado")) {
					DtEspectaculo nuevo = entry.getValue().getDatosEspectaculo();
					ret.add(nuevo);
			}
			}
			return ret;
		}

		public Set<DtEspectaculo> listarEspectaculos(){
		Set<DtEspectaculo> ret = new HashSet<DtEspectaculo>();		
		for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
			DtEspectaculo nueva = entry.getValue().getDatosEspectaculo();
			ret.add(nueva);            
		}
		return ret;
		}	
		public Set<DtFuncion> listarFuncionesDeEspectaculo(String NombreEsp){
			Espectaculo espec = espectaculos.get(NombreEsp);
			return espec.listarFunciones();
		}
		
		public void altaEspectaculo(String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion, String imagen, Set<String> categorias) {
			Fabrica fabric = Controladores.Fabrica.getInstancia();
			ICategoria icat = fabric.getICategoria();
			IUsuario iusuario = fabric.getIUsuario();
			Espectaculo nuevo = new Espectaculo(nomEspectaculo, fecha, costo, url , maxEsp, minEsp, duracion, descripcion, imagen);
			nuevo.setEstado(EstadoEspectaculo.Ingresado);
			if (categorias.size()>0) {
			Iterator<String> itercat = categorias.iterator();
			while (itercat.hasNext()) {
				Categoria aux = icat.getCategoria(itercat.next());
				nuevo.AnadirCategoria(aux);
				aux.anadirEspectaculo(nuevo);
			}
			}
			espectaculos.put(nomEspectaculo, nuevo);
			iusuario.RelacionarArtistaEspectaculo(nickArtista, nuevo);
		}
		public DtEspectaculoDatos getDtEspectaculoDatos(String NombreEspectaculo) {
			Espectaculo esp = espectaculos.get(NombreEspectaculo);
			return esp.getDtEspectaculoDatos();
		}
		public Boolean existeFuncion(String nombreFuncion) {
			boolean ret = false;
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
				ret = entry.getValue().existeFuncion(nombreFuncion);
				if (ret){
					return ret;
				}
			}
			return ret;
		}

		public Boolean ExisteEspectaculo(String nomEspectaculo) {
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
	            if (entry.getValue().getNombre().equalsIgnoreCase(nomEspectaculo)) {
	            	return true;
	            }           
			}
			return false;
		}
		public Set<DtEspectaculo> listarEspectaculosEnPlataformaNoPaquete(String NombrePaquete){
			
			ManejadorPaquetes manpaq = Manejadores.ManejadorPaquetes.getInstancia();
			Paquete p = manpaq.getPaquete(NombrePaquete);
			
			Set<DtEspectaculo> set = new HashSet<DtEspectaculo>();
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
				DtEspectaculo nuevo = entry.getValue().getDatosEspectaculo();
				if (!p.tieneEspectaculo(entry.getValue().getNombre())) set.add(nuevo);
				
			}
			return set;
		}
		public Espectaculo getEspectaculo(String NombreEspectaculo) {
			return espectaculos.get(NombreEspectaculo);
		}
		
		public Set<DtEspectaculoDatos> listarEspectaculoDatos(){
			Set<DtEspectaculoDatos> ret = new HashSet<DtEspectaculoDatos>();		
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
				DtEspectaculoDatos nueva = entry.getValue().getDtEspectaculoDatos();
				ret.add(nueva);            
			}
			return ret;
		}
		public DtFuncionDatos getFuncionDatos(String nombreEspectaculo, String nombreFuncion) {
			
			return espectaculos.get(nombreEspectaculo).getFuncionDatos(nombreFuncion);
		}
		
		public String ExisteEspectaculoDeFuncion(String nombreFuncion){
			String ret = "";
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
				if (entry.getValue().existeFuncion(nombreFuncion)) {
					ret = entry.getValue().getNombre();
					break;
				}           
			}
			return ret;
		}
		
		public Boolean PuedeAgregarEspectadores(String nombreEspectaculo, String nombreFuncion){
			Espectaculo espec = espectaculos.get(nombreEspectaculo);
			return espec.PuedeAgregarEspectadores(nombreFuncion);
		}
		
		public HashSet<DtCategoria> ListarCategoriasDeEspectaculo(String Espectaculo) {
			Espectaculo espec = espectaculos.get(Espectaculo);
			return espec.listarCategorias();
		}
		
		
}
		

 


