package ej1;

public class ej1 {
	
 public static void metodoFor(int x, int y) {
	 for (int i=x; i<=y; i++) {
		 System.out.println(i);
	 }
 }
 
 public static void metodoWhile(int x, int y) {
	 int i=x;
	 while (i<=y) {
		 System.out.println(i);
		 i++;
	 }
 }
 
 public static void metodoRecursivo(int x, int y) {
	 System.out.println(x);
	 if (x<y) {
		 metodoRecursivo(x+1,y);
	 }
 }
}
