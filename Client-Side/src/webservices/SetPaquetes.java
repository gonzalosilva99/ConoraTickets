
package webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para setPaquetes complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="setPaquetes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="paqs" type="{http://webservices/}dtPaqueteDatos" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setPaquetes", propOrder = {
    "paqs"
})
public class SetPaquetes {

    @XmlElement(nillable = true)
    protected List<DtPaqueteDatos> paqs;

    /**
     * Gets the value of the paqs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paqs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaqs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtPaqueteDatos }
     * 
     * 
     */
    public List<DtPaqueteDatos> getPaqs() {
        if (paqs == null) {
            paqs = new ArrayList<DtPaqueteDatos>();
        }
        return this.paqs;
    }

}
