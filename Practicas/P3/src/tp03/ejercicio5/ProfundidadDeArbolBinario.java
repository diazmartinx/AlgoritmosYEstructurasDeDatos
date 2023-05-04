package tp03.ejercicio5;
import tp03.ejercicio1.*;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> arbol;
	
	
	
	public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	public int sumaElementosProfundidad(int p) {	
		return rec(arbol,p,0);
	}
	
	private int rec(ArbolBinario<Integer> raiz, int p, int pActual) {
		if (raiz==null) return 0;
		if (p==pActual) return raiz.getDato();
		return rec(raiz.getHijoIzquierdo(),p,pActual+1) + rec(raiz.getHijoDerecho(),p,pActual+1);
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
		    
		    ProfundidadDeArbolBinario arbolP = new ProfundidadDeArbolBinario(arbol);
		    System.out.println(arbolP.sumaElementosProfundidad(2));

	}

}
