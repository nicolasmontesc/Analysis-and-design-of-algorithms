package Test;

import bd.Conexion;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Juan Nicolas
 */
public class ConexionTest {

    Conexion co;

    @Before
    public void before() {
        System.out.println("before()");
        co = new Conexion();
    }

    @Test
    public void testConexion() {
        System.out.println("testConexion()");
        Conexion.getConnection();
        assertNotNull(co);//Significa que la conexion no es nulla, o sea se conecto a la bd
    }

    @After
    public void after() {
        System.out.println("after()");
    }
}
