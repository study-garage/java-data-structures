package am.studygarage.datastructures.priorityqueue;

import am.studygarage.datastructures.common.Entry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnsortedPriorityQueueTest {

    @Test
    void insertAndCheckPriorities() {
        PriorityQueue<Integer, String> priorityQueue = new UnsortedPriorityQueue<>();

        priorityQueue.insert(7, "a");
        priorityQueue.insert(3, "c");
        priorityQueue.insert(77, "b");
        priorityQueue.insert(8, "kb");
        priorityQueue.insert(109, "k");
        priorityQueue.insert(10, "dd");

        Entry<Integer, String> min = priorityQueue.min();

        assertEquals(3, min.getKey());

        priorityQueue.removeMin();

        assertEquals(5, priorityQueue.size());

        assertEquals(7, priorityQueue.min().getKey());
    }

}
