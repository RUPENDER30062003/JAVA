import java.util.*;
public class assignment3{

    public static Node head;

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static void segregateEvenOdd(){

        Node end=head;
        Node prev=null;
        Node curr=head;
        while(end.next !=null){
            end=end.next;
        }
    
        Node new_end=end;

        while(curr.data %2 != 0 && curr!=end){
            new_end.next = curr;
            curr=curr.next;
            new_end.next.next = null;
            new_end=new_end.next;
        }

        if(curr.data %2 ==0){
            head=curr;
            while(curr != end){
                if(curr.data % 2 == 0){
                    prev=curr;
                    curr=curr.next;
                }else{
                    prev.next = curr.next;
                    curr.next = null;
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                    }
                }
        }else{
                prev = curr;
                if(new_end != end && end.data %2 != 0){
                    prev.next = end.next;
                    end.next = null;
                    new_end.next = end;
                }
            }

    }

    public static Node segregateEvenOdd_(){

        Node even=null;
        Node odd=null;
        Node o=null;
        Node e=null;

        while(head!=null){
            if(head.data%2==0){
                if(even ==null){
                    even=head;
                    e=head;
                }else{
                    e.next=head;
                    e=e.next;
                }
            }else{
                if(odd == null){
                    odd=head;
                    o=head;
                }else{
                    o.next=head;
                    o=o.next;
                }
            }
            head=head.next;
        }

            if(e != null){
                e.next=odd;
            }
            if(o !=null){
                o.next=null;
            }
            if(even != null){
                return even;
            }
            return odd;

    }

    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
            }
        System.out.println();
    }
    
    public static void main(String args[]){
        assignment3 llist = new assignment3();
        llist.push(11);
        llist.push(10);
        llist.push(8);
        llist.push(7);
        llist.push(4);
        llist.push(3);
        llist.push(1);
        System.out.println("Linked List");
        llist.printList();
        head=llist.segregateEvenOdd_();
        System.out.println("updated Linked List");
        llist.printList();

    }
}