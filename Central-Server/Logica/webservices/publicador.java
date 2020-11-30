/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;


import controladores.Fabrica;
import datatypes.ArrayEspectaculos;
import controladores.Fabrica;
import datatypes.ArrayCategorias;
import datatypes.ArrayDtRegistros;
import datatypes.ArrayPlataformas;
import datatypes.ArrayPremios;
import datatypes.ArrayArtistas;
import datatypes.DtArtista;
import datatypes.DtArtistaConsulta;
import datatypes.DtArtistaPerfil;
import datatypes.DtCategoria;
import datatypes.DtEspectaculo;
import datatypes.DtEspectaculoDatos;
import datatypes.DtEspectador;
import datatypes.DtEspectadorConsulta;
import datatypes.DtEspectadorPerfil;
import datatypes.DtFuncion;
import datatypes.DtFuncionDatos;
import datatypes.DtPaquete;
import datatypes.DtPaqueteDatos;
import datatypes.DtPlataforma;
import datatypes.DtPremio;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
import datatypes.SetEspectaculos;
import datatypes.SetUsuarios;
import datatypes.SetPaquetes;
import datatypes.TipoRegistro;
import datatypes.EstadoEspectaculo;
import datatypes.EstadoRegistro;
import datatypes.EstadoSesion;
import excepciones.Identidad;
import interfaces.ICategoria;
import interfaces.IPlataforma;
import interfaces.IUsuario;
import interfaces.IPaquete;
import datatypes.ArrayEspectadores;
import datatypes.ArrayPaquetes;


import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.ws.Endpoint;

