package Clases;

import java.util.HashMap;
import java.util.HashSet;

import DataTypes.DtCategoria;

public class Categoria {
	private String NomCategoria;
	private HashSet<Espectaculo> Espectaculos;
	public Categoria(String nomCategoria) {
		super();
		NomCategoria = nomCategoria;
		Espectaculos = new HashSet<Espectaculo>();
	}
	public String getNomCategoria() {
		return NomCategoria;
	}
	public void setNomCategoria(String nomCategoria) {
		NomCategoria = nomCategoria;
	}
	public HashSet<Espectaculo> getEspectaculos() {
		return Espectaculos;
	}
	public void setEspectaculos(HashSet<Espectaculo> espectaculos) {
		Espectaculos = espectaculos;
	}
	
	public DtCategoria getDtCategoria()
	{
		DtCategoria ret = new DtCategoria(NomCategoria);
		return ret;
	}
	
	public void anadirEspectaculo(Espectaculo e) {
		Espectaculos.add(e);
	}
	
}
