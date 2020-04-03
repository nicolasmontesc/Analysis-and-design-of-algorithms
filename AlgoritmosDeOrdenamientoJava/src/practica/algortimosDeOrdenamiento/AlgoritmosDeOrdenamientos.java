package practica.algortimosDeOrdenamiento;

import java.util.Scanner;

public class AlgoritmosDeOrdenamientos {

	static Scanner input;

	/* Declaraci�n de variables */
	static int nn;

	static int ArrayN[];

	private static Scanner sc;

	private static Scanner sc2;

	/* Inicio del m�todo principal */
	public static void main(String[] args) {

		sc = new Scanner(System.in);

		System.out.print("Introduzca longitud del array: ");
		/*
		 * Guardamos en la variable nn el n�mero de elementos que va a tener nuestro
		 * array
		 */
		nn = sc.nextInt();

		/* Creamos el array del tama�o nn (lo que pongamos por teclado) */
		ArrayN = new int[nn];

		/* Bucle para rellenar el array con n�meros introducidos por teclado */
		for (int i = 0; i < ArrayN.length; i++) {
			System.out.print("Introduzca n�mero para el elemento " + (i + 1) + ": ");
			ArrayN[i] = sc.nextInt();
		}

		/* Mostramos primero el array sin ordenar */
		System.out.println("      -SIN ORDENAR-");
		/* Llamada al m�todo */
		mostrarN(ArrayN);

		menu();

	}

	public static void menu() {
		input = new Scanner(System.in);
		int opcion = 10;

		System.out.println("�Desea ordenar los n�meros? S/N");
		sc2 = new Scanner(System.in);
		/* Con esto capturamos lo que introducimos por teclado */
		String res = sc2.nextLine();
		/* Si es 'S' entra, si no sale */
		if (res.equalsIgnoreCase("S")) {

			do {
				System.out.println("\t::|MEN�|::");

				System.out.println("\t	 Algortimos de Ordenamiento");
				System.out.println("1.\tOrdenamiento Burbuja");
				System.out.println("2.\tBurbuja bidireccional ");
				System.out.println("3.\tSelecci�n  ");
				System.out.println("4.\tInserci�n");
				System.out.println("5.\tQuicksort");
				System.out.println("6.\tShell ");
				System.out.println("7.\tGnome ");
				System.out.println("8.\tPeine");
				System.out.println("9.\tSalir");
				opcion = input.nextInt();

				input.nextLine();

				switch (opcion) {
				case 1:
					System.out.println();
					System.out.println("*********Arreglo Ordenado*********");
					ordenaBurbuja(ArrayN);
					break;
				case 2:
					System.out.println();
					System.out.println("*********Arreglo Ordenado*********");
					burbujaDireccional(ArrayN);
					break;
				case 3:
					System.out.println();
					System.out.println("*********Arreglo Ordenado*********");
					seleccion(ArrayN);
					break;
				case 4:
					System.out.println();
					System.out.println("*********Arreglo Ordenado*********");
					insercionDirecta(ArrayN);
					break;
				case 5:
					System.out.println();
					System.out.println("*********Arreglo Ordenado*********");
					quicksort(ArrayN, 0, ArrayN.length-1);
					break;
				case 6:
					System.out.println();
					System.out.println("*********Arreglo Ordenado*********");
					shellSort(ArrayN);
					break;
				case 7:
					System.out.println();
					System.out.println("*********Arreglo Ordenado*********");
					gnome(ArrayN);
					break;
				case 8:
					System.out.println();
					System.out.println("*********Arreglo Ordenado*********");
					peine(ArrayN);
					break;
				case 9:
					break;
				default:
					System.out.println("Error. Se equivoco de opcion de men�.");

				}

			} while (opcion != 9);
			System.out.println("�Desea ordenar los n�meros? S/N");
			sc2 = new Scanner(System.in);
			/* Con esto capturamos lo que introducimos por teclado */
			res = sc2.nextLine();
			/* Si es 'S' entra, si no sale */
		}
	}

	/* M�todo para mostrar el array */
	static void mostrarN(int ArrayN[]) {

		System.out.println("|-----------------------|");
		/*
		 * Bucle para mostrar el array desde la posicion 0 hasta la longitud del array
		 */
		for (int i = 0; i < ArrayN.length; i++) {
			System.out.print(" Elemento " + (i + 1) + " -----> " + ArrayN[i] + "\n");
		}
		System.out.println("|-----------------------|");
	}
	/* Fin del m�todo principal */

