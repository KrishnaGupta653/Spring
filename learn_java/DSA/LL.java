class Node{
    int data;
    Node next;
    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
};


public class LL {
    private static Node convertArr2LL(int[] arr){
    Node head=new Node(arr[0], null); //head node
    Node mover=head; //to traverse the linked list
    for(int i=1;i<arr.length;i++){ //from 1 to n-1
        Node temp=new Node(arr[i], null); 
        mover.next=temp;
        mover=temp;

    }
    return head;
    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50};
        Node y=new Node(arr[0], null);
        //System.out.println(y.data);

        Node head=convertArr2LL(arr); //head node
        //System.out.println(head.data);

        Node temp=head; //to traverse the linked list
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
            
        }

    
    }
}
