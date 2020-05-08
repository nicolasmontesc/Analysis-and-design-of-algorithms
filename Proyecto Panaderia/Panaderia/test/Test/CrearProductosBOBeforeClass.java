package Test;

import bd.Conexion;
import bo.Productos_BO;
import modelo.Productos;
import org.junit.After;
import org.junit.AfterClass;
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
        prod_bo.crear(new Productos(1, "Pan de semillas", "Marinela", 20, "Libras", 20000, "3/07/2021", "2/3/2020"));
    }
}
