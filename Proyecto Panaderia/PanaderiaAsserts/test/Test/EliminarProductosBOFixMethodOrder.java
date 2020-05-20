package Test;

import bd.Conexion;
import bo.Productos_BO;
import modelo.Productos;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Juan Nicolas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EliminarProductosBOFixMethodOrder {

    Conexion co;
    Productos_BO prod_bo;

    public EliminarProductosBOFixMethodOrder() {
        co = new Conexion();
        prod_bo = new Productos_BO();
    }

    @BeforeClass
    public static void BeforeClass() {
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
    public void test1_getConexion() {
        Conexion.getConnection();
    }

    @Test
    public void test2_EliminarProductosBO() {
        String actual;
        String esperado;
        try {
            actual = prod_bo.eliminar(1);
            esperado = "Se han eliminado los datos.";
            assertNotEquals("Mensaje diferente al esperado" ,actual);
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.getMessage());
            fail("No se han eliminado los datos.");
        }
    }
}
