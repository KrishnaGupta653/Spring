//A linked list is a collection of nodes where each node stores data and a reference to the next node.
//[value | next]
import java.util.LinkedList;
class Node {
    int value;
    Node next;

    // Constructor
    Node(int value) {
        this.value = value;
        this.next = null;
    }
}
//1.Manual Implementation of Linked List
class MyLinkedList {
    Node head;
    // Insert at end
    void add(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Display list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class linked_list {
    public static void main(String[] args) {
        //1. Using Manual Implementation
        MyLinkedList list = new MyLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.display();

        //2. Using Java's Built-in LinkedList
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        System.out.println(list2);

        list2.get(2); // Remove element at index 1



    }
}







