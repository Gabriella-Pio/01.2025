package A_Introduction;
import java.util.Random;
import java.util.Scanner;

public class Vetor {
    Scanner scanner = new Scanner(System.in);

    final int TAMANHO = 50;
    String nome;


    public void buscarNumero(int[] vetor, int numero) {
        System.out.println("Insira um número para verificarmos se ele está no vetor.");
        numero = scanner.nextInt();
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

    public void exibirVetor(int[] vetor) {
        System.out.print("Vetor gerado: ");
        for(int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    public void preencherVetor(int[] vetor) {
        Random random = new Random();
        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(100) + 1;
        }
    }
}
