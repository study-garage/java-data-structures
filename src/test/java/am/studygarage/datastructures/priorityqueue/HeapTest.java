package am.studygarage.datastructures.priorityqueue;

import am.studygarage.datastructures.common.Entry;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeapTest {

    @Test
    void insertEntriesThenRemoveAssertSorted() {
        Comparator<Integer> comparator = Integer::compareTo;
        PriorityQueue<Integer, String> heap = new Heap<>(comparator);
        heap.insert(5, "e");
        heap.insert(2, "b");
        heap.insert(1, "a");
        heap.insert(3, "c");
        heap.insert(4, "d");
        heap.insert(7, "g");
        heap.insert(6, "f");

        StringBuilder stringBuilder = new StringBuilder();
        while (!heap.isEmpty()) {
            stringBuilder.append(heap.removeMin().getValue());
        }
        String result = stringBuilder.toString();

        assertEquals("abcdefg", result);

        assertEquals(15, ((Heap<?, ?>)heap).getOperations());
    }

    @Test
    void insertCollectionThenRemoveAssertSorted() {
        Comparator<Integer> comparator = Integer::compareTo;
        List<Entry<Integer, String>> list = List.of(
                new AbstractPriorityQueue.PriorityQueueEntry<>(5, "e"),
                new AbstractPriorityQueue.PriorityQueueEntry<>(2, "b"),
                new AbstractPriorityQueue.PriorityQueueEntry<>(1, "a"),
                new AbstractPriorityQueue.PriorityQueueEntry<>(3, "c"),
                new AbstractPriorityQueue.PriorityQueueEntry<>(4, "d"),
                new AbstractPriorityQueue.PriorityQueueEntry<>(7, "g"),
                new AbstractPriorityQueue.PriorityQueueEntry<>(6, "f"));
        PriorityQueue<Integer, String> heap = new Heap<>(list, comparator);

        StringBuilder stringBuilder = new StringBuilder();
        while (!heap.isEmpty()) {
            stringBuilder.append(heap.removeMin().getValue());
        }
        String result = stringBuilder.toString();

        assertEquals("abcdefg", result);

        assertEquals(12, ((Heap<?, ?>)heap).getOperations());
    }
}
