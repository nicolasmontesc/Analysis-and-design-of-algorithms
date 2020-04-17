package parte3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Juan Nicolas
 */
public class PalabrasRepetidasPoema {

    // Metodo contar vocales
    public static int contarVocales(String vocal, int posicion) {
        if (posicion < vocal.length()) {
            char caracter = vocal.toLowerCase().charAt(posicion);
            if (esVocal(caracter)) {
                return 1 + contarVocales(vocal, posicion + 1);
            } else {
                return contarVocales(vocal, posicion + 1);
            }
        } else {
            return 0;
        }
    }

    // Verificar si es una vocal
    public static boolean esVocal(char caracter) {
        return caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u';
    }

    // Contar Espacios
    public static int contarEspacios(String espacios) {
        if (espacios.length() == 0) {
            return 0;
        } else {
            return (espacios.charAt(0) == ' ' ? 1 : 0) + contarEspacios(espacios.substring(1)); // Si hay espacio ponga
            // "1" sino ponga "0"
        }
    }

    // Validar consonantes
    public static boolean esConsonante(char letra) {
        return "bcdfghjklmnñpqrstvwxyz".contains(String.valueOf(letra).toLowerCase());
    }

    // Contar consonantes
    public static int contarConsonantes(String palabra, int posicion) {
        if (posicion < palabra.length()) {
            char caracter = palabra.charAt(posicion);
            if (esConsonante(caracter)) {
                return 1 + contarConsonantes(palabra, posicion + 1);
            } else {
                return contarConsonantes(palabra, posicion + 1);
            }
        } else {
            return 0;
        }
    }

    // Contar letras
    public static int contarLetras(int vocales, int consonantes) {
        if (consonantes == 0) {
            return vocales;
        } else if (vocales == 0) {
            return consonantes;
        } else {
            return 1 + contarLetras(vocales, consonantes - 1);
        }
    }

    public static ArrayList<String> arreglo1 = new ArrayList<String>();
    public static ArrayList<String> arreglo2 = new ArrayList<String>();
    static String elemento;

    // Metodo para guardar palabras
    public static ArrayList<String> guardarPalabras(ArrayList<String> arreglo, String elemento, int indice, String nuevoElemento) {

        if (indice != elemento.length()) {
            if (elemento.charAt(indice) != ' ' && elemento.charAt(indice) != '\n') {
                nuevoElemento += elemento.charAt(indice);
            } else {
                if (!nuevoElemento.equals("")) {
                    arreglo.add(nuevoElemento);
                    nuevoElemento = "";
                }
            }
            guardarPalabras(arreglo, elemento, indice + 1, nuevoElemento);
        }

        return arreglo;
    }

    // Ordenar el arreglo
    public static ArrayList<String> ordenarArreglo(ArrayList<String> listaArreglo, int indice, int indice2) {
        if (indice < listaArreglo.size() - 1) {
            if (indice2 < listaArreglo.size()) {
                if (listaArreglo.get(indice).equalsIgnoreCase(listaArreglo.get(indice2))
                        || listaArreglo.get(indice2).equals("")) {
                    listaArreglo.remove(indice2);
                    indice2 = indice + 1;
                    ordenarArreglo(listaArreglo, indice, indice2);
                }
                indice2++;
                ordenarArreglo(listaArreglo, indice, indice2);
            } else {
                indice++;
                indice2 = indice + 1;
                ordenarArreglo(listaArreglo, indice, indice2);
            }
        }
        return listaArreglo;
    }

    // Metodo para contar palabras 
    public static String contarPalabras(ArrayList<String> listaArreglo, ArrayList<String> listaArreglo2, int contador,int indice, int indice2) {
        if (indice < listaArreglo.size()) {
            if (indice2 < listaArreglo2.size()) {
                if (listaArreglo.get(indice).equalsIgnoreCase(listaArreglo2.get(indice2))) {
                    contador++;
                }
                indice2++;// recorrer el arreglo con las palabras repetidas
                contarPalabras(listaArreglo, listaArreglo2, contador, indice, indice2);
            } else {
                elemento = "("+listaArreglo.get(indice)+") esta repetida: " + String.valueOf(contador)
                        + " veces";
                System.out.println(elemento);
                indice2 = 0;
                contador = 0;
                indice++;// Se recorre el arreglo sin las palbras repetidas
                contarPalabras(listaArreglo, listaArreglo2, contador, indice, indice2);
            }
        }
        return elemento;
    }


    public static void main(String[] args) {
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        String linea;
        String poema = "";
        try {
            // Apertura del fichero 
            archivo = new File("Poema.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            while ((linea = br.readLine()) != null) {
                poema += linea + "\n";
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
        System.out.println("Poema Cientifico: El Corazón \n \n" + poema);
        System.out.println("Cantidad de vocales: " + contarVocales(poema, 0));
        System.out.println("Cantidad de espacios: " + contarEspacios(poema));
        System.out.println("Cantidad de consonantes: " + contarConsonantes(poema, 0));
        System.out.println("Cantidad de letras: " + contarLetras(contarVocales(poema, 0), contarConsonantes(poema, 0)));
        guardarPalabras(arreglo1, poema, 0, "");
        ordenarArreglo(arreglo1, 0, 1);
        guardarPalabras(arreglo2, poema, 0, "");
        System.out.println("");
        contarPalabras(arreglo1, arreglo2, 0, 0, 0);
    }
}
