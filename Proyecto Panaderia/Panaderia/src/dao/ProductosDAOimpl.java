package dao;

import bd.Conexion;
import com.github.cassandra.jdbc.internal.datastax.driver.core.Session;
import javax.swing.JOptionPane;
import modelo.Productos;

/**
 *
 * @author Juan Nicolas
 */
public class ProductosDAOimpl implements ProductosDAO {

    @Override
    public void crear(Productos entidad, Session session) {
        session = Conexion.getConnection();
        try {

            session.execute("INSERT INTO panaderia.productos (id, cantidad, costo, dia_venta, fecha_vencimiento, marca, nombre, peso)" + "VALUES (" + entidad.getId() + "," + entidad.getCantidad() + "," + entidad.getCosto() + ",'" + entidad.getDia_venta() + "','" + entidad.getFecha_vencimiento() + "','" + entidad.getMarca() + "','" + entidad.getNombre() + "','" + entidad.getPeso() + "');");
            session.close();
            JOptionPane.showMessageDialog(null, "Se han agregado los datos");
        } catch (Exception e) {
            System.out.println("No ha sido posible guardar los datos en DAO " + e.getMessage());
        }
    }

    @Override
    public void editar(Productos entidad, Session session) {
        session = Conexion.getConnection();
        try {
            session.execute("UPDATE productos SET cantidad=" + entidad.getCantidad() + ",costo=" + entidad.getCosto() + ",dia_venta='" + entidad.getDia_venta() + "',fecha_vencimiento='" + entidad.getFecha_vencimiento() + "',marca='" + entidad.getMarca() + "',nombre='" + entidad.getNombre() + "',peso='" + entidad.getPeso() + "'WHERE id=" + entidad.getId() + ";");
            session.close();
            JOptionPane.showMessageDialog(null, "Se han actualizado los datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No ha sido posible actualizar los datos " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id, Session session) {
        session = Conexion.getConnection();
        try {
            session.execute("DELETE FROM productos WHERE id=" + id + ";");
            session.close();
            JOptionPane.showMessageDialog(null, "Se han eliminado los datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No ha sido posible eliminar los datos " + e.getMessage());
        }
    }

}
