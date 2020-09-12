package Clases;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

import DataTypes.DtArtista;
import DataTypes.DtEspectaculo;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtFuncion;
import DataTypes.DtFuncionDatos;
import DataTypes.DtPaquete;
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
	private Map<String, Funcion> Funciones;
	
	
	
		public Espectaculo(String nombre, Date registro, Integer costo, String uRL, Integer cantMax, Integer cantMin, Integer duracion, String descripcion) {
			super();
			Nombre = nombre;
			Registro = registro;
			Costo = costo;
			URL = uRL; 
			CantMax = cantMax;
			CantMin = cantMin;
			Duracion = duracion;
			Descripcion = descripcion;
			Funciones = new HashMap<String,Funcion>();
		
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
			System.out.print("loco va bien");
			for (Map.Entry<String,Funcion> entry : Funciones.entrySet()) {
				System.out.print("se mete al for");
				if(entry.getValue().estaVigente()) {
					System.out.print("se mete al if");
					DtFuncion nueva = entry.getValue().getDtFuncion();
					ret.add(nueva);  
				}				
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
		public DtFuncionDatos mostrarFuncion(String NombreFun) {
			Funcion fun = Funciones.get(NombreFun);
			DtFuncionDatos dtfun = new DtFuncionDatos();
			return dtfun;
		}
		public DtEspectaculoDatos getDtEspectaculoDatos() {
			ManejadorPaquetes manpaq = Manejadores.ManejadorPaquetes.getInstancia();
			Set<DtPaquete> listaPaquetes = manpaq.listarPaquetesEspectaculo(Nombre);
			DtEspectaculoDatos ret = new DtEspectaculoDatos(Nombre, Descripcion, Duracion, CantMin, CantMax, URL, Costo.floatValue(), Registro, this.listarFunciones() , listaPaquetes); 
			return ret;
		
		}
		public void AnadirFuncion(String nombre, Date inicio, Date alta) {
			Funcion ret = new Funcion(nombre, inicio, alta);
			Funciones.put(nombre, ret);
		}
		public Funcion ObtenerFuncion(String nombre) {
			return Funciones.get(nombre);
		}
		
		public boolean existeFuncion(String nombreFuncion) {
			return Funciones.containsKey(nombreFuncion);	
		}
		
		
}


