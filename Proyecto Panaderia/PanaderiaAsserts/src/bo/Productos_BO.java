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

    private String mensaje = "";
    private ProductosDAOimpl productosDAOimpl = new ProductosDAOimpl();

    public String crear(Productos productos) {
        Session session = Conexion.getConnection();

        try {
            mensaje = productosDAOimpl.crear(productos, session);
            session.close();
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        }
        return mensaje;
    }

    public String editar(Productos productos) {
        Session session = Conexion.getConnection();

        try {
            mensaje = productosDAOimpl.editar(productos, session);
            session.close();
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminar(int id) {
        Session session = Conexion.getConnection();

        try {
            mensaje = productosDAOimpl.eliminar(id, session);
            session.close();
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        }
        return mensaje;
    }
}
