package dsa.linkedlist.simplelinkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySimpleLinkedList implements Iterable<Integer> {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // QUEUE methods

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(int el) {
        for (int i : this)
            if (i == el)
                return true;

        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                int data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public int[] toArray() {
        int[] arr = new int[size];
        int i = 0;
        for (int el : this)
            arr[i++] = el;

        return arr;
    }

    public boolean add(int el) {
        Node newNode = new Node(el);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
        return true;
    }

    public boolean remove(int el) {
        if (isEmpty())
            return false;

        Node current = head;

        if (current.data == el) {
            if (size == 1)
                tail = null;

            head = head.next;

            size--;
            return true;
        }

        while (current.next != null) {
            if (current.next.data == el) {
                current.next = current.next.next;
                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public boolean containsAll(MySimpleLinkedList c) {
        for (int el : c)
            if (!contains(el))
                return false;

        return true;
    }

    public boolean addAll(int[] c) {
        if (c.length == 0)
            return true;

        Node first = new Node(c[0]);
        Node current = first;
        for (int i = 1; i < c.length; i++) {
            current.next = new Node(c[i]);
            current = current.next;
        }

        if (isEmpty()) {
            head = first;
        } else {
            tail.next = first;
        }
        tail = current;

        size += c.length;
        return true;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {
        Node current = head;
        while (current != null) {
            Node next = current.next;

            current.next = null;
            current.data = 0;

            current = next;
        }

        head = null;
        tail = null;
        size = 0;
    }

    public boolean offer(int el) {
        return add(el);
    }

    public int remove() {
        if (isEmpty())
            throw new NoSuchElementException();

        return removeFirst();
    }

    public int poll() {
        if (isEmpty())
            return -1;

        return removeFirst();
    }

    private int removeFirst() {
        size--;

        Node removed = head;
        head = head.next;
        if (size == 1) {
            tail = null;
        }

        return removed.data;
    }

    public int element() {
        if (isEmpty())
            throw new NoSuchElementException();

        return head.data;
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return head.data;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int el : this) {
            sb.append(el);
            sb.append(',').append(' ');
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append(']');

        return sb.toString();
    }
}
