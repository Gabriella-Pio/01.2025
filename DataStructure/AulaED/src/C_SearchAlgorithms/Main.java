package C_SearchAlgorithms;

import B_VectorCreation.Vector;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector vetor = new Vector(20);
        int[] Va = new int[20];

        vetor.fillVector(Va);
        vetor.printVector(Va);
        System.out.println();

        chooseAlgorithm(sc, Va);
    }

    public static void chooseAlgorithm(Scanner sc, int[] vetor) {
        System.out.println(" ------------------------------- ");
        System.out.println(" --- Choose Search Algorithm --- ");
        System.out.println(" ------------------------------- ");
        System.out.println(" 1 - Linear Search           --- ");
        System.out.println(" 2 - Binary Search           --- ");
        System.out.println(" ------------------------------- ");

        System.out.print("Digite sua escolha: ");
        int op = sc.nextInt();

        if(op == 1) {
            SearchAlgoritms.linearSearch(vetor, inputValue(sc));
        } else if(op == 2) {
            System.out.println("Elemento encontrado no índice: " + SearchAlgoritms.binarySearch(vetor, inputValue(sc)));

        }
    }

    public static int inputValue (Scanner sc) {
        System.out.print("Digite o valor que deseja encontrar: ");
        int num = sc.nextInt();
        return num;
    }
}