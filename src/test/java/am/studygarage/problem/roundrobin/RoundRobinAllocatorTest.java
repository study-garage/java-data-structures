package am.studygarage.problem.roundrobin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundRobinAllocatorTest {
    private RoundRobinAllocator roundRobinAllocator;
    private Collection<Task<Integer>> objects;

    @BeforeEach
    public void initList() {
        roundRobinAllocator = new RoundRobinAllocator();
        roundRobinAllocator.addConsumer(new Agent());
        roundRobinAllocator.addConsumer(new Agent());
        roundRobinAllocator.addConsumer(new Agent());
    }

    @BeforeEach
    public void initTasks() {
        List<Integer> numbers = List.of(3, 5, 3, 1, 5, 9, 10);
        objects = new ArrayList<>();
        for (Integer num : numbers) {
            objects.add(new Task<>(num));
        }
    }

    @Test
    public void allocationTest() {
        roundRobinAllocator.allocate(objects);

        List<Task<?>> currentTasks = roundRobinAllocator.getCurrentTasks();
        assertEquals(2, currentTasks.size());
        assertEquals("5", currentTasks.get(0).getValue().toString());
        assertEquals("5", currentTasks.get(1).getValue().toString());

        roundRobinAllocator.skipOne();
        currentTasks = roundRobinAllocator.getCurrentTasks();
        assertEquals(2, currentTasks.size());
        assertEquals("3", currentTasks.get(0).getValue().toString());
        assertEquals("9", currentTasks.get(1).getValue().toString());

        roundRobinAllocator.skipOne();
        currentTasks = roundRobinAllocator.getCurrentTasks();
        assertEquals(3, currentTasks.size());
        assertEquals("3", currentTasks.get(0).getValue().toString());
        assertEquals("1", currentTasks.get(1).getValue().toString());
        assertEquals("10", currentTasks.get(2).getValue().toString());
    }
}
