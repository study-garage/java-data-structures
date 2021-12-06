package am.studygarage.problem;

import am.studygarage.datastructures.linkedlist.CircularlyLinkedList;

import java.util.Collection;

public class RoundRobinAllocation<A extends Allocatable, O> {

    private final CircularlyLinkedList<A> allocators;
    private final Collection<O> objects;

    public RoundRobinAllocation(CircularlyLinkedList<A> allocators, Collection<O> objects) {
        this.allocators = allocators;
        this.objects = objects;
    }

    public CircularlyLinkedList<A> allocate() {
        for (O object : objects) {
            allocators.first().addValue(object);
            allocators.rotate();
        }

        return allocators;
    }

}