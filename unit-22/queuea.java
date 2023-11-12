import java.util.*;

public class queuea{

    public static void interleave(Queue<Integer>q){

        Queue <Integer> firsthalf=new LinkedList<>();
        int size=q.size();

        for(int i=0;i<size/2;i++){
             firsthalf.add(q.remove());
        }

        while(!firsthalf.isEmpty()){
            q.add(firsthalf.remove());
            q.add(q.remove());
        }
    }

    public static void queuereverse(Queue<Integer>q){
        Stack<Integer>s=new Stack<>();
        int size=q.size();
        int i=0;
        // while(!q.isEmpty())//

        while(i<size){
            s.push(q.remove());
            i++;
        }

        // while(!s.isEmpty())//
        int j=0;
        while(j<size){
            q.add(s.pop());
            j++;
        }
        
    }

    public static void printnonrepeating(String str){

        int freq[]=new int[26];
        Queue<Character> q=new LinkedList<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();

    }

    public static void main(String args[]){

        String str ="aabccxb";
        printnonrepeating(str);

        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<11;i++){
            q.add(i);
        }

        /*
        interleave(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
        System.out.println();
        */

        queuereverse(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
        System.out.println();

        Deque<Integer> deque=new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        System.out.println(deque);
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque);
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());



    }
}