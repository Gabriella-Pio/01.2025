package E_FatorialRecursion;

import java.util.Scanner;

public class Recursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira o número para calcular seu fatorial: ");
        int n = sc.nextInt();

        System.out.println("Fatorial de " + n + " é: " + fatorial(n)); //Chamada Externa
    }

    public static int fatorial(int n) {
        if (n == 0) return 1; //Base
        else return fatorial(n - 1) * n; //Chamada recursiva
    }
}