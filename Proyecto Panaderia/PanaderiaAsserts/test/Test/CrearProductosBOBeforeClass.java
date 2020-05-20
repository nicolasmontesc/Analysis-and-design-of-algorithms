package Test;

import bd.Conexion;
import bo.Productos_BO;
import modelo.Productos;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Juan Nicolas
 */
public class CrearProductosBOBeforeClass {

    Conexion co;
    Productos_BO prod_bo;

    public CrearProductosBOBeforeClass() {
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
    public void testBeforeClassCrearProductosBO() {
        String actual;
        String esperado;
        try {
            actual = prod_bo.crear(new Productos(2, "Pan Itegral", "Bimbo", 5, "Libras", 20000, "3/07/2021", "2/3/2020"));
            esperado = "Se han guardado los datos.";
            assertNotEquals("Mensaje inesperado", actual);
        } catch (Exception e) {
            System.out.println("¡ERROR!" + e.getMessage());
            fail("No se han guardado los datos.");
        }
    }
}
