package am.studygarage.datastructures.tree;

import am.studygarage.datastructures.queue.LinkedQueue;
import am.studygarage.datastructures.queue.Queue;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }

    public int height(Position<E> p) {
        int h = 0;
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }

        return h;
    }

    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();

        if (!isEmpty()) {
            preorderSubtree(root(), snapshot);
        }

        return snapshot;
    }

    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        // for preorder, we add position p before exploring subtrees
        snapshot.add(p);
        for (Position<E> child : children(p)) {
            preorderSubtree(child, snapshot);
        }
    }

    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();

        if (!isEmpty()) {
            postorderSubtree(root(), snapshot);
        }

        return snapshot;
    }

    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> child : children(p)) {
            preorderSubtree(child, snapshot);
        }
        // for postorder, we add position p after exploring subtrees
        snapshot.add(p);
    }

    public Iterable<Position<E>> breadthFirst() {
        List<Position<E>> snapshot = new ArrayList<>();

        if (!isEmpty()) {
            Queue<Position<E>> queue = new LinkedQueue<>();
            queue.enqueue(root());

            while (!queue.isEmpty()) {
                // remove from front of the queue
                Position<E> p = queue.dequeue();
                // report this position
                snapshot.add(p);

                for (Position<E> child : children(p)) {
                    // add children to back of queue
                    queue.enqueue(child);
                }
            }
        }

        return snapshot;
    }
}