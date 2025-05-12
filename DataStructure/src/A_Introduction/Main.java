package A_Introduction;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        /* VETOR */

        final int TAMANHO = 50; //final -> variável constante
        int[]v1 = new int[TAMANHO];



        preencherVetor(v1);
        exibirVetor(v1);

        System.out.println("Insira um número para verificarmos se ele está no vetor.");
        numero = scanner.nextInt();
        buscarNumero(v1, numero);
    }

    public static void buscarNumero(int[] vetor, int numero) {
        boolean encontrado = false;
        for(int i = 0; i < vetor.length; i++) {
            if(numero == vetor[i]) {
                System.out.println();
                System.out.println("Número correspondente encontrado: " + vetor[i]);
                System.out.println("Encontrado no índice: " + (i + 1));
                encontrado = true;
            }
        }
        if(encontrado == false) {
            System.out.println("Número não encontrado.");
        }
    }

    public static void exibirVetor(int[] vetor) {
        System.out.print("Vetor gerado: ");
        for(int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    public static void preencherVetor(int[] vetor) {
        Random random = new Random();
        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(100) + 1;
        }
    }
}
