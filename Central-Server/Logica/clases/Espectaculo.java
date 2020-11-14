package clases;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Date;

import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoDatos;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import datatypes.DtPaquete;
import datatypes.EstadoEspectaculo;
import manejadores.ManejadorPaquetes;
import relaciones.PuntajeAsignado;


public class Espectaculo {
	private String nombre;
	private Date registro;
	private Integer costo;
	private String url;
	private Integer cantmax;
	private Integer cantmin;
	private Integer duracion;
	private String descripcion;
	private Artista organizador;
	private String imagen;
	private EstadoEspectaculo estado;
	private Map<String, Funcion> funciones;
	private String urlVideo;
	private String premio;
	private int cantPremios;
	private Set<Categoria> categorias;
	private Set<PuntajeAsignado> puntajesAsignados;
	private int cantFavoritos;
	
	
	
	
		public Espectaculo(String nombre, Date registro, Integer costo, String url, Integer cantmax, 
				Integer cantmin, Integer duracion, String descripcion, String imagen, String urlVideo, String premio, int cantPremios) {
			super();
			this.nombre = nombre;
			this.registro = registro;
			this.costo = costo;
			this.url = url; 
			this.cantmax = cantmax;
			this.cantmin = cantmin;
			this.duracion = duracion;
			this.descripcion = descripcion;
			this.imagen = imagen;
			this.funciones = new HashMap<String, Funcion>();
			this.estado = EstadoEspectaculo.Ingresado;
			this.categorias = new HashSet<Categoria>();
			this.urlVideo = urlVideo;
			this.premio = premio;
			this.cantPremios = cantPremios;
			this.puntajesAsignados = new HashSet<>();
			this.cantFavoritos=0;
		}
		public String getUrlVideo() {
			return urlVideo;
		}
		public int getCantPremios() {
			return cantPremios;
		}
		public String getPremio() {
			return premio;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Date getRegistro() {
			return registro;
		}
		public void setRegistro(Date registro) {
			this.registro = registro;
		}
		public Integer getCosto() {
			return costo;
		}
		
		public void setCosto(Integer costo) {
			this.costo = costo;
		}
		public String getURL() {
			return url;
		}
		public void setURL(String url) {
			this.url = url;
		}
		public Integer getCantMax() {
			return cantmax;
		}
		public void setCantMax(Integer cantmax) {
			this.cantmax = cantmax;
		}
		public Integer getCantMin() {
			return cantmin;
		}
		
		
		public EstadoEspectaculo getEstado() {
			return estado;
		}
		public void setEstado(EstadoEspectaculo estado) {
			this.estado = estado;
		}
		public String getImagen() {
			return imagen;
		}
		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		public Set<Categoria> getCategorias() {
			return categorias;
		}
		public void setCategorias(Set<Categoria> categorias) {
			this.categorias = categorias;
		}
		public Artista getOrganizador() {
			return organizador;
		}
		public void setOrganizador(Artista organizador) {
			this.organizador = organizador;
		}
		public Map<String, Funcion> getFunciones() {
			return funciones;
		}
		public void setFunciones(Map<String, Funcion> funciones) {
			this.funciones = funciones;
		}
		public Set<DtFuncion> getFuncionesVigentes(){
			Set<DtFuncion> ret = new HashSet<DtFuncion>();
			for (Map.Entry<String, Funcion> entry : funciones.entrySet()) {
				if (entry.getValue().estaVigente()) {
					DtFuncion nueva = entry.getValue().getDtFuncion();
					ret.add(nueva);  
				}				
			}
			return ret;
		}
		 
		
		
		public void setCantMin(Integer cantmin) {
			this.cantmin = cantmin;
		}
		public Integer getDuracion() {
			return duracion;
		}
		public void setDuracion(Integer duracion) {
			this.duracion = duracion;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public Funcion getFuncion(String nomFuncion) {
			return funciones.get(nomFuncion);
		}
		public DtEspectaculo getDatosEspectaculo() {
			double puntajePromedio = obtenerPromedio();
			DtEspectaculo dte = new DtEspectaculo(nombre, descripcion, imagen, estado, costo, 
					urlVideo, premio, cantPremios, puntajePromedio, this.cantFavoritos, this.duracion);
			return dte;
		}
		public DtFuncionDatos getDtFuncionDatos(String nombreFuncion){
			return funciones.get(nombreFuncion).getDtFuncionDatos(this.getDatosEspectaculo());
		}
		
		
		public DtFuncionDatos mostrarFuncion(String NombreFun) {
			Funcion fun = funciones.get(NombreFun);
			DtFuncionDatos dtfun = new DtFuncionDatos();
			return dtfun;
		}
		public DtEspectaculoDatos getDtEspectaculoDatos() {
			double puntajePromedio = obtenerPromedio();
			ManejadorPaquetes manpaq = manejadores.ManejadorPaquetes.getInstancia();
			Set<DtPaquete> listaPaquetes = manpaq.listarPaquetesEspectaculo(nombre);
			Set<DtCategoria> listacategorias = listarCategorias();
			DtEspectaculo esp = new DtEspectaculo(this.nombre, this.descripcion, imagen, this.estado, this.costo, urlVideo, premio, cantPremios, puntajePromedio, this.cantFavoritos, this.duracion);
			DtEspectaculoDatos ret = new DtEspectaculoDatos(nombre, descripcion, duracion, 
					cantmin, cantmax, url, costo.floatValue(), registro, this.listarFuncionesDatos(esp) , 
					listaPaquetes, organizador.getDtArtista(), imagen, listacategorias, cantPremios, 
					puntajePromedio, urlVideo, premio, this.cantFavoritos); 
			return ret;
		
		}
		public void anadirFuncion(String nombre, Date inicio, Date alta, String imagen) {
			Funcion ret = new Funcion(nombre, inicio, alta, imagen);
			funciones.put(nombre, ret);
		}
		public Funcion obtenerFuncion(String nombre) {
			return funciones.get(nombre);
		}
		
		public boolean existeFuncion(String nombreFuncion) {
			for (Map.Entry<String, Funcion> entry : funciones.entrySet()) {
	            if (entry.getValue().getNombre().equalsIgnoreCase(nombreFuncion)) {
	            	return true;
	            }           
			}
			return false;	
		}
		private double obtenerPromedio() {
			int cantPuntajes = puntajesAsignados.size();
			if (cantPuntajes > 0) {
				int total = 0;
				for (PuntajeAsignado puntaje: puntajesAsignados) {
					total += puntaje.getPuntaje();
				}
				return total/ (double)cantPuntajes;	
			}else {
				return 0;
			}

		}
		public DtFuncionDatos getFuncionDatos(String nombreFuncion) {
			double puntajePromedio = obtenerPromedio();
			Funcion fun = funciones.get(nombreFuncion);
			DtEspectaculo datosEsp = new DtEspectaculo(nombre, descripcion, imagen, estado, costo, urlVideo, premio, cantPremios, puntajePromedio, this.cantFavoritos, this.duracion);
			return fun.getDtFuncionDatos(datosEsp);
		}
		
		public Boolean puedeAgregarEspectadores(String nombreFuncion){
			Funcion fun = funciones.get(nombreFuncion);
			Integer espec = fun.getEspectadores();
			return espec<cantmax;
		}
		
		public void anadirCategoria(Categoria cat) {
			categorias.add(cat);
		}
		
		public Set<DtCategoria> listarCategorias() {
			HashSet<DtCategoria> ret = new HashSet<DtCategoria>();
			Iterator<Categoria> iter = categorias.iterator();
			while (iter.hasNext()) {
				DtCategoria nueva = iter.next().getDtCategoria();
				ret.add(nueva);
			}
			return ret;
		}
		
		public Set<DtFuncionDatos> listarFuncionesDatos(DtEspectaculo esp){
			HashSet<DtFuncionDatos> ret = new HashSet<DtFuncionDatos>();
			if (funciones != null) {
				for (Map.Entry<String, Funcion> entry : funciones.entrySet()) {
					DtFuncionDatos nueva = entry.getValue().getDtFuncionDatos(esp);
					ret.add(nueva);
				}
			}
			return ret;
		}
		
		public Set<DtFuncion> listarFunciones(){
			HashSet<DtFuncion> ret = new HashSet<DtFuncion>();
			if (funciones != null) {
				for (Map.Entry<String, Funcion> entry : funciones.entrySet()) {
					DtFuncion nueva = entry.getValue().getDtFuncion();
					ret.add(nueva);
				}
			}
			return ret;
		}
		
		public DtFuncion getDtFuncion(String nombreFuncion) {
			for (Map.Entry<String, Funcion> entry : funciones.entrySet()) {
				if(entry.getValue().getDtFuncion().getNombre().equals(nombreFuncion))
					return entry.getValue().getDtFuncion();
			}
			return null;
		
		}

		public Set<PuntajeAsignado> getPuntajesAsignados() {
			return puntajesAsignados;
		}
		public void setPuntajesAsignados(Set<PuntajeAsignado> puntajesAsignados) {
			this.puntajesAsignados = puntajesAsignados;
		}
		public int getCantFavoritos() {
			return cantFavoritos;
		}
		public void setCantFavoritos(int cantFavoritos) {
			this.cantFavoritos = cantFavoritos;
		}
		public void setUrlVideo(String urlVideo) {
			this.urlVideo = urlVideo;
		}
		public void setPremio(String premio) {
			this.premio = premio;
		}
		public void setCantPremios(int cantPremios) {
			this.cantPremios = cantPremios;
		}
		
		public void aumentarFavoritos() {
			this.cantFavoritos++;
		}
		
		public void quitarFavoritos() {
			this.cantFavoritos--;
		}
		
		public void anadirPuntaje(PuntajeAsignado pun) {
			this.puntajesAsignados.add(pun);
		}
}


