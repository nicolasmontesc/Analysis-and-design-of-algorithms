package corte1.ejerciciosdemaraton;

import java.util.Scanner;

public class WalkingInTime {

    private static Scanner entrada;

    public static void main(String[] args) {

        entrada = new Scanner(System.in);

        int viaje1 = entrada.nextInt();
        int viaje2 = entrada.nextInt();
        int viaje3 = entrada.nextInt();

        if ((viaje1 + viaje2) == viaje3) {
            System.out.println("S");

        } else if ((viaje2 + viaje3) == viaje1) {
            System.out.println("S");

        } else if ((viaje1 + viaje3) == viaje2) {
            System.out.println("S");

        } else if (viaje1 == viaje2) {
            System.out.println("S");

        } else if (viaje2 == viaje3) {
            System.out.println("S");

        } else if (viaje1 == viaje3) {
            System.out.println("S");

        } else {
            System.out.println("N");
        }

    }

}
