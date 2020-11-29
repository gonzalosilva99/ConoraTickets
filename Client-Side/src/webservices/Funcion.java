
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
 * <p>Clase Java para funcion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="funcion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="espectaculo" type="{http://webservices/}espectaculo" minOccurs="0"/>
 *         &lt;element name="espectadores" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fechaSorteo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inicio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="registros" type="{http://webservices/}registroFuncion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "funcion", propOrder = {
    "alta",
    "espectaculo",
    "espectadores",
    "fechaSorteo",
    "imagen",
    "inicio",
    "nombre",
    "registros"
})
public class Funcion {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar alta;
    protected Espectaculo espectaculo;
    protected Integer espectadores;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaSorteo;
    protected String imagen;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar inicio;
    protected String nombre;
    @XmlElement(nillable = true)
    protected List<RegistroFuncion> registros;

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
     * Obtiene el valor de la propiedad espectaculo.
     * 
     * @return
     *     possible object is
     *     {@link Espectaculo }
     *     
     */
    public Espectaculo getEspectaculo() {
        return espectaculo;
    }

    /**
     * Define el valor de la propiedad espectaculo.
     * 
     * @param value
     *     allowed object is
     *     {@link Espectaculo }
     *     
     */
    public void setEspectaculo(Espectaculo value) {
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
     * {@link RegistroFuncion }
     * 
     * 
     */
    public List<RegistroFuncion> getRegistros() {
        if (registros == null) {
            registros = new ArrayList<RegistroFuncion>();
        }
        return this.registros;
    }

}
