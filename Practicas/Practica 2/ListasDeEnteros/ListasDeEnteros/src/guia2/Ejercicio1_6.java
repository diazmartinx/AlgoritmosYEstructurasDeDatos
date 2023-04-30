package guia2;
import tp02.ejercicio1.*;

public class Ejercicio1_6 {
	ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
	
	public ListaDeEnterosEnlazada calcularSucesion(int n) {
		
		if (n == 1) {
			lista.agregarFinal(n);
		} else if (n % 2 == 0) {
		    lista.agregarFinal(n);
		    calcularSucesion(n/2);
		} else {
			lista.agregarFinal(3);
			calcularSucesion(3*n+1);
		}
		
		return(lista);
	}
	
	public static void main (String[] args) {
		 Ejercicio1_6 f = new Ejercicio1_6();
		 ListaDeEnterosEnlazada l = f. calcularSucesion(6);
		 
		 for (int i=1; i<=l.tamanio(); i++) {
			 System.out.println(l.elemento(i));
		 }
	}


}
