package clases;

import java.util.HashSet;
import java.util.Set;

import clases.Espectaculo;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.EstadoEspectaculo;

import java.util.Iterator;

public class Categoria {
	private String nomcategoria;

	private Set<Espectaculo> espectaculos;

	public Categoria(String nomCategoria) {
		super();
		this.nomcategoria = nomCategoria;
		this.espectaculos = new HashSet<Espectaculo>();
	}
	public Categoria() {
		super();
	}
	public String getNomCategoria() {
		return nomcategoria;
	}
	public void setNomCategoria(String nomCategoria) {
		nomcategoria = nomCategoria;
	}
	public Set<Espectaculo> getEspectaculos() {
		return espectaculos;
	}
	public void setEspectaculos(Set<Espectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}
	
	public DtCategoria getDtCategoria(){
		DtCategoria ret = new DtCategoria(nomcategoria);
		return ret;
	}
	
	public void anadirEspectaculo(Espectaculo eve) {
		espectaculos.add(eve);
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
	
	public Set<DtEspectaculo> getDtEspectaculosAceptados(){
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

	public String getNomcategoria() {
		return nomcategoria;
	}
	public void setNomcategoria(String nomcategoria) {
		this.nomcategoria = nomcategoria;
	}
	
}
