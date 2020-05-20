package dao;

import bd.Conexion;
import com.github.cassandra.jdbc.internal.datastax.driver.core.Session;
import modelo.Productos;

/**
 *
 * @author Juan Nicolas
 */
public class ProductosDAOimpl implements ProductosDAO {

    private String mensaje = "";

    @Override
    public String crear(Productos entidad, Session session) {
        session = Conexion.getConnection();
        try {

            session.execute("INSERT INTO panaderia.productos (id, cantidad, costo, dia_venta, fecha_vencimiento, marca, nombre, peso)" + "VALUES (" + entidad.getId() + "," + entidad.getCantidad() + "," + entidad.getCosto() + ",'" + entidad.getDia_venta() + "','" + entidad.getFecha_vencimiento() + "','" + entidad.getMarca() + "','" + entidad.getNombre() + "','" + entidad.getPeso() + "');");
            session.close();
            mensaje = "Se han guardado los datos.";
        } catch (Exception e) {
            mensaje = "No se han guardado los datos." + e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String editar(Productos entidad, Session session) {
        session = Conexion.getConnection();
        try {
            session.execute("UPDATE productos SET cantidad=" + entidad.getCantidad() + ",costo=" + entidad.getCosto() + ",dia_venta='" + entidad.getDia_venta() + "',fecha_vencimiento='" + entidad.getFecha_vencimiento() + "',marca='" + entidad.getMarca() + "',nombre='" + entidad.getNombre() + "',peso='" + entidad.getPeso() + "'WHERE id=" + entidad.getId() + ";");
            session.close();
            mensaje = "Se han editado los datos.";
        } catch (Exception e) {
            mensaje = "No se han editado los datos." + e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String eliminar(int id, Session session) {
        session = Conexion.getConnection();
        try {
            session.execute("DELETE FROM productos WHERE id=" + id + ";");
            session.close();
            mensaje = "Se han eliminado los datos.";
        } catch (Exception e) {
            mensaje = "No se han eliminado los datos." + e.getMessage();
        }
        return mensaje;
    }
}
