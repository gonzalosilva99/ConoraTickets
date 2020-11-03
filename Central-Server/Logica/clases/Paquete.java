package clases;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtPaquete;
import datatypes.DtPaqueteDatos;
import manejadores.ManejadorPlataforma;

public class Paquete {
	private String nombre;
	private String descripcion;
	private Date inicio;
	private Date fin;
	private Date alta;
	private String imagen;
	private Map<String, Espectaculo> espectaculos;
	
	public Paquete() {
		super();
	}
	private Double descuento;
		public Paquete(String nombre, String descripcion, Date inicio, Date fin, Double descuento, Date alta, String imagen) {
			super();
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.inicio = inicio;
			this.fin = fin;
			this.imagen = imagen;
			this.descuento = descuento;
			this.alta = alta;
			this.espectaculos = new HashMap<String, Espectaculo>();
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
		public Date getInicio() {
			return inicio;
		}
		public void setInicio(Date inicio) {
			this.inicio = inicio;
		}
		public Date getFin() {
			return fin;
		}
		public void setFin(Date fin) {
			this.fin = fin;
		}
		public Double getDescuento() {
			return descuento;
		}
		public void setDescuento(Double descuento) {
			this.descuento = descuento;
		}
		public DtPaquete getDtPaquete() {
			DtPaquete ret = new DtPaquete(this.nombre, this.descripcion, this.imagen, this.descuento, this.inicio, this.fin);
			return ret;
		}
		public Boolean tieneEspectaculo(String NombreEspectaculo) {
			return espectaculos.containsKey(NombreEspectaculo);
		}
		public void agregarEspectaculo(Espectaculo eve) {
			espectaculos.put(eve.getNombre(), eve);
		}
		public void confirmarAgregarEspectaculoPaquete(String NombrePaquete, String NombrePlataforma, String NombreEspectaculo) {
			ManejadorPlataforma manplat = ManejadorPlataforma.getInstancia();
			Plataforma pla = manplat.getPlataforma(NombrePlataforma);
			Espectaculo esp = pla.getEspectaculo(NombreEspectaculo);
			this.agregarEspectaculo(esp);
			
			
			
		}
		public Date getAlta() {
			return alta;
		}
		public void setAlta(Date alta) {
			this.alta = alta;
		}
		public String getImagen() {
			return imagen;
		}
		public void setImagen(String imagen) {
			this.imagen = imagen;
		}
		
		public boolean hayEspectaculo(String nombreEsp) {
			return espectaculos.containsKey(nombreEsp);
		}
		public void confirmarAltaPaquete(String NombrePaquete, String descripcion, Date inicio, Date fin, String descuento) {
			
		}
		public DtPaqueteDatos getDtPaqueteDatos() {
			Set<DtCategoria> cat = this.listarCategorias();
			HashSet<DtEspectaculo> esp = new HashSet<DtEspectaculo>();
			for (HashMap.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
				DtEspectaculo nuevo = entry.getValue().getDatosEspectaculo();
				esp.add(nuevo);
			}
			DtPaqueteDatos ret = new DtPaqueteDatos(nombre, descripcion, inicio, fin, descuento, esp, cat, imagen); 
			return ret;
		}
		
		public boolean perteneceDtCategoria(DtCategoria cat, Set<DtCategoria> ret) {
			boolean rett = false;
			Iterator<DtCategoria> iter = ret.iterator();
			while (iter.hasNext()){
				if (iter.next().getNomCategoria().equals(cat.getNomCategoria())) {
					rett = true;
					break;
				}
			}
			return rett;
		}
		
		public Set<DtCategoria> listarCategorias(){
			HashSet<DtCategoria> ret = new HashSet<DtCategoria>();
			
			for (Map.Entry<String, Espectaculo> entry : espectaculos.entrySet()) {
				
				Set<DtCategoria> nueva = entry.getValue().listarCategorias();
				Iterator<DtCategoria> iter = nueva.iterator();
				while (iter.hasNext()){
					DtCategoria cat = iter.next();
					if (!perteneceDtCategoria(cat, ret)) {
						ret.add(cat);
					}
					
				}
			}
			return ret;
		}
} 
