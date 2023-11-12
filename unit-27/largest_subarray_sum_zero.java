import java.util.*;

public class largest_subarray_sum_zero {

    public static int subarray_sum_zero(int arr[]){

        // T.C-O(n)// 
        int len=0;
        for (int i = 0; i < arr.length; i++) {
            int sum=0;
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];
                if(sum==0 && j-i>len){
                    len=j-i;
                }
            }
        }
        return len+1;

    }

    public static void main(String[] args){

        // T.C-O(n)//
        int arr[]={15,-2,2,-8,1,7,10,23};

        HashMap<Integer,Integer> map=new HashMap<>();
        // (sum ,index) //

        int sum=0;
        int len=0;

        for (int j = 0; j < arr.length; j++){

            sum+=arr[j];
            if(map.containsKey(sum)){
                len=Math.max(len, j-map.get(sum));
            }else{
                map.put(sum,j);
            }

        }

        System.out.println(len);
        int subarray=subarray_sum_zero(arr);
        System.out.println(subarray);
    }
    
}
