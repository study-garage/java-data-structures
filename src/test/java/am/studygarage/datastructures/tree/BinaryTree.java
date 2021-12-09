package am.studygarage.datastructures.tree;

public interface BinaryTree<E> extends Tree<E> {

    /**
     *
     * @param p position
     * @return the position of the left child of p (or null if p has no left child)
     * @throws IllegalArgumentException - invalid position is sent as a parameter
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    /**
     *
     * @param p position
     * @return the position of the right child of p (or null if p has no right child)
     * @throws IllegalArgumentException - invalid position is sent as a parameter
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    /**
     *
     * @param p position
     * @return the position of the sibling of p (or null if p has no sibling)
     * As defined each position in Binary tree has only one sibling
     * @throws IllegalArgumentException - invalid position is sent as a parameter
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
