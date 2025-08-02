package Prova;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Digite uma operação: ");
        String operation = sc.nextLine();
        
        // Usa o Try para tratar os erros
        try {
            System.out.println(checkExpression(operation));
        } catch (Exception e) {
            //Printa o erro
            e.printStackTrace();
        }
    }

    private static String checkExpression(String operation) throws Exception{
        Stack<Character> operations = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for(int i = 0; operation.length() > i; i++) {
            char current = operation.charAt(i);
            
            //Verifica se é um número,se sim adiciona o número na resposta final
            if (Character.isDigit(current)) { 
                answer.append(current);
                continue;
            }

            //Verifica se o atual e o anterior são operadores
            if (i>0 && !Character.isDigit(current) && !Character.isDigit(operation.charAt(i-1))) { 
                throw new Exception("Dois operadores sem número");
            }
            
            //Verifica se o atual e o anterior são números e joga um erro
            if (i>0 &&Character.isDigit(current) && Character.isDigit(operation.charAt(i-1))) { 
                throw new Exception("Dois números sem operador");
            }

            //Verifica o caractere atual se é soma ou subtração e coloca na pilha
            if (String.valueOf(current).matches("\\+|\\-")) {
                operations.push(current);

            //Verifica o caractere da pilha tiver precedência maior, remove e imprime o topo da pilha
            // e adiciona o caractere atual na pilha
            } else if (!operations.isEmpty() && operations.lastElement().toString().matches("\\*|\\/")
                    && String.valueOf(current).matches("\\+|\\-")) {
                answer.append(operations.pop());
                operations.push(current);
            }

            //Verifica o caractere atual se é soma ou verifica se a precedência é menor ou a pilha está vazia
            // e adiciona o caractere de precedencia maior na pilha
            if (String.valueOf(current).matches("\\*|\\/") && (operations.isEmpty()||operations.lastElement().toString().matches("\\-|\\+") )){
                operations.push(current);

            //Verifica se o caractere atual tem precedencia igual ao topo da pilha, ele remove e imprime o topo da pilha
            // e adiciona o caractere atual na pilha
            } else if (!operations.isEmpty() && operations.lastElement().toString().matches("\\*|\\/")
                    && String.valueOf(current).matches("\\*|\\/")) {
                answer.append(operations.pop());
                operations.push(current);
            }


            //Verifica abertura de parenteses e adiciona na pilha
            if (String.valueOf(current).matches("\\(")) {
                operations.push(current);

            //Verifica a Fehcamento dos Parentêses
            } else if (String.valueOf(current).matches("\\)")) {
                // Verifica se na pilha tem a abertura, caso negativo joga um erro
                if(!operations.contains((char) 40)){
                    throw new Exception("Parenteses inválidos: não encontrada abertura");
                }

                //Limpa a pilha após os parênteses
                while(!operations.isEmpty()){
                    if (!operations.peek().equals((char)40)) {
                        answer.append(operations.pop());
                    }else{
                        //elimina a abertura de parênteses da pilha
                        operations.pop();
                    }        
                }
            }
        }

        // Desempilha o resto na resposta
        while (!operations.isEmpty()) {
                answer.append(operations.pop());      
        }

        //Retorna o valor da Resposta Final posfixada
        return answer.toString();
    }
}