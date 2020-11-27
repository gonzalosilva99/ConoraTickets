package Persistencia;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-11-26T20:32:17.111-0300")
@StaticMetamodel(ArtistaPersistencia.class)
public class ArtistaPersistencia_ {
	public static volatile SingularAttribute<ArtistaPersistencia, Long> id;
	public static volatile SingularAttribute<ArtistaPersistencia, String> nickname;
	public static volatile SingularAttribute<ArtistaPersistencia, String> nombre;
	public static volatile SingularAttribute<ArtistaPersistencia, String> apellido;
	public static volatile SingularAttribute<ArtistaPersistencia, String> email;
	public static volatile SingularAttribute<ArtistaPersistencia, String> contrasena;
	public static volatile SingularAttribute<ArtistaPersistencia, Date> nacimiento;
	public static volatile SingularAttribute<ArtistaPersistencia, String> descripcion;
	public static volatile SingularAttribute<ArtistaPersistencia, String> biografia;
	public static volatile SingularAttribute<ArtistaPersistencia, String> url;
}
