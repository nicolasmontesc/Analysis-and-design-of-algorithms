package corte2.taller4recursividad.parte2;

import java.util.Scanner;

/**
 *
 * @author Juan Nicolas
 */
public class InvertirNumero {

    // Invertir numero de manera recursiva
    public static int invertirNumeroRecursiva(int numero, int unidades) {

        if (numero < 10) { // Caso base
            return numero;
        } else {
            return (numero % 10) * (int) Math.pow(10, unidades) + (invertirNumeroRecursiva(numero / 10, unidades - 1));
        }
    }

    // Invertir numero de manera iterativa
    public static int invertirNumeroIterativa(int numero) {

        String elemento = "";

        for (int i = String.valueOf(numero).length() - 1; i >= 0; i--) {
            elemento += String.valueOf(numero).charAt(i);         
        }
        return Integer.parseInt(elemento);
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese el numero: ");
        int numero = lector.nextInt();
        System.out.print("¿Cuantas unidades tiene el numero que ingreso? ");
        int unidades = lector.nextInt();
        System.out.println("El numero invertido de manera recursiva es: " + invertirNumeroRecursiva(numero, unidades - 1));
        System.out.println("El numero invertido de manera iterativa es: " + invertirNumeroIterativa(numero));
    }
}
