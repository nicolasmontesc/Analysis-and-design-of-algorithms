package Test;

import bo.Productos_BO;
import modelo.Productos;
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
public class CrearProductosBORuleTimeOut {

    Productos_BO prod_bo;

    @Before
    public void before() {
        prod_bo = new Productos_BO();
    }

    @Test
    public void CrearProductosBORuleTimeOut() {

        String actual;
        String esperado;
        try {
            actual = prod_bo.crear(new Productos(2, "Pan integral", "Comapans", 15, "Libras", 200000, "2/10/2021", "1/1/2020"));
            esperado = "Se han guardado los datos.";
            assertNotSame("Mensaje inesperado", actual);
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.getMessage());
            fail("No se han guardado los datos.");
        }
    }

    @After
    public void after() {
    }

    @Rule
    public Timeout timeout = Timeout.millis(5000);
}
