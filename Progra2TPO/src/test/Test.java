package test;

import impl.ListaDinamica;

public class Test {

	public static void main(String[] args) {

		ListaDinamica lista = new ListaDinamica(); lista.inicializar();
		ListaDinamica lista_dos = new ListaDinamica(); lista_dos.inicializar();
		//Prueba de append()
		for (int i = 0; i < 10; i++) {
			lista.append(i);
			lista_dos.append(i*5);
		}
		lista.append(3);
	
		//Prueba de get()
		lista.print();
		System.out.println(lista.get(9));
		
		//Prueba de pop() y pop(int x)
		lista.pop(3);
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

		// Prueba de insert(index, int x)
		lista.insert(3, 123);
		lista.print();

		// Prueba de extend(listaTDA x)
		lista.extend(lista_dos);
		lista.print();

		
		
		
	}

}
