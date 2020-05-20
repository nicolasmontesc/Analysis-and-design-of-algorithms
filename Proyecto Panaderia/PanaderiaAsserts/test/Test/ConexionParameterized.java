package Test;

import bd.Conexion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runners.Parameterized;

/**
 *
 * @author Juan Nicolas
 */
public class ConexionParameterized {

    private Conexion co;

    @Before
    public void before() {
        co = new Conexion();
    }

    @BeforeClass
    public static void BeforeClass() {
    }

    @AfterClass
    public static void AfterClass() {
    }

    @After
    public void after() {
    }

    @Parameterized.Parameters
    public static Object[][] datos() {
        return new Object[8][0];
    }

    @Test
    public void testConexion() {
        Conexion.getConnection();
    }
}
