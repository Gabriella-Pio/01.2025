package F_LinkedLists;

public class Node { // Lista para representar um nó na lista encadeada
    int data; // Dados armazenados no nó
    Node next; // referência para o próximo nó
    Node prev; // referência para o nó anterior

    public Node(int data) {
        this.data = data;
        this.next = null; //O próximo nó é nulo por padrão
        this.prev = null;
    }

    public Node() {
        this.next = null;
    }
}