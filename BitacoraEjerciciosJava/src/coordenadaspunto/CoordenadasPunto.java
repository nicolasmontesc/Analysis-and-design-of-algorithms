package coordenadaspunto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Juan Nicolás Montes
 */
public class CoordenadasPunto {

    public static void main(String[] args) {

        //Se define el lector 
        Scanner lector = new Scanner(System.in);

        try {
            //Se definen las variables
            float x, y;

            //Se definen los lectores de cada variable 
            x = lector.nextFloat();
            y = lector.nextFloat();

            //Condiciones para saber el cuadrante en el que se encuentra el punto
            if (x > 0 && y < 0) {
                System.out.println("Q4");
            } else if (x > 0 && y > 0) {
                System.out.println("Q1");
            } else if (x < 0 && y < 0) {
                System.out.println("Q3");
            } else if (x < 0 && y > 0) {
                System.out.println("Q2");
            } else if (x == 0 && y == 0) {
                System.out.println("Origen");
            } else if (x == 0 && y < 0 || y > 0) {
                System.out.println("Eje Y");
            } else if (y == 0 && x < 0 || x > 0) {
                System.out.println("Eje X");
            }
        } catch (InputMismatchException a) {
            System.out.println("¡ERROR! CARACTER INVALIDO. SOLO SE PUEDEN INGRESAR NUMEROS.");
        }
    }
}
