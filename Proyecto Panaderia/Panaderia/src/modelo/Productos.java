package modelo;

import java.util.Objects;

/**
 *
 * @author Juan Nicolas
 */
public class Productos {

    private int id;
    private String nombre;
    private String marca;
    private int cantidad;
    private String peso;
    private int costo;
    private String dia_venta;
    private String fecha_vencimiento;

    public Productos(int id, String nombre, String marca, int cantidad, String peso, int costo, String fecha_vencimiento, String dia_venta) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.cantidad = cantidad;
        this.peso = peso;
        this.costo = costo;
        this.fecha_vencimiento = fecha_vencimiento;
        this.dia_venta = dia_venta;
    }

    public Productos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getDia_venta() {
        return dia_venta;
    }

    public void setDia_venta(String dia_venta) {
        this.dia_venta = dia_venta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.marca);
        hash = 47 * hash + this.cantidad;
        hash = 47 * hash + Objects.hashCode(this.peso);
        hash = 47 * hash + this.costo;
        hash = 47 * hash + Objects.hashCode(this.fecha_vencimiento);
        hash = 47 * hash + Objects.hashCode(this.dia_venta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Productos other = (Productos) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.costo != other.costo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.peso, other.peso)) {
            return false;
        }
        if (!Objects.equals(this.fecha_vencimiento, other.fecha_vencimiento)) {
            return false;
        }
        if (!Objects.equals(this.dia_venta, other.dia_venta)) {
            return false;
        }
        return true;
    }

}