	/**********************
	 * ORDENAMIENTO BURBUJA
	 * 
	 * @param ArrayN La Ordenaci�n de burbuja funciona revisando cada elemento de la
	 *               lista que va a ser ordenada con el siguiente, intercambi�ndolos
	 *               de posici�n si est�n en el orden equivocado. Es necesario
	 *               revisar varias veces toda la lista hasta que no se necesiten
	 *               m�s intercambios, lo cual significa que la lista est� ordenada.
	 *               ********************
	 */
	static void ordenaBurbuja(int ArrayN[]) {
		/* Bucle desde 0 hasta la longitud del array -1 */
		for (int i = 0; i < ArrayN.length - 1; i++) {
			/* Bucle anidado desde 0 hasta la longitud del array -1 */
			for (int j = 0; j < ArrayN.length - 1; j++) {
				/*
				 * Si el n�mero almacenado en la posici�n j es mayor que el de la posici�n j+1
				 * (el siguiente del array)
				 */ if (ArrayN[j] > ArrayN[j + 1]) {
					/*
					 * guardamos el n�mero de la posicion j+1 en una variable (el menor)
					 */
					int temp = ArrayN[j + 1];
					/* Lo intercambiamos de posici�n */
					ArrayN[j + 1] = ArrayN[j];
					ArrayN[j] = temp;
					/*
					 * y volvemos al inicio para comparar los siguientes hasta que todos se hayan
					 * comparado
					 */
					/*
					 * de esta forma vamos dejando los n�meros mayores al final del array en orden
					 */
				}
			}
		}
		/*
		 * Llama al m�todo mostrarN, si ordena damos por hecho que lo quiere mostrar
		 */
		mostrarN(ArrayN);
	}

	/*********************
	 * ORDENAMIENTO POR INSERCION
	 * 
	 * @param ArrayN El ordenamiento por inserci�n es una manera muy natural de
	 *               ordenar para un ser humano, y puede usarse f�cilmente para
	 *               ordenar un mazo de cartas numeradas en forma arbitraria.
	 * 
	 *               La idea de este algoritmo de ordenaci�n consiste en ir
	 *               insertando un elemento de la lista � un arreglo en la parte
	 *               ordenada de la misma, asumiendo que el primer elemento es la
	 *               parte ordenada, el algoritmo ira comparando un elemento de la
	 *               parte desordenada de la lista con los elementos de la parte
	 *               ordenada, insertando el elemento en la posici�n correcta dentro
	 *               de la parte ordenada, y as� sucesivamente hasta obtener la
	 *               lista ordenada. ********************
	 */
	static void insercionDirecta(int ArrayN[]) {
		int p, j;
		int aux;
		for (p = 1; p < ArrayN.length; p++) { // desde el segundo elemento hasta
			aux = ArrayN[p]; // el final, guardamos el elemento y
			j = p - 1; // empezamos a comprobar con el anterior
			while ((j >= 0) && (aux < ArrayN[j])) { // mientras queden
													// posiciones y el
				// valor de aux sea menor que los
				ArrayN[j + 1] = ArrayN[j]; // de la izquierda, se desplaza a
				j--; // la derecha
			}
			ArrayN[j + 1] = aux; // colocamos aux en su sitio
		}
		mostrarN(ArrayN);
	}

	/*************************
	 * ORDENAMIENTO SELECCION
	 * 
	 * @param arrayN Consiste en encontrar el menor de todos los elementos del
	 *               vector e intercambiarlo con el que est� en la primera posici�n.
	 *               Luego el segundo mas peque�o, y as� sucesivamente hasta
	 *               ordenarlo todo.
	 ************************
	 */
	static void seleccion(int[] arrayN) {
		int i, j, menor, pos, tmp;
		for (i = 0; i < arrayN.length; i++) { // tomanos el elemento menor como
												// el primero
			menor = arrayN[i]; // el menor lo guaro y el resto falta por ordenar
			pos = i; // guardo posici�n

			for (j = i + 1; j < arrayN.length; j++) { // busqueda en el restpo
														// del vector (TAO)
				if (arrayN[j] < menor) {
					menor = arrayN[j]; // menor que el actual
					pos = j;
				}
			}

			// Si hay algun menor lo intercambio
			if (pos != i) { // manuel i
				tmp = arrayN[i];
				arrayN[i] = arrayN[pos];
				arrayN[pos] = tmp;
			}
		}
		/*
		 * Llama al m�todo mostrarN, si ordena damos por hecho que lo quiere mostrar
		 */
		mostrarN(arrayN);
	}

