package corte2.taller4recursividad.parte3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan Nicolas
 */
public class Permutaciones {

    public static String arr[];
    public static ArrayList<String> arrayList = new ArrayList<String>();

    public static String[] convertirArreglo(String[] arreglo, String cadena, int indice) {

        if (indice < arreglo.length) {
            arreglo[indice] = String.valueOf(cadena.charAt(indice));
            indice++;
            return convertirArreglo(arreglo, cadena, indice);
        }
        return arreglo;
    }

    public static void imprmirArreglo(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("[" + arr[i] + "]");
        }
    }

    public static void imprimirArrayList(ArrayList array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println("[" + array.get(i) + "]");
        }
    }

    public static ArrayList permutacion(ArrayList array, String[] vector, String auxiliar, int base, int permutado, int indice) {
        if (base == 0) {
            array.add(auxiliar);
        } else {
            if (indice != permutado) {
                if (!auxiliar.contains(vector[indice])) {

                    permutacion(array, vector, auxiliar + vector[indice], base - 1, permutado, 0);
                }
                permutacion(array, vector, auxiliar, base, permutado, indice + 1);
            }
            return array;
        }
        return array;
    }

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el elemento");
        String cadena = lector.next();
        arr = new String[cadena.length()];
        convertirArreglo(arr, cadena, 0);
        imprmirArreglo(arr);
        permutacion(arrayList, arr, "", arr.length, arr.length, 0);
        imprimirArrayList(arrayList);
    }
}
