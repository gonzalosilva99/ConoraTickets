package Persistencia;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-11-25T13:38:05.289-0300")
@StaticMetamodel(EspectadorPersistencia.class)
public class EspectadorPersistencia_ {
	public static volatile SingularAttribute<EspectadorPersistencia, Long> id;
	public static volatile SingularAttribute<EspectadorPersistencia, String> nickname;
	public static volatile SingularAttribute<EspectadorPersistencia, String> nombre;
	public static volatile SingularAttribute<EspectadorPersistencia, String> apellido;
	public static volatile SingularAttribute<EspectadorPersistencia, String> email;
	public static volatile SingularAttribute<EspectadorPersistencia, String> imagen;
	public static volatile SingularAttribute<EspectadorPersistencia, String> contrasena;
	public static volatile SingularAttribute<EspectadorPersistencia, Date> nacimiento;
}
