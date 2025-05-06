package F_LinkedLists;

class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserindo valores na lista
        list.insertEndD(10);
        list.insertEndD(20);
        list.insertEndD(30);
        list.insertEndD(40);

        System.out.print("Lista encadeada: "); //  Exibindo a lista encadeada
        list.printList(); // Resultado esperado: 10 -> 20 -> 30 -> 40 -> null
        System.out.println();

        // Inserindo valores na lista
        list.insertStartD(8);
        list.insertStartD(2);

        System.out.print("Lista encadeada: "); //  Exibindo a lista encadeada
        list.printList();
        System.out.println();

        // Inserindo valores na lista
        list.insertOrd(9);
        list.insertOrd(25);

        System.out.print("Lista ordenada: "); //  Exibindo a lista
        list.printList();
    }
}
