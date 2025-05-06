package E_FatorialRecursion;

import java.util.Scanner;

public class Fatorial {
    Scanner sc = new Scanner(System.in);

    public int escolherNumero() {
        System.out.print("Insira o número para calcular seu fatorial: ");
        int n = sc.nextInt();
        return n;
    }

    private int calcularFatorial(int n) {
        int f = 1;

        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public void imprimirFatorial(int n) {
        System.out.println("Fatorial de " + n + " é: " + calcularFatorial(n));
    }
}
