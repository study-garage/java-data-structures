package am.studygarage.datastructures.priorityqueue;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

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
    }
}
