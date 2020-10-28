package Interfaces;

import java.util.Set;

import Clases.Paquete;

import java.util.Date;
import java.util.HashSet;

import DataTypes.DtCategoria;
import DataTypes.DtPaquete;
import DataTypes.DtPaqueteDatos;
import Excepciones.Identidad;

public interface IPaquete {
	
	public Set<DtPaquete> ListarPaquetes();
	public Set<DtPaquete> ListarPaquetesEspectaculo(String nomEsp);
	public 	DtPaqueteDatos MostrarPaquete(String NombrePaquete);
	public void ConfirmarAgregarEspectaculoPaquete(String NombrePaquete, String NombrePlataforma, String NombreEspectaculo);
	public void ConfirmarAltaPaquete(String NombrePaquete, String Descripcion, Date inicio, Date fin, Double Descuento, Date alta,String imagen) throws Identidad;
	public DtPaqueteDatos getPaqueteDatos(String nombrePaquete);
	public DtPaquete getDtPaquete(String nombrePaquete);
	public HashSet<DtCategoria> ListarCategorias(String Paquete);
	public Set<DtPaquete> ListarPaquetesVigentes();
	public Paquete getPaquete(String nombrePaquete);
	public Set<DtPaqueteDatos> filtrarPaquetes(String search); 
}
