package C_SearchAlgorithms;

public class SearchAlgoritms {

    public static void linearSearch(int vetor[], int num) {
        boolean encontrado = false;
        for(int i = 0; i < vetor.length; i++) {
            if(vetor[i] == num) {
                System.out.println("Elemento " + vetor[i] + " encontrado na posição " + (i + 1));
                encontrado = true;
            }
        }
        if(!encontrado) System.out.println("Elemento " + num + " não encontrado :(");
    }

    public static int binarySearch(int vetor[], int num) {
        int left = 0;
        int right = vetor.length - 1;
        int middle;

        while(left <= right) {
            middle = (left + right) / 2;
            if(vetor[middle] == num) return middle;
            if(num < vetor[middle]) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }
}
