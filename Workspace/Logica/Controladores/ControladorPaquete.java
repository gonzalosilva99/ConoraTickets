package Controladores;

import java.util.HashSet;
import java.util.Set;

import Clases.Paquete;
import Clases.Plataforma;
import DataTypes.DtPaquete;
import DataTypes.DtPaqueteDatos;
import Interfaces.IPaquete;
import Manejadores.ManejadorPaquetes;
import Manejadores.ManejadorPlataforma;

public class ControladorPaquete implements IPaquete{
	
	public Set<DtPaquete> ListarPaquetes() {
		ManejadorPaquetes manpac = ManejadorPaquetes.getInstancia();
		return manpac.listarPaquetesEspectaculo("asd");
		
	};
	public DtPaqueteDatos MostrarPaquete(String NombrePaquete) {
		DtPaqueteDatos ret = new DtPaqueteDatos();
		return ret;
	};
	
	public void ConfirmarAgregarEspectaculoPaquete(String NombrePaquete, String NombrePlataforma, String NombreEspectaculo) {
		ManejadorPaquetes manpaq = ManejadorPaquetes.getInstancia();
		Paquete paq = manpaq.getPaquete(NombrePaquete);
	
		paq.ConfirmarAgregarEspectaculoPaquete(NombrePaquete,NombrePlataforma,NombreEspectaculo);
		
		
	}
}
