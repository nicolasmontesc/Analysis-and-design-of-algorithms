package Test;

import bd.Conexion;
import bo.Productos_BO;
import modelo.Productos;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Juan Nicolas
 */
public class EliminarProductosBOBeforeClass {

    Conexion co;
    Productos_BO prod_bo;

    public EliminarProductosBOBeforeClass() {
        co = new Conexion();
        prod_bo = new Productos_BO();
    }

    @BeforeClass
    public static void BeforeClass() {
        Conexion.getConnection();
    }

    @AfterClass
    public static void AfterClass() {
    }

    @Before
    public void Before() {
    }

    @After
    public void After() {
    }

    @Test
    public void testBeforeClassEliminarProductosBO() {

        String actual;
        String esperado;
        try {
            actual = prod_bo.eliminar(1);
            esperado = "Se han eliminado los datos.";
            assertThat(esperado, is(actual));
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.getMessage());
            fail("No se han eliminado los datos.");
        }

    }
}
