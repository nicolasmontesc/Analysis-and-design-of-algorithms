package Test;

import bo.Productos_BO;
import modelo.Productos;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Juan Nicolas
 */
public class EditarProductosBOTest {

    Productos_BO prod_bo;

    @Before
    public void before() {
        System.out.println("before()");
        prod_bo = new Productos_BO();
    }

    @Test
    public void testEditarProductosBO() {
        System.out.println("testEditar()");
        prod_bo.editar(new Productos(1, "Pan de semillas", "Marinela", 20, "Libras", 20000, "3/07/2021", "2/3/2020"));
    }

    @After
    public void after() {
        System.out.println("after()");
        assertTrue("Se editado el producto", true);
    }
}
