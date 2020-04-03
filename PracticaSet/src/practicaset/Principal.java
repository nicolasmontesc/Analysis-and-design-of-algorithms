package practicaset;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
/**
 *
 * @author Juan Nicolás Montes Cetina
 */
public class Principal {

    public static void main(String[] args) {
        Set<Integer> personas = new HashSet<Integer>();

        /**
         * HashSet: No duplicados + No se almacenan en orden específico.
         */
        personas.add(15);
        personas.add(30);
        personas.add(115);// repetido
        personas.add(21);
        personas.add(56);
        personas.add(115);// repetido

        System.out.println("*** Ejemplo HashSet *****");
        for (Integer iterador : personas) {
            System.out.print(iterador + "-");
        }
        System.out.println("");

        /**
         * LinkedHashSet = No duplicados + Elementos quedan en el orden que los
         * inserto
         */
        Set<Integer> mascotas = new LinkedHashSet<Integer>();

        mascotas.add(2);//repetido
        mascotas.add(2);//repetido
        mascotas.add(5);
        mascotas.add(8);
        mascotas.add(100);
        mascotas.add(-5);

        System.out.println("**** Ejemplo LinkedHashSet ****");
        for (Integer inter : mascotas) {
            System.out.print(inter + "-");
        }
        System.out.println("");

        Set<Integer> noviaJimmy = new TreeSet<Integer>();
        noviaJimmy.add(20);
        noviaJimmy.add(40);//Repetido
        noviaJimmy.add(40);//Repetido
        noviaJimmy.add(40);//Repetido
        noviaJimmy.add(25);
        noviaJimmy.add(15);
        noviaJimmy.add(19);
        noviaJimmy.add(35);
        noviaJimmy.add(35);
        noviaJimmy.add(35);

        noviaJimmy.remove(1);//Eliminar un 40
        noviaJimmy.remove(1);//Desplaza y elimina

        System.out.println("**** Ejemplo TreeSet ****");
        for (Integer inter : noviaJimmy) {
            System.out.print(inter + "-");
        }
        System.out.println("");

        System.out.println("Cuantas novias no repetidas por edad tiene Jimmy :" + noviaJimmy.size());

        String valor = (noviaJimmy.contains(35)) ? "Si" : "No";
        System.out.println(valor);

        /**
         * SortedSet = Interfaz de la collection de java extiende de set
         * Proporciona un orden total a sus elementos Sort = Ordenamiento -
         * QuickSort
         */
        SortedSet<String> videoJuegos = new TreeSet<>();
        videoJuegos.add("Doom");
        videoJuegos.add("Gears of war");
        videoJuegos.add("Doom");
        videoJuegos.add("bdz");
        videoJuegos.add("Star wars");
        videoJuegos.add("Assassin's creed");
        videoJuegos.add("fifa 2020");
        videoJuegos.add("call of dutty");
        videoJuegos.add("lol");
        
        System.out.println("Sorted set" + videoJuegos);
        System.out.println("First game: "+videoJuegos.first());
        System.out.println("Last game: "+videoJuegos.last());
    }
}