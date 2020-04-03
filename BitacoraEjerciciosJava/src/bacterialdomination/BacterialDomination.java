package bacterialdomination;

import java.util.Scanner;

/**
 *
 * @author Juan Nicolás Montes
 */
public class BacterialDomination {

    public static void main(String[] args) {

        Scanner e = new Scanner(System.in);
        int bacteriasExpuestas = e.nextInt();
        for (int i = 0; i < bacteriasExpuestas; i++) {
            int area = e.nextInt();
            int[][] matriz = new int[area][area];

            //Realizar cuadrícula
            for (int j = 0; j < matriz.length; j++) {
                for (int k = 0; k < matriz.length; k++) {
                    matriz[j][k] = e.nextInt();
                }
            }

            //Ciclo para sumar "1"
            int contador1 = 0;
            for (int j = 0; j < matriz.length; j++) {
                for (int k = 0; k < matriz.length; k++) {
                    if (matriz[j][k] == 1) {
                        contador1 += 1;
                    }
                }
            }

            int contador2 = 0;
            for (int j = 0; j < matriz.length; j++) {
                for (int k = 0; k < matriz.length; k++) {
                    if (matriz[j][k] == 1) {
                        if (k + 1 < matriz.length) {
                            if (matriz[j][k + 1] == 0) {
                                if (verificarCeros(matriz, j, k + 1)) {
                                    k = k + 1;
                                    if (k < matriz.length) {
                                        contador2 = contador2 + sumarCeros(matriz, j, k);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.printf("%n%.2f", diviision(contador1, contador2));
        }
        System.out.println("\n");
    }

    static double diviision(int sumaUnos, int sumaCeros) {
        return (double) (sumaUnos + sumaCeros) / 2;
    }

    static int sumarCeros(int matriz[][], int posicion1, int posicion2) {
        int contador = 0;
        for (int i = posicion2; i < matriz.length; i++) {
            if (matriz[posicion1][i] == 0) {
                if (verificarCeros(matriz, posicion1, i)) {
                    contador += 1;
                } else {
                    contador = 0;
                    i = matriz.length;
                }
            } else {
                i = matriz.length;
            }
        }
        return contador;
    }

    static boolean verificarCeros(int matriz[][], int posicion1, int posicion2) {
        boolean verificador = false;
        for (int i = posicion2; i < matriz.length; i++) {

            if (matriz[posicion1][i] == 1) {

                i = matriz.length;

                //Proceso para evaluar si arriba del 0 hay un 1, si j es -1 sale del bucle.
                for (int j = posicion1 - 1; j >= 0; j--) {

                    if (matriz[j][posicion2] == 1) {

                        j = -1;

                        for (int k = posicion1 + 1; k < matriz.length; k++) {

                            if (matriz[k][posicion2] == 1) {

                                k = matriz.length + 1;

                                verificador = true;
                            }
                        }
                    }
                }
            }
        }
        return verificador;
    }
}
