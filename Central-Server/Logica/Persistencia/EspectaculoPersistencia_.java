package Persistencia;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-11-26T20:32:17.150-0300")
@StaticMetamodel(EspectaculoPersistencia.class)
public class EspectaculoPersistencia_ {
	public static volatile SingularAttribute<EspectaculoPersistencia, Long> id;
	public static volatile SingularAttribute<EspectaculoPersistencia, String> nombre;
	public static volatile SingularAttribute<EspectaculoPersistencia, String> descripcion;
	public static volatile SingularAttribute<EspectaculoPersistencia, Integer> duracion;
	public static volatile SingularAttribute<EspectaculoPersistencia, Date> registro;
	public static volatile SingularAttribute<EspectaculoPersistencia, Integer> costo;
	public static volatile SingularAttribute<EspectaculoPersistencia, String> url;
	public static volatile SingularAttribute<EspectaculoPersistencia, Date> fechaFinalizacion;
	public static volatile SingularAttribute<EspectaculoPersistencia, String> plataforma;
	public static volatile SingularAttribute<EspectaculoPersistencia, ArtistaPersistencia> organizador;
	public static volatile SetAttribute<EspectaculoPersistencia, FuncionPersistencia> funciones;
}
