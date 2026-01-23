//A linked list is a collection of nodes where each node stores data and a reference to the next node.
//[value | next]

class Node {
    int value;
    Node next;

    // Constructor
    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
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

        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);

        list.display();
    }
}







