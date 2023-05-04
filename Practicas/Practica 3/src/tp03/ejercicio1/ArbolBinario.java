package tp03.ejercicio1;
package tp03.ej3;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		// debo recorrer el arboles y contar cada nodo que no tenga hijos
		// hare un recorrido INORDEN -> primero proceso el dato y luego sigo 
		int contHi = 0;
		int contHd = 0;
		
		if (this.esHoja()) {
			return 1
		} else {
			if (this.tieneHijoIzquierdo()) contHi = this.getHijoIzquierdo().contarHojas();
			if (this.tieneHijoDerecho()) contHd = this.getHijoDerecho().contarHojas();
		}
		
		return contHi + contHd;
	}
	

    public ArbolBinario<T> espejo() {
    	if (this.esVacio()) {
    		return new ArbolBinario<T>();
    	} else {
    		ArbolBinario espejo = new ArbolBinario<T>(this.getDato());
    		if (this.tieneHijoIzquierdo()) {
    			espejo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
    		}
    		if (this.tieneHijoIzquierdo()) {
    			espejo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
    		}
    		return espejo;
    	}
	}


	public void entreNiveles(int n, int m){
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		int nivelActual = 0;
		
		while (!cola.esVacia()) {
			ArbolBinario<T> arbol = cola.desencolar();
			if (arbol == null) {
				nivelActual++;
				if (nivelActual > m) break;
				if (nivelActual >= n) System.out.println('----');
				cola.encolar(null);
			} else {
				if (nivelActual>=n && nivelActual<=m) {
					System.out.pritln(arbol.getDato());
				}
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			}
		}
	}

}
