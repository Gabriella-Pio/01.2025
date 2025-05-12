package G_Stack;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<>();

        pilha.push("A");
        pilha.push("B");
        pilha.push("C");

        System.out.println("Size: " + pilha.size());
        System.out.println("Topo: " + pilha.peek());
        System.out.println("Pop: " + pilha.pop());
        System.out.println("IsEmpty: " + pilha.isEmpty());
        System.out.println("-------------------------------");
        System.out.println("Size: " + pilha.size());
        System.out.println("Top: " + pilha.peek());
        System.out.println("Pop: " + pilha.pop());
        System.out.println("IsEmpty: " + pilha.isEmpty());
        System.out.println("-------------------------------");
        System.out.println("Size: " + pilha.size());
        System.out.println("Top: " + pilha.peek());
        System.out.println("Pop: " + pilha.pop());
        System.out.println("IsEmpty: " + pilha.isEmpty());
        System.out.println("-------------------------------");
    }
}
