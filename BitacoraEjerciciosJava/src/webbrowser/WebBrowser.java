package webbrowser;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan Nicolás Montes
 */
public class WebBrowser {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        try {
            int num1 = input.nextInt();
            ArrayList<String> vector1 = new ArrayList<>();
            ArrayList<String> vector2 = new ArrayList<>();
            boolean comprobar = true;
            if (num1 >= 1 && num1 <= Math.pow(10, 4)) {

                // Comparacion
                for (int i = 0; i < num1; i++) {
                    String cadena = input.next();
                    if (cadena.length() <= 100) {
                        vector1.add(cadena);
                    } else {
                        comprobar = false;
                        break;
                    }
                }

                //Comparacion de cadenas ingresadas
                int num2 = input.nextInt();

                if (num2 >= 1 && num2 <= 100) {
                    for (int i = 0; i < num2; i++) {
                        String cadena2 = input.next();
                        if (cadena2.length() <= 100) {
                            vector2.add(cadena2);
                        } else {
                            comprobar = false;
                            break;
                        }
                    }
                }
                if (comprobar) {
                    for (int i = 0; i < vector2.size(); i++) {
                        int contador = 0;
                        int contador2 = 0;
                        for (int j = 0; j < vector1.size(); j++) {

                            if (vector1.get(j).contains(vector2.get(i))) {
                                contador += 1;
                                if (contador2 < vector1.get(j).length()) {
                                    contador2 = vector1.get(j).length();
                                }
                            }
                        }
                        if (contador != 0) {
                            System.out.println("");
                            System.out.println(contador + "  " + contador2);
                        } else {
                            System.out.println("");
                            System.out.println("-1");
                        }
                    }
                } else {
                    System.out.println("ERROR. DATOS INVALIDOS");
                }
            } else {
                System.out.println("ERROR. DATOS INVALIDOS");
            }
        } catch (Exception o) {
            System.out.println("ERROR. DATOS INVALIDOS");
        }
    }
}
