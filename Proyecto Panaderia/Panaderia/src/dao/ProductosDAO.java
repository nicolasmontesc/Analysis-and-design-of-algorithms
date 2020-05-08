package dao;

import com.github.cassandra.jdbc.internal.datastax.driver.core.Session;

import modelo.Productos;

/**
 *
 * @author Juan Nicolas
 */
public interface ProductosDAO {

    public void crear(Productos entidad, Session session);

    public void editar(Productos entidad, Session session);

    public void eliminar(int id, Session session);

}
