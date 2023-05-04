package ej3;
import tp02.ejercicio2.*;

public class PilaGenerica<T> {
	ListaEnlazadaGenerica<T> pila = new ListaEnlazadaGenerica<T>();
	
	public void apilar(T elem) {
		pila.agregarFinal(elem);
	}
	
	public T desapilar() {
		T elem = this.tope();
		pila.eliminarEn(pila.tamanio());
		return elem;
	}
	
	public T tope() {
		return pila.elemento(pila.tamanio());
	}
	
	public boolean esVacia() {
		return pila.esVacia();
	}
}
