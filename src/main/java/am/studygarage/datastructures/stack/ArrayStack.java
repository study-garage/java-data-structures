package am.studygarage.datastructures.stack;

public class ArrayStack<T> implements Stack<T> {

    /**
     * default array capacity
     */
    public static final int CAPACITY = 1000;

    /**
     * generic array used for storage
     */
    private T[] data;

    /**
     * index of the top element in stack
     */
    private int t = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        // Safe cast: ignore warning
        data = (T[]) new Object[capacity];
    }

    /**
     * Adds element e to the top of the stack.
     * @param e element
     * @throws IllegalStateException if data sized reached its capacity
     */
    @Override
    public void push(T e) throws IllegalStateException {
        if (size( ) == data.length) {
            throw new IllegalStateException("Stack is full");
        }

        // increment top and store new value
        data[++t] = e;
    }

    /**
     * Removes and returns the top element from the stack
     * (or <code>null</> if the stack is empty).
     * @return the top element from the stack
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T o = data[t];
        // dereference to help garbage collection
        data[t] = null;
        t--;
        return o;
    }

    /**
     * Returns the top element of the stack, without removing it (or null if the stack is empty).
     * @return the top element of the stack
     */
    @Override
    public T top() {
        if (isEmpty()) {
            return null;
        }
        return data[t];
    }

    /**
     * @return the number of elements in the stack.
     */
    @Override
    public int size() {
        return t + 1;
    }

    /**
     *
     * @return a boolean indicating whether the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return t == -1;
    }
}