import Persistencia.EspectaculoPersistencia;
import Persistencia.SetEspectaculoPersistencia;
import clases.Categoria;
import clases.Espectaculo;
import clases.Funcion;
import clases.Paquete;
/**
 *
 * @author Pablo
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class publicador {
    Fabrica fab = Fabrica.getInstancia();
	IUsuario iusuario = fab.getIUsuario();
	IPlataforma iplataforma = fab.getIPlataforma();
	ICategoria icategoria = fab.getICategoria();
	IPaquete ipaquete = fab.getIPaquete();
    private Endpoint endpoint = null;
    EntityManager emPub;
    //Constructor
    public publicador(){
    }

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9105/publicador", this);
    }
    
    @WebMethod(exclude = true)
    public void quitar(){
         endpoint.stop();
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }

    @WebMethod
    public void altaEspectaculo(String nomPlat, String nickArtista, String nomEspectaculo, String descripcion, Integer minEsp, Integer maxEsp, String url, Integer costo, Date fecha, Integer duracion, String imagen, ArrayCategorias categorias,  String urlVideo, String premio, int cantPremios) throws Identidad {
    	try {
    		URL urlaux = new URL(imagen);
        	URLConnection urlcon = urlaux.openConnection();
        	System.out.println(urlcon.getContentType());
        	InputStream is = urlcon.getInputStream();
        	FileOutputStream fos = new FileOutputStream("../Central-Server/files/Espectaculo"+nomEspectaculo+".jpg");
        	byte[] array = new byte[1000];
        	int leido = is.read(array);
        	while(leido>0) {
        		fos.write(array, 0, leido);
        		leido = is.read(array);
        	}
        	is.close();
        	fos.close();
        	
    	}    	
    	catch(Exception e) {
    		System.out.print(e.getMessage());
    		e.printStackTrace();
    	}
    	try {
    	
    	Set<String> cat = new HashSet<String>();
    	if (categorias.getCategorias().size()>0) {
    	Iterator<DtCategoria> itr = categorias.getCategorias().iterator();
    	while(itr.hasNext()) {
    		cat.add(itr.next().getNomCategoria());
    	}
    	}
    	String im = "Espectaculo"+nomEspectaculo+".jpg";
        iplataforma.altaEspectaculo(nomPlat, nickArtista, nomEspectaculo, descripcion, minEsp, maxEsp, url, costo, fecha, duracion, im, cat, urlVideo, premio, cantPremios);
    	}
    	catch(Exception e) {
    		throw e;
    	}
    	
    }
    @WebMethod
    public void actualizarUltimoIngreso(String nickname) {
    	iusuario.actualizarUltimoIngreso(nickname);
    }
    
    @WebMethod
    public DtEspectaculoDatos getDatosEspectaculo(String nombrePlataforma, String nombreEspectaculo) {
    	return iplataforma.getDatosEspectaculo(nombrePlataforma, nombreEspectaculo);
    }
    
    @WebMethod
	public ArrayEspectaculos listarEspectaculosAceptadosDePlataforma(String Nombre){
    	ArrayList<DtEspectaculo> set = new ArrayList<DtEspectaculo>(iplataforma.listarEspectaculosAceptadosDePlataforma(Nombre));
    	ArrayEspectaculos ret = new ArrayEspectaculos(set);
    	return ret;
    }
    
    @WebMethod
    public void altaPlataforma(String nombre, String Descripcion, String Url) {
    	try {
    		iplataforma.altaPlataforma(nombre, Descripcion, Url);
    	}
    	catch(Exception e) {
    		
    	}
    	
    }
    
    @WebMethod   
    public ArrayPlataformas listarPlataformas(){
    	ArrayList<DtPlataforma> set = new ArrayList<DtPlataforma>(iplataforma.listarPlataformas());
    	ArrayPlataformas ret = new ArrayPlataformas(set);
    	return ret;
    }
    
    @WebMethod
	public void confirmarAltaFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nombre, Date inicio, ArrayArtistas artistas, Date alta, String imagen) {
    	try {
    		URL urlaux = new URL(imagen);
        	URLConnection urlcon = urlaux.openConnection();
        	System.out.println(urlcon.getContentType());
        	InputStream is = urlcon.getInputStream();
        	FileOutputStream fos = new FileOutputStream("../Central-Server/files/Funcion"+nombre+".jpg");
        	byte[] array = new byte[1000];
        	int leido = is.read(array);
        	while(leido>0) {
        		fos.write(array, 0, leido);
        		leido = is.read(array);
        	}
        	is.close();
        	fos.close();
        	
    	}    	
    	catch(Exception e) {
    		System.out.print(e.getMessage());
    		e.printStackTrace();
    	}
    	ArrayList<String> listaArtistas = new ArrayList<>();
    	for (DtArtista artista: artistas.getArtistas()) {
    		listaArtistas.add(artista.getNickname());
    	}
    	String im = "Funcion"+nombre+".jpg";
    	Set<String> art = new HashSet<String>(listaArtistas);
    	iplataforma.confirmarAltaFuncionEspectaculo(nombrePlataforma, nombreEspectaculo, nombre, inicio, art, alta, im);
    }

    @WebMethod
    public boolean existeFuncion(String nombreFuncion) {
    	return iplataforma.existeFuncion(nombreFuncion);
    }
	
    @WebMethod
	public DtEspectaculoDatos findDatosEspectaculo(String nombreEspectaculo) {
    	return iplataforma.findDatosEspectaculo(nombreEspectaculo);
    }
    @WebMethod
	public String getPlataformaDeEspectaculo(String esp) {
    	return iplataforma.getPlataformaDeEspectaculo(esp);
    }
    
    @WebMethod
	public DtFuncionDatos findDatosFuncion(String nombre) {
    	return iplataforma.findDatosFuncion(nombre);
    }
    @WebMethod
	public Boolean puedeAgregarEspectadores(String nombrePlataforma, String nombreEspectaculo, String nombreFuncion) {
    	return iplataforma.puedeAgregarEspectadores(nombrePlataforma, nombreEspectaculo, nombreFuncion);
    }
    @WebMethod
	public ArrayCategorias listarCategoriasDeEspectaculo(String Plataforma, String Espectaculo){
    	ArrayCategorias arrcat = new ArrayCategorias();
    	List<DtCategoria> lcat = new ArrayList<DtCategoria>(iplataforma.listarCategoriasDeEspectaculo(Plataforma, Espectaculo));
    	arrcat.setCategorias(lcat);
    	return arrcat;
    }
    @WebMethod
	public void aceptarEspectaculo(String nomEspectaculo) {
    	iplataforma.aceptarEspectaculo(nomEspectaculo);
    }
    @WebMethod
	public DtFuncion getDtFuncion(String nombreFuncion) {
    	return iplataforma.getDtFuncion(nombreFuncion);
    }
    @WebMethod
	public ArrayEspectadores sortearPremios(String nombrePlataforma, String nombreEspectaculo, String nombreFuncion){
    	ArrayList<DtEspectador> set = new ArrayList<DtEspectador>(iplataforma.sortearPremios(nombrePlataforma, nombreEspectaculo, nombreFuncion));
    	ArrayEspectadores ret = new ArrayEspectadores(set);
    	return ret;
    }
    @WebMethod    
	public void confirmarAltaArtista(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento, String imagen, String contrasena, String Descripcion, String Biografia, String Link) throws Identidad{
    	try {
    		URL urlaux = new URL(imagen);
        	URLConnection urlcon = urlaux.openConnection();
        	System.out.println(urlcon.getContentType());
        	InputStream is = urlcon.getInputStream();
        	FileOutputStream fos = new FileOutputStream("../Central-Server/files/Usuario"+Nickname+".jpg");
        	byte[] array = new byte[1000];
        	int leido = is.read(array);
        	while(leido>0) {
        		fos.write(array, 0, leido);
        		leido = is.read(array);
        	}
        	is.close();
        	fos.close();
        	
    	}    	
    	catch(Exception e) {
    		System.out.print(e.getMessage());
    		e.printStackTrace();
    	}
    	try {
    		String im = "Usuario"+Nickname+".jpg";
    		iusuario.confirmarAltaArtista(Nickname, Nombre, Apellido, Email, Nacimiento, im, contrasena, Descripcion, Biografia, Link);
    	}
    	catch(Exception e) {
    		throw e;
    	}
    }
    
    @WebMethod
	public void confirmarAltaEspectador(String Nickname, String Nombre, String Apellido, String Email, Date Nacimiento,  String imagen, String contrasena) throws Identidad{
    	try {
    		URL urlaux = new URL(imagen);
        	URLConnection urlcon = urlaux.openConnection();
        	System.out.println(urlcon.getContentType());
        	InputStream is = urlcon.getInputStream();
        	FileOutputStream fos = new FileOutputStream("../Central-Server/files/Usuario"+Nickname+".jpg");
        	byte[] array = new byte[1000];
        	int leido = is.read(array);
        	while(leido>0) {
        		fos.write(array, 0, leido);
        		leido = is.read(array);
        	}
        	is.close();
        	fos.close();
        	
    	}    	
    	catch(Exception e) {
    		System.out.print(e.getMessage());
    		e.printStackTrace();
    	}
    	try {
    		String im = "Usuario"+Nickname+".jpg";
    		iusuario.confirmarAltaEspectador(Nickname, Nombre, Apellido, Email, Nacimiento, im, contrasena);
    	}
    	catch(Exception e) {
    		throw e;
    	}
    }
    @WebMethod
	public Boolean esArtista(String nickname) {
    	return iusuario.esArtista(nickname);
    }
    @WebMethod
	public DtArtistaPerfil perfilArtista(String nickname) {
    	return iusuario.perfilArtista(nickname);
    }
    @WebMethod
	public DtEspectadorPerfil perfilEspectador(String nickname) {
    	return iusuario.perfilEspectador(nickname);
    }
    @WebMethod
	public ArrayArtistas listarArtistas(){
    	ArrayList<DtArtista> artistas = new ArrayList<DtArtista>(iusuario.listarArtistas());
    	ArrayArtistas ret = new ArrayArtistas(artistas);
    	return ret;
    }
    @WebMethod
	public ArrayDtRegistros listarRegistrosSinCanjeaer(String nickname){
    	ArrayList<DtRegistro> set = new ArrayList<DtRegistro>(iusuario.listarRegistrosSinCanjeaer(nickname));
    	ArrayDtRegistros ret = new ArrayDtRegistros(set);
    	return ret;
    }
    @WebMethod
	public void confirmarRegistroFuncionEspectaculo(String nombrePlataforma, String nombreEspectaculo, String nickname, String nombreFuncion, Date fecha, TipoRegistro registro, Integer Registro1, Integer Registro2, Integer Registro3, String NombrePaquete, Double costo) {
    	iusuario.confirmarRegistroFuncionEspectaculo(nombrePlataforma, nombreEspectaculo, nickname, nombreFuncion, fecha, registro, Registro1, Registro2, Registro3, NombrePaquete, costo);
    }
    @WebMethod
	public Boolean existeRegistroaFuncion(String nickname, String nombreFuncion) {
    	return iusuario.existeRegistroaFuncion(nickname, nombreFuncion);
    }
    @WebMethod
	public void seguirUsuario(String NickSeguidor, String NickASeguir) {
    	iusuario.seguirUsuario(NickSeguidor, NickASeguir);
    }
    @WebMethod
	public DtUsuario getUsuarioNickname(String nickname) {
    	return iusuario.getUsuarioNickname(nickname);
    }
    @WebMethod
	public DtUsuario getUsuarioEmail(String email) {
    	return iusuario.getUsuarioEmail(email);
    }
    @WebMethod
	public Boolean logueoCorrecto(String login, String password) {
    	return iusuario.logueoCorrecto(login, password);
    }
    @WebMethod
	public void comprarPaquete(String nickname, String nombrePaquete, Date fecha) {
    	iusuario.comprarPaquete(nickname, nombrePaquete, fecha);
    }
    @WebMethod
	public Boolean existeCompraPaquete(String nickname, String nombrePaquete) {
    	return iusuario.existeCompraPaquete(nickname, nombrePaquete);
    }
    @WebMethod
	public Boolean existeNickname(String nickname) {
    	return iusuario.existeNickname(nickname);
    }
    @WebMethod
	public void dejarSeguirUsuario(String NickSeguidor, String NickDejarSeguir) {
    	iusuario.dejarSeguirUsuario(NickSeguidor, NickDejarSeguir);
    }
    @WebMethod
	public DtArtista getDtArtistaNickname(String nickname) {
    	return iusuario.getDtArtistaNickname(nickname);
    }
    @WebMethod
	public void modificarArtistaCompleto(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Descripcion, String Biografia, String Link, String Imagen) {
    	iusuario.modificarArtistaCompleto(Nickname, Nombre, Apellido, Nacimiento, Descripcion, Biografia, Link, Imagen);
    }
    @WebMethod
	public void modificarEspectadorCompleto(String Nickname, String Nombre, String Apellido, Date Nacimiento, String Imagen) {
    	iusuario.modificarEspectadorCompleto(Nickname, Nombre, Apellido, Nacimiento, Imagen);
    }
    @WebMethod
    public ArrayDtRegistros listarRegistros(String Nickname){
    	ArrayDtRegistros ret = new ArrayDtRegistros();
    	ret.setRegistros(new ArrayList<DtRegistro>(iusuario.listarRegistros(Nickname)));
    	return ret;
    }
    @WebMethod
	public void marcarFavorito(String nickname, String nomEsp) {
    	iusuario.marcarFavorito(nickname, nomEsp);
    }
    @WebMethod
	public void desmarcarFavorito(String nickname, String nomEsp) {
    	iusuario.desmarcarFavorito(nickname, nomEsp);
    }
    @WebMethod
	public ArrayEspectaculos listarEspectaculosParaPuntuar(String nickname){
    	ArrayEspectaculos ret = new ArrayEspectaculos();
    	ArrayList<DtEspectaculo> set = new ArrayList<DtEspectaculo>(iusuario.listarEspectaculosParaPuntuar(nickname));
    	ret.setEspectaculos(set);
    	return ret;
    }
    @WebMethod
	public void valorarEspectaculo(String nickname, String nomEsp, int valoracion) {
    	iusuario.valorarEspectaculo(nickname, nomEsp, valoracion);
    }
    @WebMethod
	public int getPuntajeEspectaculo(String nickname, String nomEspectaculo) {
    	return iusuario.getPuntajeEspectaculo(nickname, nomEspectaculo);
    }	
    @WebMethod
	public void altaCategoria(String Nombre) {
    	try {
    		icategoria.altaCategoria(Nombre);
    	}
    	catch(Exception e) {
    		
    	}
    }
    

    @WebMethod
	public DtCategoria getDtCategoria(String nombre){
    	return icategoria.getCategoria(nombre).getDtCategoria();
    }
    
    @WebMethod
	public Categoria getCategoria(String nombre){
    	return icategoria.getCategoria(nombre);
    }
    @WebMethod
	public ArrayEspectaculos listarEspectaculosAceptadosDeCategoria(String nombreCat){
    	ArrayList<DtEspectaculo> set = new ArrayList<DtEspectaculo>(icategoria.listarEspectaculosAceptadosDeCategoria(nombreCat));
    	ArrayEspectaculos ret = new ArrayEspectaculos(set);
    	return ret;
    }
    
    @WebMethod
	public ArrayCategorias listarCategorias(){
    	ArrayCategorias arrcats = new ArrayCategorias();
    	List<DtCategoria> listcataux = new ArrayList<DtCategoria>(icategoria.listarCategorias());
    	arrcats.setCategorias(listcataux);
    	return arrcats;
    }
    @WebMethod	
	public ArrayPaquetes listarPaquetes(){
    	ArrayList<DtPaquete> set = new ArrayList<DtPaquete>(ipaquete.listarPaquetes());
    	ArrayPaquetes ret = new ArrayPaquetes(set);
    	return ret;
    }
    @WebMethod
	public void confirmarAgregarEspectaculoPaquete(String NombrePaquete, String NombrePlataforma, String NombreEspectaculo) {
    	ipaquete.confirmarAgregarEspectaculoPaquete(NombrePaquete, NombrePlataforma, NombreEspectaculo);
    }
    @WebMethod
	public void confirmarAltaPaquete(String NombrePaquete, String Descripcion, Date inicio, Date fin, Double Descuento, Date alta, String imagen) {
    	try {
    		URL urlaux = new URL(imagen);
        	URLConnection urlcon = urlaux.openConnection();
        	System.out.println(urlcon.getContentType());
        	InputStream is = urlcon.getInputStream();
        	FileOutputStream fos = new FileOutputStream("../Central-Server/files/Paquete"+NombrePaquete+".jpg");
        	byte[] array = new byte[1000];
        	int leido = is.read(array);
        	while(leido>0) {
        		fos.write(array, 0, leido);
        		leido = is.read(array);
        	}
        	is.close();
        	fos.close();
        	
    	}    	
    	catch(Exception e) {
    		System.out.print(e.getMessage());
    		e.printStackTrace();
    	}
    	try {
    		String im = "Paquete"+NombrePaquete+".jpg";
    		ipaquete.confirmarAltaPaquete(NombrePaquete, Descripcion, inicio, fin, Descuento, alta, im);
    	}
    	catch(Exception e) {
    		
    	}
    }
    @WebMethod
	public DtPaqueteDatos getPaqueteDatos(String nombrePaquete) {
    	return ipaquete.getPaqueteDatos(nombrePaquete);
    }
    @WebMethod
	public Paquete getPaquete(String nombrePaquete) {
    	return ipaquete.getPaquete(nombrePaquete);
    }
    
    @WebMethod
	public SetPaquetes filtrarPaquetes(String search){
    	SetPaquetes ret = new SetPaquetes();
    	ret.setPaqs(ipaquete.filtrarPaquetes(search));
    	System.out.print("El tamanio de los paquetes antes de ir es " + ret.getPaqs().size() + " " );
    	return ret;
    }

    @WebMethod
    public SetEspectaculos filtrarEspectaculos(String search){
    	SetEspectaculos ret = new SetEspectaculos();
    	ret.setEspecs(iplataforma.filtrarEspectaculos(search));
    	return ret;
    }
    

    @WebMethod
    public SetUsuarios filtrarUsuarios(String search){
    	SetUsuarios ret = new SetUsuarios();
    	ret.setUsuarios(iusuario.filtrarUsuarios(search));
    	return ret;
    }
    
    @WebMethod public EstadoSesion paraQueAndeEstadoSesion() {
    	EstadoSesion estado = null;
    	return estado;
    }

    
    @WebMethod
    public void finalizarEspectaculo(String nomesp, Date fechafin) {
    	iplataforma.finzalizarEspectaculo(nomesp, fechafin);
    }
    
    @WebMethod
    public SetEspectaculoPersistencia listarEspectaculosFinalizados(String nick) {
    	return iusuario.listarEspectaculosFinalizados(nick);
    }
    
    @WebMethod 
    public ArrayEspectaculos listarEspectaculosAceptadosArtistaPlataforma(String nickname, String nombrePlataforma){
    	ArrayEspectaculos espectaculos = new ArrayEspectaculos();
    	espectaculos.setEspectaculos(new ArrayList<>(iusuario.listarEspectaculosAceptadosArtistaPlataforma(nickname, nombrePlataforma)));
    	return espectaculos;
    }
    
    @WebMethod
    public boolean esFavorito(String nickname, String nomEspectaculo) {
    	return iusuario.esFavorito(nickname, nomEspectaculo);
    }
    
    public int obtenerCantVotos(int cantEstrellas, String nomEspectaculo) {
    	return iplataforma.obtenerCantVotos(cantEstrellas, nomEspectaculo);
    }
    public EspectaculoPersistencia getEspectaculoPersistencia(String nombreesp) {
    	return iplataforma.getEspectculoPersistencia(nombreesp);
    }
    
    @WebMethod
    public byte[] getFile(@WebParam(name = "fileName") String name)
                    throws  IOException {
        byte[] byteArray = null;
        try {
                File f = new File("../Central-Server/files/"+name);
                FileInputStream streamer = new FileInputStream(f);
                byteArray = new byte[streamer.available()];
                streamer.read(byteArray);
        } catch (IOException e) {
                throw e;
        }
        return byteArray;
    }
    
    @WebMethod
    public ArrayPremios listarPremiosEspectador(String nickname) {
    	return iusuario.listarPremiosEspectador(nickname);
    }

}
