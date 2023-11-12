import java.util.*;
public class assignment{

    public static int max_balance_string(String str){
        int balance=0;
        int partition=0;
        int n=str.length();

        if(n%2!=0){
            System.out.println("NOT A BALANCE STRING");
            return 0;
        }

        for(int i=0;i<n;i++){

            if(str.charAt(i)=='L'){
                balance++;
            }else{
                balance--;
            }

            if(balance==0){
                partition++;
            }
        }

        System.out.println(partition);
        return partition;
    }

    public static int kthOdd(int range[],int K){

        if(K<=0){
            return 0;
        }

        int L=range[0];
        int R=range[1];

        if((R & 1)>0){
            int Count=(int)Math.ceil((R-L+1)/2);
            if(K>Count){
                return 0;
            }else{
                return(R-2*K+2);
            }
        }else{
            int Count=(R-L+1)/2;
            if(K>Count){
                return 0;
            }else{
                return(R-2*K+1);
            }
        }

    }

        public static int findKthLargestOdd(int start, int end, int k) {
            List<Integer> oddNumbers = new ArrayList<>();
    
            // Generate a list of odd numbers within the given range [start, end].
            for (int i = start; i <= end; i++) {
                if (i % 2 != 0) {
                    oddNumbers.add(i);
                }
            }
    
            // Sort the list in descending order.
            Collections.sort(oddNumbers, Collections.reverseOrder());
    
            // Retrieve the kth largest odd number.
            if (k > 0 && k <= oddNumbers.size()) {
                return oddNumbers.get(k - 1);
            } else {
                return Integer.MIN_VALUE;
            }
        }

    public static char[] lexo_small(int n, int k){

        char arr[] =new char[n];
        Arrays.fill(arr, 'a');

        for(int i=n-1;i>=0;i--){

            k-=i;
            if(k>=0){
                if(k>=26){
                    arr[i]='z';
                    k -= 26;
                }else{
                    arr[i]=(char)(k+97-1);
                    k-=arr[i]-'a'+1;
                }                
            }else{
                break;
            }
            k+=i;

        }
        return arr;

    }

    public static int stocks(int prices[]){
        int n=prices.length;
        int buy = prices[0], max_profit = 0;
        for (int i = 1; i < n; i++) {
            if (buy > prices[i]){
                buy = prices[i];
            }else if(prices[i]-buy > max_profit){
                max_profit = prices[i] - buy;
            }
        }
        return max_profit;
    }

    public static int ans = 10000000;

    public static void solve(int a[], int n, int k,int index, int sum, int maxsum){

        if (k == 1) {
            maxsum = Math.max(maxsum, sum);
            sum = 0;
            for (int i = index; i < n; i++){
                sum += a[i];
            }
            maxsum = Math.max(maxsum, sum);
            ans = Math.min(ans, maxsum);
            return;
        }

        sum = 0;
        for (int i = index; i < n; i++) {
            sum += a[i];
            maxsum = Math.max(maxsum, sum);
            solve(a, n, k - 1, i + 1, sum, maxsum);
        }

    }

    public static void main(String args[]){

        System.out.println((int)'a');

        String str="LRRRRLLRLLRL";
        max_balance_string(str);

        int p[]={-3,3};
        int k=1;
        System.out.println(kthOdd(p,k));

        int n=5,j=42;
        char arr[]=lexo_small(n, j);
        System.out.println(new String(arr));
        int a=(int)'a';
        System.out.println(a);

        int price1[]={7,6,4,3,1};
        int price2[]={7,1,5,3,6,4};

        System.out.println(stocks(price2));

        int arr1[]={1,2,3,4};
        int x=3;// x divisions
        int y=4;// Size of Array
        solve(arr1,y,x,0,0,0);
        System.out.println(ans+"\n");

    }
}