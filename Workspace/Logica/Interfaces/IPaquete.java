package Interfaces;

import java.util.Set;
import java.util.Date;

import DataTypes.DtPaquete;
import DataTypes.DtPaqueteDatos;
import Excepciones.Identidad;

public interface IPaquete {
	
	public Set<DtPaquete> ListarPaquetes();
	public Set<DtPaquete> ListarPaquetesEspectaculo(String nomEsp);
	public 	DtPaqueteDatos MostrarPaquete(String NombrePaquete);
	public void ConfirmarAgregarEspectaculoPaquete(String NombrePaquete, String NombrePlataforma, String NombreEspectaculo);
	public void ConfirmarAltaPaquete(String NombrePaquete, String Descripcion, Date inicio, Date fin, Double Descuento, Date alta) throws Identidad;
}
