package am.studygarage.datastructures.tree;

import am.studygarage.datastructures.common.Position;
import am.studygarage.datastructures.util.ArraysSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayBinaryTree<E> extends AbstractBinaryTree<E> {

    private static final int DEFAULT_CAPACITY = 16;

    // TODO remove functionality
    private Object[] treeData;
    private int size;

    public ArrayBinaryTree() {
        treeData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayBinaryTree(int capacity) {
        if (capacity >= 0) {
            treeData = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Illegal initial capacity: " + capacity);
        }
    }

    /**
     * Creates a root for an empty tree, storing e as the element, and returns the position of that root;
     * an error occurs if the tree is not empty.
     * @return the position of the root
     * @throws IllegalArgumentException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalArgumentException {
        if (!isEmpty()) {
            throw new IllegalArgumentException("Tree is not empty");
        }

        Node<E> node = createNode(e, 0);
        treeData[0] = node;
        size++;

        return node;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        if (left(parent) != null) {
            throw new IllegalArgumentException("p already has a left child");
        }

        Node<E> node = createNode(e, 2 * parent.getIndex() + 1);
        treeData[node.getIndex()] = node;
        size++;

        return node;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        if (right(parent) != null) {
            throw new IllegalArgumentException("p already has a right child");
        }

        Node<E> node = createNode(e, 2 * parent.getIndex() + 2);
        treeData[node.getIndex()] = node;
        size++;

        return node;
    }

    /**
     * Replaces the element at Position p with e and returns the replaced element.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E rv = node.getElement();
        node.setElement(e);

        return rv;
    }

    /**
     *
     * @param p position
     * @return the position of the left child of p (or null if p has no left child)
     * @throws IllegalArgumentException - invalid position is sent as a parameter
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return elementData(2 * node.index + 1);
    }

    /**
     *
     * @param p position
     * @return the position of the right child of p (or null if p has no right child)
     * @throws IllegalArgumentException - invalid position is sent as a parameter
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return elementData(2 * node.index + 2);
    }

    /**
     * @return the position of the root of the tree (or null if empty)
     */
    @Override
    public Position<E> root() {
        return elementData(0);
    }

    /**
     * The parent of {@code p} has index equal to (f(p) − 1)/2
     * @param p position
     * @return the position of the parent of position p (or null if <code>p</code> is the root)
     * @throws IllegalArgumentException - invalid position is sent as a parameter
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return elementData((node.getIndex() -1) / 2);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return arrayPositions().iterator();
    }

    /**
     * Validates the position and returns it as a node
     */
    protected Node<E> validate(Position<E> p) {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid Position type");
        }

        return (Node<E>) p;
    }

    /**
     * Increases the capacity to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     * @throws OutOfMemoryError if minCapacity is less than zero
     */
    private Object[] grow(int minCapacity) {
        int oldCapacity = treeData.length;
        if (oldCapacity > 0) {
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return treeData = Arrays.copyOf(treeData, newCapacity);
        } else {
            return treeData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    @SuppressWarnings("unchecked")
    Node<E> elementData(int index) {
        return (Node<E>) treeData[index];
    }

    protected Node<E> createNode(E element, int index) {
        return new Node<>(element, index);
    }

    private Iterable<E> arrayPositions() {
        List<E> snapshot = new ArrayList<>();

        for (int i = 0; i < treeData.length; i++) {
            Node<E> node = elementData(i);
            if (node == null) {
                snapshot.add(null);
            } else {
                snapshot.add(node.getElement());
            }
        }

        return snapshot;
    }

    private class ElementsIterator implements Iterator<E> {
        Iterator<Position<E>> positionIterator = positions().iterator();

        @Override
        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        @Override
        public E next() {
            return positionIterator.next().getElement();
        }

        @Override
        public void remove() {
            positionIterator.remove();
        }
    }

    protected static class Node<E> implements Position<E> {
        private E element;
        private final int index;

        public Node(E element, int index) {
            this.element = element;
            this.index = index;
        }

        @Override
        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public int getIndex() {
            return index;
        }
    }
}
