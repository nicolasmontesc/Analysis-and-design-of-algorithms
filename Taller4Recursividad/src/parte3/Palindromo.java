package parte3;

import java.util.Scanner;

/**
 *
 * @author Juan Nicolas
 */
public class Palindromo {

    public static String esPalindromo(String palabra) {
        if (palabra.length() <= 1) {
            return "La palabra es Palidromo";
        } else {
            
            if (palabra.charAt(0) == palabra.charAt(palabra.length() - 1)) { // Si la letra de la posicion inicial 0 es
                // igual a la letra de la ultima
                return esPalindromo(palabra.substring(1, palabra.length() - 1));// Se evalua el substring con la misma

            } else {
                return "La palabra no es Palidromo";
            }
        }
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Por favor ingrese la palabra a evaluar: ");
        String cadena = lector.next();
        System.out.println(esPalindromo(cadena));
    }
}
