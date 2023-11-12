import java.util.*;


public class assignment3 {
    public static void main(String[] args) {
        
        int arr[]={1,5,8,19};

        int sum=0;

        PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            pq.add(arr[i]);
        }

        int half=sum/2;

        int operation=0;

        while(sum>half && !pq.isEmpty()) {
            int top=(pq.remove()/2);    
            sum -= (top);
            pq.add(top);
            operation++;
        }

        System.out.println(operation);
    }
}
