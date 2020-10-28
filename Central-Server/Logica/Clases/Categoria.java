package Clases;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

import DataTypes.DtCategoria;
import DataTypes.DtEspectaculo;
import DataTypes.EstadoEspectaculo;

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
	public Set<DtEspectaculo> getDtEspectaculos(){
		Set<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
		Iterator<Espectaculo> esp = Espectaculos.iterator();
		while(esp.hasNext()) {
				DtEspectaculo nuevo = esp.next().getDatosEspectaculo();
				ret.add(nuevo);
		}
		return ret;
	}
	
	public HashSet<DtEspectaculo> getDtEspectaculosAceptados(){
		HashSet<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
		Iterator<Espectaculo> esp = Espectaculos.iterator();
		while(esp.hasNext()) {
			Espectaculo aux = esp.next();
			if(aux.getEstado()==EstadoEspectaculo.Aceptado) {
				DtEspectaculo nuevo = aux.getDatosEspectaculo();
				ret.add(nuevo);
			}
		}
		return ret;
	}
	
}
