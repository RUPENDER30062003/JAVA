import java.util.*;
public class linkedlistinbuilt{
    

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;

    public Node findmid(Node head){
       
        Node slow=head;
        Node fast=head.next;

        while(fast !=null && fast.next!=null){
            slow=slow.next; //+1
            fast=fast.next.next;  // +2
        }
        return slow; //slow is my midNode
    }

    public Node mergesort(Node head){
         if(head==null || head.next==null){
            return head;
        }
        // find mid
        Node mid=findmid(head);
        // left and right ms
        Node righthead=mid.next;
        mid.next=null;
        Node newleft=mergesort(head);
        Node newright=mergesort(righthead);
        // merge
        return merge(newleft,newright);
    }

    public Node merge(Node head1,Node head2){
        Node mergedll=new Node(-1);
        Node temp=mergedll;

        while(head1 !=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }

        while(head1 !=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }

        while(head2 != null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }

        return mergedll.next;
    }

    public static void main(String args[]){

        // create 
        LinkedList<Integer> ll=new LinkedList<>();
        // add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        // 0->1->2 //
        System.out.println(ll);

        // remove
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);

        LinkedList<Integer> lm=new LinkedList<>();
        lm.addLast(5);
        lm.addLast(4);
        lm.addLast(3);
        lm.addLast(2);
        lm.addLast(1);

        System.out.println(lm);
        //mergesort(lm);
        System.out.println(lm);
        
    }
}