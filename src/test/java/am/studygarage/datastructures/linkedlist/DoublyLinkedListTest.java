package am.studygarage.datastructures.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublyLinkedListTest {
    protected DoublyLinkedList<String> list;

    @BeforeEach
    public void initList() {
        list = new DoublyLinkedList<>();
    }
    @Test
    public void testSizeEmpty() {
        assertEquals(0, list.size());
    }

    @Test
    public void testAdd() {
        list.addFirst("Greg");
        list.addFirst("Brian");
        list.addFirst("Berkin");
        assertEquals("[Berkin, Brian, Greg]", list.toString());
    }

    @Test
    public void testSizeNonEmpty() {
        list.addFirst ("Greg");
        list.addFirst ("Brian");
        list.addFirst ("Berkin");
        assertEquals(3, list.size());
    }

    @Test
    public void testEquality() {
        DoublyLinkedList<Integer> first = new DoublyLinkedList<>();
        first.addFirst(0);
        first.addFirst(1);
        first.addFirst(2);
        DoublyLinkedList<Integer> second = new DoublyLinkedList<>();
        second.addFirst(0);
        second.addFirst(1);
        second.addFirst(2);

        assertEquals(second, first);
    }
}
