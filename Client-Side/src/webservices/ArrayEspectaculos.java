
package webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para arrayEspectaculos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="arrayEspectaculos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="espectaculos" type="{http://webservices/}dtEspectaculo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "arrayEspectaculos", propOrder = {
    "espectaculos"
})
public class ArrayEspectaculos {

    @XmlElement(nillable = true)
    protected List<DtEspectaculo> espectaculos;

    /**
     * Gets the value of the espectaculos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the espectaculos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEspectaculos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtEspectaculo }
     * 
     * 
     */
    public List<DtEspectaculo> getEspectaculos() {
        if (espectaculos == null) {
            espectaculos = new ArrayList<DtEspectaculo>();
        }
        return this.espectaculos;
    }

}
