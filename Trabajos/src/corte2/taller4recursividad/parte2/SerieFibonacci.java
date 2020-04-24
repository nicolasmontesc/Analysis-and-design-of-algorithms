package corte2.taller4recursividad.parte2;

import java.util.Scanner;

/**
 *
 * @author Juan Nicolas
 */
public class SerieFibonacci {

    // Metodo Fibonacci de manera recursiva
    public static int fibonacciRecursivo(int numero) {
        if (numero <= 1) { // Caso base
            return numero;
        }
        return fibonacciRecursivo(numero - 1) + fibonacciRecursivo(numero - 2);
    }

    // Metodo Fibonacci de manera iterativa
    public static int fibonacciIterativo(int numero) {
        if (numero <= 1) {
            return numero;
        }
        int fibonacci = 1;
        int fibonacciAnterior = 1;

        for (int i = 2; i < numero; i++) {
            int temporal = fibonacci;
            fibonacci += fibonacciAnterior;
            fibonacciAnterior = temporal;
        }
        return fibonacci;
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese el numero: ");
        int numero = lector.nextInt();
        System.out.println("La serie fibonacci de manera recursiva es: " + fibonacciRecursivo(numero));
        System.out.println("La serie fibonacci de manera iterativa es: " + fibonacciIterativo(numero));
    }
}
