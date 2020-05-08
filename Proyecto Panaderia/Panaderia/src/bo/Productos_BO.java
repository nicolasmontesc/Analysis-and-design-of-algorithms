package bo;

import bd.Conexion;
import com.github.cassandra.jdbc.internal.datastax.driver.core.Session;
import dao.ProductosDAOimpl;
import modelo.Productos;

/**
 *
 * @author Juan Nicolas
 */
public class Productos_BO {

    private ProductosDAOimpl productosDAOimpl = new ProductosDAOimpl();

    public void crear(Productos productos) {
        Session session = Conexion.getConnection();

        try {
            productosDAOimpl.crear(productos,session);
            session.close();
        } catch (Exception e) {
            System.out.println("No ha sido posible guardar los datos BO " + e.getMessage());
        }
    }

    public void editar(Productos productos) {
        Session session = Conexion.getConnection();

        try {
            productosDAOimpl.editar(productos, session);
        } catch (Exception e) {
            System.out.println("No ha sido posible actualizar los datos " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        Session session = Conexion.getConnection();

        try {
            productosDAOimpl.eliminar(id, session);
        } catch (Exception e) {
            System.out.println("No ha sido posible eliminado los datos " + e.getMessage());
        }
    }
}
