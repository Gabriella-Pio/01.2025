package H_Queue;
import java.util.LinkedList;
import java.util.Queue;

public class ProcessSimulation {
    public static void main(String[] args) {
        Queue<Process> fila = new LinkedList<>();

        // Adicionando processos na fila
        fila.add(new Process(500));
        fila.add(new Process(300));
        fila.add(new Process(1000));
        fila.add(new Process(200));

        int totalTime = 0;

        System.out.println("Ordem de execução dos processos: ");
        while(!fila.isEmpty()) {
            Process currentProcess = fila.poll(); // Remove o processo
            System.out.println(currentProcess);
            totalTime += currentProcess.getTime();
        }

        System.out.println("Tempo total gasto: " + totalTime + "ms");
    }

    static class Process {
        private static int contadorID = 0;
        private int id;
        private int time;

        public Process(int time) {
            this.id = ++contadorID;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public int getTime() {
            return time;
        }

        public String toString() {
            return "Process ID: " + id + ", Time: " + time + "ms";
        }
    }
}
