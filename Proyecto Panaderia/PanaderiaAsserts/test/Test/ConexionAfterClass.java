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
    Conexion co1;
    Productos_BO prod_bo;

    @Before
    public void before() {
        co = new Conexion();
        co1 = null;
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
        assertNull(co1);
    }

    @After
    public void after() {
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass()");
    }
}
