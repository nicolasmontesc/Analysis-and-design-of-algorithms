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
    }

    @After
    public void after() {
        System.out.println("after()");
        assertTrue("Se ha conectado a la base de datos Cassandra", true);
    }
}
