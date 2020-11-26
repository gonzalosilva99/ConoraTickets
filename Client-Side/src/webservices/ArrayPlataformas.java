
package webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para arrayPlataformas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="arrayPlataformas"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="plats" type="{http://webservices/}dtPlataforma" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "arrayPlataformas", propOrder = {
    "plats"
})
public class ArrayPlataformas {

    @XmlElement(nillable = true)
    protected List<DtPlataforma> plats;

    /**
     * Gets the value of the plats property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plats property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlats().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtPlataforma }
     * 
     * 
     */
    public List<DtPlataforma> getPlats() {
        if (plats == null) {
            plats = new ArrayList<DtPlataforma>();
        }
        return this.plats;
    }

}
