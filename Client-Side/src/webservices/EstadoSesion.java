
package webservices;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estadoSesion.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="estadoSesion"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NO_LOGIN"/&gt;
 *     &lt;enumeration value="LOGIN_CORRECTO"/&gt;
 *     &lt;enumeration value="LOGIN_INCORRECTO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "estadoSesion")
@XmlEnum
public enum EstadoSesion {

    NO_LOGIN,
    LOGIN_CORRECTO,
    LOGIN_INCORRECTO;

    public String value() {
        return name();
    }

    public static EstadoSesion fromValue(String v) {
        return valueOf(v);
    }

}
