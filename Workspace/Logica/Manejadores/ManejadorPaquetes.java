package Manejadores;
import java.util.*;
import Clases.Paquete;
import Clases.Plataforma;
import DataTypes.DtPaquete;
import DataTypes.DtPaqueteDatos;
import DataTypes.DtPlataforma;


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
	
		Map<String, Paquete> getPaquetes() {
			return Paquetes;
		}

		void setPaquetes(HashMap<String, Paquete> paquetes) {
			Paquetes = paquetes;
		}
		
		Set<DtPaquete> ListarPaquetes(){
			return new HashSet<DtPaquete>();
		}
		
		DtPaqueteDatos MostrarPaquete(String NombrePaquete) {
			return new DtPaqueteDatos();
		}
		
		Paquete getPaquete(String NombrePaquete) {
			return new Paquete();
		}
		
		public Set<DtPaquete> listarPaquetesEspectaculo(String nomEsp){
			Set<DtPaquete> ret = new HashSet<DtPaquete>();		
			for (Map.Entry<String, Plataforma> entry : Paquetes.entrySet()) {
	            DtPlataforma nueva = entry.getValue().getDtPlataforma();
	            ret.add(nueva);            
			}
			return ret;
		}
		
		
}
