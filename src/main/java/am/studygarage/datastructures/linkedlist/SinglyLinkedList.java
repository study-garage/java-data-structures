package am.studygarage.datastructures.linkedlist;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    private int size;

    public SinglyLinkedList() {

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
        return this.head.getElement();
    }

    public T last() {
        if (isEmpty()) {
            return null;
        }
        return this.tail.getElement();
    }

    public void addFirst(T obj) {
        head = new Node<>(obj, head);
        if (isEmpty()) {
            tail = head;
        }

        size++;
    }

    public void addLast(T obj) {
        Node<T> newest = new Node<>(obj, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;

        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T rv = head.getElement();
        head = head.getNext();

        size--;

        if (isEmpty()) {
            tail = null;
        }

        return rv;
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
        SinglyLinkedList<?> that = (SinglyLinkedList<?>) o;
        if (size != that.size()) {
            return false;
        }

        Node<?> walkA = head;
        Node<?> walkB = that.head;

        while (walkA != null) {
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
        Node<T> node = head;
        while (true) {
            builder.append(node.getElement());
            if (node.getNext() == null) {
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
