import java.util.*;

public class priorityqueue{

    static class Student implements Comparable<Student>{// overriding //
        
        String name;
        int rank;

        public Student(int rank,String name){
            this.rank=rank;
            this.name=name;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank; // ascending order //
        }

    }

    

    public static void main(String[] args) {

        PriorityQueue<Integer> pr = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);
        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }

        PriorityQueue<Student>  psa=new PriorityQueue<>();
        PriorityQueue<Student>  ps =new PriorityQueue<>(Comparator.reverseOrder());

        ps.add(new Student(4,"A"));
        ps.add(new Student(5,"B"));
        ps.add(new Student(2,"C"));
        ps.add(new Student(12,"D"));

        while(!ps.isEmpty()){
            System.out.println(ps.peek().name+"->"+ ps.peek().rank);
            ps.remove();
        }

    }
}
