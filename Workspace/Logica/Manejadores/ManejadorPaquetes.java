package Manejadores;
import java.util.*;
import Clases.Paquete;
import DataTypes.DtPaquete;
import DataTypes.DtPaqueteDatos;


public class ManejadorPaquetes {
	private 
		Map<String,Paquete> Paquetes;
	public 
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
