package Test;

import bo.Productos_BO;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Juan Nicolas
 */
public class EliminarProductosBOTest {

    Productos_BO prod_bo;

    @Before
    public void before() {
        System.out.println("before()");
        prod_bo = new Productos_BO();
    }

    @Test
    public void testEliminarProductosBO() {
        System.out.println("testEliminar()");
        prod_bo.eliminar(1);
    }

    @After
    public void after() {
        System.out.println("after()");
        assertTrue("Se elimino el producto", true);
    }
}
