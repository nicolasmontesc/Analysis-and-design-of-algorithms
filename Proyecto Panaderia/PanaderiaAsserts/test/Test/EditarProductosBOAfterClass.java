package Test;

import bo.Productos_BO;
import modelo.Productos;
import static org.hamcrest.CoreMatchers.is;
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
public class EditarProductosBOAfterClass {

    Productos_BO prod_bo;

    @Before
    public void before() {
        prod_bo = new Productos_BO();
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass()");
    }

    @Test //AssertArrayEquals
    public void afterClassEditar() {
        String actual;
        String esperado;
        try {
            System.out.println("afterClassEditar()");
            actual = prod_bo.editar(new Productos(1, "Pan de semillos", "Marinelos", 20, "Libras", 20000, "3/07/2021", "2/3/2020"));
            esperado = "Se han editado los datos.";
            assertThat(esperado,is(actual));           
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.getMessage());
            fail("No se han editado los datos.");
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
