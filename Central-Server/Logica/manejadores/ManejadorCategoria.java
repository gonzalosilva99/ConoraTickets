package manejadores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import manejadores.ManejadorCategoria;
import clases.Categoria;
import clases.Plataforma;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtPlataforma;
import excepciones.Identidad;

public class ManejadorCategoria {
	private 
	static ManejadorCategoria instancia;
	HashMap<String, Categoria> categorias;
public 
	static ManejadorCategoria getInstancia() {
		if (instancia==null)
			instancia=new ManejadorCategoria();
		return instancia;
			
	}

	private ManejadorCategoria() {
		categorias = new HashMap<String, Categoria>();
	}

	ManejadorCategoria(HashMap<String, Categoria> Cats){
		super();
		categorias = Cats;
	}
	
	public void altaCategoria(String nombre) throws Identidad{
		if (!existeCategoria(nombre)) {
			Categoria cat = new Categoria(nombre);
			categorias.put(nombre, cat);
		}
		else
			throw new Identidad("Ya existe una Categoria con ese Nombre");
	}
	
	public Boolean existeCategoria(String nombre){
		for (Map.Entry<String, Categoria> entry : categorias.entrySet()) {
            if (entry.getValue().getNomCategoria().equalsIgnoreCase(nombre)) {
            	return true;
            }           
		}
		return false;
	}
	
	public HashSet<DtCategoria> listarCategorias(){
		HashSet<DtCategoria> ret = new HashSet<DtCategoria>();		
		for (Map.Entry<String, Categoria> entry : categorias.entrySet()) {
            DtCategoria nueva = entry.getValue().getDtCategoria();
            ret.add(nueva);            
		}
		return ret;
	}
	
	public Categoria getCategoria(String nombre) {
		return categorias.get(nombre);
	}
	public Set<DtEspectaculo> listarEspectaculosDeCategoria(String Nombre){
		return getCategoria(Nombre).getDtEspectaculos();
	}
	public HashSet<DtEspectaculo> listarEspectaculosAceptadosDeCategoria(String nombreCat){
		return  getCategoria(nombreCat).getDtEspectaculosAceptados();
	}
}
