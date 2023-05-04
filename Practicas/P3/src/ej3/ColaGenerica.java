package ej3;
import tp02.ejercicio2.*;

public class ColaGenerica<T>{
	private ListaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
	
	public void encolar (T dato) {
		lista.agregarFinal(dato);
	}
	
	public T desencolar() {
		T elemento = this.tope();
		lista.eliminarEn(1);
		return elemento;
	}
	
	public T tope() { //El tope de una cola es el primer elemento!
		return lista.elemento(1);
	}
	
	public boolean esVacia() {
		return lista.esVacia();
	}
}
