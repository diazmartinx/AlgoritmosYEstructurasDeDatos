package ej2;

import java.util.Scanner;

public class Contador {
    
    public static int[] multiplos(int n) {
        int[] resultado = new int[n];
        for (int i = 0; i < n; i++) {
            resultado[i] = n * (i+1);
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese un número entero n: ");
        int n = input.nextInt();
        int[] arreglo = multiplos(n);
        System.out.print("Los primeros " + n + " múltiplos de " + n + " son: ");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
    }
}
