package Test;

import bo.Productos_BO;
import modelo.Productos;
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
public class CrearProductosBOAfterClass {

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
    public void afterClassCrear() {
        System.out.println("afterClassCrear()");
        prod_bo.crear(new Productos(1, "Pan de semillas", "Marinela", 20, "Libras", 20000, "3/07/2021", "2/3/2020"));
    }

    @After
    public void after() {
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass()");
        assertTrue("Se agrego el producto", true);
    }
}
