package Test;

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
public class EliminarProductosBOAfterClass {

    Productos_BO prod_bo;

    @Before
    public void before() {
        prod_bo = new Productos_BO();
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass()");
    }

    @Test
    public void afterClassEliminar() {
        System.out.println("afterClassEliminar()");
        prod_bo.eliminar(1);
    }

    @After
    public void after() {
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass()");
        assertTrue("Se elimino el producto", true);
    }
}
