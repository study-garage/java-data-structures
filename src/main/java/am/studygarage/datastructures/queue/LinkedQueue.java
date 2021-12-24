package am.studygarage.datastructures.queue;

import am.studygarage.datastructures.linkedlist.SinglyLinkedList;

public class LinkedQueue<T> implements Queue<T> {

    /**
     * An empty list
     *
     * Note: We use adapter design pattern approach here.
     * The adapter design pattern applies to any context where we effectively want to modify an
     * existing class so that its methods match those of a related, but different, class or interface.
     * One general way to apply the adapter pattern is to define a new class in such a way that it
     * contains an instance of the existing class as a hidden field, and then to implement each
     * method of the new class using methods of this hidden instance variable.
     * By applying the adapter pattern in this way, we have created a new class that performs some
     * of the same functions as an existing class, but repackaged in a more convenient way.
     */
    private final SinglyLinkedList<T> list = new SinglyLinkedList<>();

    /**
     * Adds element e to the back of queue.
     */
    @Override
    public void enqueue(T e) {
        list.addLast(e);
    }

    /**
     * Removes and returns the first element from the queue
     * (or null if the queue is empty).
     * @return the first element from the queue
     */
    @Override
    public T dequeue() {
        return list.removeFirst();
    }

    /**
     * Returns the first element of the queue, without removing it
     * (or null if the queue is empty).
     * @return the first element of the queue
     */
    @Override
    public T first() {
        return list.first();
    }

    /**
     * @return the number of elements in the queue.
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     *
     * @return a boolean indicating whether the queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
