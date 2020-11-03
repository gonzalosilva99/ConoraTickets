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
	private String nomcategoria;
	private HashSet<Espectaculo> espectaculos;
	public Categoria(String nomCategoria) {
		super();
		this.nomcategoria = nomCategoria;
		this.espectaculos = new HashSet<Espectaculo>();
	}
	public String getNomCategoria() {
		return nomcategoria;
	}
	public void setNomCategoria(String nomCategoria) {
		nomcategoria = nomCategoria;
	}
	public HashSet<Espectaculo> getEspectaculos() {
		return espectaculos;
	}
	public void setEspectaculos(HashSet<Espectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}
	
	public DtCategoria getDtCategoria(){
		DtCategoria ret = new DtCategoria(nomcategoria);
		return ret; }
	
	public void anadirEspectaculo(Espectaculo e) {
		espectaculos.add(e);
	}
	public Set<DtEspectaculo> getDtEspectaculos(){
		Set<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
		Iterator<Espectaculo> esp = espectaculos.iterator();
		while (esp.hasNext()) {
				DtEspectaculo nuevo = esp.next().getDatosEspectaculo();
				ret.add(nuevo);
		}
		return ret;
	}
	
	public HashSet<DtEspectaculo> getDtEspectaculosAceptados(){
		HashSet<DtEspectaculo> ret = new HashSet<DtEspectaculo>();
		Iterator<Espectaculo> esp = espectaculos.iterator();
		while (esp.hasNext()) {
			Espectaculo aux = esp.next();
			if (aux.getEstado()==EstadoEspectaculo.Aceptado) {
				DtEspectaculo nuevo = aux.getDatosEspectaculo();
				ret.add(nuevo);
			}
		}
		return ret;
	}
	
}
