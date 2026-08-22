package dsa.linkedlist.doublylinkedlist;

import java.util.*;

public class MyDoublyLinkedList implements Deque<Integer> {
    private static class Node {
        Integer val;
        Node next;
        Node prev;

        public Node(Integer val) {
            this.val = val;
        }

        public Node(Node prev, Integer val) {
            this.val = val;
            this.prev = prev;
        }

        public Node(Integer val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node n = head; n != null; n = n.next) {
            sb.append(n.val);
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void addFirst(Integer val) {
        Node node = new Node(val, head);

        if (isEmpty()) {
            head = tail = node;
            size = 1;
            return;
        }

        size++;
        head.prev = node;
        head = node;
    }

    @Override
    public void addLast(Integer val) {
        Node node = new Node(tail, val);

        if (isEmpty()) {
            head = tail = node;
            size = 1;
            return;
        }

        size++;
        tail.next = node;
        tail = node;
    }

    @Override
    public boolean offerFirst(Integer el) {
        addFirst(el);
        return true;
    }

    @Override
    public boolean offerLast(Integer el) {
        addLast(el);
        return true;
    }

    private Integer unlinkFirst() {
        Node f = head;
        Node n = f.next;

        f.next = null;
        if (n != null)
            n.prev = null;
        else
            tail = null;
        head = n;

        size--;
        return f.val;
    }

    private Integer unlinkLast() {
        Node t = tail;
        Node p = t.prev;

        t.prev = null;
        if (p != null) {
            p.next = null;
        } else {
            head = null;
        }
        tail = p;

        size--;
        return t.val;
    }

    @Override
    public Integer removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        return unlinkFirst();
    }

    @Override
    public Integer removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        return unlinkLast();
    }

    @Override
    public Integer pollFirst() {
        if (isEmpty())
            return null;
        return unlinkFirst();
    }

    @Override
    public Integer pollLast() {
        if (isEmpty())
            return null;
        return unlinkLast();
    }

    @Override
    public Integer getFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        return head.val;
    }

    @Override
    public Integer getLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        return tail.val;
    }

    @Override
    public Integer peekFirst() {
        Node f = head;
        return f == null ? null : f.val;
    }

    @Override
    public Integer peekLast() {
        Node t = tail;
        return t == null ? null : t.val;
    }

    private void unlink(Node x) {
        Node p = x.prev;
        Node n = x.next;
        x.prev = x.next = null;

        if (p != null) {
            p.next = n;
        } else {
            head = n;
        }

        if (n != null) {
            n.prev = p;
        } else {
            tail = p;
        }
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        for (Node x = head; x != null; x = x.next) {
            if (Objects.equals(x.val, o)) {
                unlink(x);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        for (Node x = tail; x != null; x = x.prev) {
            if (Objects.equals(x.val, o)) {
                unlink(x);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean add(Integer integer) {
        return offerLast(integer);
    }

    @Override
    public boolean offer(Integer integer) {
        return offerLast(integer);
    }

    @Override
    public Integer remove() {
        return removeFirst();
    }

    @Override
    public Integer poll() {
        return pollFirst();
    }

    @Override
    public Integer element() {
        if (isEmpty())
            throw new NoSuchElementException();
        return peekFirst();
    }

    @Override
    public Integer peek() {
        return peekFirst();
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        if (c.isEmpty())
            return true;

        Iterator<? extends Integer> iterator = c.iterator();


        Node first = new Node(null, iterator.next());
        Node current = first;
        while (iterator.hasNext()) {
            Node newNode = new Node(current, iterator.next());
            current.next = newNode;
            current = newNode;
        }

        if (isEmpty()) {
            head = first;
            tail = current;
            return true;
        }

        tail.next = first;
        current.prev = tail;
        tail = current;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void push(Integer integer) {
        addFirst(integer);
    }

    @Override
    public Integer pop() {
        return getFirst();
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new AbsIterator(head) {
            @Override
            public Integer next() {
                Node n = cursor;
                cursor = cursor.next;
                return n.val;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    private static abstract class AbsIterator implements Iterator<Integer> {
        protected Node cursor;

        public AbsIterator(Node cursor) {
            this.cursor = cursor;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }
    }

    @Override
    public Iterator<Integer> descendingIterator() {
        return new AbsIterator(tail) {
            @Override
            public Integer next() {
                Node n = cursor;
                cursor = cursor.prev;
                return n.val;
            }
        };
    }

    @Override
    public LinkedList<Integer> reversed() {
        return null;
    }

    public void reverse() {
        if (isEmpty())
            return;

        Node temp = head;
        head = tail;
        tail = temp;

        Node prev = null;
        Node curr = tail;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
    }


    // only List interface methods

    public boolean addAll(int index, Collection<? extends Integer> c) {
        return false;
    }

    public Integer get(int index) {
        return 0;
    }

    public Integer set(int index, Integer element) {
        return 0;
    }

    public void add(int index, Integer element) {

    }

    public Integer remove(int index) {
        return 0;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<Integer> listIterator() {
        return null;
    }

    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    public List<Integer> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
