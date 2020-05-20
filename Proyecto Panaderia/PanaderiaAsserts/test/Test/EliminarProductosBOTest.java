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

        String actual;
        String esperado;
        try {
            actual = prod_bo.eliminar(1);
            esperado = "Se han eliminado los datos.";
            assertArrayEquals(esperado.toCharArray(), actual.toCharArray());
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.getMessage());
            fail("No se han eliminado los datos.");
        }
    }

    @After
    public void after() {
        System.out.println("after()");
    }
}