	/*************************
	 * ORDENAMIENTO QUICKSORT
	 * 
	 * @param arreglo
	 * @param izq
	 * @param der
	 * @return
	 * 
	 *         El ordenamiento r�pido (tambien llamado ordonamiento de Hoare o
	 *         quicksort en ingl�s) es un algoritmo creado por el cient�fico
	 *         brit�nico en computaci�n Tony Hoare y basado en la t�cnica de divide
	 *         y vencer�s. Esta es la t�cnica quiz�s la m�s eficiente y en ella que
	 *         en la mayor�a de los casos da mejores resultados
	 * 
	 *         El algoritmo fundamental es el siguiente: 1.Elegir un elemento de la
	 *         lista de elementos a ordenar, al que llamaremos pivote. 2.Resituar
	 *         los dem�s elementos de la lista a cada lado del pivote, de manera que
	 *         a un lado queden todos los menores que �l, y al otro los mayores. En
	 *         este momento, el pivote ocupa exactamente el lugar que le
	 *         corresponder� en la lista ordenada. 3.La lista queda separada en dos
	 *         sublistas, una formada por los elementos a la izquierda del pivote, y
	 *         otra por los elementos a su derecha. 4.Repetir este proceso de forma
	 *         recursiva para cada sublista mientras �stas contengan m�s de un
	 *         elemento. Una vez terminado este proceso todos los elementos estar�n
	 *         ordenados. Como se puede suponer, la eficiencia del algoritmo depende
	 *         de la posici�n en la que termine el pivote elegido.
	 *         **********************
	 */
	static void quicksort(int[] arrayN, int primero, int ultimo) {// Par�metros de entrada necesarios para el m�todo,
		int i, j, aux;// Declaraci�n de variables necesarias para implementar el m�todo Quick.
		int pivote;// El privote representa un n�mero de referencia para realizar los
					// ordenamientos.
		i = primero;// primer posicion del arreglo
		j = ultimo;// ultima posicion del arreglo
		pivote = arrayN[(i + j) / 2];// Tomar la mitad del arreglo o dividir el arreglo en 2. Esto se realiza en el
										// caso
		// de que exista una mitad exacta, sino pasa esto, se toma un n�mero diferente
		// de la mitad.
		do {
			while (arrayN[i] < pivote) {// se colocan los n�meros menores al pivote a la izquierda del arreglo.
				i++; // De esta forma si la condici�n se cumple, se recorre el arreglo en sentido de
						// derecha a izquierda.
			}
			while (arrayN[j] > pivote) {// se recorre los ultimos elementos del arreglo hasta pivote
				j--; // De esta forma si la condici�n se cumple, se recorre el arreglo en sentido de
						// izquierda a derecha.
			}
			// Aqui hacemos el intercambio de elementos
			if (i <= j) {
				aux = arrayN[i];
				arrayN[i] = arrayN[j]; // Corresponde a la mec�nica de ordenaci�n relacionada al m�todo de la burbuja y
										// a otros m�todos de ordenamiento.
				arrayN[j] = aux;
				i++; // Incrementando al contador i.
				j--; // Decrementando al contador j.
			}

		} while (i <= j);// Mientras el valor guardado en la primera posici�n correpondiente a i sea
							// menor o igual al valor correspondiente en la posicion j que es la �ltima del
							// arreglo.
		if (primero < j) { // Realizando recursividad del algoritmo para volver a repetir pasos sin
							// necesidad de interponer un ciclo nuevo.
			quicksort(arrayN, primero, j);// En este caso el nuevo n�mero que se encuentra en la posici�n final del
											// arreglo, ser�a el almacenado en j.
		}
		if (i < ultimo) {// En este caso se define que la variable i, ser� la primera posici�n del
							// arreglo, de esa forma se toma una peque�a poblaci�n,
			// Que represente el conjunto nuevo a ordenar, de esa forma se divide el arreglo
			// entre partes para ser nuevamente ordenado.
			quicksort(arrayN, i, ultimo);// De igual forma se realiza recursividad para evitar el proceso de algunos
											// pasos nuevamente.
		}

		mostrarN(arrayN);
	}

