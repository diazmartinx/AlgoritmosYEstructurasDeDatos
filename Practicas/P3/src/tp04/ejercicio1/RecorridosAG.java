package tp04.ejercicio1;
import tp02.ejercicio2.*;
import ej3.ColaGenerica;

public class RecorridosAG {
	
	public static ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, int n){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		if (a.esVacio()) return lista;
		preOrden(a,lista,n);
		return lista;
	}
	
	private static void preOrden(ArbolGeneral<Integer> arbol, ListaGenerica<Integer> lista, int n) {
		if (arbol.getDato() % 2 != 0 && arbol.getDato()>n) {
			lista.agregarFinal(arbol.getDato());
		}
		if (arbol.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				preOrden(hijos.proximo(),lista,n);
			}
		}
		
	}
	
	public static ListaGenerica<Integer> NumerosImparesMAyoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		ArbolGeneral<Integer> arbol_aux;
		if (a.esVacio()) return lista;
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		cola.encolar(a);
		while(!cola.esVacia()) {
			arbol_aux = cola.desencolar();
			//if (arbol_aux.getDato() % 2 != 0 && arbol_aux.getDato() > n)
			lista.agregarFinal(arbol_aux.getDato());
			if (arbol_aux.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = arbol_aux.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
		}
		return lista;
	}
	
	public static void porNivelesConMarca(ArbolGeneral<Integer> a){
		ArbolGeneral<Integer> arbol_aux;	
		if (a.esVacio());
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		cola.encolar(a);
		cola.encolar(null);
		int nivel=0;
		while(!cola.esVacia()) {
			arbol_aux = cola.desencolar();
			
			if (arbol_aux!=null) {
				System.out.print(arbol_aux.getDato() + " ");
				if (arbol_aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Integer>> hijos = arbol_aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			} else if (!cola.esVacia()) {		
				System.out.println();
				nivel++;
				cola.encolar(null);
			}
			
			
		}
	}
	
	

	public static void main(String[] args) {
		ArbolGeneral<Integer> raiz = new ArbolGeneral<Integer>(0);
		
		ArbolGeneral<Integer> nodo1 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> nodo12 = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> nodo14 = new ArbolGeneral<Integer>(14);
		
		raiz.agregarHijo(nodo1);
		raiz.agregarHijo(nodo12);
		raiz.agregarHijo(nodo14);
		
		ArbolGeneral<Integer> nodo5 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> nodo4 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> nodo8 = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> nodoo4 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> nodo7 = new ArbolGeneral<Integer>(7);
		
		nodo1.agregarHijo(nodo5);
		nodo1.agregarHijo(nodo4);
		nodo12.agregarHijo(nodo8);
		nodo12.agregarHijo(nodoo4);
		nodo12.agregarHijo(nodo7);
		
		ArbolGeneral<Integer> nodo9 = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> nodo10 = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> nodoo5 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> nodo3 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> nodo13 = new ArbolGeneral<Integer>(13);
		
		nodo4.agregarHijo(nodo9);
		nodo4.agregarHijo(nodo10);
		nodo4.agregarHijo(nodoo5);
		nodo8.agregarHijo(nodo3);
		nodo7.agregarHijo(nodo13);
		
		ArbolGeneral<Integer> nodo133 = new ArbolGeneral<Integer>(133);
		nodo13.agregarHijo(nodo133);
		//
		ListaGenerica<Integer> lista = RecorridosAG.numerosImparesMayoresQuePreOrden(raiz, 5);
		ListaGenerica<Integer> listaPorNivel = RecorridosAG.NumerosImparesMAyoresQuePorNiveles(raiz, 5);
		System.out.println(lista.toString());
		System.out.println(listaPorNivel.toString());
		//RecorridosAG.porNivelesConMarca(raiz);
		int i = raiz.altura();
		System.out.println(raiz.alturaPN());
		System.out.println(raiz.nivel(nodo5));
		System.out.println(raiz.ancho());
		System.out.println(raiz.esAncestro(nodo9,nodo3));
		System.out.println(raiz.minimoCaudal(1000));
	}

}
