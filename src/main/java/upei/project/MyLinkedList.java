package upei.project;
import java.util.Iterator;

/**
 * A simple, generic singly linked list implementation.
 * Supports adding, removing, searching, and iteration.
 *
 * @param <T> the type of elements stored in the list
 */
public class MyLinkedList<T> implements Iterable<T> {

    /**
     * Private static inner class for nodes of the list.
     * Each node holds data and a reference to the next node.
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T d) { data = d; }
    }

    private Node<T> head; // First node in the list
    private int size = 0; // Number of elements in the list

    /**
     * Adds an item to the end of the list.
     * @param item the item to add
     */
    public void add(T item) {
        Node<T> node = new Node<>(item);
        if (head == null) { // List is empty
            head = node;
        } else {
            Node<T> cur = head;
            while (cur.next != null) cur = cur.next; // Traverse to the end
            cur.next = node;
        }
        size++;
    }

    /**
     * Removes the first occurrence of an item from the list.
     * @param item the item to remove
     * @return true if item was found and removed, false otherwise
     */
    public boolean remove(T item) {
        Node<T> cur = head, prev = null;
        while (cur != null) {
            // Check for equality with item, including nulls
            if ((cur.data == null && item == null) || (cur.data != null && cur.data.equals(item))) {
                if (prev == null) head = cur.next;     // Removing head
                else prev.next = cur.next;             // Removing non-head
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false; // Item not found
    }

    /**
     * Checks if the list contains the specified item.
     * @param item the item to look for
     * @return true if item is in the list, false otherwise
     */
    public boolean contains(T item) {
        for (T t : this) { // Use iterator
            if ((t == null && item == null) || (t != null && t.equals(item))) return true;
        }
        return false;
    }

    /**
     * Returns the number of items in the list.
     * @return number of items
     */
    public int size() { return size; }

    /**
     * Checks if the list is empty.
     * @return true if the list has no items
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * Gets the item at the specified index.
     * @param index position of the item (0-based)
     * @return item at the given index
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> cur = head; int i = 0;
        while (i < index) { cur = cur.next; i++; }
        return cur.data;
    }

    /**
     * Returns an iterator to allow use in for-each loops.
     * @return an iterator over elements of type T
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> cur = head;
            public boolean hasNext() { return cur != null; }
            public T next() {
                T data = cur.data;
                cur = cur.next;
                return data;
            }
        };
    }

    /**
     * Returns a string representation of the list.
     * @return string version of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> cur = head;
        boolean first = true;
        while (cur != null) {
            if (!first) sb.append(", ");
            sb.append(cur.data);
            first = false;
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
