package dsa.linkedlist.doublylinkedlist;

public class MyDoublyLinkedListDemo {
    static void main() {
        MyDoublyLinkedList list = new MyDoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addFirst(11);
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
        list.offerLast(12);
        list.removeLast();
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}
