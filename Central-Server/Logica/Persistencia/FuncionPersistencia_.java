package Persistencia;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-11-26T12:09:09.982-0300")
@StaticMetamodel(FuncionPersistencia.class)
public class FuncionPersistencia_ {
	public static volatile SingularAttribute<FuncionPersistencia, Long> id;
	public static volatile SingularAttribute<FuncionPersistencia, String> nombre;
	public static volatile SingularAttribute<FuncionPersistencia, Date> inicio;
	public static volatile SingularAttribute<FuncionPersistencia, Date> alta;
	public static volatile SetAttribute<FuncionPersistencia, RegistroPersistencia> registros;
}
