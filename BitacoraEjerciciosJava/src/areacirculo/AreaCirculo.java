package areacirculo;
import java.util.Scanner;
/**
 *
 * @author Juan Nicolás Montes
 */
public class AreaCirculo {

    public static void main(String[] args) {
        //Inicializacion de Scanner 
        Scanner lector = new Scanner(System.in);
        //Variables
        double area, radio;
        //Constante
        final double PI = 3.14159;
        //Se definen los lectores
        radio = lector.nextDouble();
        //Operacion 
        area = (double)(PI)*(Math.pow(radio,2));
        System.out.printf("A= "+"%.4f%n", area);
    }
}
