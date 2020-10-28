package Clases;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import DataTypes.DtArtista;
import DataTypes.DtCategoria;
import DataTypes.DtEspectaculo;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtFuncion;
import DataTypes.DtFuncionDatos;
import DataTypes.DtPaquete;
import DataTypes.EstadoEspectaculo;
import Manejadores.ManejadorPlataforma;
import Manejadores.ManejadorPaquetes;


public class Espectaculo {
	private String Nombre;
	private Date Registro;
	private Integer Costo;
	private String URL;
	private Integer CantMax;
	private Integer CantMin;
	private Integer Duracion;
	private String Descripcion;
	private Artista Organizador;
	private String Imagen;
	private EstadoEspectaculo Estado;
	private Map<String, Funcion> Funciones;
	private HashSet<Categoria> Categorias;
	
	
	
		public Espectaculo(String nombre, Date registro, Integer costo, String uRL, Integer cantMax, Integer cantMin, Integer duracion, String descripcion, String imagen) {
			super();
			Nombre = nombre;
			Registro = registro;
			Costo = costo;
			URL = uRL; 
			CantMax = cantMax;
			CantMin = cantMin;
			Duracion = duracion;
			Descripcion = descripcion;
			Imagen = imagen;
			Funciones = new HashMap<String,Funcion>();
			Estado = EstadoEspectaculo.Ingresado;
			Categorias = new HashSet<Categoria>();
		}
		public String getNombre() {
			return Nombre;
		}
		public void setNombre(String nombre) {
			Nombre = nombre;
		}
		public Date getRegistro() {
			return Registro;
		}
		public void setRegistro(Date registro) {
			Registro = registro;
		}
		public Integer getCosto() {
			return Costo;
		}
		
		public void setCosto(Integer costo) {
			Costo = costo;
		}
		public String getURL() {
			return URL;
		}
		public void setURL(String uRL) {
			URL = uRL;
		}
		public Integer getCantMax() {
			return CantMax;
		}
		public void setCantMax(Integer cantMax) {
			CantMax = cantMax;
		}
		public Integer getCantMin() {
			return CantMin;
		}
		
		
		public EstadoEspectaculo getEstado() {
			return Estado;
		}
		public void setEstado(EstadoEspectaculo estado) {
			Estado = estado;
		}
		public String getImagen() {
			return Imagen;
		}
		public void setImagen(String imagen) {
			Imagen = imagen;
		}

		public Set<Categoria> getCategorias() {
			return Categorias;
		}
		public void setCategorias(HashSet<Categoria> categorias) {
			Categorias = categorias;
		}
		public Artista getOrganizador() {
			return Organizador;
		}
		public void setOrganizador(Artista organizador) {
			Organizador = organizador;
		}
		public Map<String, Funcion> getFunciones() {
			return Funciones;
		}
		public void setFunciones(Map<String, Funcion> funciones) {
			Funciones = funciones;
		}
		public Set<DtFuncion> getFuncionesVigentes(){
			Set<DtFuncion> ret = new HashSet<DtFuncion>();
			for (Map.Entry<String,Funcion> entry : Funciones.entrySet()) {
				if(entry.getValue().estaVigente()) {
					DtFuncion nueva = entry.getValue().getDtFuncion();
					ret.add(nueva);  
				}				
			}
			return ret;
		}
		 
		
		
		public void setCantMin(Integer cantMin) {
			CantMin = cantMin;
		}
		public Integer getDuracion() {
			return Duracion;
		}
		public void setDuracion(Integer duracion) {
			Duracion = duracion;
		}
		public String getDescripcion() {
			return Descripcion;
		}
		public void setDescripcion(String descripcion) {
			Descripcion = descripcion;
		}
		public Funcion getFuncion(String nomFuncion) {
			return Funciones.get(nomFuncion);
		}
		public DtEspectaculo getDatosEspectaculo() {
			DtEspectaculo dte = new DtEspectaculo(Nombre, Descripcion);
			return dte;
		}
		public DtFuncionDatos getDtFuncionDatos(String nombreFuncion){
			return Funciones.get(nombreFuncion).getDtFuncionDatos(this.getDatosEspectaculo());
		}
		
		
		public DtFuncionDatos mostrarFuncion(String NombreFun) {
			Funcion fun = Funciones.get(NombreFun);
			DtFuncionDatos dtfun = new DtFuncionDatos();
			return dtfun;
		}
		public DtEspectaculoDatos getDtEspectaculoDatos() {
			ManejadorPaquetes manpaq = Manejadores.ManejadorPaquetes.getInstancia();
			Set<DtPaquete> listaPaquetes = manpaq.listarPaquetesEspectaculo(Nombre);
			HashSet<DtCategoria> listacategorias = listarCategorias();
			DtEspectaculoDatos ret = new DtEspectaculoDatos(Nombre, Descripcion, Duracion, CantMin, CantMax, URL, Costo.floatValue(), Registro, this.listarFunciones() , listaPaquetes, Organizador.getDtArtista(),Imagen,listacategorias); 
			return ret;
		
		}
		public void AnadirFuncion(String nombre, Date inicio, Date alta, String imagen) {
			Funcion ret = new Funcion(nombre, inicio, alta, imagen);
			Funciones.put(nombre, ret);
		}
		public Funcion ObtenerFuncion(String nombre) {
			return Funciones.get(nombre);
		}
		
		public boolean existeFuncion(String nombreFuncion) {
			for (Map.Entry<String,Funcion> entry : Funciones.entrySet()) {
	            if(entry.getValue().getNombre().equalsIgnoreCase(nombreFuncion)) {
	            	return true;
	            }           
			}
			return false;	
		}
		public DtFuncionDatos getFuncionDatos(String nombreFuncion) {
			Funcion fun = Funciones.get(nombreFuncion);
			DtEspectaculo datosEsp = new DtEspectaculo(Nombre, Descripcion);
			return fun.getDtFuncionDatos(datosEsp);
		}
		
		public Boolean PuedeAgregarEspectadores(String nombreFuncion){
			Funcion fun = Funciones.get(nombreFuncion);
			Integer espec = fun.getEspectadores();
			return (espec<CantMax);
		}
		
		public void AnadirCategoria(Categoria c) {
			Categorias.add(c);
		}
		
		public HashSet<DtCategoria> listarCategorias() {
			HashSet<DtCategoria> ret = new HashSet<DtCategoria>();
			Iterator<Categoria> iter = Categorias.iterator();
			while(iter.hasNext()) {
				DtCategoria nueva = iter.next().getDtCategoria();
				ret.add(nueva);
			}
			return ret;
		}
		
		public Set<DtFuncion> listarFunciones(){
			HashSet<DtFuncion> ret = new HashSet<DtFuncion>();
			if ( Funciones != null) {
				for(Map.Entry<String, Funcion> entry : Funciones.entrySet()) {
					DtFuncion nueva = entry.getValue().getDtFuncion();
					ret.add(nueva);
				}
			}
			return ret;
		}
}


