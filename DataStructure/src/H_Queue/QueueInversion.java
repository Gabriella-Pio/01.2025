package H_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueInversion {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();

        // Adicionando elementos na fila
        fila.add(1);
        fila.add(2);
        fila.add(3);
        fila.add(4);
        fila.add(5);

        System.out.println("Fila original: " + fila);

        // Inverter a fila
        inverterFila(fila);

        System.out.println("Fila invertida: " + fila);
    }

    public static void inverterFila(Queue<Integer> fila) {
        Stack<Integer> pilha = new Stack<>();

        // Passo 1: Transferir os elementos da fila para a pilha
        while (!fila.isEmpty()) {
            pilha.push(fila.poll());
        }

        // Passo 2: Transferir os elementos da pilha de volta para a fila
        while (!pilha.isEmpty()) {
            fila.add(pilha.pop());
        }
    }
}
