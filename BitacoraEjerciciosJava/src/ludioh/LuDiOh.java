package ludioh;

import java.util.Scanner;

/**
 *
 * @author Juan Nicolás Montes
 */
public class LuDiOh {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        //Ingresa el numero de atributos de las cartas 
        int atributos = input.nextInt();
        int cartasMarco = input.nextInt();
        int cartasLeo = input.nextInt();

        int marcos[][] = new int[cartasMarco][atributos];
        int leo[][] = new int[cartasLeo][atributos];

        for (int i = 0; i < cartasMarco; i++) {
            for (int j = 0; j < atributos; j++) {
                marcos[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < cartasLeo; i++) {
            for (int j = 0; j < atributos; j++) {
                leo[i][j] = input.nextInt();
            }
        }

        int cartElegida1 = input.nextInt(); // carta elegida por Marco
        int cartElegida2 = input.nextInt(); // carta elegida por Leonardo

        int arrayMarcos[] = new int[atributos];
        int arrayLeo[] = new int[atributos];

        for (int i = 0; i < arrayMarcos.length; i++) {
            arrayMarcos[i] = marcos[cartElegida1 - 1][i];
            arrayLeo[i] = leo[cartElegida2 - 1][i];
        }
        int atributoElegido = input.nextInt();

        if (arrayMarcos[atributoElegido - 1] > arrayLeo[atributoElegido - 1]) {
            System.out.println("Marco");
        } else if (arrayMarcos[atributoElegido - 1] < arrayLeo[atributoElegido - 1]) {
            System.out.println("Leonardo");
        } else {
            System.out.println("Empate");
        }
    }

}
