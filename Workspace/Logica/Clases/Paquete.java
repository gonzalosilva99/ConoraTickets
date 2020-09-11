package Clases;

import java.util.Date;
import java.util.Map;

import DataTypes.DtPaquete;
import Manejadores.ManejadorPlataforma;

public class Paquete {
	private String Nombre;
	private String Descripcion;
	private Date Inicio;
	private Date Fin;
	private Map<String, Espectaculo> Espectaculos;
	
	public Paquete() {
		super();
	}
	private Double Descuento;
		public Paquete(String nombre, String descripcion, Date inicio, Date fin, Double descuento) {
			super();
			Nombre = nombre;
			Descripcion = descripcion;
			Inicio = inicio;
			Fin = fin;
			Descuento = descuento;
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
		public Date getInicio() {
			return Inicio;
		}
		public void setInicio(Date inicio) {
			Inicio = inicio;
		}
		public Date getFin() {
			return Fin;
		}
		public void setFin(Date fin) {
			Fin = fin;
		}
		public Double getDescuento() {
			return Descuento;
		}
		public void setDescuento(Double descuento) {
			Descuento = descuento;
		}
		public DtPaquete getDtPaquete() {
			DtPaquete ret = new DtPaquete(Nombre, Descripcion);
			return ret;
		}
		public Boolean tieneEspectaculo(String NombreEspectaculo) {
			if (Espectaculos.get(NombreEspectaculo) == null) return false;
			else return true;
		}
		public void agregarEspectaculo(Espectaculo e) {
			Espectaculos.put(e.getNombre(), e);
		}
		public void ConfirmarAgregarEspectaculoPaquete(String NombrePaquete,String NombrePlataforma,String NombreEspectaculo) {
			ManejadorPlataforma manplat = ManejadorPlataforma.getInstancia();
			Plataforma p = manplat.getPlataforma(NombrePlataforma);
			Espectaculo s = p.getEspectaculo(NombreEspectaculo);
			this.agregarEspectaculo(s);
			
			
		}
}
