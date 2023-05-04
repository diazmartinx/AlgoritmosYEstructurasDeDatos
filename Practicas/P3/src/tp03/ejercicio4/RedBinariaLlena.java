package tp03.ejercicio4;
import tp03.ejercicio1.*;

public class RedBinariaLlena {
	
	private ArbolBinario<Integer> arbol;
	
	public RedBinariaLlena(ArbolBinario<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	

	public int retardoReenvio() {
		return RetardoPreOrden(this.arbol);
	}
	
	private int RetardoPreOrden(ArbolBinario<Integer> raiz) {
		if (raiz==null) return 0;
		
		int retardoIzq = RetardoPreOrden(raiz.getHijoIzquierdo());
		int retardoDer = RetardoPreOrden(raiz.getHijoDerecho());
		
		return raiz.getDato() + Math.max(retardoIzq, retardoDer);
		
	}

	public static void main(String[] args) {
		//   1
		//  / \
		// 2   3
		//  \
		//   4
		ArbolBinario<Integer> arbol =new ArbolBinario(1);
	    ArbolBinario<Integer> b =new ArbolBinario(2);
	    ArbolBinario<Integer> c =new ArbolBinario(3);
	    ArbolBinario<Integer> d =new ArbolBinario(4);
	    arbol.agregarHijoIzquierdo(b);
	    arbol.agregarHijoDerecho(c);
	    b.agregarHijoDerecho(d);
	    
	    RedBinariaLlena retardo = new RedBinariaLlena(arbol);
	    System.out.println(retardo.retardoReenvio());

	}

}
