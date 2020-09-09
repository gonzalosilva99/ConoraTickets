package Controladores;

import java.util.HashSet;
import java.util.Set;
import DataTypes.DtPaquete;
import Interfaces.IPaquete;

public class ControladorPaquete implements IPaquete{
	public Set<DtPaquete> ListarPaquetes() {
		Set<DtPaquete> ret = new HashSet<DtPaquete>();
		return ret;
	};
	public DtPaqueteDatos MostrarPaquete(String NombrePaquete) {
		DtPaqueteDatos ret = new DtPAqueteDatos();
		return ret;
	};
}
