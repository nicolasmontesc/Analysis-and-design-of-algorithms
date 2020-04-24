package corte2.apicollections;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue1 {

    public static void main(String[] args) {

        Queue<Persona> cola = new PriorityQueue<Persona>();

        cola.add(new Persona("Nicolas", 80));
        cola.add(new Persona("Dimate", 19));
        cola.add(new Persona("Juan cetina", 3));
        cola.add(new Persona("Ariel ", 26));

        while (!cola.isEmpty()) {
            Persona a = cola.remove();
            System.err.println(a.getNombre() + " " + a.getEdad());

        }

    }

}

class Persona implements Comparable<Persona> {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(Persona o) {
        if (edad < o.getEdad()) {
            return 1;
        } else if (edad > o.getEdad()) {
            return -1;
        } else {
            return 0;
        }
    }
}
