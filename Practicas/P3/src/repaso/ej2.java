package repaso;
import tp03.ejercicio1.*;

public class ej2 {
	
	ArbolBinario<Integer> arbol;
	
	public ej2(ArbolBinario<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	

	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}



	public int contarHojas() {
		int total=0;
		
		if (arbol.esHoja()) {
			return 1;
		} else {
			if (arbol.tieneHijoIzquierdo()) total += arbol.getHijoIzquierdo().contarHojas();
			if (arbol.tieneHijoDerecho()) total += arbol.getHijoDerecho().contarHojas();
		}
		
		return total;
	}
	
	public ArbolBinario<Integer> espejo(){
		if (arbol.esVacio()) return new ArbolBinario<Integer>();
		else {
			ArbolBinario<Integer> espejo = new ArbolBinario<Integer>(arbol.getDato());
			if (arbol.tieneHijoIzquierdo()) {
				espejo.agregarHijoDerecho(arbol.getHijoIzquierdo());
			}
			if (arbol.tieneHijoDerecho()) {
				espejo.agregarHijoIzquierdo(arbol.getHijoDerecho());
			}
			return espejo;
		}	
	}
	
	public static void main(String[] args) {
		//   1
		//  / \
		// 2   3
		//  \
		//   4
		ArbolBinario<Integer> a =new ArbolBinario(1);
	    ArbolBinario<Integer> b =new ArbolBinario(2);
	    ArbolBinario<Integer> c =new ArbolBinario(3);
	    ArbolBinario<Integer> d =new ArbolBinario(4);
	    a.agregarHijoIzquierdo(b);
	    a.agregarHijoDerecho(c);
	    b.agregarHijoDerecho(d);
		
	    ej2 arb = new ej2(a);
	    //System.out.println(arb.contarHojas());
	    ArbolBinario<Integer> espejo = arb.espejo();
	    arb.getArbol().entreNiveles2(0,1);
	    //espejo.porNiveles();
	    
	}

}
