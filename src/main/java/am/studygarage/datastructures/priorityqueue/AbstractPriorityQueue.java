package am.studygarage.datastructures.priorityqueue;

import am.studygarage.datastructures.common.Entry;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
    /**
     * The comparator defining the ordering of keys in the priority queue.
     */
    private final Comparator<K> comparator;

    /**
     * Creates an empty priority queue based on the natural ordering of its keys.
     * Key must implement {@link Comparator} in order to avoid {@link ClassCastException}
     * during the compare operation
     */
    public AbstractPriorityQueue() {
        this(new DefaultComparator<>());
    }

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     */
    public AbstractPriorityQueue(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    /**
     *
     * @return a boolean indicating whether the priority queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Compares two entries based on keys
     *
     * @param a first entry
     * @param b second entry
     * @return result of comparison
     */
    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comparator.compare(a.getKey(), b.getKey());
    }

    protected boolean checkKey(K key) {
        try {
            return (comparator.compare(key, key) == 0); // see if key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    protected static class PriorityQueueEntry<K, V> implements Entry<K, V> {

        private K key;
        private V value;

        @Override public K getKey() {
            return key;
        }

        protected void setKey(K key) {
            this.key = key;
        }

        @Override public V getValue() {
            return value;
        }

        protected void setValue(V value) {
            this.value = value;
        }
    }
}
