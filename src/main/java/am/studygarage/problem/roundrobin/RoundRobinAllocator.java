package am.studygarage.problem.roundrobin;

import am.studygarage.datastructures.linkedlist.CircularlyLinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A wrapper class for the Round-Robin allocation problem solution.
 */
public class RoundRobinAllocator {

    private final CircularlyLinkedList<Consumer> consumers;

    public RoundRobinAllocator() {
        this.consumers = new CircularlyLinkedList<>();
    }

    public void addConsumers(Collection<? extends Consumer> consumers) {
        for (Consumer consumer : consumers) {
            addConsumer(consumer);
        }
    }

    /**
     * Add new customer to the end of consumers chain
     */
    public void addConsumer(Consumer consumer) {
        this.consumers.addLast(consumer);
    }

    /**
     * Circularly assign given tasks(objects) to consumers.
     * The idea behind this method is an example of usage of {@link CircularlyLinkedList}
     *
     * @param objects to assign to <code>Consumers</code>
     */
    public <T> void allocate(Collection<Task<T>> objects) {
        for (Task<T> object : objects) {
            consumers.first().addValue(object);
            skipOne();
        }
    }

    public void skipOne() {
        consumers.rotate();
    }

    List<Task<?>> getCurrentTasks() {
        if (consumers.isEmpty()) {
            return new ArrayList<>();
        }

        return consumers.first().getValues();
    }
}