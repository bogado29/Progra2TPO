package impl;

public class Nodo {

	int info;
	Nodo siguiente;
	Nodo anterior;
	
	public Nodo(int n){
		this.info = n;
		this.siguiente = null;
		this.anterior = null;
	}
	
	public void enlazarSiguiente(Nodo n) {
		this.siguiente = n;
		n.anterior = this;
	}
	
	public void enlazarAnterior(Nodo n) {
		this.anterior = n;
		n.siguiente = this;
	}
	
	public Nodo obtenerSiguiente() {
		return this.siguiente;
	}
	
	public Nodo obtenerAnterior() {
		return this.anterior;
	}
	
	public int obtenerValor() {
		return info;
	}
	
	public void modificar(int valor) {
		this.info = valor;
	}
	
	
}
