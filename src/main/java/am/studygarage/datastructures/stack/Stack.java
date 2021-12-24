package am.studygarage.datastructures.stack;

public interface Stack<T> {

    /**
     * Adds element e to the top of the stack.
     * @param e element
     */
    void push(T e);

    /**
     * Removes and returns the top element from the stack
     * (or <code>null</> if the stack is empty).
     * @return the top element from the stack
     */
    T pop();

    /**
     * Returns the top element of the stack, without removing it (or null if the stack is empty).
     * @return the top element of the stack
     */
    T top();

    /**
     * @return the number of elements in the stack.
     */
    int size();

    /**
     *
     * @return a boolean indicating whether the stack is empty.
     */
    boolean isEmpty();
}
