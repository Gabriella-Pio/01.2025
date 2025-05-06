package B_VectorCreation;
import java.util.Random;

public class Vector {
    private int[] numbers;

    public Vector(int tamanho) {
        numbers = new int[tamanho];
    }

    public static void printVector(int[] vetor) {
        System.out.print("Vetor : { ");
        for(int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.print(" }");
        System.out.println();
    }

    public static int[] fillVector(int[] vetor) {
        Random r = new Random();
        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = r.nextInt(100) + 1;
        }
        return vetor;
    }

    public static int[] fillOrdVector(int[] vetor) {
        Random r = new Random();
        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = vetor[i];
        }
        return vetor;
    }
}
