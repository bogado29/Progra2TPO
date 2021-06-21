package impl;

import api.ListaTDA;

public class ListaDinamica implements ListaTDA {

	public class Nodo {
		int info;
		Nodo siguiente , anterior;
	}

	Nodo cabeza, fin;
	int size;

	
	/**
	 * @Tarea: Permite inicializar las propiedades de la lista.
	 * @Parametros: -
	 * @Devuelve: -
	 * @Precondicion: -
	 **/
	public void inicializar() {
		cabeza = null;
		size = 0;
	}

	/**
	 * @Tarea: Agrega un nuevo elemento a final de la lista.
	 * @Parametros: Elemento a agregar (int).
	 * @Devuelve: -
	 * @Precondicion: la estructura debe estar inicializada.
	 **/
	public void append(int x) {
		Nodo nuevo = new Nodo(); nuevo.info = x;
		if (cabeza == null) {
			cabeza = nuevo;
		} else {
			Nodo temp = cabeza;
			while (temp.siguiente != null){ // busco el ultimo nodo de la lista
				temp = temp.siguiente;
			}
			temp.siguiente = nuevo;
			fin = nuevo;
		}
		size++;
	}

	/**
	 * @Tarea: Retorna el elemento que se encuentra en la posicion x.
	 * @Parametros: Elemento a obtener (int).
	 * @Devuelve: -
	 * @Precondicion: La estructura no debe estar vacia.
	 **/
	public int get(int index) {
		int contador = 0;
		Nodo temp = cabeza; // Arranca desde el inicio de la lista
		while (contador < index) {
			temp = temp.siguiente;
			contador++;
		}
		return temp.info;
	}

	/**
	 * @Tarea: Modifica el elemento que se encuentra en la posicion x.
	 * @Parametros: Elemento a editar (int) y su nuevo valor (int).
	 * @Devuelve: -
	 * @Precondicion: La estructura no debe estar vacia.
	 **/
	public void set(int index, int valor) {
		if (index > size - 1) // INDEX OUT OF RANGE
			return;
		else {
			int contador = 0;
			Nodo temp = cabeza;
			while (contador < index) {
				temp = temp.siguiente;
				contador++;
			}
			temp.info = valor;
		}
	}

	/**
	 * @Tarea: Inserta el valor en la posicion x, haciendo un corrimiento a la
	 *         derecha de los restantes elementos.
	 * @Parametros: Elemento a insertar (int valor) y la posicion a insertar (int index)
	 * @Devuelve: -
	 * @Precondicion: Precondicion x es un valor positivo y debe existir el
	 *                elemento en posicion x
	 **/
	public void insert(int index, int valor) {
		Nodo temp = cabeza;
		Nodo nuevo = new Nodo(); nuevo.info = valor;
		int contador = 0;
		while (contador < index){
			temp = temp.siguiente;
			contador++;
		}
		Nodo nodoAnterior = temp.anterior;
		//Enlazo con el nodo anterior
		nodoAnterior.siguiente = nuevo;
		nuevo.anterior = nodoAnterior;

		//Enlazo con el nodo siguiente
		temp.anterior = nuevo;
		nuevo.siguiente = temp;

		size++;
	}

	/**
	 * @Tarea: Permite eliminar el ultimo elemento de la lista, que sera
	 *         retornado por el metodo.
	 * @Parametros: -
	 * @Devuelve: Valor a eliminar (int).
	 * @Precondicion: Precondicion que no se encuentre vacia la lista
	 **/
	public int pop() {
		int info;
		if (cabeza.siguiente == null){
			info = cabeza.info;
			cabeza = null;
		} else {
			Nodo temp = cabeza;
				while (temp.siguiente.siguiente != null) { // Busco el anteultimo elemento
					temp = temp.siguiente;
				}
			Nodo anteultimo = temp; Nodo ultimo = temp.siguiente;
			info = ultimo.info;
		/*
		 * Defino al siguiente de anteultimo como null y al anterior del ultimo
		 * como null, de esta forma borro el enlace y el elemento ultimo queda
		 * desvinculado para ser despues eliminado por garbage collection
		 */
			anteultimo.siguiente = null;
			ultimo.anterior = null;
			fin = anteultimo;
		}
		size--;
		return info;
	}

	/**
	 * @Tarea: Permite eliminar el elemento x de la lista, que sera retornado
	 *         por el metodo.
	 * @Parametros: Indice a eliminar de la lista (int).
	 * @Devuelve: Valor a eliminar (int).
	 * @Precondicion: Precondicion que no se encuentre vacia la lista
	 **/
	@Override
	public int pop(int x) {
		Nodo temp = cabeza;
		while (temp != null && temp.info != x){
				temp = temp.siguiente;
		}
		this.remove(x); 
		return x; 
	}

	/**
	 * @Tarea: Permite imprimir los elementos separados por comas entre
	 *         corchetes.
	 * @Parametros: -
	 * @Devuelve: Println de elementos de la lista [n0, n1, n2]
	 * @Precondicion: Precondicion que no se encuentre vacia la lista
	 **/
	public void print() {
		System.out.print("[");
		int contador = 0;
		Nodo temp = cabeza;
		while (contador < size - 1) {
			
			System.out.print(temp.info + ", ");
			temp = temp.siguiente;
			contador++;

		}
		System.out.println(temp.info + "]");
	}

