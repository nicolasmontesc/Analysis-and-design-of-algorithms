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
public class EditarProductosBOIgnore {

    Productos_BO prod_bo;

    @Before
    public void before() {

        prod_bo = new Productos_BO();
    }

    @Test
    public void productosBOIgnoreEditar() {

        String actual;
        String esperado;
        try {
            actual = prod_bo.editar(new Productos(1, "Pan integral", "Comapan", 15, "Libras", 30000, "2/10/2021", "1/1/2020"));
            esperado = "Se han editado los datos.";
            assertNotSame("Mensaje inesperado", actual);
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.getMessage());
            fail("No se han editado los datos.");
        }

    }

    @After
    public void after() {
    }

    @Test
    @Ignore
    public void testIgnore() {
        System.out.println(5 * 5);
    }
}
