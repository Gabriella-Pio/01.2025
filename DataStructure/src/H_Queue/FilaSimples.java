package H_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FilaSimples {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        //Operações básicas
        fila.add("A");
        fila.add("B");
        fila.add("C");

        System.out.println("------------------------------------------");
        System.out.println("Primeiro da fila: " + fila.peek());

        System.out.println("------------------------------------------");
        while(!fila.isEmpty()) {
            String processo = fila.poll();
            System.out.println("Executando: " + processo);
        }
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
    }
}