
package webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para registroFuncion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="registroFuncion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="canjeable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="costo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="paquete" type="{http://webservices/}paquete" minOccurs="0"/&gt;
 *         &lt;element name="registro" type="{http://webservices/}tipoRegistro" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registroFuncion", propOrder = {
    "canjeable",
    "costo",
    "fecha",
    "paquete",
    "registro"
})
public class RegistroFuncion {

    protected Boolean canjeable;
    protected Double costo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    protected Paquete paquete;
    @XmlSchemaType(name = "string")
    protected TipoRegistro registro;

    /**
     * Obtiene el valor de la propiedad canjeable.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanjeable() {
        return canjeable;
    }

    /**
     * Define el valor de la propiedad canjeable.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanjeable(Boolean value) {
        this.canjeable = value;
    }

    /**
     * Obtiene el valor de la propiedad costo.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCosto() {
        return costo;
    }

    /**
     * Define el valor de la propiedad costo.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCosto(Double value) {
        this.costo = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad paquete.
     * 
     * @return
     *     possible object is
     *     {@link Paquete }
     *     
     */
    public Paquete getPaquete() {
        return paquete;
    }

    /**
     * Define el valor de la propiedad paquete.
     * 
     * @param value
     *     allowed object is
     *     {@link Paquete }
     *     
     */
    public void setPaquete(Paquete value) {
        this.paquete = value;
    }

    /**
     * Obtiene el valor de la propiedad registro.
     * 
     * @return
     *     possible object is
     *     {@link TipoRegistro }
     *     
     */
    public TipoRegistro getRegistro() {
        return registro;
    }

    /**
     * Define el valor de la propiedad registro.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoRegistro }
     *     
     */
    public void setRegistro(TipoRegistro value) {
        this.registro = value;
    }

}
