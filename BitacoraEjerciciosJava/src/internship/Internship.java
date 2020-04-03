package internship;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

/**
 *
 * @author Juan Nicolás Montes Cetina
 */
public class Internship {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        try {
            Integer contador = lector.nextInt();
            if (contador >= 1 && contador <= 40) {
                Integer num1, num2, suma = 0, suma2 = 0;
                boolean verificador = true;
                double resultado;
                for (int i = 0; i < contador; i++) {
                    num1 = lector.nextInt();
                    num2 = lector.nextInt();
                    if (num1 >= 0 && num1 <= 100 && num2 >= 30 && num2 <= 120) {
                        suma += (num1 * num2);
                        suma2 += num2;
                    } else {
                        verificador = false;
                        break;
                    }
                }
                if (verificador) {
                    System.out.println("");
                    DecimalFormatSymbols separador = new DecimalFormatSymbols();
                    separador.setDecimalSeparator('.');
                    DecimalFormat formato = new DecimalFormat("0.0000", separador);
                    System.out.println(formato.format(resultado = (double) suma / (suma2 * 100)));
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
