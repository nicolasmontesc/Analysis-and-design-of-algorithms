package Usb.modelo;

public class Pais {

    public String nombre;
    public int numeroContagiados;
    public int numeroMuertos;

    public Pais(String nombre, int numeroContagiados, int numeroMuertos) {
        this.nombre = nombre;
        this.numeroContagiados = numeroContagiados;
        this.numeroMuertos = numeroMuertos;
    }

    public Pais() {
        this.nombre = "";
        this.numeroContagiados = 0;
        this.numeroMuertos = 0;
    }

  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroContagiados() {
        return numeroContagiados;
    }

    public void setNumeroContagiados(int numeroContagiados) {
        this.numeroContagiados = numeroContagiados;
    }

    public int getNumeroMuertos() {
        return numeroMuertos;
    }

    public void setNumeroMuertos(int numeroMuertos) {
        this.numeroMuertos = numeroMuertos;
    }

    public String toStringContagios() {
        return "\n"
                + nombre + ": \n"
                + numeroContagiados+ " contagiados \n"
                + "________________________________";
    }

    public String toStringMuertos() {
        return "\n"
                + nombre + ": \n"
                + numeroMuertos +" muertos \n"
                + "________________________________";
    }

}
