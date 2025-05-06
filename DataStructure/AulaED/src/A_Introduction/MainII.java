package A_Introduction;

public class MainII {
    public static void main(String[] args) {
        Vetor vetor = new Vetor();

        int[]v1 = new int[vetor.TAMANHO];

        vetor.preencherVetor(v1);
        vetor.exibirVetor(v1);
        vetor.buscarNumero(v1, 0);
    }
}
