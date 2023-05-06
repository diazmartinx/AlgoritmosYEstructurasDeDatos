package tp03.ejercicio1;
import ej3.ColaGenerica;

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
			return 1;
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
    		ArbolBinario<T> espejo = new ArbolBinario<T>(this.getDato());
    		if (this.tieneHijoIzquierdo()) {
    			espejo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
    		}
    		if (this.tieneHijoIzquierdo()) {
    			espejo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
    		}
    		return espejo;
    	}
	}
    
    public void porNiveles() {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol!=null) {
				System.out.print(arbol.getDato());
				if (arbol.tieneHijoIzquierdo())
						cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
						cola.encolar(arbol.getHijoDerecho());
			} else if (!cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
			}
		}
	}


	public void entreNiveles(int n, int m){
		int altura = 0;
		ColaGenerica<ArbolBinario<T>> cola= new ColaGenerica<>();
		ArbolBinario <T> arbol;
		cola.encolar(this);
		cola.encolar(null);

		if (n>=0 && m<=altura){
			while (!cola.esVacia()){
				arbol = cola.desencolar();
				if (arbol == null){ //Si llegue al final del nivel
					if (!cola.esVacia()){
						cola.encolar(null);
						altura++;
					}
				}
				else{
					if (n<=altura && altura<=m){
						System.out.println(arbol.getDato());
					}
					if (arbol.tieneHijoIzquierdo()){
						cola.encolar(arbol.getHijoIzquierdo());
					}
					if (arbol.tieneHijoDerecho()){
						cola.encolar(arbol.getHijoDerecho());
					}
				}
			}
		}
	}
	
	public void preOrden() {
		if (this.esVacio()) return;
		else {
			System.out.print(this.getDato() + " ");
			if (this.tieneHijoIzquierdo()) 
				this.getHijoIzquierdo().preOrden();

			if (this.tieneHijoDerecho())
				this.getHijoDerecho().preOrden();
		}
			
	}
	
	
	
	//
	//
	//
	
	
	public void entreNiveles2(int min, int max) {
		int nivel = 0;
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia() && nivel<=max) {
			arbol = cola.desencolar();
			if (arbol!=null) {
				
				if (nivel>=min)
					System.out.print(arbol.getDato() + " ");
				
				if (arbol.tieneHijoIzquierdo())
						cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
						cola.encolar(arbol.getHijoDerecho());
			} else if (!cola.esVacia()) {
				System.out.println();
				nivel++;
				cola.encolar(null);
			}
		}
	}
}


