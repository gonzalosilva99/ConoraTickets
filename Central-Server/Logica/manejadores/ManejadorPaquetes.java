package manejadores;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import clases.Paquete;
import datatypes.DtCategoria;
import datatypes.DtPaquete;
import datatypes.DtPaqueteDatos;
import excepciones.Identidad;


public class ManejadorPaquetes {
	private 
		static ManejadorPaquetes instancia;
		Map<String, Paquete> paquetes;
	public 
		static ManejadorPaquetes getInstancia(){
			if (instancia==null) {
				instancia=new ManejadorPaquetes();
			}
			return instancia;
				
		}
	
		private ManejadorPaquetes() {
			paquetes = new HashMap<String, Paquete>();
		}
	
		public Map<String, Paquete> getPaquetes() {
			return paquetes;
		}

		
		public Set<DtPaqueteDatos> filtrarPaquetes(String search){
			HashSet<DtPaqueteDatos> ret = new HashSet<DtPaqueteDatos>();
			for (Map.Entry<String, Paquete> entry : paquetes.entrySet()) {
				DtPaqueteDatos nuevo = entry.getValue().getDtPaqueteDatos();
				if (nuevo.getNombre().toLowerCase().contains(search.toLowerCase()))
					ret.add(nuevo);
			}
			return ret;
		}
		void setPaquetes(Map<String, Paquete> paquetes) {
			this.paquetes = paquetes;
		}
		
		public DtPaqueteDatos mostrarPaquete(String NombrePaquete) {
			Paquete paq = paquetes.get(NombrePaquete);
			return paq.getDtPaqueteDatos();
		}
		
		public Paquete getPaquete(String NombrePaquete) {
			return paquetes.get(NombrePaquete);
		}
		
		public Set<DtPaquete> listarPaquetesEspectaculo(String nomEsp){
			Set<DtPaquete> ret = new HashSet<DtPaquete>();		
			for (Map.Entry<String, Paquete> entry : paquetes.entrySet()) {
				if (entry.getValue().hayEspectaculo(nomEsp)){
		            DtPaquete nueva = entry.getValue().getDtPaquete();
		            ret.add(nueva);
				}
			}
			return ret;
		} 
		
		public Set<DtPaquete> listarPaquetes(){
			HashSet<DtPaquete> ret = new HashSet<DtPaquete>();
			for (Map.Entry<String, Paquete> entry : paquetes.entrySet()) {
	            DtPaquete nuevo = entry.getValue().getDtPaquete();
	            ret.add(nuevo);            
			}
			return ret;
		}
		
		public Boolean existePaquete(String nombre){
			for (Map.Entry<String, Paquete> entry : paquetes.entrySet()) {
	            if (entry.getValue().getNombre().equalsIgnoreCase(nombre)) {
	            	return true;
	            }           
			}
			return false;
		}
		
		public void confirmarAltaPaquete(String NombrePaquete, String Descripcion, Date inicio, Date fin, Double Descuento, Date alta, String imagen) throws Identidad{
			if (!existePaquete(NombrePaquete)) {
				Paquete paq = new Paquete(NombrePaquete, Descripcion, inicio, fin, Descuento, alta, imagen);
				paquetes.put(NombrePaquete, paq);
			}
			else {
				throw new Identidad("Ya Existe un Paquete con ese Nombre");
			}
		}
		public DtPaqueteDatos getPaqueteDatos(String nombrePaquete) {
			Paquete paquete = paquetes.get(nombrePaquete);
			return paquete.getDtPaqueteDatos();
		}
		public DtPaquete getDtPaquete(String nombrePaquete) {
			Paquete paquete = paquetes.get(nombrePaquete);
			return paquete.getDtPaquete();
		}
		
		public Set<DtCategoria> listarCategorias(String Paquete){
			Paquete paquete = paquetes.get(Paquete);
			return paquete.listarCategorias();
		}
		public Set<DtPaquete> listarPaquetesVigentes(){
			Set<DtPaquete> ret = new HashSet<DtPaquete>();		
			for (Map.Entry<String, Paquete> entry : paquetes.entrySet()) {
		            DtPaquete nueva = entry.getValue().getDtPaquete();
		            ret.add(nueva);
			}
			return ret;
		}
		
}
