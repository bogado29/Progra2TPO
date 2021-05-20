package impl;

import api.ListaTDA;

public class ListaDinamica implements ListaTDA {

	Nodo cabeza;
	Nodo fin;
	int size;
	
	public void inicializar() {
		cabeza = null;
		size = 0;
	}

	//Agregar nuevo Nodo con valor x 
	public void append(int x) {
		Nodo nuevo = new Nodo(x);
		if (cabeza==null) {
			cabeza = nuevo;
			fin = cabeza;
		}
		else {
			fin.enlazarSiguiente(nuevo);
			fin = nuevo;
		}
		size++;
	}

	//Obtener el valor del nodo en la posicion x
	public int get(int index) {
		int contador = 0;
		Nodo temp = cabeza; // Arranca desde el inicio de la lista
		while (contador < index) {
			temp = temp.obtenerSiguiente();
			contador++;
		}
		return temp.obtenerValor();
	}

	//Modificar elemento en posicion index
	public void set(int index, int valor) {
		if (index > size-1) // INDEX OUT OF RANGE
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

	/*Inserta el valor en la posición x, 
	haciendo un corrimiento a la derecha de los restantes elementos.
	Precondición: x es un valor positivo y debe existir el elemento 
	en posición x o debe ser el inmediato siguiente (len de la lista)*/
	public void insert(int index, int valor) {
		// TODO Auto-generated method stub

	}

	/*Permite eliminar el último elemento de la lista, que 
	será retornado por el método. Precondición que no se encuentre 
	vacía la lista.*/
	public int pop() {
		Nodo temp = cabeza;
		while (temp.obtenerSiguiente().obtenerSiguiente() != null) { // Busco el anteultimo elemento
			temp = temp.obtenerSiguiente();
		}
		Nodo anteultimo = temp;
		Nodo ultimo = temp.obtenerSiguiente();
		/* Defino al siguiente de anteultimo como null y 
		al anterior del ultimo como null, de esta forma borro el enlace y 
		el elemento ultimo queda desvinculado para ser despues eliminado por garbage collection*/
		anteultimo.siguiente = null; 
		ultimo.anterior = null;
		size--;
		return ultimo.obtenerValor();
	}

	@Override
	public int pop(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

	//Permite imprimir los elementos separados por comas entre corchetes. Por ejemplo: [3,5,1]
	public void print() {
		System.out.print("[");
		int contador = 0;
		Nodo temp = cabeza;
		while (contador < size-1) {
			int valor = temp.obtenerValor();
			System.out.print(valor + ", ");
			temp = temp.obtenerSiguiente();
			contador++;
		}
		int valor = temp.obtenerValor();
		System.out.println(valor + "]");
	}

	//Retorna la cantidad de elementos de la lista
	public int len() {
		return size;
	}

	/*Permite ordenar la lista, en el caso de recibir 1,  
	de menor a mayor, en el caso de recibir 2 como parámetro, de  mayor a menor
	
	Se utiliza un algoritmo de ordenamiento por Burbujeo
	 if (a[i] > a[i+1]){
		temp = a[i];
		a[i] = a[i+1];
		a[i+1] = temp;
		sorted = false;
		}
		Estaria bueno buscar otra forma porque me parece que el codigo quedo horrible en este metodo*/
	public void sort(int orden) {
		boolean ordenado = false;
		int temp;
			if (orden == 1) {
				while (!ordenado) {
					ordenado = true;
					for (int i = 0; i < size - 1; i++) { 
			            if (this.get(i) > this.get(i+1)) {
			                temp = this.get(i);
			                this.set(i, this.get(i+1));
			                this.set(i+1, temp);
			                ordenado = false;
			            }  
					}
				}
			}
			else if (orden==2){
				while (!ordenado) {
					ordenado = true;
					for (int i = 0; i < size - 1; i++) { 
			            if (this.get(i) < this.get(i+1)) {
			                temp = this.get(i);
			                this.set(i, this.get(i+1));
			                this.set(i+1, temp);
			                ordenado = false;
			            }  
					}
				}
			}
	}

	@Override
	public void extend(ListaTDA x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub

	}

}
