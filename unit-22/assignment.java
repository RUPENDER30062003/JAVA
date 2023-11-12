import java.util.*;

public class assignment{

    static class Job {
    
        char job_id;
        int deadline;
        int profit;
    
        public Job(char job_id, int deadline, int profit){

            this.deadline = deadline;
            this.job_id = job_id;
            this.profit = profit;
            
        }
    
    }

    public static void printJobScheduling(ArrayList<Job> arr){
        
        int n = arr.size();
        
        Collections.sort(arr, (a, b) -> {return a.deadline - b.deadline;}); // ascending order //
        ArrayList<Job> result = new ArrayList<>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> { return b.profit - a.profit; }); // descending order //

        for (int i = n - 1; i > -1; i--){
            
            int slot_available;
            
            if (i == 0) {
                slot_available = arr.get(i).deadline;
            }else{
                slot_available = arr.get(i).deadline- arr.get(i - 1).deadline;
            }            
                         
            maxHeap.add(arr.get(i));
            
            while( slot_available > 0 && maxHeap.size() > 0){
                Job job = maxHeap.remove();
                slot_available--;
                result.add(job);
            }
        }

        Collections.sort(result, (a, b) -> {return a.deadline - b.deadline;});

        for (Job job : result) {
            System.out.print(job.job_id + " ");
        }

        System.out.println();
    }

    public static int roop(int arr[]){

        Arrays.sort(arr);
        int n=arr.length;
        int price=0;

        for(int i=1;i<n;i++){
            arr[i]=arr[i-1]+arr[i];
            price+=arr[i];
        }

        System.out.println(price);
        return price;

    }

    public static void reverse_first_k(Queue <Integer>q,int k){

        int n=q.size();
        Stack<Integer> s=new Stack<>();

        for(int i=0;i<k;i++){
            s.push(q.remove());
        }
        for(int i=0;i<k;i++){
            q.add(s.pop());
        }
        for(int i=0;i<n-k;i++){
            int j=q.remove();
            q.add(j);
        }
    }

    public static void maximum_of_subarray(int arr[],int k){
        int n=arr.length;
        int ans[]=new int[n-k+1];

        for(int i=0;i<n-k+1;i++){
            int maximum=arr[i];
            for(int j=i+1;j<(i+k);j++){
                maximum=Math.max(arr[j],maximum);
            }
            ans[i]=maximum;
        }
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }

    public static void binarynumber(int n){

        Queue<String> q=new LinkedList<>();

        q.add("1");

        while(n>0){
            String s1=q.peek();
            q.remove();
            System.out.println(s1);
            String s2=s1;
            q.add(s1+"0");
            q.add(s2+"1");
            n--;
        }

    }

    public static int binarynumber_(int n) {
    
        int binary = 0;
        int i = 0;  // Initialize the loop counter
    
        while (n > 0) {
            int remainder = n % 2;
            binary += remainder*(int)Math.pow(10,i);
            n = n / 2;
            i++;  
        }
    
        return binary;
    }

    public static void main(String args[]){

        System.out.println(binarynumber_(10));
        binarynumber(10);

        int arrr[]={4,3,2,6};
        roop(arrr);

        ArrayList<Job> arr = new ArrayList<Job>();
        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));
        System.out.println("Following is maximum "+ "profit sequence of jobs");
        printJobScheduling(arr);


        Queue <Integer> q=new LinkedList<>();
        for(int i=0;i<10;i++){
            q.add(i*10);
        }
        System.out.println(q);
        reverse_first_k(q,5);
        System.out.println(q);

        int arrrr[]={1,2,3,1,4,5,2,3,6};
        maximum_of_subarray(arrrr,3);


    }
}
