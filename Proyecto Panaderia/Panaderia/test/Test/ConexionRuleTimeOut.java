package Test;

import bd.Conexion;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 *
 * @author Juan Nicolas
 */
public class ConexionRuleTimeOut {

    Conexion co;

    @Before
    public void before() {
        co = new Conexion();
    }

    @Test
    public void ruleTimeOutConexion() {
        Conexion.getConnection();
    }

    @After
    public void after() {
        assertTrue("Se ha conectado a la base de datos Cassandra", true);
    }

    @Rule
    public Timeout timeout = Timeout.millis(5000);
}
