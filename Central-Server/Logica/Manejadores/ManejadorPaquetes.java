package Manejadores;
import java.util.*;

import Clases.Espectador;
import Clases.Paquete;
import Clases.Plataforma;
import DataTypes.DtCategoria;
import DataTypes.DtEspectador;
import DataTypes.DtPaquete;
import DataTypes.DtPaqueteDatos;
import DataTypes.DtPlataforma;
import Excepciones.Identidad;


public class ManejadorPaquetes {
	private 
		static ManejadorPaquetes instancia;
		HashMap<String,Paquete> Paquetes;
	public 
		static ManejadorPaquetes getInstancia(){
			if(instancia==null) {
				instancia=new ManejadorPaquetes();
			}
			return instancia;
				
		}
	
		private ManejadorPaquetes() {
			Paquetes = new HashMap<String,Paquete>();
		}
	
		public Map<String, Paquete> getPaquetes() {
			return Paquetes;
		}

		
		public Set<DtPaqueteDatos> filtrarPaquetes(String search){
			HashSet<DtPaqueteDatos> ret = new HashSet<DtPaqueteDatos>();
			for (Map.Entry<String, Paquete> entry : Paquetes.entrySet()) {
				DtPaqueteDatos nuevo = entry.getValue().getDtPaqueteDatos();
				if(nuevo.getNombre().contains(search))
					ret.add(nuevo);
			}
			return ret;
		}
		void setPaquetes(HashMap<String, Paquete> paquetes) {
			Paquetes = paquetes;
		}
		
		public Set<DtPaquete> ListarPaquetes(){
			return new HashSet<DtPaquete>();
		}
		
		public DtPaqueteDatos MostrarPaquete(String NombrePaquete) {
			Paquete p = Paquetes.get(NombrePaquete);
			return p.getDtPaqueteDatos();
		}
		
		public Paquete getPaquete(String NombrePaquete) {
			return Paquetes.get(NombrePaquete);
		}
		
		public Set<DtPaquete> listarPaquetesEspectaculo(String nomEsp){
			Set<DtPaquete> ret = new HashSet<DtPaquete>();		
			for (Map.Entry<String, Paquete> entry : Paquetes.entrySet()) {
				if ( entry.getValue().hayEspectaculo(nomEsp)) {
		            DtPaquete nueva = entry.getValue().getDtPaquete();
		            ret.add(nueva);
				}
			}
			return ret;
		} 
		
		public Set<DtPaquete> listarPaquetes(){
			HashSet<DtPaquete> ret = new HashSet<DtPaquete>();
			for (Map.Entry<String,Paquete> entry : Paquetes.entrySet()) {
	            DtPaquete nuevo = entry.getValue().getDtPaquete();
	            ret.add(nuevo);            
			}
			return ret;
		}
		
		public Boolean ExistePaquete(String nombre){
			for (Map.Entry<String,Paquete> entry : Paquetes.entrySet()) {
	            if(entry.getValue().getNombre().equalsIgnoreCase(nombre)) {
	            	return true;
	            }           
			}
			return false;
		}
		
		public void ConfirmarAltaPaquete(String NombrePaquete,String Descripcion,Date inicio,Date fin,Double Descuento, Date alta,String imagen) throws Identidad{
			if(!ExistePaquete(NombrePaquete)) {
				Paquete paq = new Paquete(NombrePaquete,Descripcion,inicio,fin,Descuento, alta,imagen);
				Paquetes.put(NombrePaquete, paq);
			}
			else {
				throw new Identidad("Ya Existe un Paquete con ese Nombre");
			}
		}
		public DtPaqueteDatos getPaqueteDatos(String nombrePaquete) {
			Paquete paquete = Paquetes.get(nombrePaquete);
			return paquete.getDtPaqueteDatos();
		}
		public DtPaquete getDtPaquete(String nombrePaquete) {
			Paquete paquete = Paquetes.get(nombrePaquete);
			return paquete.getDtPaquete();
		}
		
		public HashSet<DtCategoria> ListarCategorias(String Paquete){
			Paquete paquete = Paquetes.get(Paquete);
			return paquete.ListarCategorias();
		}
		public Set<DtPaquete> listarPaquetesVigentes(){
			Set<DtPaquete> ret = new HashSet<DtPaquete>();		
			for (Map.Entry<String, Paquete> entry : Paquetes.entrySet()) {
		            DtPaquete nueva = entry.getValue().getDtPaquete();
		            ret.add(nueva);
			}
			return ret;
		}
		
}
