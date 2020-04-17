package parte2;

import java.util.Scanner;

/**
 *
 * @author Juan Nicolas
 */
public class NumeroFactorial {

    // Metodo para calcular el numero factorial de manera recursiva
    public static int factorialRecursivo(int numero) {
        int respuesta;
        if (numero == 1) { // Condicion Base
            return 1;
        } else {
            respuesta = factorialRecursivo(numero - 1) * numero; // Llamada recursiva
        }
        return respuesta;
    }

    // Metodo para calcular el numero factorial de manera iterativa
    public static int factorialIterativo(int numero) {

        int respuesta = 1;
        for (int i = 1; i < numero; i++) // Iteración
        {
            respuesta = respuesta * (i + 1);
        }
        return respuesta;
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese el numero: ");
        int numero = lector.nextInt();
        System.out.println("El numero factorial de manera recursiva es: " + factorialRecursivo(numero));
        System.out.println("El numero factorial de manera iterativa es: " + factorialIterativo(numero));
    }
}
