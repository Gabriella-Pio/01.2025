package G_Stack;
import java.util.Scanner;
import java.util.Stack;

public class Converter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int resultado;
        System.out.println("Digite um numero decimal: ");
        int numero = sc.nextInt();

        if(numero == 0) resultado = 0;

        Stack<Character> pilha = new Stack<>();
        String digitos = "01";

        while (numero > 0) {
            int resto = numero % 2;
            pilha.push(digitos.charAt(resto));
            numero = numero / 2;
        }

        StringBuilder binario = new StringBuilder();
        while(!pilha.isEmpty()){
            binario.append(pilha.pop());
        }
        System.out.println("Resultado em binario: " + binario);
    }
}
