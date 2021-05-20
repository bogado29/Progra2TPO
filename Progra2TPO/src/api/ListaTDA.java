package api;

//OBSERVACION: Al tratarse de una interfaz, todos los metodos declarados se consideran implicitamente como abstract, por lo que no es necesario usar la keyword
public interface ListaTDA {

	void inicializar();
	// Permite inicializar las propiedades de la lista. Es precondicion para el resto de los metodos
	
	void append(int x);
	// Permite agregar un entero que recibe como parametro
	
	int get(int x);
	// Retorna el elemento que se encuentra en la posicion x. Precondicion que la lista no se encuentre vacia
	
	void set(int index, int valor);
	// Asigna el elemento que se encuentra en la posicion x un valor int
	
	void insert(int index, int valor);
	// Inserta el valor en la posicion x, haciendo un corrimiento a la derecha de los restantes elementos. Precondicion x es un valor positivo y debe existir el elemento en posicion x
	
	int pop();
	// Permite eliminar el ultimo elemento de la lista, que sera retornado por el metodo. Precondicion que no se encuentre vacia la lista
	
	int pop(int x);
	// Permite eliminar el elemento x de la lista, que sera retornado por el metodo. Precondicion que la lista no se encuentra vacia

    void print();
    // Permite imprimir los elementos separados por comas entre corchetes. Ej: [3, 5, 1]
    
    int len();
    // Retorna la cantidad de elementos de la lista
    
    void sort(int orden);
    // Permite ordenar la lista, en caso de orden=1 de menor a mayor, en caso de orden=2 de mayor a menor
    
    void extend(ListaTDA x);
    // Permite agregar la lista x a la lista
    
    void remove(int x);
    // Permite eliminar el elemetno de la lista. En el caso de que el elemento estuviera repetido, elimina el primero de ellos. Precondicion lista=/=vacia
    
    void reverse();
    // Permite invertir el orden en que esta almacenada la lista
    
}