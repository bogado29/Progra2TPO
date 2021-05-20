package test;

import impl.ListaDinamica;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListaDinamica lista = new ListaDinamica();
		lista.inicializar();
		
		//Prueba de append()
		for (int i = 0; i < 10; i++) {
			lista.append(i);
		}
	
		//Prueba de get()
		lista.print();
		System.out.println(lista.get(9));
		
		//Prueba de set()
		lista.set(9, 10);
		lista.print();
		
		//Prueba de pop()
		int ultimo = lista.pop();
		System.out.println(ultimo);
		lista.print();
		
		//Prueba de sort()
		lista.sort(2);
		lista.print();
		lista.sort(1);
		lista.print();
		
		
		
		
		
	}

}
