package parte3;

/**
 *
 * @author Juan Nicolas
 */
public class TorreDeHanoi {

    static int contador = 0;

    public static void main(String[] args) {
        torresHanoi(4, 1, 2, 3);
        System.out.println("Juego Completado\n" + "Cantidad de movimientos: " + contador);

    }

    public static void torresHanoi(int discos, int origen, int auxiliar, int destino) {
        // Caso base

        if (discos == 1) {
            System.out.println("Mover disco " + discos + " de Torre " + origen + " a Torre " + destino);
        } else {
            
            torresHanoi(discos - 1, origen, destino, auxiliar);
            System.out.println("Mover disco " + discos + " de Torre " + origen + " a Torre " + destino);
            torresHanoi(discos - 1, auxiliar, origen, destino);
        }
        contador++;
    }
}
