package Test;

import bo.Productos_BO;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 *
 * @author Juan Nicolas
 */
public class EliminarProductosBORuleTimeOut {

    Productos_BO prod_bo;

    @Before
    public void before() {
        prod_bo = new Productos_BO();
    }

    @Test
    public void EliminarProductosBORuleTimeOut() {
        String actual;
        String esperado;
        try {
            actual = prod_bo.eliminar(1);
            esperado = "Se han eliminado los datos.";
            assertEquals(esperado, actual);
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.getMessage());
            fail("No se han eliminado los datos.");
        }
    }

    @After
    public void after() {
    }

    @Rule
    public Timeout timeout = Timeout.millis(5000);
}
