package Test;

import bd.Conexion;
import bo.Productos_BO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Juan Nicolas
 */
public class ConexionAfterClass {

    Conexion co;
    Productos_BO prod_bo;

    @Before
    public void before() {
        co = new Conexion();
        prod_bo = new Productos_BO();
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass()");
    }

    @Test
    public void afterClassConexion() {
        System.out.println("afterClassConexion()");
        Conexion.getConnection();
    }

    @After
    public void after() {
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass()");
        assertTrue("Se ha conectado a la base de datos Cassandra", true);
    }
}
