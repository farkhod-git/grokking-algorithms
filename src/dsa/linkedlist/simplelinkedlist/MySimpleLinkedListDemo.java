package dsa.linkedlist.simplelinkedlist;

public class MySimpleLinkedListDemo {
    static void main() {
        MySimpleLinkedList list = new MySimpleLinkedList();
        list.add(1);
        list.addAll(new int[]{1, 2, 3});
        list.clear();
        list.offer(10);
        list.offer(11);
        list.offer(12);
        list.offer(13);
        System.out.println(list.remove());
        System.out.println(list.poll());
        System.out.println(list);
        System.out.println(list.element());
        System.out.println(list.peek());
        System.out.println(list);
    }
}
