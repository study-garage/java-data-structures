package am.studygarage.problem;

import am.studygarage.datastructures.linkedlist.CircularlyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundRobinAllocationTest {
    private RoundRobinAllocation<Agent, Integer> roundRobinAllocation;

    @BeforeEach
    public void initList() {
        List<Integer> numbers = List.of(3, 5, 3, 1, 5, 9);
        CircularlyLinkedList<Agent> agents = new CircularlyLinkedList<>();

        agents.addFirst(new Agent());
        agents.addFirst(new Agent());
        agents.addFirst(new Agent());

        this.roundRobinAllocation = new RoundRobinAllocation<>(agents, numbers);
    }

    @Test
    public void allocationTest() {
        CircularlyLinkedList<Agent> allocated = roundRobinAllocation.allocate();

        assertEquals("[3, 1]", allocated.first().getValues().toString());
        allocated.rotate();

        assertEquals("[5, 5]", allocated.first().getValues().toString());
        allocated.rotate();

        assertEquals("[3, 9]", allocated.first().getValues().toString());
    }

    static class Agent implements Allocatable {
        private final List<Object> values;

        public Agent() {
            this.values = new ArrayList<>();
        }

        public List<Object> getValues() {
            return values;
        }

        @Override
        public void addValue(Object value) {
            this.values.add(value);
        }

        @Override
        public String toString() {
            return "Agent{" +
                    "values=" + getValues() +
                    '}';
        }
    }

}
