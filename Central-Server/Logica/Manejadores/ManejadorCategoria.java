package Manejadores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Clases.Categoria;
import Clases.Plataforma;
import DataTypes.DtCategoria;
import DataTypes.DtPlataforma;
import Clases.Categoria;
import Excepciones.Identidad;

public class ManejadorCategoria {
	private 
	static ManejadorCategoria instancia;
	HashMap<String,Categoria> Categorias;
public 
	static ManejadorCategoria getInstancia() {
		if(instancia==null)
			instancia=new ManejadorCategoria();
		return instancia;
			
	}

	private ManejadorCategoria() {
		Categorias = new HashMap<String,Categoria>();
	}

	ManejadorCategoria(HashMap<String,Categoria> Cats){
		super();
		Categorias = Cats;
	}
	
	public void AltaCategoria(String nombre) throws Identidad{
		if(!ExisteCategoria(nombre)) {
			Categoria cat = new Categoria(nombre);
			Categorias.put(nombre, cat);
		}
		else
			throw new Identidad("Ya existe una Categoria con ese Nombre");
	}
	
	public Boolean ExisteCategoria(String nombre){
		for (Map.Entry<String,Categoria> entry : Categorias.entrySet()) {
            if(entry.getValue().getNomCategoria().equalsIgnoreCase(nombre)) {
            	return true;
            }           
		}
		return false;
	}
	
	public HashSet<DtCategoria> listarCategorias(){
		HashSet<DtCategoria> ret = new HashSet<DtCategoria>();		
		for (Map.Entry<String, Categoria> entry : Categorias.entrySet()) {
            DtCategoria nueva = entry.getValue().getDtCategoria();
            ret.add(nueva);            
		}
		return ret;
	}
	
	public Categoria getCategoria(String nombre) {
		return Categorias.get(nombre);
	}
}
