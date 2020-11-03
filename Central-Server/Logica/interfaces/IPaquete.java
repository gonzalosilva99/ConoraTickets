package interfaces;

import java.util.Set;
import java.util.Date;
import java.util.HashSet;

import clases.Paquete;
import datatypes.DtCategoria;
import datatypes.DtPaquete;
import datatypes.DtPaqueteDatos;
import excepciones.Identidad;

public interface IPaquete {
	
	public Set<DtPaquete> listarPaquetes();
	public Set<DtPaquete> listarPaquetesEspectaculo(String nomEsp);
	public 	DtPaqueteDatos mostrarPaquete(String NombrePaquete);
	public void confirmarAgregarEspectaculoPaquete(String NombrePaquete, String NombrePlataforma, String NombreEspectaculo);
	public void confirmarAltaPaquete(String NombrePaquete, String Descripcion, Date inicio, Date fin, Double Descuento, Date alta, String imagen) throws Identidad;
	public DtPaqueteDatos getPaqueteDatos(String nombrePaquete);
	public DtPaquete getDtPaquete(String nombrePaquete);
	public HashSet<DtCategoria> listarCategorias(String Paquete);
	public Set<DtPaquete> listarPaquetesVigentes();
	public Paquete getPaquete(String nombrePaquete);
	public Set<DtPaqueteDatos> filtrarPaquetes(String search); 
}
