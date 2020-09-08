package Clases;

import java.util.Date;

public class Espectaculo {
	private String Nombre;
	private Date Registro;
	private Double Costo;
	private String URL;
	private Integer CantMax;
	private Integer CantMin;
	private Double Duracion;
	private String Descripcion;
		public Espectaculo(String nombre, Date registro, Double costo, String uRL, Integer cantMax, Integer cantMin,
				Double duracion, String descripcion) {
			super();
			Nombre = nombre;
			Registro = registro;
			Costo = costo;
			URL = uRL;
			CantMax = cantMax;
			CantMin = cantMin;
			Duracion = duracion;
			Descripcion = descripcion;
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
		
}
