package Clases;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

import DataTypes.DtArtista;
import DataTypes.DtEspectaculo;
import DataTypes.DtFuncionDatos;


public class Espectaculo {
	private String Nombre;
	private Date Registro;
	private Double Costo;
	private String URL;
	private Integer CantMax;
	private Integer CantMin;
	private Double Duracion;
	private String Descripcion;
	private Map<String, Funcion> Funciones;
		public Espectaculo(String nombre, Date registro, Double costo, String uRL, Integer cantMax, Integer cantMin,
				Double duracion, String descripcion, Map<String, Funcion> funciones) {
			super();
			Nombre = nombre;
			Registro = registro;
			Costo = costo;
			URL = uRL;
			CantMax = cantMax;
			CantMin = cantMin;
			Duracion = duracion;
			Descripcion = descripcion;
			Funciones = new HashMap<String, Funcion>();
		
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
		public Double getCosto() {
			return Costo;
		}
		public void setCosto(Double costo) {
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
		public void setCantMin(Integer cantMin) {
			CantMin = cantMin;
		}
		public Double getDuracion() {
			return Duracion;
		}
		public void setDuracion(Double duracion) {
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
		
}
