package Test;

import bd.Conexion;
import bo.Productos_BO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Juan Nicolas
 */
public class EliminarProductosBOBeforeClass {

    Conexion co;
    Productos_BO prod_bo;

    public EliminarProductosBOBeforeClass() {
        co = new Conexion();
        prod_bo = new Productos_BO();
    }

    @BeforeClass
    public static void BeforeClass() {
        Conexion.getConnection();
    }

    @AfterClass
    public static void AfterClass() {
    }

    @Before
    public void Before() {
    }

    @After
    public void After() {
    }

    @Test
    public void testBeforeClassEliminarProductosBO() {
        prod_bo.eliminar(1);
    }
}
