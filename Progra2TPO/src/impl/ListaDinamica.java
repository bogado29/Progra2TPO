package impl;

import api.ListaTDA;

public class ListaDinamica implements ListaTDA {

	Nodo cabeza;
	Nodo fin;
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
		Nodo nuevo = new Nodo(x);
		if (cabeza == null) {
			cabeza = nuevo;
			fin = cabeza;
		} else {
			fin.enlazarSiguiente(nuevo);
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
			temp = temp.obtenerSiguiente();
			contador++;
		}
		return temp.obtenerValor();
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
				temp = temp.obtenerSiguiente();
				contador++;
			}
			temp.modificar(valor);
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
		Nodo nuevo = new Nodo(valor);
		int contador = 0;
		while (contador < index){
			temp = temp.obtenerSiguiente();
			contador++;
		}
		Nodo nodoAnterior = temp.obtenerAnterior();

		nodoAnterior.siguiente = nuevo;
		nuevo.anterior = nodoAnterior;

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
		Nodo temp = cabeza;
		while (temp.obtenerSiguiente().obtenerSiguiente() != null) { // Busco el anteultimo elemento
			temp = temp.obtenerSiguiente();
		}
		Nodo anteultimo = temp;
		Nodo ultimo = temp.obtenerSiguiente();
		/*
		 * Defino al siguiente de anteultimo como null y al anterior del ultimo
		 * como null, de esta forma borro el enlace y el elemento ultimo queda
		 * desvinculado para ser despues eliminado por garbage collection
		 */
		anteultimo.siguiente = null;
		ultimo.anterior = null;
		size--;
		return ultimo.obtenerValor();
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
		int contador = 0;
		while (contador < size-1){
			if (temp.obtenerValor() == x)
				break;
			else  {
				temp = temp.obtenerSiguiente();
				contador++;
			} 
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
			int valor = temp.obtenerValor();
			System.out.print(valor + ", ");
			temp = temp.obtenerSiguiente();
			contador++;
		}
		int valor = temp.obtenerValor();
		System.out.println(valor + "]");
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
		int aux = x.len();
		int aux2;
		while (aux - 1 > 0) {
			aux2 = x.pop();
			System.out.println("value: " + aux2);
			append(aux2);
			aux--;
			System.out.println("Aux value: " + aux);
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
		int contador = 0;
		while (contador < size-1){
			if (temp.obtenerValor() == x)
				break;
			else  {
				temp = temp.obtenerSiguiente();
				contador++;
			} 
		}
		// Si el elemento x no se encuentra en la lista
		if (temp.obtenerSiguiente() == null) 
			return;

		Nodo nodoAnterior = temp.obtenerAnterior(); // Nodo anterior al elemento x
		Nodo nodoSiguiente = temp.obtenerSiguiente(); // Nodo siguiente al elemento x

		// Elimino los enlaces con el nodo anterior/siguiente segun corresponda

		// En caso de que x NO sea el PRIMER elemento
		if (nodoAnterior != null){
			nodoAnterior.siguiente = nodoSiguiente;
		    temp.anterior = null;
		}
		//En caso de que x NO sea el ULTIMO elemento
		if (nodoSiguiente != null){
			nodoSiguiente.anterior = nodoAnterior;
			temp.siguiente = null;
		}
		//En caso de que x SEA EL UNICO elemento de la lista
		if (nodoAnterior == null & nodoSiguiente == null)
			temp = null;

		size--;
	}

	/**
	 * @Tarea: Permite invertir el orden en que esta almacenada la lista.
	 * @Parametros: -
	 * @Devuelve: -
	 * @Precondicion: La lista no debe estar vacia.
	 **/
	public void reverse() {
		// TODO Auto-generated method stub
	}

}
