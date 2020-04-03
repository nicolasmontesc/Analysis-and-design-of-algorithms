package promediotres;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Juan Nicolás Montes
 */
public class PromedioTres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Se define el lector
        Scanner lector = new Scanner(System.in);
        try {
            //Se definen el tipo de variables
            double nota1, nota2, nota3, nota4, media, notaexamen, promediofinal;

            //Se definen los lectores de cada variable
            nota1 = lector.nextDouble();
            nota2 = lector.nextDouble();
            nota3 = lector.nextDouble();
            nota4 = lector.nextDouble();

            //Condiciones 
            if (nota1 >= 0 && nota2 >= 0 && nota3 >= 0 && nota4 >= 0) {
                //Metodo para hallar la media (promedio)
                media = (nota1 * 2 + nota2 * 3 + nota3 * 4 + nota4 * 1) / (2 + 3 + 4 + 1);
                DecimalFormat f = new DecimalFormat("#.0");
                System.out.println("Media: " + f.format(media));
                if (media >= 7.0) {
                    System.out.println("Estudiante aprobado");
                }
                if (media < 5.0) {
                    System.out.println("Estudiante reprobado");
                }
                if (media >= 5.0 && media <= 6.9) {
                    System.out.println("Estudiante en examen");
                    notaexamen = lector.nextDouble();
                    if (notaexamen >= 0) {
                        System.out.println("Nota del examen: " + notaexamen);
                        promediofinal = (media + notaexamen) / 2;
                        if (promediofinal >= 5.0) {
                            System.out.println("Estudiante aprobado");
                        } else {
                            System.out.println("Estudiante reprobado");
                        }
                        System.out.println("Media final: " + promediofinal);
                    } else {
                        System.out.println("¡ERROR! EL DATO INGRESADO ES INCORRECTO");
                    }
                }
            } else {
                System.out.println("¡ERROR! EL DATO INGRESADO ES INCORRECTO");
            }
        } catch (InputMismatchException a) {
            System.out.println("¡ERROR! EL DATO INGRESADO ES INCORRECTO");
        }
    }
}
