package testeo;

import bo.Productos_BO;
import modelo.Productos;

/**
 *
 * @author Juan Nicolas
 */
public class Test {

    Productos_BO productosBO = new Productos_BO();
    Productos productos = new Productos();

    public void insertar() {
        productos.setId(8);
        productos.setCantidad(5);
        productos.setCosto(200000);
        productos.setDia_venta("6/12/2020");
        productos.setFecha_vencimiento("6/12/2021");
        productos.setMarca("Alqueria");
        productos.setNombre("Helado");
        productos.setPeso("Litros");
        productosBO.crear(productos);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.insertar();
    }
}
