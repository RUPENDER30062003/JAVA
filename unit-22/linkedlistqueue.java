import java.util.*;
public class linkedlistqueue{

    
    static class Node{
        int data;
        Node next;

        Node (int data){
            this.data=data;
            this.next=null;
        }
    }

    static class Queue{

        static Node head=null;
        static Node tail=null;

        public static boolean isEmpty(){
            return head==null && tail== null;
            // *&& will be used insted of &
        }

        public static void add(int data){

            Node newnode=new Node(data);

            if(head==null){
                head=tail=newnode;
                return;
            }
            tail.next=newnode;
            tail=newnode;
            
        }

        public static int remove(){

            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }

            // single element //
            int front=head.data;

            if(tail==head){
                tail=head=null;
            }else{
                 head=head.next;
            }
            
            return front;

        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return head.data;
        }

    }

    public static void main(String args[]){

        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}