package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCompraPaquete.class, TestIPaquete.class, TestIPlataforma.class, TestIUsuario.class, TestICategoria.class })
public class AllTests {

}
