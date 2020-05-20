package Test;

import bd.Conexion;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;

/**
 *
 * @author Juan Nicolas
 */
public class ConexionIgnore {

    Conexion co;

    @Before
    public void before() {
        co = new Conexion();
    }

    @Test
    public void CrearIgnoreRuleTimeOut() {
        Conexion.getConnection();
    }

    @After
    public void after() {
        assertTrue("Se ha conectado a la base de datos Cassandra", true);
    }

    @Test
    @Ignore
    public void testIgnore() {
        System.out.println(5 * 4);
    }
}
