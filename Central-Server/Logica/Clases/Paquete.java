package Clases;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import DataTypes.DtPaqueteDatos;
import DataTypes.DtEspectaculoDatos;
import DataTypes.DtEspectaculo;
import DataTypes.DtPaquete;
import Manejadores.ManejadorPaquetes;
import Manejadores.ManejadorPlataforma;

public class Paquete {
	private String Nombre;
	private String Descripcion;
	private Date Inicio;
	private Date Fin;
	private Date Alta;
	private String Imagen;
	private HashMap<String, Espectaculo> Espectaculos;
	
	public Paquete() {
		super();
	}
	private Double Descuento;
		public Paquete(String nombre, String descripcion, Date inicio, Date fin, Double descuento, Date alta,String imagen) {
			super();
			Nombre = nombre;
			Descripcion = descripcion;
			Inicio = inicio;
			Fin = fin;
			Imagen = imagen;
			Descuento = descuento;
			Alta = alta;
			Espectaculos = new HashMap<String, Espectaculo>();
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
			DtPaquete ret = new DtPaquete(this.Nombre, this.Descripcion);
			return ret;
		}
		public Boolean tieneEspectaculo(String NombreEspectaculo) {
			return Espectaculos.containsKey(NombreEspectaculo);
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
		public Date getAlta() {
			return Alta;
		}
		public void setAlta(Date alta) {
			Alta = alta;
		}
		public String getImagen() {
			return Imagen;
		}
		public void setImagen(String imagen) {
			Imagen = imagen;
		}
		
		public boolean hayEspectaculo(String nombreEsp) {
			return Espectaculos.containsKey(nombreEsp);
		}
		public void ConfirmarAltaPaquete(String NombrePaquete, String Descripcion, Date inicio, Date fin, String Descuento) {
			
		}
		public DtPaqueteDatos getDtPaqueteDatos() {
			HashSet<DtEspectaculo> esp = new HashSet<DtEspectaculo>();
			for(HashMap.Entry<String,Espectaculo> entry : Espectaculos.entrySet()) {
				DtEspectaculo nuevo = entry.getValue().getDatosEspectaculo();
				esp.add(nuevo);
			}
			DtPaqueteDatos ret = new DtPaqueteDatos(Nombre, Descripcion, Inicio, Fin, Descuento,esp); 
			return ret;
		}
} 
