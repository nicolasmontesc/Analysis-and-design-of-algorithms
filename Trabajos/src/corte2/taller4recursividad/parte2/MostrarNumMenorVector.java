package corte2.taller4recursividad.parte2;

import java.util.Scanner;

/**
 *
 * @author Juan Nicolas
 */
public class MostrarNumMenorVector {

    // Mostrar el numeo menor de forma recursiva
    public static int numeroMenorRecursivo(int[] numero, int indice, int menor) {

        if (indice != numero.length) {
            if (numero[indice] < menor) {
                menor = numeroMenorRecursivo(numero, indice + 1, numero[indice]);
            } else {
                menor = numeroMenorRecursivo(numero, indice + 1, menor);
            }
        }
        return menor;
    }

    // Mostrar el numero menor de manera iterativa
    public static int numeroMenorIterativo(int[] vector) {
        int min = vector[0];
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < min) {
                min = vector[i];
            }
        }
        return min;
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
        System.out.println("El numero menor de manera recursiva es: " + numeroMenorRecursivo(array, 0, array[0]));
        System.out.println("El numero menor de manera iterativa es: " + numeroMenorIterativo(array));
    }
}
