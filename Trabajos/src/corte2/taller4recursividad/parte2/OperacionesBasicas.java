package corte2.taller4recursividad.parte2;

import java.util.Scanner;

/**
 *
 * @author Juan Nicolas
 */
public class OperacionesBasicas {

    // Suma de manera recursiva
    public static int sumaRecursiva(int numero1, int numero2) {
        if (numero2 == 0) {
            return numero1;
        } else if (numero1 == 0) {
            return numero2;
        } else {
            return 1 + sumaRecursiva(numero1, numero2 - 1);
        }
    }

    // Suma de manera iterativa
    public static int sumaIterativa(int numero1, int numero2) {
        int sumar = numero1 + numero2;
        return sumar;
    }

    // Resta de manera recursiva
    static int restaRecursiva(int numero1, int numero2) {
        if (numero1 > numero2) {
            return 1 + restaRecursiva(numero1, numero2 + 1);
        }
        if (numero2 > numero1) {
            return -1 + restaRecursiva(numero1 + 1, numero2);
        } else {
            return 0;
        }
    }

    // Resta de manera iterativa
    public static int restaIterativa(int numero1, int numero2) {
        int restar = numero1 - numero2;
        return restar;
    }

    // Multiplicacion de manera recursiva
    public static int multiplicacionRecursiva(int numero1, int numero2) {
        if (numero2 == 1) {
            return numero1;
        } else {
            return numero1 + multiplicacionRecursiva(numero1, numero2 - 1);
        }
    }

    // Multiplicacion de manera iterativa
    public static int multiplicacionIterativa(int numero1, int numero2) {
        int multiplicar = numero1 * numero2;
        return multiplicar;
    }

    // Dividision de manera recursiva
    private static int divisionRecursiva(int numero1, int numero2) {
        if (numero2 > numero1) {
            return 0;
        } else {
            return 1 + divisionRecursiva(numero1 - numero2, numero2);
        }
    }

    // Division de manera iterativa
    public static int divisionIterativa(int numero1, int numero2) {
        int dividir = numero1 / numero2;
        return dividir;
    }

    // Potenciacion de manera recursiva
    private static int potenciaRecursiva(int numero1, int numero2) {
        if (numero2 == 0) {
            return 1;
        } else {
            return numero1 * potenciaRecursiva(numero1, numero2 - 1);
        }
    }

    // Potenciacion de manera iterativa
    public static int potenciaIterativa(int numero1, int numero2) {
        int potenciar = (int) Math.pow(numero1, numero2);
        return potenciar;
    }

    public static void main(String[] args) {
        
        Scanner lector = new Scanner(System.in);
        
        System.out.print("Ingrese el primer numero: ");
        
        int numero1 = lector.nextInt();
        
        System.out.print("Ingrese el segundo numero: ");
        
        int numero2 = lector.nextInt();

        System.out.println("La suma de manera recursiva es: " + sumaRecursiva(numero1, numero2));
        System.out.println("La suma de manera iterativa es: " + sumaIterativa(numero1, numero2));

        System.out.println("La resta de manera recursiva es: " + restaRecursiva(numero1, numero2));
        System.out.println("La resta de manera iterativa es: " + restaIterativa(numero1, numero2));

        System.out.println("La multiplicacion de manera recursiva es: " + multiplicacionRecursiva(numero1, numero2));
        System.out.println("La multiplicacion de manera iterativa es: " + multiplicacionIterativa(numero1, numero2));

        System.out.println("La división de manera recursiva es: " + divisionRecursiva(numero1, numero2));
        System.out.println("La división de manera iterativa es: " + divisionIterativa(numero1, numero2));

        System.out.println(numero1 + " elevado a la " + numero2 + " de manera recursiva es: " + potenciaRecursiva(numero1, numero2));
        System.out.println(numero1 + " elevado a la " + numero2 + " de manera iterativa es: " + potenciaIterativa(numero1, numero2));
    }
}
