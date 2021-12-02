package am.studygarage.datastructures.linkedlist;

public class DoublyLinkedList<T> {

    private final Node<T> header;
    private final Node<T> trailer;

    private int size;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, null, header);
        header.setNext(trailer);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T first() {
        if (isEmpty()) {
            return null;
        }
        return this.header.getNext().getElement();
    }

    public T last() {
        if (isEmpty()) {
            return null;
        }
        return this.trailer.getPrev().getElement();
    }

    public void addFirst(T obj) {
        addBetween(obj, header, header.getNext());
    }

    public void addLast(T obj) {
        addBetween(obj, trailer.getPrev(), trailer);
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        return remove(header.getNext());
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        return remove(trailer.getPrev());
    }

    // private update methods
    // Adds element e to the linked list in between the given nodes. ∗/
    private void addBetween(T obj, Node<T> predecessor, Node<T> successor) {
        // create and link a new node
        Node<T> newest = new Node<>(obj, successor, predecessor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private T remove(Node<T> node) {
        Node<T> predecessor = node.getPrev( );
        Node<T> successor = node.getNext( );

        predecessor.setNext(successor);
        successor.setNext(predecessor);

        size--;

        return node.getElement();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("[");
        Node<T> node = header.getNext();
        for (int i = 0; i < size; i++){
            builder.append(node.getElement());
            if (i == size - 1) {
                break;
            }
            builder.append(",").append(" ");
            node = node.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

    private static class Node<T> {
        private final T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(T element, Node<T> next, Node<T> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
}
