import java.util.*;

public class linkedlist{

    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head; // inside class as a property //

    public static Node tail; 

    public static int size=0;

    public static void main(String args[]){

        linkedlist ll=new linkedlist();
        ll.head=new Node(1);
        ll.head.next=new Node(2);
        // we made methods for operation in linked list class in linked list class //
        System.out.println(ll.head.next.data);
        
    }
} 