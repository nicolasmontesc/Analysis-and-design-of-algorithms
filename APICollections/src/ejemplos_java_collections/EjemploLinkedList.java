package ejemplos_java_collections;

import java.util.LinkedList;

public class EjemploLinkedList {

    public static void main(String[] args) {
        // EJEMPLOS LISTAS EN JAVA
        // crear lista Doblemente enlazada

        LinkedList<String> listaPeliculas = new LinkedList<>();
        try {
            listaPeliculas.add("La vida es bella");
            listaPeliculas.add(1, "Los pitufos");
            listaPeliculas.add("Los magnificos");
            listaPeliculas.remove(2);
            listaPeliculas.remove("Los pitufos");
            System.out.println("El tamaño es " + listaPeliculas.size());

            // IF
            String res = (listaPeliculas.isEmpty()) ? "esta vacia" : "No esta vacia";
            System.out.println(res);

            String estaPeli = (listaPeliculas.contains("Advengers")) ? "Si esta" : "No esta";
            System.out.println(estaPeli);

            // imrpimir
            for (String peli : listaPeliculas) {
                System.out.println(peli + "***");
            }

        } catch (IndexOutOfBoundsException errorEspacio) {
            System.err.print("Error al dejar un nodo de la lista enlazada con espacio");
            // errorEspacio.printStackTrace();
        } catch (ArithmeticException error) {
            error.printStackTrace();

        }

    }

}
