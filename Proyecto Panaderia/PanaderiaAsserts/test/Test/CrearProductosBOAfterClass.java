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
        String actual;
        String esperado;
        try {
            System.out.println("afterClassCrear()");
            actual = prod_bo.crear(new Productos(1, "Pan de semillas", "Bimbo", 20, "Libras", 20000, "3/07/2021", "2/3/2020"));
            esperado = "Se han guardado los datos.";
            assertEquals(esperado, actual); 
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.getMessage());
            fail("No se han guardado los datos.");
        }
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
