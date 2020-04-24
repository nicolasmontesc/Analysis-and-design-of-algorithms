package corte1.quiz;

import java.util.Scanner;

public class ElectricalOutlet { //Quiz

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int resta1;

        try {
            int t1 = lector.nextInt();
            int t2 = lector.nextInt();
            int t3 = lector.nextInt();
            int t4 = lector.nextInt();
            if ((t1 <= 2 && t1 <= 6) && (t2 <= 2 && t2 <= 6) && (t3 <= 2 && t3 <= 6) && (t4 <= 2 && t4 <= 6)) {
                resta1 = (t1 + t2 - 1) + (t3 - 1) + (t4 - 1);
                System.out.println(resta1);
            }
        } catch (Exception InputMismatchException) {
        }
    }

}
