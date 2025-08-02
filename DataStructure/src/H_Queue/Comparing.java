package H_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Comparing {
    public static void main(String[] args) {
        Queue<Integer> fila1 = new LinkedList<>();
        Queue<Integer> fila2 = new LinkedList<>();
        Queue<Integer> fila3 = new LinkedList<>();

        // Adicionando elementos nas filas
        fila1.add(1);
        fila1.add(2);
        fila1.add(3);

        fila2.add(1);
        fila2.add(2);
        fila2.add(3);

        fila3.add(1);
        fila3.add(2);
        fila3.add(4);

        System.out.println("Fila1 e Fila2 são iguais? " + compararFilas(fila1, fila2)); // true
        System.out.println("Fila1 e Fila3 são iguais? " + compararFilas(fila1, fila3)); // false
    }

    public static boolean compararFilas(Queue<Integer> fila1, Queue<Integer> fila2) {
        // Verifica se os tamanhos das filas são diferentes
        if (fila1.size() != fila2.size()) {
            return false;
        }

        // Cria cópias das filas para não alterar as originais
        Queue<Integer> copiaFila1 = new LinkedList<>(fila1);
        Queue<Integer> copiaFila2 = new LinkedList<>(fila2);

        // Compara elemento por elemento
        while (!copiaFila1.isEmpty() && !copiaFila2.isEmpty()) {
            if (!copiaFila1.poll().equals(copiaFila2.poll())) {
                return false;
            }
        }

        return true; // As filas são iguais
    }
}
