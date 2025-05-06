package F_LinkedLists;

class LinkedList { // Classe para representar a lista encadeada
    Node head; // Referência para o primeiro nó da lista

    public LinkedList() { // Contrutor para inicializar a lista encadeada
        this.head = null; // Lista começa vazia
    }

    public void insertEndD(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void insertStartD(int data) { // Método para inserir um novo nó no início lista
        Node newNode = new Node(data);
        newNode.next = head.next;
        newNode.prev = head.prev;
        head.next = newNode;
    }

    public void insertEnd(int data) { // Método para inserir um novo nó no fim lista
        Node newNode = new Node(data); //Cria um novo nó com o valor
        if (head == null) { // Se a lista estiver vazia
            head = new Node();
            head.next = newNode; // O novo nó é o primeiro da lista
        } else {
            Node current = head;
            while (current.next != null) { // Vai até o último nó
                current = current.next;
            }
            current.next = newNode; // Insere o novo nó no final da lista
        }
    }

    public void insertStart(int data) { // Método para inserir um novo nó no início lista
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next = newNode;
    }

    public void insertOrd (int data) { // Método para inserir um novo entre elementos na lista
        Node newNode = new Node(data);
        Node current = head.next;
        Node previous = head;

        if (previous == null || current == null) { // Se a lista estiver vazia
            previous = new Node();
            current = newNode; // O novo nó é o primeiro da lista
        } else if (current.data > data) {
            newNode.next = current;
            current = newNode;
        } else {
            while(current != null && current.data < data) {
                previous = current;
                current = current.next;
            }
            newNode.next = current;
            previous.next = newNode;
        }
    }

    public void printList() { // Método para exibir os elementos da lista
        if (head == null) {
            System.out.println("Lista Vazia");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " "); //Exibe o valor do nó
                current = current.next; // Vai para o próximo nó
            }
        }
    }
}