package guia2;
import tp02.ejercicio1.*;

public class TestListaDeEnterosEnlazada {
	
	
	public static void imprimeRecursivo(ListaDeEnteros lista, int i) {
		if (i<=lista.tamanio()) {
			imprimeRecursivo(lista, i+1);
			System.out.println(lista.elemento(i));
		}
	}

	public static void main(String[] args) {
		ListaDeEnteros lista = new ListaDeEnterosEnlazada();
		
		
		for (String arg: args) {
			lista.agregarFinal(Integer.parseInt(arg));
		}
		
		for (int i=1; i<=lista.tamanio(); i++) {
			System.out.print(lista.elemento(i));
			
		}
		System.out.println();
		
		
		imprimeRecursivo(lista, 1);
		
		

	}

}
