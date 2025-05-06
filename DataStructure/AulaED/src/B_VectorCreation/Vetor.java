package B_VectorCreation;

import java.util.Scanner;
import java.util.Random;

public class Vetor {
    Scanner scanner = new Scanner(System.in);

    final int TAMANHO = 50;

    public void bucarNumero(int[] vetor, int n) {
        System.out.print("Insira um número para verificarmos se ele está no vetor: ");
        n = scanner.nextInt();
        boolean encontrado = false;
        for(int i = 0; i<vetor.length; i++) {
            if(n == vetor[i]) {
                encontrado = true;
                System.out.println();
                System.out.println("Número correspondente encontrado: " + vetor[i]);
                System.out.println("Encontrado no índice: " + (i + 1));
            }
        }
        if(!encontrado) {
            System.out.printf("Número não encontrado.");
        }
    }

    public void exibirVetor(int[] vetor) {
        System.out.printf("Vetor gerado: ");
        for(int i = 0; i<vetor.length; i++) {
            System.out.println(vetor[i] + " ");
        }
        System.out.println();
    }

    public void preencherVetor(int[] vetor) {
        Random r = new Random();
        for(int i = 0; i<vetor.length; i++) {
            vetor[i] = r.nextInt(TAMANHO);
        }
    }
}
