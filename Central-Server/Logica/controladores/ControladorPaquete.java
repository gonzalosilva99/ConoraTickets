package controladores;

import java.util.Date;
import java.util.Set;

import clases.Paquete;
import datatypes.DtCategoria;
import datatypes.DtPaquete;
import datatypes.DtPaqueteDatos;
import excepciones.Identidad;
import interfaces.IPaquete;
import manejadores.ManejadorPaquetes;

public class ControladorPaquete implements IPaquete{
	
	public Set<DtPaquete> listarPaquetes() {
		ManejadorPaquetes manpac = ManejadorPaquetes.getInstancia();
		return manpac.listarPaquetes();
		
	};
	
	public Set<DtPaquete> listarPaquetesEspectaculo(String nomEsp){
		ManejadorPaquetes manpac = ManejadorPaquetes.getInstancia();
		return manpac.listarPaquetesEspectaculo(nomEsp);
	}
	
	public DtPaqueteDatos mostrarPaquete(String NombrePaquete) {
		ManejadorPaquetes manpaq = ManejadorPaquetes.getInstancia();
		return manpaq.mostrarPaquete(NombrePaquete);
	};
	
	public void confirmarAgregarEspectaculoPaquete(String NombrePaquete, String NombrePlataforma, String NombreEspectaculo) {
		ManejadorPaquetes manpaq = ManejadorPaquetes.getInstancia();
		Paquete paq = manpaq.getPaquete(NombrePaquete);
		
		paq.confirmarAgregarEspectaculoPaquete(NombrePaquete, NombrePlataforma, NombreEspectaculo);
		
		
	}
	

	public Set<DtPaqueteDatos> filtrarPaquetes(String search){
		ManejadorPaquetes manpaq = ManejadorPaquetes.getInstancia();
		return manpaq.filtrarPaquetes(search);
	}
	
	
	public Set<DtCategoria> listarCategorias(String Paquete){
		ManejadorPaquetes manpaq = ManejadorPaquetes.getInstancia();
		return manpaq.listarCategorias(Paquete);
	}
	
	
	public void confirmarAltaPaquete(String NombrePaquete, String Descripcion, Date inicio, Date fin, Double Descuento, Date alta, String imagen) throws Identidad{
		ManejadorPaquetes manpaq = ManejadorPaquetes.getInstancia();
		manpaq.confirmarAltaPaquete(NombrePaquete, Descripcion, inicio, fin, Descuento, alta, imagen);
	}
	public DtPaqueteDatos getPaqueteDatos(String nombrePaquete) {
		ManejadorPaquetes manpaq = ManejadorPaquetes.getInstancia();
		return manpaq.getPaqueteDatos(nombrePaquete);
	
	}
	public DtPaquete getDtPaquete(String nombrePaquete) {
		ManejadorPaquetes manpaq = ManejadorPaquetes.getInstancia();
		return manpaq.getDtPaquete(nombrePaquete);
	
	}
	public Set<DtPaquete> listarPaquetesVigentes(){
		ManejadorPaquetes manpac = ManejadorPaquetes.getInstancia();
		return manpac.listarPaquetesVigentes();
	}
	public Paquete getPaquete(String nombrePaquete) {
		ManejadorPaquetes manpac = ManejadorPaquetes.getInstancia();
		return manpac.getPaquete(nombrePaquete);
	}

}
