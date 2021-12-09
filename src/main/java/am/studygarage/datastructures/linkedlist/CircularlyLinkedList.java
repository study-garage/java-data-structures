package am.studygarage.datastructures.linkedlist;

public class CircularlyLinkedList<T> {

    private Node<T> tail;

    private int size;

    public CircularlyLinkedList() {

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
        return this.tail.getNext().getElement();
    }

    public T last() {
        if (isEmpty()) {
            return null;
        }
        return this.tail.getElement();
    }

    public void rotate() {
        if (!isEmpty()) {
            tail = tail.getNext();
        }
    }

    public void addFirst(T obj) {
        if (isEmpty()) {
            tail = new Node<>(obj, null);
            tail.setNext(tail);
        } else {
            Node<T> newest = new Node<>(obj, tail.getNext());
            tail.setNext(newest);
        }

        size++;
    }

    public void addLast(T obj) {
        addFirst(obj);
        tail = tail.getNext();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<T> head = tail.getNext();
        if (head == tail) {
            // last one
            tail = null;
        } else {
            // Dereference first
            tail.setNext(head.getNext());
        }

        size--;

        return head.getElement();
    }

    /**
     * we consider two lists to be equivalent if they have the same length and contents that are
     * element-by-element equivalent.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CircularlyLinkedList<?> that = (CircularlyLinkedList<?>) o;
        if (size != that.size()) {
            return false;
        }

        Node<?> walkA = tail.getNext();
        Node<?> walkB = that.tail.getNext();

        while (walkA != tail) {
            if (!walkA.getElement().equals(walkB.getElement())) {
                return false;
            }

            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("[");
        for (int i = 0; i < size; i++){
            builder.append(tail.getNext().getElement());
            if (i == size - 1) {
                break;
            }
            builder.append(",").append(" ");
            rotate();
        }
        builder.append("]");
        return builder.toString();
    }

    private static class Node<T> {
        private final T element;
        private Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
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
    }
}
