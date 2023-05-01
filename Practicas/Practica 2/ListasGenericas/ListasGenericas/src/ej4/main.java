package ej4;
import ej3.PilaGenerica;

//Utilizare una pila, una vez que se ingrese un char de apertura ej (
// se colocara en una pila, si se agrega un tag de cierre ej ')' este debe 
// corresponderle al utimo elemento de la pila
// si ese elemento no le corresponde entonces el string esta desvalanceado
// si la pila no esta vacia luego de recorrer el string este no esta balanceado

public class main {
	
	public static boolean estaBalanceado(String cadena) {
		//retorna true si esta balanceado
		
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		
		boolean desvalanceado = false;
				
		for (char elem: cadena.toCharArray()) {
			if (elem=='(' || elem=='[' || elem=='{') {
				pila.apilar(elem);
			} else if (elem==')' || elem==']' || elem=='}') {
				Character tope = pila.tope();
				switch (elem) {
					case ')': if (tope != '(') desvalanceado = true; break;
					case ']': if (tope != '[') desvalanceado = true; break;
					case '}': if (tope != '{') desvalanceado = true; break;
				}	
				if (!desvalanceado) pila.desapilar();
			}
			if (desvalanceado) break;
		}
		// pila vacia -> true
		return pila.esVacia();
	}

	public static void main(String[] args) {
		String balanceado = "{( ) [ ( ) ] }";
		String desbalanceado = "( [ ) ]";
		
		System.out.println(estaBalanceado(balanceado)); //true
		System.out.println(estaBalanceado(desbalanceado)); //false

	}

}
