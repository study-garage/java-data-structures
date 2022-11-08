package am.studygarage.datastructures.priorityqueue;

import am.studygarage.datastructures.common.Entry;

public interface PriorityQueue<K, V> {

    /**
     * Creates an entry with key {@code k} and value {@code v} in the priority queue.
     * @param key the key of the entry
     * @param value the value of the entry
     * @return created entry.
     */
    Entry<K, V> insert(K key, V value);

    /**
     *
     * @return returns (but does not remove) a priority queue entry (k,v)
     * having minimal key; returns null if the priority queue is empty.
     */
    Entry<K, V> min();

    /**
     *
     * @return removes and returns a priority queue entry (k,v)
     * having minimal key; returns null if the priority queue is empty.
     */
    Entry<K, V> removeMin();

    /**
     *
     * @return the number of entries in the priority queue.
     */
    int size();

    /**
     *
     * @return a boolean indicating whether the priority queue is empty.
     */
    boolean isEmpty();
}
