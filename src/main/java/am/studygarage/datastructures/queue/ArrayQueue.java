package am.studygarage.datastructures.queue;

public class ArrayQueue<T> implements Queue<T> {
    public static final int CAPACITY = 1000;

    /**
     * generic array used for storage
     */
    private T[] data;

    /**
     * index of the front element
     * end = (f + size) % data.length;
     */
    private int f;

    private int size;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity) {
        // Safe cast: ignore warning
        data = (T[]) new Object[capacity];
    }

    /**
     * Adds element e to the back of queue.
     */
    @Override
    public void enqueue(T e) {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }

        // use modular arithmetic to find the end of the queue as array is implemented circularly
        int position = (f + size) % data.length;

        data[position] = e;
        size++;
    }

    /**
     * Removes and returns the first element from the queue
     * (or null if the queue is empty).
     * @return the first element from the queue
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T o = data[f];
        // dereference to help garbage collection
        data[f] = null;

        // As array is implemented circularly
        f = (f + 1) % data.length;

        size--;

        return o;
    }

    /**
     * Returns the first element of the queue, without removing it
     * (or null if the queue is empty).
     * @return the first element of the queue
     */
    @Override
    public T first() {
        if (isEmpty()) {
            return null;
        }
        return data[f];
    }

    /**
     * @return the number of elements in the queue.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @return a boolean indicating whether the queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
