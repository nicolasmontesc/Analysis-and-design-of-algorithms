package parte2;

import java.util.Scanner;

/**
 *
 * @author Juan Nicolas
 */
public class BuscarElementoString {

    // Metodo para buscar una un elemento tipo String de manera recursiva
    public static boolean buscarElementoRecursivo(String[][] matriz, String elemento, int recorridoFilas,
            int recorridoColumnas) {
        if (matriz[recorridoFilas][recorridoColumnas].equalsIgnoreCase(elemento)) {
            return true;
        } else {
            if (recorridoFilas != matriz.length - 1 || recorridoColumnas != matriz.length - 1) {
                if (recorridoColumnas == matriz.length - 1) {
                    recorridoFilas++;
                    recorridoColumnas = 0;
                } else {
                    recorridoColumnas++;
                }
                return buscarElementoRecursivo(matriz, elemento, recorridoFilas, recorridoColumnas);
            }
            return false;
        }
    }

    // Metodo para buscar una un elemento tipo String de manera iterativa
    public static boolean buscarElementoIterativo(String[][] matriz, String elemento) {
        boolean verificador = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j].equalsIgnoreCase(elemento)) {
                    verificador = true;
                    break;
                }
            }
        }
        return verificador;
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del vector");
        int tam = lector.nextInt();
        String matriz[][] = new String[tam][tam];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("Digite el elemento de la posición " + i + j + " de la matriz");
                String elemento = lector.next();
                matriz[i][j] = elemento;
            }
        }

        System.out.println("Ingrese el elemento que desea buscar en el vector");
        String cadena = lector.next();
        System.out.println("La validacion del elemento [" + cadena + "] de manera recursiva es: " + buscarElementoRecursivo(matriz, cadena, 0, 0));
        System.out.println("La validacion del elemento [" + cadena + "] de manera iterativa es: " + buscarElementoIterativo(matriz, cadena));
    }
}
