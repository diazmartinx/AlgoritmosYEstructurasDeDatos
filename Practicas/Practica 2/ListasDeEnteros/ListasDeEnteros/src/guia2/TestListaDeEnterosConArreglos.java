package guia2;
import tp02.ejercicio1.*;

public class TestListaDeEnterosConArreglos {

	public static void main(String[] args) {
		
		ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
		
		
		for (String arg: args) {
			lista.agregarFinal(Integer.parseInt(arg));
		}
		
		for (int i=1; i<=lista.tamanio(); i++) {
			System.out.println(lista.elemento(i));
		}

	}

}
