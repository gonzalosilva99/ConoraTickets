package Interfaces;

import java.util.Set;

import DataTypes.DtPaquete;
import DataTypes.DtPaqueteDatos;

public interface IPaquete {
	
	public Set<DtPaquete> ListarPaquetes();
	public 	DtPaqueteDatos MostrarPaquete(String NombrePaquete);
	public void ConfirmarAgregarEspectaculoPaquete(String NombrePaquete, String NombrePlataforma, String NombreEspectaculo);
}
