import java.util.*;
public class deque{
    static class stack{
        Deque<Integer> deque=new LinkedList<>();

        public void Push(int data){
            deque.addLast(data);

        }

        public int pop(){
            return deque.removeLast();
        }

        public int peek(){
            return deque.getLast();
        }
    }

    static class queueb{
        Deque<Integer> deque=new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        }

        public int remove(){
            return deque.removeFirst();
        }

        public int peek(){
            return deque.getFirst();
        }
    }

    public static void main(String args[]){
        
        stack s=new stack();
        s.Push(1);
        s.Push(2);
        s.Push(3);
        System.out.println("peek ="+s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

        queueb q=new queueb();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("peek ="+ q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}