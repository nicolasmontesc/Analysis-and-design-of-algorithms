package dao;


import com.github.cassandra.jdbc.internal.datastax.driver.core.Session;
import modelo.Productos;

/**
 *
 * @author Juan Nicolas
 */
public interface ProductosDAO {

    public String crear(Productos entidad, Session session);

    public String editar(Productos entidad, Session session);

    public String eliminar(int id, Session session);
}
