package ejemplos_java_collections;

import java.util.ArrayList;

public class Ejemplo3_ArrayLIst {

	public static void main(String[] args) {
		// EJEMPLOS LISTAS EN JAVA
		// crear lista
		ArrayList<String> listaJuegos = new ArrayList<String>();

		// agregar elementos a la lista
		listaJuegos.add("Rise of nations");
		listaJuegos.add("Halo");
		listaJuegos.add(" Medal of Honor ");
		listaJuegos.add("FIFA 2020");
		listaJuegos.add(" Max payne ");

		listaJuegos.add(5, "FORZA"); // agregar por indice
		listaJuegos.remove(2); // eliminar por elemento
		// listaJuegos.remove(listaJuegos); // Eliminar collection

		// Ver cantidad de elementos de la lista
		System.out.println("tamaño = " + listaJuegos.size());

		// Validar si hay elemento en la lista por un criterio como un String
		if (listaJuegos.contains("Halo")) {
			System.out.println("Si esta Halo en la lista");
		} else {
			System.out.println("No esta Halo en la lista");
		}

		// Ver si hay un elemento en la lista por un criterio como la direccion o index
		System.out.println("El elemento  FIFA 2020 es la posicion = " + listaJuegos.get(3));

		if (listaJuegos.isEmpty()) {
			System.out.println("LA lista esta vacioa");
		} else {
			System.out.println("La lista no esta vacia");
		}

		// Imprimir lista
		for (String corona : listaJuegos) {
			System.out.println(corona + "-");
			System.out.println();
		}

		// Modificar elemento de la lista
		listaJuegos.set(0, "LOL");

		for (String corona : listaJuegos) {
			System.out.println(corona + "-");
			System.out.println();
		}

		// vaciar la lista
		listaJuegos.clear();

	}

}
