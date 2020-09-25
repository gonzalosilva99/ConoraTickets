package Clases;

import java.util.HashMap;

public class Categoria {
	private String NomCategoria;
	private HashMap<String, Espectaculo> Espectaculos;
	public Categoria(String nomCategoria) {
		super();
		NomCategoria = nomCategoria;
	}
	public String getNomCategoria() {
		return NomCategoria;
	}
	public void setNomCategoria(String nomCategoria) {
		NomCategoria = nomCategoria;
	}
	public HashMap<String, Espectaculo> getEspectaculos() {
		return Espectaculos;
	}
	public void setEspectaculos(HashMap<String, Espectaculo> espectaculos) {
		Espectaculos = espectaculos;
	}
	
	
}