	/***************************************
	 * Ordenaci�n del peine o de Dobosiewicz
	 * 
	 * @param arrayN
	 * 
	 *               En 1980, Wlodzimierz Dobosiewicz propuso este algoritmo en su
	 *               breve art�culo "An Efficient Variation of Bubble Sort",
	 *               Information Processing Letters, vol. 11, num. 1, 1980. En �l
	 *               escribi� literalmente: "Bubble sort can be improved in yet
	 *               another way, which is similar to Shell�s version of the
	 *               insertion sort." ("La ordenaci�n por burbuja se puede mejorar
	 *               de otra manera adicional, que es similar a la versi�n de Shell
	 *               de la ordenaci�n por inserci�n").
	 * 
	 *               Posteriormente fue redescubierto y popularizado por Stephen
	 *               Lacey y Richard Box en un art�culo publicado por la revista
	 *               Byte en abril de 1991. En el ordenamiento de burbuja, cuando
	 *               dos elementos cualquiera se comparan, siempren tienen un
	 *               espacio (distancia entre ellos) de 1. La idea b�sica del
	 *               algoritmo CombSort es que el espacio pueda ser mucho mayor de
	 *               uno. El ordenamiento Shell tambi�n se basa en esta idea, pero
	 *               es una modificaci�n del algoritmo de ordenamiento por inserci�n
	 *               m�s que del algoritmo de ordenamiento de burbuja.
	 */
	private static int siGap(int gap) {
		gap = (gap * 10) / 13;
		if (gap < 1)
			return 1;
		return gap;
	}

	static void peine(int[] arrayN) {
		int n = arrayN.length;
		int gap = n;
		boolean flag = true;
		while (gap != 1 || flag == true) {
			gap = siGap(gap);
			flag = false;
			for (int i = 0; i < n - gap; i++) {
				if (arrayN[i] > arrayN[i + gap]) {
					int aux = arrayN[i];
					arrayN[i] = arrayN[i + gap];
					arrayN[i + gap] = aux;

					flag = true;
				}
			}
		}
		mostrarN(arrayN);
	}

	/********************************
	 * Ordenaci�n "Gnome"
	 * 
	 * @param arrayN
	 * 
	 *               El algoritmo de ordenaci�n conocido como Gnome_sort fue
	 *               inventada por Hamid Sarbazi-Azad, (profesor de la universidad
	 *               de Sharif, una de las mayores universidades de Ir�n) quien lo
	 *               desarroll� en el a�o 2000 y al que llam� Stupid sort
	 *               (Ordenamiento est�pido).
	 * 
	 *               Cuando Dick Grune lo reinvent� y document�, no hall� evidencias
	 *               de que existiera y en palabras suyas, dijo de �l "the simplest
	 *               sort algorithm" (es el algoritmo m�s simple) y quiz�s tenga
	 *               raz�n, pues lo describi� en s�lo cuatro l�neas de c�digo. Dick
	 *               Grune se bas� en los gnomos de jard�n holand�s, en como se
	 *               colocan en los maceteros y de ah� tambi�n el nombre que le dio.
	 * 
	 *               El algoritmo es similar a la ordenaci�n por inserci�n , excepto
	 *               que , en lugar de insertar directamente el elemento a su lugar
	 *               apropiado , el algoritmo realiza una serie de permutaciones ,
	 *               como en el ordenamiento de burbuja.
	 *               *******************************
	 */
	static void gnome(int[] arrayN) {
		int i = 1; // Inicia en la posicion 1.
		int temp; // Variable temporal o auxiliar para intercambiar valores.
		while (i < arrayN.length) { // Mientras "i" sea menor que el tama�o del arreglo.
			if (arrayN[i] >= arrayN[i - 1]) { // Si el arreglo es mayor o igual al arreglo menos una posicion.
				i = i + 1; // Se suma una posicion.
			} else { // Sino, intercambia los valores
				temp = arrayN[i - 1];
				arrayN[i - 1] = arrayN[i];
				arrayN[i] = temp;
				if (i > 1) { // Si "i" es mayor que 1.
					i = i - 1; // Se resta una posicion.
				}
			}
		}
		mostrarN(arrayN); // Se muestra el arreglo
	}

