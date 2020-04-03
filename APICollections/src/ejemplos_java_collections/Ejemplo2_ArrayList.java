package ejemplos_java_collections;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejemplo2_ArrayList {

    private static Scanner lc;

    public static void main(String[] args) {
        ArrayList<Object> listaAmigos = new ArrayList<>();

        lc = new Scanner(System.in);
        try {
            for (int i = 0; i < 10; i++) {
                listaAmigos.add(lc.next() + ":" + lc.next());
            }
            int num[] = new int[listaAmigos.size()];
            System.out.println(listaAmigos);
            System.out.println(listaAmigos.size());
            for (int i = 0; i < listaAmigos.size(); i++) {
                if (i % 2 != 0) {
                    num[i] = i;
                }
            }
            for (int i = listaAmigos.size() - 1; i > 0; i--) {
                if (num[i] != 0) {
                    listaAmigos.remove(num[i]);
                }
            }
            System.out.println(listaAmigos);
            System.out.println(listaAmigos.size());
        } catch (IndexOutOfBoundsException errorEspacio) {
            errorEspacio.printStackTrace();

        }

    }

}