	/**
	 * @Tarea: Retorna la cantidad de elementos de la lista.
	 * @Parametros: -
	 * @Devuelve: Valor de la cantidad de elementos de lista (int).
	 * @Precondicion: -
	 **/
	public int len() {
		return size;
	}

	/*
	 * * Se utiliza un algoritmo de ordenamiento por Burbujeo if (a[i] >
	 * a[i+1]){ temp = a[i]; a[i] = a[i+1]; a[i+1] = temp; sorted = false; }
	 * Estaria bueno buscar otra forma porque me parece que el codigo quedo
	 * horrible en este metodo
	 */
	/**
	 * @Tarea: Permite ordenar la lista de forma ascente o descendente.
	 * @Parametros: 1 Asc, 2 Desc.
	 * @Devuelve: -
	 * @Precondicion: La lista no debe estar vacia.
	 **/
	public void sort(int orden) {
		boolean ordenado = false;
		int temp;
		if (orden == 1) {
			while (!ordenado) {
				ordenado = true;
				for (int i = 0; i < size - 1; i++) {
					if (this.get(i) > this.get(i + 1)) {
						temp = this.get(i);
						this.set(i, this.get(i + 1));
						this.set(i + 1, temp);
						ordenado = false;
					}
				}
			}
		} else if (orden == 2) {
			while (!ordenado) {
				ordenado = true;
				for (int i = 0; i < size - 1; i++) {
					if (this.get(i) < this.get(i + 1)) {
						temp = this.get(i);
						this.set(i, this.get(i + 1));
						this.set(i + 1, temp);
						ordenado = false;
					}
				}
			}
		}
	}

	/* #################################### */
	/* Extend function for testing propuse */
	/* #################################### */
	/**
	 * @Tarea: Concatena 2 listas.
	 * @Parametros: Lista X a concatenar.
	 * @Devuelve: -
	 * @Precondicion: La lista X no debe estar vacia.
	 **/
	public void extend(ListaTDA x) {
		int valorNodo;
		while (x.len() - 1 > 0) {
			valorNodo = x.pop();
			System.out.println("value: " + valorNodo);
			append(valorNodo);
			System.out.println("Aux value: " + x.len());
		}
	}

	/*
	 * public void extend(ListaTDA x) { 
	 * int aux = x.len(); while (aux-1 > 0 ) {
	 * append(x.pop()); aux--; } 
	 * }
	 */

	/**
	 * @Tarea: Permite eliminar el elemento x de la lista. En el caso de que el
	 *         elemento estuviera repetido, elimina el primero de ellos.
	 * @Parametros: Elemento a eliminar (int).
	 * @Devuelve: -
	 * @Precondicion: La lista no debe estar vacia.
	 **/
	public void remove(int x) {
		Nodo temp = cabeza;
		while (temp != null){
			if (temp.info == x)
				break;
			else  {
				temp = temp.siguiente;
			} 
		}
		// Si el elemento x no se encuentra en la lista
		if (temp == null) 
			return;

		Nodo nodoAnterior = temp.anterior; // Nodo anterior al elemento x
		Nodo nodoSiguiente = temp.siguiente; // Nodo siguiente al elemento x

		// Elimino los enlaces con el nodo anterior/siguiente segun corresponda

		//En caso de que x SEA EL UNICO elemento de la lista
		if (nodoAnterior == null & nodoSiguiente == null)
			temp = null;
		
		else {
			// En caso de que x sea el PRIMER elemento
			if (nodoAnterior == null){
				nodoSiguiente.anterior = null;
				cabeza = nodoSiguiente;
			}
			//En caso de que x sea el ULTIMO elemento
			else if (nodoSiguiente == null){
				nodoAnterior.siguiente = null;
				fin = nodoAnterior;
			}
			else { // Caso generico
				nodoAnterior.siguiente = nodoSiguiente;
				nodoSiguiente.anterior = nodoAnterior;

			}
			temp.anterior = null;
			temp.siguiente = null;
		}
		size--;
	}

	/**
	 * @Tarea: Permite invertir el orden en que esta almacenada la lista.
	 * @Parametros: -
	 * @Devuelve: -
	 * @Precondicion: La lista no debe estar vacia.
	 **/
	public void reverse() {
		//Declaro variables auxiliares
		int cant = len(); int valor;
		// Array donde voy a guardar los valores de los nodo de manera inversa. (El ultimo de la lista sera el primero en el array)
		int[] elementos = new int[cant];
		for (int i = 0; i < cant; i++) {
			valor = pop();
			System.out.println("valor: " + valor);
			elementos[i] = valor;
		}
		// Voy agregando los elementos en el array del primero al ultimo en la lista
		for (int i = 0; i < cant; i++){
			valor = elementos[i];
			append(valor);
		}	
	}

}
