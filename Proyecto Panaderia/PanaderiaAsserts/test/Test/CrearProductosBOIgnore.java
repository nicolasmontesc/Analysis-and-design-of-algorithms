package Test;

import bo.Productos_BO;
import modelo.Productos;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;

/**
 *
 * @author Juan Nicolas
 */
public class CrearProductosBOIgnore {

    Productos_BO prod_bo;

    @Before
    public void before() {

        prod_bo = new Productos_BO();
    }

    @Test
    public void productosBOIgnoreCrear() {
        String actual;
        String esperado;
        try {
            actual = prod_bo.crear(new Productos(1, "Pan integral", "Comapan", 15, "Libras", 30000, "2/10/2021", "1/1/2020"));
            esperado = "Se han guardado los datos.";
            assertSame(esperado, actual);
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.getMessage());
            fail("No se han guardado los datos.");
        }
    }

    @After
    public void after() {
        assertTrue("Se agrego el producto", true);
    }

    @Test
    @Ignore
    public void testIgnore() {
        System.out.println(34 - 9);
    }
}
