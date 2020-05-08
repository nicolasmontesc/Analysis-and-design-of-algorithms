package Test;

import bd.Conexion;
import bo.Productos_BO;
import org.junit.After;
import org.junit.AfterClass;
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
        prod_bo.eliminar(1);
    }
}
