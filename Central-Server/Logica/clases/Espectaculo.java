package clases;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import clases.Artista;
import clases.Categoria;
import clases.Funcion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import datatypes.DtArtista;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoDatos;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import datatypes.DtPaquete;
import datatypes.EstadoEspectaculo;
import manejadores.ManejadorPaquetes;
import manejadores.ManejadorPlataforma;


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
	private HashSet<Categoria> categorias;
	
	
	
		public Espectaculo(String nombre, Date registro, Integer costo, String url, Integer cantmax, Integer cantmin, Integer duracion, String descripcion, String imagen) {
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
		public void setCategorias(HashSet<Categoria> categorias) {
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
			DtEspectaculo dte = new DtEspectaculo(nombre, descripcion, imagen, estado, costo);
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
			ManejadorPaquetes manpaq = manejadores.ManejadorPaquetes.getInstancia();
			Set<DtPaquete> listaPaquetes = manpaq.listarPaquetesEspectaculo(nombre);
			HashSet<DtCategoria> listacategorias = listarCategorias();
			DtEspectaculo esp = new DtEspectaculo(this.nombre, this.descripcion, imagen, this.estado, this.costo);
			DtEspectaculoDatos ret = new DtEspectaculoDatos(nombre, descripcion, duracion, cantmin, cantmax, url, costo.floatValue(), registro, this.listarFuncionesDatos(esp) , listaPaquetes, organizador.getDtArtista(), imagen, listacategorias); 
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
		public DtFuncionDatos getFuncionDatos(String nombreFuncion) {
			Funcion fun = funciones.get(nombreFuncion);
			DtEspectaculo datosEsp = new DtEspectaculo(nombre, descripcion, imagen, estado, costo);
			return fun.getDtFuncionDatos(datosEsp);
		}
		
		public Boolean puedeAgregarEspectadores(String nombreFuncion){
			Funcion fun = funciones.get(nombreFuncion);
			Integer espec = fun.getEspectadores();
			return (espec<cantmax);
		}
		
		public void anadirCategoria(Categoria c) {
			categorias.add(c);
		}
		
		public HashSet<DtCategoria> listarCategorias() {
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
}


