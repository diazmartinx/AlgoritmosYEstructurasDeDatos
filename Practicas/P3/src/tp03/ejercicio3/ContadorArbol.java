package tp03.ejercicio3;
import tp03.ejercicio1.*;
import tp02.ejercicio2.*;

public class ContadorArbol {
	
	private ArbolBinario<Integer> arbol;
	
	public ContadorArbol(ArbolBinario<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	public ListaEnlazadaGenerica<Integer> numerosPares(){
		ListaEnlazadaGenerica<Integer> pares = new ListaEnlazadaGenerica<Integer>();
		inOrden(arbol,pares);
		postOrden(arbol,pares);
		return pares;
	}
	
	private void inOrden(ArbolBinario<Integer> raiz, ListaEnlazadaGenerica<Integer> pares) {
		if (raiz==null) return;
		inOrden(raiz.getHijoIzquierdo(),pares);
		if (raiz.getDato()%2==0) {
			pares.agregarFinal(raiz.getDato());
			System.out.println(raiz.getDato());
		}
		inOrden(raiz.getHijoDerecho(),pares);
	}
	
	private void postOrden(ArbolBinario<Integer> raiz, ListaEnlazadaGenerica<Integer> pares) {
		if (raiz==null) return;
		postOrden(raiz.getHijoIzquierdo(),pares);
		
		postOrden(raiz.getHijoDerecho(),pares);
		if (raiz.getDato()%2==0) {
			pares.agregarFinal(raiz.getDato());
			System.out.println(raiz.getDato());
		}
	}
	public static void main(String[] args) {
	    ArbolBinario<Integer> arbol =new ArbolBinario(1);
	    ArbolBinario<Integer> b =new ArbolBinario(2);
	    ArbolBinario<Integer> c =new ArbolBinario(3);
	    ArbolBinario<Integer> d =new ArbolBinario(4);
	    arbol.agregarHijoIzquierdo(b);
	    arbol.agregarHijoDerecho(c);
	    b.agregarHijoDerecho(d);
	    
	    ContadorArbol contador = new ContadorArbol(arbol);
	    
	    ListaEnlazadaGenerica<Integer> pares = contador.numerosPares();
	    System.out.println( "Tamanio:" + pares.tamanio());

	}

}
