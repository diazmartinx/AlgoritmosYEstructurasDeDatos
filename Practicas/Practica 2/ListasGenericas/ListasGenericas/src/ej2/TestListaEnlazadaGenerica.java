package ej2;
import tp02.ejercicio2.*;

public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {
		Estudiante[] estudiantes = new Estudiante[4];
		
		for (int i=0; i<estudiantes.length; i++) {
			estudiantes[i] = new Estudiante("a","a",i,"a","a");
		}
		
		ListaEnlazadaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<Estudiante>();
		for (Estudiante estudiante: estudiantes) {
			lista.agregarFinal(estudiante);
		}
		
		for (int i=1; i<=lista.tamanio();i++) {
			System.out.println(lista.elemento(i).tusDatos());
		}
		
		
	}

}
