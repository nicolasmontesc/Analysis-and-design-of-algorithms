package Test;

import bd.Conexion;
import bo.Productos_BO;
import modelo.Productos;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Juan Nicolas
 */
public class EditarProductosBOBeforeClass {

    Conexion co;
    Productos_BO prod_bo;

    public EditarProductosBOBeforeClass() {
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
    public void testBeforeClassEditarProductosBO() {
        String actual;
        String esperado;
        try {
            actual = prod_bo.editar(new Productos(1, "Pan integral", "Bimbo", 20, "Libras", 20000, "3/07/2021", "2/3/2020"));
            esperado = "Se han editado los datos.";
            assertSame(esperado, actual);
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.getMessage());
            fail("No se han editado los datos.");
        }
    }
}
