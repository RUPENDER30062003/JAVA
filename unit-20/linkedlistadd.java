import java.util.*;

public class linkedlistadd{

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head; // inside class as a property //

    public static Node tail; 

    public static int size;

    public void addFirst(int data){

        // time complexity :O(1) //

        // step1=create new node //
        Node newNode=new Node(data);
        size++;

        if(head==null){
            head=tail=newNode;
            return;
        }
        
        // step2=newnode.next=head;
        newNode.next=head; //link //

        // step3=newNode //
        head=newNode;
    }

    public void addLast(int data){

        Node newNode=new Node(data);
        size++;

        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;

    }

    public void printLinkList(){  //T.C:  O(n) //

        if(head==null){
            System.out.println("ll is empty");
            return;
        }

        Node temp=head;

        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }

        System.out.print("null");
        System.out.println();

    }

    public void add(int index,int data){


        if(index==0){
            addFirst(data);
            return;
        }

        Node newNode=new Node(data);
        
        size++;

            Node temp=head;
            int i=0;
            while(i<index-1){
                temp=temp.next;
                i++;
            }
            newNode.next=temp.next;
            temp.next=newNode;
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
            }

            Node pre=head;
            for(int i=0;i<size-2;i++){
                pre=pre.next;
            }

            int val=pre.next.data;
            pre.next=null;
            tail=pre;
            size--;
            return val;

    }

    public int search(int key){
        Node temp=head;
        int i=0;

        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }

        return -1;
    }

    public int helper(Node head,int key){
        
        if(head==null){
            return -1;
        }

        if(head.data==key){
            return 0;
        }

        int index=helper(head.next,key);

        if(index==-1){
            return -1;
        }

        return index+1;
    }

    public int recSearch(int key){
        return  helper(head,key);
    }

    public void reverse(){

        Node prev=null;
        Node curr=tail=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public int delete_nth_from_last(int n){

        // calculate size
        int size=0;
        Node temp=head;
        while(temp != null){
            temp=temp.next;
            size++;
        }

        if(n==size){
            int val=head.data;
            head=head.next; // remove first 
            return val;
        }

        // size-n or previous index //
        int i=1;
        int i_to_find=size-n;
        Node prev=head;
        while(i< i_to_find){
            prev=prev.next;
            i++;
        }
        int val=pre.next.data;
        prev.next=prev.next.next;
        return val;

    }

    // slow fast concept //
    public Node findmid(Node head){
        Node slow=head;
        Node fast=head;

        while(fast !=null && fast.next!=null){
            slow=slow.next; //+1
            fast=fast.next.next;  // +2

        }
        return slow; //slow is my midNode

    }

    public boolean checkPalindrome(){

        if(head==null || head.next==null){
            return true;
        }
        //Step 1: find middle Node //
        Node midNode=findmid(head);

        // step 2: reverse 2nd array //
        Node pre=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        Node right=pre; // right half head
        Node left=head;

        // step 3- check left half and right half
        while(right !=null){
            if(left.data != right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    public static boolean iscycle(){
        Node slow=head;
        Node fast=head;
        while(fast != null && fast.next!= null){
            slow=slow.next; // +1 //
            fast=fast.next.next; // +2 //
            if(slow==fast){
                return true; // cycle exists //
            }
        }
        return false; // cycle doesnot exist  //
    }

    public static void removeCycle(){
        // detect cycle

        Node slow=head;
        Node fast=head;
        boolean cycle=false;

        while(fast !=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                cycle=true;
                break;
            }
        }

        if(cycle ==false){
            return ;
        }

        // find meeting point //
        slow=head;
        Node prev=null; //last node
        while(slow != fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        
        // remove cycle -> last.next=null
        prev.next=null;
    }

    public Node findmid_merge(Node head){
       
        Node slow=head;
        Node fast=head.next;

        while(fast !=null && fast.next!=null){
            slow=slow.next; //+1
            fast=fast.next.next;  // +2
        }
        return slow; //slow is my midNode
    }

    public Node mergesort(Node head){
         if(head==null || head.next == null){
            return head;
        }
        // find mid
        Node mid=findmid_merge(head);
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

    public void zigzag(){
        // find mid
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        Node mid=slow;

        // reverse 2nd half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;

        while(curr!= null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node left=head;
        Node right=prev;
        Node nextl,nextr;

        // alt merrge -zigzag merge

        while(left!=null && right!=null){
            nextl=left.next;
            left.next=right;
            nextr=right.next;
            right.next=nextl;

            left=nextl;
            right=nextr;
        }
    }

    public static void main(String args[]){

        linkedlistadd ll=new linkedlistadd();
        ll.printLinkList();
        ll.addFirst(2);
        ll.printLinkList();
        ll.addFirst(1);
        ll.printLinkList();
        ll.addLast(3);
        ll.printLinkList();
        ll.addLast(4);
        ll.add(2,9);
        ll.printLinkList();
        System.out.println(ll.size);
        ll.removeFirst();
        ll.printLinkList();
        System.out.println(ll.size);

        ll.removeLast();
        ll.printLinkList();
        System.out.println(ll.size);

        System.out.println(ll.search(3));
        System.out.println(ll.recSearch(3));

        ll.reverse();
        ll.printLinkList();

        ll.printLinkList();
        ll.delete_nth_from_last(2);
        ll.printLinkList();

        linkedlistadd lm=new linkedlistadd();
        //lm.addLast(2);
        lm.addLast(3);

        System.out.println();
        lm.printLinkList();
        System.out.println(lm.checkPalindrome());

        head=new Node(1);
        Node temp=new Node(2);        
        head.next=temp;
        head.next.next=new Node(3);
        head.next.next.next=temp;

        // 1->2->3->1
        System.out.println(iscycle());
        removeCycle();
        System.out.println(iscycle());

        ll.addFirst(1);
        ll.addFirst(4);
        ll.printLinkList();

        ll.head=ll.mergesort(ll.head);
        ll.printLinkList();
        ll.removeFirst();
        ll.printLinkList();

        // O(nlogn)

        ll.zigzag();
        ll.printLinkList();
        
        linkedlistadd ln=new linkedlistadd();
        ln.addLast(5);
        ln.addLast(4);
        ln.addLast(3);
        ln.addLast(2);
        ln.addLast(1);

        ln.printLinkList();
        ln.head=ln.mergesort(ln.head);
        ln.printLinkList();

    }
} 