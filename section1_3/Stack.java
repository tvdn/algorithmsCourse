package section1_3;


public class Stack<Item> {
    private Node first;
    private int N; //size


    private class Node {
        Node next;
        Item item;
    }


    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
        N++;

    }

    public Item pop() {
        Item temp = first.item;
        first = first.next;
        N--;
        return temp;
    }

    public Item peek() {
        return first.item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getSize() {
        return N;
    }

    //1.3.19 Give a code fragment that removes the last node in a linked list whose first node
    //is first

//    public void removeLastNode(){
//        Node currentNode = first;
//        Node nextNode = currentNode.next;
//        while (true){
//            if (nextNode == null) {
//                currentNode = null;
//                break;
//            } else {
//                currentNode = currentNode.next;
//            }
//        }
//    }
public void removeLastNode() {
    if (!isEmpty()) {
        if (N == 1) {
            first = null;
        } else {
            Node current = first;
            for (int i = 0; i < N-2; i++) {
                current = current.next;
            }
            current.next = null;
        }

        N--;
    }
}

//Write a method delete() that takes an int argument k and deletes the kth element in a linked list, if it exists.
    public void delete(int k) {
        int i = 1;

        for (Node x = first; x != null ; x = x.next) {
            i++;
            if (i == k - 1) {
                x.next = x.next.next;
            }

        }


    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.push("first");
        s.push("second");
        s.push("third");
        s.push("fourth");
        s.push("fifth");
        s.push("sixth");
        s.push("seventh");

        s.delete(2);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }


    }
//    public static void main(String[] args)
//    { // Create a stack and push/pop strings as directed on StdIn.
//        Stack<String> s = new Stack<String>();
//        while (true) {
//
//            String item = StdIn.readLine();
//            if (item.equals("0")) break;   //exit program when input is "0"
//            if (!item.equals("-"))
//                s.push(item);
//            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
//        }
//        StdOut.println("(" + s.size() + " left on stack)");
//    }
}
//to be or not to - be - - that - - - is