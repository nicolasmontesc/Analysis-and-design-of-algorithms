package Test;

import bd.Conexion;
import bo.Productos_BO;
import modelo.Productos;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
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
public class EditarProductosBOFixMethodOrder {

    Conexion co;
    Productos_BO prod_bo;

    public EditarProductosBOFixMethodOrder() {
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
    public void test2_EditarProductosBO() {
        
        String actual;
        String esperado;
        try {
            actual = prod_bo.editar(new Productos(1, "Pan de semillas", "Bimbo", 20, "Libras", 500000, "3/07/2021", "2/3/2020"));
            esperado = "Se han editado los datos.";
            assertEquals(esperado, actual);
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.getMessage());
            fail("No se han editado los datos.");
        }
    }
}
