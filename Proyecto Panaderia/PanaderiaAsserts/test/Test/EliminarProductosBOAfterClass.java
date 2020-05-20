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
        String actual;
        String esperado;
        try {
            actual = prod_bo.eliminar(1);
            esperado = "Se han eliminado los datos.";
            assertSame(esperado, actual);
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.getMessage());
            fail("No se han eliminado los datos.");
        }

    }

    @After
    public void after() {
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass()");

    }
}
