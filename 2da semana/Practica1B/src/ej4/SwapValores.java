package ej4;

public class SwapValores {
	 public static void swap1 (int x, int y) {
		 if (x < y) {
			 int tmp = x ;
			 x = y ;
			 y = tmp;
		 }
	 } // swap intercambia los valores de X e Y pero localmente o globalmente?
	 
	 public static void swap2 (Integer x, Integer y) {
		 if (x < y) {
			 int tmp = x ;
			 x = y ;
			 y = tmp;
		}
	 }
	 
	 public static void main(String[] args) {
		 int a = 1, b = 2;
		 Integer c = 3, d = 4;
		 swap1(a,b);
		 swap2(c,d);
		 System.out.println("a=" + a + " b=" + b) ; // los valores no son intercambiados
		 System.out.println("c=" + c + " d=" + d) ; // los valores no son intercambiados ;c
	 }
}
