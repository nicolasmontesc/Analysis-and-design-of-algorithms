package corte2.taller4recursividad.parte2;

import java.util.Scanner;

/**
 *
 * @author Juan Nicolas
 */
public class SumarElementosVector {

    //Sumar los elementos de un vector de manera recursiva
    public static int sumaVectorRecursiva(int inicio, int fin, int[] array) {
        if (inicio == fin) {
            return array[inicio];
        } else {
            int mitad = (inicio + fin) / 2;
            int x = sumaVectorRecursiva(inicio, mitad, array);
            int y = sumaVectorRecursiva(mitad + 1, fin, array);
            return x + y;
        }
    }

    //Suma los elementos de un vector de manera iterativa
    public static int sumaVectorIterativa(int array[]) {
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("¿Cuantos numeros quiere ingresar?");
        int n = input.nextInt();
        int[] array = new int[n];

        System.out.println("Llenando el arreglo");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + i + "]" + "= ");
            array[i] = input.nextInt();
        }
        System.out.println("La suma de los elementos del vector de manera recursiva es: " + sumaVectorRecursiva(0, array.length - 1, array));
        System.out.println("La suma de los elementos del vector de manera iterativa es: " + sumaVectorIterativa(array));
    }
}
