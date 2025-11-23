package upei.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void testLinkedListBasicOps() {
        MyLinkedList<String> list = new MyLinkedList<>();
        assertTrue(list.isEmpty());
        list.add("A");
        list.add("B");
        list.add("C");
        assertTrue(list.contains("A"));
        assertTrue(list.contains("B"));
        assertTrue(list.contains("C"));
        assertEquals(3, list.size());
        list.remove("B");
        assertFalse(list.contains("B"));
        assertEquals(2, list.size());
        list.remove("A");
        list.remove("C");
        assertTrue(list.isEmpty());
    }

    @Test
    void testIterationAndGet() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("X"); list.add("Y"); list.add("Z");
        StringBuilder s = new StringBuilder();
        for (String value : list) s.append(value);
        assertEquals("XYZ", s.toString());
        assertEquals("X", list.get(0));
        assertEquals("Z", list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }

    @Test
    void testRemoveNonExistent() {
        MyLinkedList<String> list = new MyLinkedList<>();
        assertFalse(list.remove("Ghost"));
    }
}
