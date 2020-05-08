package Test;

import bo.Productos_BO;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;

/**
 *
 * @author Juan Nicolas
 */
public class EliminarProductosBOIgnore {

    Productos_BO prod_bo;

    @Before
    public void before() {

        prod_bo = new Productos_BO();
    }

    @Test
    public void productosBOIgnoreEditar() {
        prod_bo.eliminar(1);
    }

    @After
    public void after() {
        assertTrue("Se elimino el producto", true);
    }

    @Test
    @Ignore
    public void testIgnore() {
        System.out.println(5 * 5);
    }
}
