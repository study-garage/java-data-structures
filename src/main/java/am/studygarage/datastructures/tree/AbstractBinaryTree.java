package am.studygarage.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    /**
     * @param p position
     * @return Returns the Position of p's sibling (or null if no sibling exists).
     */
    @Override
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) { // p must be the root
            return null;
        }
        if (p == left(parent)) { //p is a left child
            return right(parent);
        } else { // p is a right child
            return left(parent);
        }
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> rv = new ArrayList<>();

        if (left(p) != null) {
            rv.add(left(p));
        }
        if (right(p) != null) {
            rv.add(right(p));
        }

        return rv;
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        int count = 0;
        if (left(p) != null) {
            count++;
        }

        if (right(p) != null) {
            count++;
        }

        return count;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return inorder();
    }

    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();

        if (!isEmpty()) {
            inorderSubtree(root(), snapshot);
        }

        return snapshot;
    }

    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null) {
            inorderSubtree(left(p), snapshot);
        }
        snapshot.add(p);

        if (right(p) != null) {
            inorderSubtree(right(p), snapshot);
        }
    }
}
