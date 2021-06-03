package test;

import impl.ListaDinamica;

public class Test {

	public static void main(String[] args) {

		ListaDinamica lista = new ListaDinamica();
		lista.inicializar();
		
		//Prueba de append()
		System.out.println();
		System.out.println("Prueba de append()");
		for (int i = 0; i < 10; i++) {
			lista.append(i);
		}

		//Prueba de get()
		System.out.println();
		System.out.println("Prueba de get()");
		lista.print();
		System.out.println(lista.get(9));
		
		//Prueba de set()
		System.out.println();
		System.out.println("Prueba de set()");
		lista.set(9, 10);
		lista.print();
		
		//Prueba de pop()
		System.out.println();
		System.out.println("Prueba de pop()");
		int ultimo = lista.pop();
		System.out.println(ultimo);
		lista.print();
		
		//Prueba de sort()
		System.out.println();
		System.out.println("Prueba de sort()");
		lista.sort(2);
		lista.print();
		lista.sort(1);
		lista.print();
		
		//Prueba de remove()
		System.out.println();
		System.out.println("Prueba de remove()");
		lista.remove(3);
		lista.print();

		//Prueba de insert()
		System.out.println();
		System.out.println("Prueba de insert()");
		lista.insert(3, 3);
		lista.print();

		//Prueba de pop(int x)
		System.out.println();
		System.out.println("Prueba de pop(int x)");
		int auxiliar = lista.pop(6);
		lista.print();
		System.out.println(auxiliar);
		lista.insert(auxiliar, auxiliar);
		lista.print();

		
		
		
		
		
	}

}
