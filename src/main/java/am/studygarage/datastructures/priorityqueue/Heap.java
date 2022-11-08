package am.studygarage.datastructures.priorityqueue;

import am.studygarage.datastructures.common.Entry;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap<K, V> extends AbstractPriorityQueue<K, V>{
    private final ArrayList<Entry<K, V>> heap = new ArrayList<>();

    public Heap() {

    }

    public Heap(Comparator<K> comparator) {
        super(comparator);
    }

    protected int parent(int index) {
        return (index - 1) / 2;
    }

    protected int left(int index) {
        return 2 * index + 1;
    }

    protected boolean hasLeft(int index) {
        return left(index) < heap.size();
    }

    protected int right(int index) {
        return 2 * index + 2;
    }

    protected boolean hasRight(int index) {
        return right(index) < heap.size();
    }

    /**
     * Exchanges the entries at indices i and j of the array list.
     */
    protected void swap(int i, int j) {
        Entry<K,V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Moves the entry at index higher, if necessary, to restore the heap property.
     */
    protected void upheap(int index) {
        while (index > 0) { // root
            int parentIndex = parent(index);
            if (compare(heap.get(index), heap.get(parentIndex)) >= 0) { // proper heap
                break;
            }
            swap(index, parentIndex);
            index = parentIndex; // continue from the parent position
        }
    }

    /**
     * Moves the entry at index lower, if necessary, to restore the heap property.
     */
    protected void downheap(int index) {
        while (hasLeft(index)) { // bottom
            int leftIndex = left(index);
            int smallChildIndex = leftIndex;
            if (hasRight(index)) {
                int rightIndex = right(index);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
                    smallChildIndex = rightIndex;
                }
            }
            if (compare(heap.get(smallChildIndex), heap.get(index)) >= 0) { // proper heap
                break;
            }
            swap(index, smallChildIndex);
            index = smallChildIndex; // continue from child position
        }
    }

    @Override
    public Entry<K, V> insert(K key, V value) {
        checkKey(key);
        Entry<K, V> entry = new PriorityQueueEntry<>(key, value);
        // add to the end of the list
        heap.add(entry);
        // upheap and fix the heap
        upheap(heap.size() - 1);

        return entry;
    }

    @Override
    public Entry<K, V> min() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    @Override
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        Entry<K, V> entry = heap.get(0);
        // put minimum item at the end
        swap(0, heap.size() - 1);
        // remove minimum item from the list
        heap.remove(heap.size() - 1);

        // fix heap from the root
        downheap(0);

        return entry;
    }

    @Override
    public int size() {
        return heap.size();
    }
}
