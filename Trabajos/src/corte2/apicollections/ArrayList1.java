package corte2.apicollections;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList1 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Amigo> listaAmigos = new ArrayList<>();
        int j = 0;
        while (j < 10) {
            Amigo p = new Amigo(s.next(), s.nextInt());
            listaAmigos.add(p);
            j++;
        }
        imprimir(listaAmigos);
        for (int i = listaAmigos.size(); i >= 0; i--) {
            if (i % 2 != 0) {
                listaAmigos.remove(i);
            }
        }
        imprimir(listaAmigos);
        System.out.println(" TAMAÑO LISTA = " + listaAmigos.size());
    }

    private static void imprimir(ArrayList<Amigo> listaJuegos) {
        System.out.println("-----------LISTA PERSONAS-------------");
        for (Amigo elemento : listaJuegos) {
            System.out.println(" - " + elemento.toString());
        }
    }

}

class Amigo {

    String nombre;
    int edad;

    public Amigo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "NOMBRE : " + nombre + " - EDAD : " + edad + " AÑOS";
    }
}