	/***************************************************
	 * El ordenamiento de burbuja bidireccional
	 * 
	 * @param arrayN El ordenamiento de burbuja bidireccional (tambi�n llamado
	 *               "m�todo de la sacudida" o "coctail sort" o "shaker sort") es un
	 *               algoritmo de ordenamiento que surge como una mejora del
	 *               algoritmo ordenamiento de burbuja.
	 * 
	 *               Si ya hab�is visto como funciona el algoritmo de ordenaci�n por
	 *               burbuja habr�is observado que los n�meros grandes se est�n
	 *               moviendo r�pidamente hasta al final de la lista (estas son las
	 *               "liebres"), pero que los n�meros peque�os (las "tortugas") se
	 *               mueven s�lo muy lentamente al inicio de la lista.
	 * 
	 *               Una soluci�n es de ordenar con el m�todo de burbuja y cuando
	 *               llegamos al final de la primera iteraci�n, no volver a realizar
	 *               el c�lculo desde el principio sino que empezaremos desde el
	 *               final hasta al inicio. De esta manera siempre se consigue que
	 *               tanto los n�meros peque�os como los n�meros grandes se
	 *               desplacen a los extremos de la lista lo m�s r�pido posible.
	 * 
	 ***************************************************
	 */
	static void burbujaDireccional(int arrayN[]) {
		int izq = 0;
		int der = arrayN.length - 1;
		int aux;
		int ultimo = arrayN.length - 1;

		do {

			// recorrido a la derecha
			for (int i = izq; i < der; i++) {
				if (arrayN[i] > arrayN[i + 1]) {
					aux = arrayN[i];
					arrayN[i] = arrayN[i + 1];
					arrayN[i + 1] = aux;
					ultimo = i;
				}
			}
			der = ultimo;

			// recorrido a la izquierda
			for (int j = der; j > izq; j--) {
				if (arrayN[j - 1] > arrayN[j]) {
					aux = arrayN[j];
					arrayN[j] = arrayN[j - 1];
					arrayN[j - 1] = aux;
					ultimo = j;
				}
			}

			izq = ultimo;
		} while (izq < der);

		/* Llama al m�todo monstrarN, si ordena damos por hecho que lo quiere mostar */
		mostrarN(arrayN);
	}

	/**
	 * Ordenaci�n de Shell
	 * 
	 * @param arrayN La ordenaci�n de Shell pertenece a los m�todos de clasificaci�n
	 *               avanzados, nombrado as� en honor del ingeniero y matem�tico
	 *               estadounidense Donald Shell que la propuso en 1959.
	 * 
	 *               Este m�todo utiliza una segmentaci�n entre los datos. Funciona
	 *               comparando elementos que est�n distantes; la distancia entre
	 *               comparaciones decrece conforme el algoritmo se ejecuta hasta la
	 *               ultima fase, en la cual se comparan los elementos adyacentes,
	 *               por esta raz�n se le llama ordenaci�n por disminuci�n de
	 *               incrementos.
	 * 
	 *               La ordenaci�n de Shell usa una secuencia, h1, h2, . . ., ht,
	 *               conocida como la secuencia de incrementos. Al principio de todo
	 *               proceso, se fija una secuencia decreciente de incrementos.
	 *               Cualquier secuencia funcionar� en tanto que empiece con un
	 *               incremento grande, pero menor al tama�o del arreglo de los
	 *               datos a ordenar, y que el �ltimo valor de dicha secuencia sea
	 *               1.
	 * 
	 *               Una elecci�n muy com�n (pero no tan eficiente) para la
	 *               secuencia de incrementos es adoptar la secuencia sugerida por
	 *               Shell: h1 = 1, hn+1 = 3hn+1 . En la siguiente animaci�n -
	 *               debido al peque�o tama�o del vector - eleg� h1=1, h2=2, h3=3,
	 *               h4=4, h5=6. Esta es la secuencia de Vaughan Pratt en 1971.
	 */
	static void shellSort(int[] arrayN) {
		int salto, aux, i;
		boolean cambios;
		for (salto = arrayN.length / 2; salto != 0; salto /= 2) {
			cambios = true;
			while (cambios) { // Mientras se intercambie alg�n elemento
				cambios = false;
				for (i = salto; i < arrayN.length; i++) // se da una pasada
					if (arrayN[i - salto] > arrayN[i]) { // y si est�n desordenados
						aux = arrayN[i]; // se reordenan
						arrayN[i] = arrayN[i - salto];
						arrayN[i - salto] = aux;
						cambios = true; // y se marca como cambio.
					}
			}
		}
		mostrarN(arrayN);
	}

}
