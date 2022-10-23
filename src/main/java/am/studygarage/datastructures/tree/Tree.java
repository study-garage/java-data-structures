package am.studygarage.datastructures.tree;

import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {
    /**
     * @return the position of the root of the tree (or null if empty)
     */
    Position<E> root();

    /**
     * @param p position
     * @return the position of the parent of position p (or null if <code>p</code> is the root)
     * @throws IllegalArgumentException - invalid position is sent as a parameter
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     *
     * @param p position
     * @return an iterable collection containing the children of position <code>p</code> (if any)
     * @throws IllegalArgumentException - invalid position is sent as a parameter
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    /**
     *
     * @param p position
     * @return the number of children of position <code>p</code>
     * @throws IllegalArgumentException - invalid position is sent as a parameter
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /**
     *
     * @param p position
     * @return true if position <code>p</code> has at least one child
     * @throws IllegalArgumentException - invalid position is sent as a parameter
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     *
     * @param p position
     * @return true if position <code>p</code> does not have any children
     * @throws IllegalArgumentException - invalid position is sent as a parameter
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     *
     * @param p position
     * @return true if position <code>p</code> is the root of the tree
     * @throws IllegalArgumentException - invalid position is sent as a parameter
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    int size();

    boolean isEmpty();

    @Override
    Iterator<E> iterator();

    Iterable<Position<E>> positions();
}
