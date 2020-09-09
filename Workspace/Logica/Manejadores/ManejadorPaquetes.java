package Manejadores;
import java.util.*;
import Clases.Paquete;
import DataTypes.DtPaquete;
import DataTypes.DtPaqueteDatos;


public class ManejadorPaquetes {
	private 
		static ManejadorPaquetes instancia;
		Map<String,Paquete> Paquetes;
	public 
		static ManejadorPaquetes getInstancia(){
			if(instancia==null) {
				instancia=new ManejadorPaquetes();
			}
			return instancia;
				
		}
		Map<String, Paquete> getPaquetes() {
			return Paquetes;
		}

		void setPaquetes(Map<String, Paquete> paquetes) {
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
		
		
}
