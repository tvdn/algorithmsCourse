package section1_3;

import java.util.Iterator;

public class LinkedListMyImpl<T> implements Iterable<T> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Node next;
        T item;
    }

    public boolean isEmpty() {return size == 0;}

    public int getSize() {return size;}

    public void addHead(T item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        if (isEmpty()) tail = head;
        if (size == 1) tail = oldHead;
        size++;
    }

    public T removeHead() {
        T item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public void addTail(T item) {
        if (isEmpty()) {
            tail = new Node();
            tail.item = item;
            size++;
            head = tail;

        } else {
            Node oldTail = tail;
            tail = new Node();
            oldTail.next = tail;
            tail.item = item;
            if (isEmpty()) head = tail;
            size++;
        }
    }

    /*
    Write a function that takes the first Node in a linked list as argument and
    (destructively) reverses the list, returning the first Node in the result
     */

    public void reverse(Node node1) {

        for (int i = size - 1; i > 0; i--) {
            Node current = head;
            Node second = head.next;
            for (int j = 0; j < i; j++) {
                T temp = current.item;
                current.item = second.item;
                second.item = temp;

                current = second;
                second = second.next;
            }
        }

    } //deze implementatie swapt enkel items, geen nodes.

    public Node reverse2(Node node) {
        Node first = node;
        Node reverse = null;

        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }

        return reverse;
    }


    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        Node current = head;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (isEmpty()) return null;
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        LinkedListMyImpl<Integer> list = new LinkedListMyImpl<>();

        for (int i = 1; i < 7; i++) {
            list.addTail(i);
        }

        list.forEach(System.out::println);
        System.out.println();
        //Node node2 = list.reverse2(list.head);
        list.forEach(System.out::println);





    }


}
