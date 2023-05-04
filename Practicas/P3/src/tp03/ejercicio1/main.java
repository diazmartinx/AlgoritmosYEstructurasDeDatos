package tp03.ejercicio1;

public class main {

	public static void main(String[] args) {
//      A
    //        /   \
    //       B     C
    //        \
    //         D
    ArbolBinario<String> a =new ArbolBinario<String>("A");
    ArbolBinario<String> b =new ArbolBinario("B");
    ArbolBinario<String> c =new ArbolBinario("C");
    ArbolBinario<String> d =new ArbolBinario("D");
    a.agregarHijoIzquierdo(b);
    a.agregarHijoDerecho(c);
    b.agregarHijoDerecho(d);
    
    System.out.println("Su arbol tiene "+a.contarHojas()+" hojas");
    a.entreNiveles(0, 2);
	}

}
