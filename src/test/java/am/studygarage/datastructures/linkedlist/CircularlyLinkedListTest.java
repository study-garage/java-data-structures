package am.studygarage.datastructures.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircularlyLinkedListTest {
    protected CircularlyLinkedList<String> list;

    @BeforeEach
    public void initList() {
        list = new CircularlyLinkedList<>();
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
        CircularlyLinkedList<Integer> first = new CircularlyLinkedList<>();
        first.addFirst(0);
        first.addFirst(1);
        first.addFirst(2);
        CircularlyLinkedList<Integer> second = new CircularlyLinkedList<>();
        second.addFirst(0);
        second.addFirst(1);
        second.addFirst(2);

        assertEquals(second, first);
    }
}
