package Persistencia;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-11-26T12:20:23.250-0300")
@StaticMetamodel(RegistroPersistencia.class)
public class RegistroPersistencia_ {
	public static volatile SingularAttribute<RegistroPersistencia, Long> id;
	public static volatile SingularAttribute<RegistroPersistencia, EspectadorPersistencia> espectador;
	public static volatile SingularAttribute<RegistroPersistencia, Date> fecha;
	public static volatile SingularAttribute<RegistroPersistencia, Integer> costo;
}
