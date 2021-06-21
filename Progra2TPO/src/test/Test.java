package test;

import impl.ListaDinamica;

public class Test {

	public static void main(String[] args) {

		ListaDinamica lista = new ListaDinamica();
		lista.inicializar();
		
		//Prueba de append()
		for (int i = 0; i < 10; i++) {
			lista.append(i);
		}
	
		//Prueba de get()
		lista.print();
		System.out.println(lista.get(9));
		
		//Prueba de pop()
		int ultimo = lista.pop();
		System.out.println(ultimo);
		lista.print();
		
		//Prueba de sort()
		lista.sort(2);
		lista.print();
		lista.sort(1);
		lista.print();
		
		// Prueba de reverse()
		lista.reverse();
		lista.print();

		
		
		
	}

}
