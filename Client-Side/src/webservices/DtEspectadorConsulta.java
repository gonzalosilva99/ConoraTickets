
package webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dtEspectadorConsulta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtEspectadorConsulta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contrasena" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="funciones" type="{http://webservices/}dtFuncion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nacimiento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="nickname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="seguidores" type="{http://webservices/}dtUsuario" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="siguiendo" type="{http://webservices/}dtUsuario" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtEspectadorConsulta", propOrder = {
    "apellido",
    "contrasena",
    "email",
    "funciones",
    "imagen",
    "nacimiento",
    "nickname",
    "nombre",
    "seguidores",
    "siguiendo"
})
@XmlSeeAlso({
    DtEspectadorPerfil.class
})
public class DtEspectadorConsulta {

    protected String apellido;
    protected String contrasena;
    protected String email;
    @XmlElement(nillable = true)
    protected List<DtFuncion> funciones;
    protected String imagen;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nacimiento;
    protected String nickname;
    protected String nombre;
    @XmlElement(nillable = true)
    protected List<DtUsuario> seguidores;
    @XmlElement(nillable = true)
    protected List<DtUsuario> siguiendo;

    /**
     * Obtiene el valor de la propiedad apellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Define el valor de la propiedad apellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellido(String value) {
        this.apellido = value;
    }

    /**
     * Obtiene el valor de la propiedad contrasena.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Define el valor de la propiedad contrasena.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContrasena(String value) {
        this.contrasena = value;
    }

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
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
     * {@link DtFuncion }
     * 
     * 
     */
    public List<DtFuncion> getFunciones() {
        if (funciones == null) {
            funciones = new ArrayList<DtFuncion>();
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
     * Obtiene el valor de la propiedad nacimiento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNacimiento() {
        return nacimiento;
    }

    /**
     * Define el valor de la propiedad nacimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNacimiento(XMLGregorianCalendar value) {
        this.nacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad nickname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Define el valor de la propiedad nickname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickname(String value) {
        this.nickname = value;
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
     * Gets the value of the seguidores property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the seguidores property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSeguidores().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtUsuario }
     * 
     * 
     */
    public List<DtUsuario> getSeguidores() {
        if (seguidores == null) {
            seguidores = new ArrayList<DtUsuario>();
        }
        return this.seguidores;
    }

    /**
     * Gets the value of the siguiendo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the siguiendo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSiguiendo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtUsuario }
     * 
     * 
     */
    public List<DtUsuario> getSiguiendo() {
        if (siguiendo == null) {
            siguiendo = new ArrayList<DtUsuario>();
        }
        return this.siguiendo;
    }

}
