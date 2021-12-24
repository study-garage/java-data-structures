package am.studygarage.datastructures.queue;

public interface Queue<T> {

    /**
     * Adds element e to the back of queue.
     */
    void enqueue(T e);

    /**
     * Removes and returns the first element from the queue
     * (or null if the queue is empty).
     * @return the first element from the queue
     */
    T dequeue();

    /**
     * Returns the first element of the queue, without removing it
     * (or null if the queue is empty).
     * @return the first element of the queue
     */
    T first();

    /**
     * @return the number of elements in the queue.
     */
    int size();

    /**
     *
     * @return a boolean indicating whether the queue is empty.
     */
    boolean isEmpty();
}
