package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		int h = -1;
		if (this.esHoja()) {
			return 0;
		} else {
			if (this.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					h = Math.max(h, hijos.proximo().altura());
				}
			}
		}
		
		return h+1;
	}
	
	public Integer alturaPN() {
		ListaGenerica<ArbolGeneral<T>> cola = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		cola.agregarFinal(this);
		cola.agregarFinal(null);
		Integer nivel=0;
		while (!cola.esVacia()) {
			aux = cola.elemento(1); cola.eliminarEn(1); //desencolar
			if (aux!=null) {
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin()) {
						cola.agregarFinal(hijos.proximo());
					}
				}
			} else if(!cola.esVacia()) {
				nivel++;
				cola.agregarFinal(null);
			}
		}
		return nivel;
	}
	
	public Integer nivel(ArbolGeneral<T> dato) {
		ListaGenerica<ArbolGeneral<T>> cola = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		cola.agregarFinal(this);
		cola.agregarFinal(null);
		Integer nivel=0;
		while (!cola.esVacia()) {
			aux = cola.elemento(1); cola.eliminarEn(1); //desencolar
			if (aux!=null) {
				if(aux.equals(dato))
						return nivel;
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin()) {
						cola.agregarFinal(hijos.proximo());
					}
				}
			} else if(!cola.esVacia()) {
				nivel++;
				cola.agregarFinal(null);
			}
		}
		return -1;
	}

	public Integer ancho() {
		ListaGenerica<ArbolGeneral<T>> cola = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		cola.agregarFinal(this);
		cola.agregarFinal(null);
		Integer max = 0;
		int cantH = 0;
		while (!cola.esVacia()) {
			aux = cola.elemento(1); cola.eliminarEn(1); //desencolar
			
			if (aux!=null) {
				
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos = aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin()) {
						cantH++;
						cola.agregarFinal(hijos.proximo());
					}
				}
				
			} else if(!cola.esVacia()) {
				max = Math.max(max, cantH);
				cola.agregarFinal(null);
				cantH = 0;
			}
		}
		return max;
	}
	
	public boolean esAncestro(ArbolGeneral<T> a, ArbolGeneral<T> b) {
		// si un nodo A es ancestro de un nodo B -> B es descendiente de A
		// Es decir B debe encontrarse dentro del SubArbol con raiz A
		
		if (a.equals(b)) return true;
		else if (a.tieneHijos()) {
			boolean es = false;
			ListaGenerica<ArbolGeneral<T>> hijos = a.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				if (a.equals(b)) {es = true; break;}
				else es = esAncestro(hijos.proximo(), b);
			}
			return es;
		} else return false;
			
	}
	
	
	public double minimoCaudal(double caudal) {
		double min = 99999.0;	
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				min = Math.min(min, hijos.proximo().minimoCaudal(caudal/hijos.tamanio()));		
			}
			return min;
		} else {
			return caudal;
		}
		
	}

}