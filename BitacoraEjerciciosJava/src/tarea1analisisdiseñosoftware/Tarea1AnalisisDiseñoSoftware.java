package tarea1analisisdiseñosoftware;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

/**
 *
 * @author Juan Nicolás Montes Cetina
 */
public class Tarea1AnalisisDiseñoSoftware {

    public static void main(String[] args) {
        //Aca se esta inicializando un  scanner
        Scanner lector = new Scanner(System.in);
        //Aca se estan definiendo las variables para luego hacer operaciones
        int h, vm; //h: hora y vm: velocidad media 
        float r; //r: resultado de operacion
        //Se define una constante (siempre en mayuscula)
        final int CL= 12;//Cantidad de litro 
        //Se definen los lectores, uno para hora y el otro para la velocidad media (enteros)
        h = lector.nextInt();
        vm = lector.nextInt();
        //Operacion para hallae los litros de combustible necesarios para el viaje
        r= (float) (h * vm) / CL;
        DecimalFormatSymbols sP= new DecimalFormatSymbols(); //sP: separador personalizado 
        sP.setDecimalSeparator('.'); //se asigna un punto al formato decinal
        DecimalFormat f = new DecimalFormat(".000", sP); //".000": significa que see imprimiran tres numeros despues del punto f: variable asiganada al formato decimal 
        System.out.println(f.format(r));
    }
}
