package repaso;
import tp03.ejercicio1.*;
import tp03.ejercicio5.ProfundidadDeArbolBinario;
import ej3.ColaGenerica;

public class ej5 {
	ArbolBinario<Integer> arbol;
	
	
	
	

	public ej5(ArbolBinario<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public int sumaElementosProfundidad(int p) {
		//profundidad distancia desde la raiz al nodo
		int profActual = 0;
		int sumaNodos = 0;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		ArbolBinario<Integer> arbol = null;
		cola.encolar(arbol);
		cola.encolar(null);
		while(!cola.esVacia() && profActual<=p){
			arbol = cola.desencolar();
			if (arbol!=null) {
				if (profActual==p)sumaNodos += arbol.getDato();				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			} else if(!cola.esVacia()) {
				profActual++;
				cola.encolar(null);
			}
		}
		return sumaNodos;
	}
	





	public static void main(String[] args) {
		//      14
   //         /    \
   //        53     2
   //       / \    / \
   //      12  9  33 102
   ArbolBinario<Integer> num14 =new ArbolBinario(14);
   ArbolBinario<Integer> num53 =new ArbolBinario(53);
   ArbolBinario<Integer> num2 =new ArbolBinario(2);
   ArbolBinario<Integer> num12 =new ArbolBinario(12);
   ArbolBinario<Integer> num9 = new ArbolBinario(9);
   ArbolBinario<Integer> num33 =new ArbolBinario(33);
   ArbolBinario<Integer> num102 =new ArbolBinario(102);

   num14.agregarHijoIzquierdo(num53);
   num14.agregarHijoDerecho(num2);
   num53.agregarHijoIzquierdo(num12);
   num53.agregarHijoDerecho(num9);
   num2.agregarHijoIzquierdo(num33);
   num2.agregarHijoDerecho(num102);

   ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(num14);
   System.out.println("La suma del nivel 0 es: "+prof.sumaElementosProfundidad(0));
   System.out.println("La suma del nivel 1 es: "+prof.sumaElementosProfundidad(1));
   System.out.println("La suma del nivel 2 es: "+prof.sumaElementosProfundidad(2));
   System.out.println("La suma del nivel 3 es: "+prof.sumaElementosProfundidad(3));

	}

}
