package D_SortingAlgoritms;

import B_VectorCreation.Vector;

public class SortingAlgoritms {

    public static int[] bubbleSort(int[] vetor) {
        int i, j, aux;
        boolean flag_ord = true;

        for(i = 0; i < vetor.length - 1; i++) {
            for(j = 0; j < (vetor.length - 1) - i; j++) {
                if(vetor[j] > vetor[j + 1]) {
                    aux = vetor[j + 1];
                    vetor[j + 1] = vetor[j];
                    vetor[j] = aux;
                    flag_ord = false;
                    Vector.printVector(vetor);
                }
            }
            if(flag_ord) {
                i = vetor.length;
                //System.out.println("Vetor ordenado");
            }
        }
        return vetor;
    }

    public static int[] selectionSort(int[] vetor) {
        int i, j, min, aux;
        boolean flag_ord = true;

        for(i = 0; i < vetor.length - 1; i++) {
            min = i;
            for(j = i + 1; j < vetor.length; j++) {
                if(vetor[min] > vetor[j]) {
                    min = j;
                    flag_ord = false;
                }
            }
            if(!flag_ord) {
                aux = vetor[i];
                vetor[i] = vetor[min];
                vetor[min] = aux;
                Vector.printVector(vetor);
            } else {
                System.out.println("Vetor ordenado");
            }
        }
        return vetor;
    }

    public static int[] insertionSort(int[] vetor) {
        int i, j, aux;

        for(i = 1; i < vetor.length; i++) {
            aux = vetor[i];
            j = i - 1;

            while(j >= 0 && aux < vetor[j]) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = aux;
        }
        return vetor;
    }

    public static void shellSort(int[] vetor) {
        int i, j, aux;
    }
}
