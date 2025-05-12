package D_SortingAlgoritms;

import B_VectorCreation.Vector;

public class Main {
    public static void main(String[] args) {
        int TAMANHO = 10;

        int[] vA = new int[TAMANHO];
        Vector.fillVector(vA);

        int[] vB = new int[TAMANHO];
        Vector.fillVector(vB);

        int[] vC = new int[TAMANHO];
        Vector.fillVector(vC);

        System.out.println("Vetor A - Bubble Sort");
        Vector.printVector(vA);
        System.out.println(div());
        SortingAlgoritms.bubbleSort(vA);
        System.out.println(div());
        Vector.printVector(vA);
        System.out.println(div());
        System.out.println();

        System.out.println("Vetor B - Selection Sort");
        Vector.printVector(vB);
        System.out.println(div());
        SortingAlgoritms.selectionSort(vB);
        System.out.println(div());
        Vector.printVector(vB);
        System.out.println(div());
        System.out.println();

        System.out.println("Vetor C - Insertion Sort");
        Vector.printVector(vC);
        System.out.println(div());
        SortingAlgoritms.selectionSort(vC);
        System.out.println(div());
        Vector.printVector(vC);
        System.out.println(div());
        System.out.println();
    }

    public static String div() {
        return "--------------------------------------------";
    }
}
