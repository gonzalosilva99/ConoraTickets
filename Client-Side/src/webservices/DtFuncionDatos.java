
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
 * <p>Clase Java para dtFuncionDatos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtFuncionDatos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="alta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="artistas" type="{http://webservices/}dtArtista" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="espectaculo" type="{http://webservices/}dtEspectaculo" minOccurs="0"/&gt;
 *         &lt;element name="espectadores" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fechaSorteo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="ganadoresSorteo" type="{http://webservices/}dtEspectador" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="inicio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="registros" type="{http://webservices/}dtRegistroFuncion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtFuncionDatos", propOrder = {
    "alta",
    "artistas",
    "espectaculo",
    "espectadores",
    "fechaSorteo",
    "ganadoresSorteo",
    "imagen",
    "inicio",
    "nombre",
    "registros"
})
public class DtFuncionDatos {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar alta;
    @XmlElement(nillable = true)
    protected List<DtArtista> artistas;
    protected DtEspectaculo espectaculo;
    protected Integer espectadores;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaSorteo;
    @XmlElement(nillable = true)
    protected List<DtEspectador> ganadoresSorteo;
    protected String imagen;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar inicio;
    protected String nombre;
    @XmlElement(nillable = true)
    protected List<DtRegistroFuncion> registros;

    /**
     * Obtiene el valor de la propiedad alta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAlta() {
        return alta;
    }

    /**
     * Define el valor de la propiedad alta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAlta(XMLGregorianCalendar value) {
        this.alta = value;
    }

    /**
     * Gets the value of the artistas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the artistas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArtistas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtArtista }
     * 
     * 
     */
    public List<DtArtista> getArtistas() {
        if (artistas == null) {
            artistas = new ArrayList<DtArtista>();
        }
        return this.artistas;
    }

    /**
     * Obtiene el valor de la propiedad espectaculo.
     * 
     * @return
     *     possible object is
     *     {@link DtEspectaculo }
     *     
     */
    public DtEspectaculo getEspectaculo() {
        return espectaculo;
    }

    /**
     * Define el valor de la propiedad espectaculo.
     * 
     * @param value
     *     allowed object is
     *     {@link DtEspectaculo }
     *     
     */
    public void setEspectaculo(DtEspectaculo value) {
        this.espectaculo = value;
    }

    /**
     * Obtiene el valor de la propiedad espectadores.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEspectadores() {
        return espectadores;
    }

    /**
     * Define el valor de la propiedad espectadores.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEspectadores(Integer value) {
        this.espectadores = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSorteo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaSorteo() {
        return fechaSorteo;
    }

    /**
     * Define el valor de la propiedad fechaSorteo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaSorteo(XMLGregorianCalendar value) {
        this.fechaSorteo = value;
    }

    /**
     * Gets the value of the ganadoresSorteo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ganadoresSorteo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGanadoresSorteo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtEspectador }
     * 
     * 
     */
    public List<DtEspectador> getGanadoresSorteo() {
        if (ganadoresSorteo == null) {
            ganadoresSorteo = new ArrayList<DtEspectador>();
        }
        return this.ganadoresSorteo;
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
     * Obtiene el valor de la propiedad inicio.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInicio() {
        return inicio;
    }

    /**
     * Define el valor de la propiedad inicio.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInicio(XMLGregorianCalendar value) {
        this.inicio = value;
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
     * Gets the value of the registros property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registros property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegistros().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtRegistroFuncion }
     * 
     * 
     */
    public List<DtRegistroFuncion> getRegistros() {
        if (registros == null) {
            registros = new ArrayList<DtRegistroFuncion>();
        }
        return this.registros;
    }

}
