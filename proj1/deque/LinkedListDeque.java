package deque;

public class LinkedListDeque<T> {
    private final Node<T> SENTINEL;
    private int size;

    private static class Node<type>{
        private type item;
        private Node<type> _prev;
        private Node<type> _next;
        public Node(){
        }
        public Node(type i, Node<type> p, Node<type> n){
            item = i;
            setPrev(p);
            setNext(n);
        }
        public Node<type> getPrev() {
            return _prev;
        }
        public Node<type> getNext() {
            return _next;
        }
        public void setPrev(Node<type> prev) {
            _prev = prev;
        }
        public void setNext(Node<type> next) {
            _next = next;
        }
    }

    public void addFirst(T item){
        Node<T> newNode = new Node<>(item, SENTINEL, SENTINEL.getNext());
        SENTINEL.getNext().setPrev(newNode);
        SENTINEL.setNext(newNode);
        size++;
    }

    public void addLast(T item){
        Node<T> newNode = new Node<>(item, SENTINEL.getPrev(), SENTINEL);
        SENTINEL.getPrev().setNext(newNode);
        SENTINEL.setPrev(newNode);
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (Node<T> n = SENTINEL.getNext(); n != SENTINEL; n = n.getNext()){
            System.out.print(n.item + " ");
        }
        System.out.println();
    }

    public T removeFirst(){
        Node<T> removed = SENTINEL.getNext();
        if (removed != SENTINEL){
            SENTINEL.getNext().getNext().setPrev(SENTINEL);
            SENTINEL.setNext(SENTINEL.getNext().getNext());
            size--;
        }
        return removed.item;
    }

    public T removeLast(){
        Node<T> removed = SENTINEL.getPrev();
        if (removed != SENTINEL) {
            SENTINEL.getPrev().getPrev().setNext(SENTINEL);
            SENTINEL.setPrev(SENTINEL.getPrev().getPrev());
            size--;
        }
        return removed.item;
    }

    public T get(int index){
        Node<T> currentNode = SENTINEL;
        for (int i = 0; (i <= index & i <= size); i++){
            currentNode = currentNode.getNext();
        }
        return currentNode.item;
    }

    public LinkedListDeque(){
        this.SENTINEL = new Node<>();
        SENTINEL.setNext(SENTINEL);
        SENTINEL.setPrev(SENTINEL);
    }

    public T getRecursive(int index){
        return getRecursiveInner(index, SENTINEL);
    }

    private T getRecursiveInner(int i, Node<T> currentNode){
        if (i == 0 | i > size - 1){
            return currentNode.item;
        }
        return getRecursiveInner(i - 1, currentNode.getNext());
    }

//    public Iterator<T> iterator(){}

//    public boolean equals(Object o){}
}
