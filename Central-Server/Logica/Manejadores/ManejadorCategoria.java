package Manejadores;

import java.util.HashMap;
import java.util.Map;

import Clases.Categoria;
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
}
