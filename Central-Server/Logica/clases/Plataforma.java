package clases;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import controladores.Fabrica;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoDatos;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import datatypes.DtPlataforma;
import datatypes.EstadoEspectaculo;
import interfaces.ICategoria;
import interfaces.IUsuario;
import manejadores.ManejadorPaquetes;

import clases.Categoria;
import clases.Espectaculo;
import clases.Funcion;
import clases.Paquete;

public class Plataforma {
	private String nombre;
	private String descripcion;
	private String url;
	private Map<String, Espectaculo> espectaculos;

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
		
		public void filtrarEspectaculos(Set<DtEspectaculoDatos> especs, String search) {
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
				DtEspectaculoDatos espec = entry.getValue().getDtEspectaculoDatos();
				if (espec.getNombre().toLowerCase().contains(search.toLowerCase()) && entry.getValue().getEstado() == EstadoEspectaculo.Aceptado)
					especs.add(espec);
			}
		}
		
		public Boolean espectaculoinPlataforma(String nombreEspectaculo) {
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
		public void setEspectaculos(Map<String, Espectaculo> espectaculos) {
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
		
		public void altaEspectaculo(String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, 
				Integer costo, Date fecha, Integer duracion, String imagen, Set<String> categorias,  String urlVideo, String premio, int cantPremios) {
			Fabrica fabric = controladores.Fabrica.getInstancia();
			ICategoria icat = fabric.getICategoria();
			IUsuario iusuario = fabric.getIUsuario();
			Espectaculo nuevo = new Espectaculo(nomEspectaculo, fecha, costo, url , maxEsp, minEsp, duracion, descripcion, imagen,  urlVideo, premio, cantPremios);
			nuevo.setEstado(EstadoEspectaculo.Ingresado);
			if (categorias.size()>0) {
			Iterator<String> itercat = categorias.iterator();
			while (itercat.hasNext()) {
				Categoria aux = icat.getCategoria(itercat.next());
				nuevo.anadirCategoria(aux);
				aux.anadirEspectaculo(nuevo);
			}
			}
			espectaculos.put(nomEspectaculo, nuevo);
			iusuario.relacionarArtistaEspectaculo(nickArtista, nuevo);
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

		public Boolean existeEspectaculo(String nomEspectaculo) {
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
	            if (entry.getValue().getNombre().equalsIgnoreCase(nomEspectaculo)) {
	            	return true;
	            }           
			}
			return false;
		}
		public Set<DtEspectaculo> listarEspectaculosEnPlataformaNoPaquete(String NombrePaquete){
			
			ManejadorPaquetes manpaq = manejadores.ManejadorPaquetes.getInstancia();
			Paquete paq = manpaq.getPaquete(NombrePaquete);
			
			Set<DtEspectaculo> set = new HashSet<DtEspectaculo>();
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
				DtEspectaculo nuevo = entry.getValue().getDatosEspectaculo();
				if (!paq.tieneEspectaculo(entry.getValue().getNombre())) set.add(nuevo);
				
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
		
		public DtEspectaculo existeEspectaculoDeFuncion(String nombreFuncion){
			DtEspectaculo ret = null;
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
				if (entry.getValue().existeFuncion(nombreFuncion)) {
					ret = entry.getValue().getDatosEspectaculo();
					break;
				}           
			}
			return ret;
		}
		
		public Boolean puedeAgregarEspectadores(String nombreEspectaculo, String nombreFuncion){
			Espectaculo espec = espectaculos.get(nombreEspectaculo);
			return espec.puedeAgregarEspectadores(nombreFuncion);
		}
		
		public Set<DtCategoria> listarCategoriasDeEspectaculo(String Espectaculo) {
			Espectaculo espec = espectaculos.get(Espectaculo);
			return espec.listarCategorias();
		}
		
		public DtFuncion getDtFuncion(String nombreFuncion) {
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
				if(entry.getValue().getDtFuncion(nombreFuncion) != null)
					return entry.getValue().getDtFuncion(nombreFuncion);
			}
			return null;
		}
		
		public void setearPremios(String esp, String fun, String nick, Date fecha) {
			Espectaculo espe = espectaculos.get(esp);
			espe.setearPremios(fun, nick, fecha);
		}
		
		
}
		

 


