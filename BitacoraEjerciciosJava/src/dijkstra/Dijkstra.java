package dijkstra;

import static dijkstra.Dijkstra.input;
import static dijkstra.Dijkstra.tesoro;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan Nicolás Montes
 */
public class Dijkstra {

    static Scanner input = new Scanner(System.in);
    static ArrayList<String> tesoro = new ArrayList<>();

    private static void addJoya(String joya) {
        if (!verificarJoya(joya)) {
            tesoro.add(joya);
        }
    }

    private static boolean verificarJoya(String joya) {
        for (int i = 0; i < tesoro.size(); i++) {
            if (joya.equals(tesoro.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String joya = input.next();
        while (joya.contains("(") || joya.contains(")")) {
            addJoya(joya);
            joya = input.next();
        }
        System.out.println(tesoro.size());
    }
} 
