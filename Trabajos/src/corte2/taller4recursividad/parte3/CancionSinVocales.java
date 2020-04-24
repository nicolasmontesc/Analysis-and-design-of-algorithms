package corte2.taller4recursividad.parte3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Juan Nicolas
 */
public class CancionSinVocales {

    static String f = null;

    public static void main(String[] args) {

        File archivo;
        FileReader fr = null;
        BufferedReader br;
        String linea;
        String cancion = "";
        String sinVocales;

        try {
            // Apertura del fichero
            archivo = new File("Cancion.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            System.out.println("Cash Machine - Oliver Tree");
            // Se lee el fichero
            while ((linea = br.readLine()) != null) {
                
                System.out.println(linea);// Imprimir Cancion por parrafos
                cancion += linea;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                System.out.println(e2.getMessage());
            }
        }
        
        System.out.println("");
        System.out.println("Cancion con vocales");
        System.out.println(cancion);
        System.out.println("");
        eliminarVocal(cancion, 0);
        sinVocales = eliminarVocal(cancion, 0);
        System.out.println("Cancion sin vocales");
        System.out.println(sinVocales);

        try {
            FileWriter fw = new FileWriter("D:\\Cancion sin vocales.txt");
            fw.write(sinVocales);
            fw.close();
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }
    
    // Metodo eliminar vocal
    public static String eliminarVocal(String a, int i) {
        // String f;//Variable que recepciona la nueva cadena generada.
        if (i != a.length()) { // Condición base.
            if (a.charAt(i) == 'a' || a.charAt(i) == 'e' || a.charAt(i) == 'i' || a.charAt(i) == 'o'
                    || a.charAt(i) == 'u') {
                f = a.substring(0, i) + "" + a.substring(i + 1, a.length());
                eliminarVocal(f, i);
            } else {
                eliminarVocal(a, i + 1);
            }
        }
        return f;
    }
}
