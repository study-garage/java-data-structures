package am.studygarage.datastructures.tree;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    protected Node<E> root;
    private int size = 0;

    public Position<E> addRoot(E e) throws IllegalArgumentException {
        if (!isEmpty()) {
            throw new IllegalArgumentException("Tree is not empty");
        }

        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("p already has a left child");
        }

        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;

        return child;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        if (parent.getRight() != null) {
            throw new IllegalArgumentException("p already has a right child");
        }

        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;

        return child;
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
     * Attaches the internal structure of trees T1 and T2 as the respective left and right subtrees
     * of leaf position p and resets T1 and T2 to empty trees; an error condition occurs
     * if p is not a leaf.
     * @param p - position under which needs to be attached
     * @param t1 - left node
     * @param t2 - right node
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) {
        Node<E> node = validate(p);
        if (isInternal(p)) {
            throw new IllegalArgumentException("p must be a leaf");
        }

        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }

        size += t1.size() + t2.size();
    }

    /**
     * Removes the node at position p,
     * replacing it with its child (if any), and returns the element that had been stored at p;
     * an error occurs if p has two children.
     * @param p
     * @return
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);

        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("node has two children");
        }

        Node<E> child = node.getLeft() != null ? node.getLeft() : node.getRight();
        if (child != null) {
            child.setParent(node.getParent());
        }
        if (node == root) {
            root = child;
        } else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }

        size--;
        E rv = node.getElement();
        // help garbage collection
        node.setElement(null);
        node.setParent(null);
        node.setLeft(null);
        node.setRight(null);

        return rv;
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    @Override
    public Position<E> root() {
        return this.root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementsIterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
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

    /**
     * Validates the position and returns it as a node
     */
    protected Node<E> validate(Position<E> p) {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid Position type");
        }

        Node<E> node = (Node<E>) p;

        // deleted node refers to itself,
        // in accordance with our conventional representation of a defunct node
        if (node.getParent() == node) {
            throw new IllegalArgumentException("p detached from the tree");
        }

        return node;
    }

    protected Node<E> createNode(E element, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<>(element, parent, left, right);
    }

    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }
}
