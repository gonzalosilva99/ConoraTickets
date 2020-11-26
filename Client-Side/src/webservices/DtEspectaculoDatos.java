
package webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dtEspectaculoDatos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtEspectaculoDatos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantFavoritos" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="cantPremios" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cantmax" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="cantmin" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="categorias" type="{http://webservices/}dtCategoria" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="costo" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="duracion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="funciones" type="{http://webservices/}dtFuncionDatos" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="organizador" type="{http://webservices/}dtArtista" minOccurs="0"/&gt;
 *         &lt;element name="paquetes" type="{http://webservices/}dtPaquete" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="premio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="puntajePromedio" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="registro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="urlVideo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtEspectaculoDatos", propOrder = {
    "cantFavoritos",
    "cantPremios",
    "cantmax",
    "cantmin",
    "categorias",
    "costo",
    "descripcion",
    "duracion",
    "funciones",
    "imagen",
    "nombre",
    "organizador",
    "paquetes",
    "premio",
    "puntajePromedio",
    "registro",
    "url",
    "urlVideo"
})
public class DtEspectaculoDatos {

    protected Integer cantFavoritos;
    protected int cantPremios;
    protected Integer cantmax;
    protected Integer cantmin;
    @XmlElement(nillable = true)
    protected List<DtCategoria> categorias;
    protected Float costo;
    protected String descripcion;
    protected Integer duracion;
    @XmlElement(nillable = true)
    protected List<DtFuncionDatos> funciones;
    protected String imagen;
    protected String nombre;
    protected DtArtista organizador;
    @XmlElement(nillable = true)
    protected List<DtPaquete> paquetes;
    protected String premio;
    protected double puntajePromedio;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar registro;
    protected String url;
    protected String urlVideo;

    /**
     * Obtiene el valor de la propiedad cantFavoritos.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantFavoritos() {
        return cantFavoritos;
    }

    /**
     * Define el valor de la propiedad cantFavoritos.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantFavoritos(Integer value) {
        this.cantFavoritos = value;
    }

    /**
     * Obtiene el valor de la propiedad cantPremios.
     * 
     */
    public int getCantPremios() {
        return cantPremios;
    }

    /**
     * Define el valor de la propiedad cantPremios.
     * 
     */
    public void setCantPremios(int value) {
        this.cantPremios = value;
    }

    /**
     * Obtiene el valor de la propiedad cantmax.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantmax() {
        return cantmax;
    }

    /**
     * Define el valor de la propiedad cantmax.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantmax(Integer value) {
        this.cantmax = value;
    }

    /**
     * Obtiene el valor de la propiedad cantmin.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantmin() {
        return cantmin;
    }

    /**
     * Define el valor de la propiedad cantmin.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantmin(Integer value) {
        this.cantmin = value;
    }

    /**
     * Gets the value of the categorias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categorias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategorias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtCategoria }
     * 
     * 
     */
    public List<DtCategoria> getCategorias() {
        if (categorias == null) {
            categorias = new ArrayList<DtCategoria>();
        }
        return this.categorias;
    }

    /**
     * Obtiene el valor de la propiedad costo.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Define el valor de la propiedad costo.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCosto(Float value) {
        this.costo = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad duracion.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDuracion() {
        return duracion;
    }

    /**
     * Define el valor de la propiedad duracion.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDuracion(Integer value) {
        this.duracion = value;
    }

    /**
     * Gets the value of the funciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the funciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtFuncionDatos }
     * 
     * 
     */
    public List<DtFuncionDatos> getFunciones() {
        if (funciones == null) {
            funciones = new ArrayList<DtFuncionDatos>();
        }
        return this.funciones;
    }

    /**
     * Obtiene el valor de la propiedad imagen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Define el valor de la propiedad imagen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImagen(String value) {
        this.imagen = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad organizador.
     * 
     * @return
     *     possible object is
     *     {@link DtArtista }
     *     
     */
    public DtArtista getOrganizador() {
        return organizador;
    }

    /**
     * Define el valor de la propiedad organizador.
     * 
     * @param value
     *     allowed object is
     *     {@link DtArtista }
     *     
     */
    public void setOrganizador(DtArtista value) {
        this.organizador = value;
    }

    /**
     * Gets the value of the paquetes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paquetes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaquetes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtPaquete }
     * 
     * 
     */
    public List<DtPaquete> getPaquetes() {
        if (paquetes == null) {
            paquetes = new ArrayList<DtPaquete>();
        }
        return this.paquetes;
    }

    /**
     * Obtiene el valor de la propiedad premio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremio() {
        return premio;
    }

    /**
     * Define el valor de la propiedad premio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremio(String value) {
        this.premio = value;
    }

    /**
     * Obtiene el valor de la propiedad puntajePromedio.
     * 
     */
    public double getPuntajePromedio() {
        return puntajePromedio;
    }

    /**
     * Define el valor de la propiedad puntajePromedio.
     * 
     */
    public void setPuntajePromedio(double value) {
        this.puntajePromedio = value;
    }

    /**
     * Obtiene el valor de la propiedad registro.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRegistro() {
        return registro;
    }

    /**
     * Define el valor de la propiedad registro.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRegistro(XMLGregorianCalendar value) {
        this.registro = value;
    }

    /**
     * Obtiene el valor de la propiedad url.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Define el valor de la propiedad url.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Obtiene el valor de la propiedad urlVideo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlVideo() {
        return urlVideo;
    }

    /**
     * Define el valor de la propiedad urlVideo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlVideo(String value) {
        this.urlVideo = value;
    }

}
