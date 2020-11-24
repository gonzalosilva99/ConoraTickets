
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
 * <p>Clase Java para dtEspectadorPerfil complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtEspectadorPerfil">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservices/}dtEspectadorConsulta">
 *       &lt;sequence>
 *         &lt;element name="paquetesComprados" type="{http://webservices/}dtPaqueteDatos" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ultimoIngreso" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtEspectadorPerfil", propOrder = {
    "paquetesComprados",
    "ultimoIngreso"
})
public class DtEspectadorPerfil
    extends DtEspectadorConsulta
{

    @XmlElement(nillable = true)
    protected List<DtPaqueteDatos> paquetesComprados;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ultimoIngreso;

    /**
     * Gets the value of the paquetesComprados property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paquetesComprados property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaquetesComprados().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtPaqueteDatos }
     * 
     * 
     */
    public List<DtPaqueteDatos> getPaquetesComprados() {
        if (paquetesComprados == null) {
            paquetesComprados = new ArrayList<DtPaqueteDatos>();
        }
        return this.paquetesComprados;
    }

    /**
     * Obtiene el valor de la propiedad ultimoIngreso.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUltimoIngreso() {
        return ultimoIngreso;
    }

    /**
     * Define el valor de la propiedad ultimoIngreso.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUltimoIngreso(XMLGregorianCalendar value) {
        this.ultimoIngreso = value;
    }

}
