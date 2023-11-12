import java.util.*;

public class assignment1practice {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;

    public static int size;

    public void addFirst(int data){
        Node newnode=new Node(data);
        size++;
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
        return;
    }

    public void print(){

        if(head==null){
            System.out.println("empty");
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("->null");

    }

    public void delete_n_after_m(int n,int m){

        Node temp=head;
        int count=1;
        while(count<m){
            temp=temp.next;
            count++;
        }
        Node connect=temp;
        int count2=0;
        while(count2<n){
            connect=connect.next;
            count2++;
        }
        temp.next=connect.next;

    }
    public static void main(String[] args) {
        assignment1practice ll=new assignment1practice();
        head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        ll.print();
        ll.delete_n_after_m(2,2);
        System.out.println();
        ll.print();
        
    }
}
