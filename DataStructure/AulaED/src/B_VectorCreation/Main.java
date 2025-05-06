package B_VectorCreation;

public class Main {
    public static void main(String[] args) {
        //int[] vetor = new int[50];

        int TAMANHO = 10;
        Vector vetor = new Vector(TAMANHO);
        int[] v1 = new int[TAMANHO];

        //preencher vetor
        vetor.fillVector(v1);
//        fillVector(v1); // Local
//        Random random = new Random();
//        for (int i = 0; i < vetor.length; i++) {
//            vetor[i] = random.nextInt(100) + 1;
//        }

        //imprimir vetor
        vetor.printVector(v1);
//        printVector(v1); // Local
//        System.out.print("Vetor gerado: ");
//        for(int i = 0; i < vetor.length; i++) {
//            System.out.println(vetor[i] + ", ");
//        }
    }

//    public static void fillVector(int[] vetor) {
//        Random random = new Random();
//        for (int i = 0; i < vetor.length; i++) {
//            vetor[i] = random.nextInt(100) + 1;
//        }
//    }

//    public static void printVector(int[] vetor) {
//        System.out.print("Vetor gerado: { ");
//        for(int i = 0; i < vetor.length; i++) {
//            System.out.print(vetor[i] + " ");
//        }
//        System.out.print(" }");
//        System.out.println();
//    }
}
