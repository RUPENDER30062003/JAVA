import java.util.*;
public class array{

    public static void update(int marks[]){
        for(int i=0;i<marks.length;i++ ){
            marks[i]+=1;
            System.out.println("marks["+ (i+1) +"]="+marks[i]);
            }
    }
    

    public static void array_pairs(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print(arr[i]+","+arr[j]+"  ");
            }
            System.out.println("");
        }
    }


    public static void sub_array(int arr[]){
        for(int i=0;i<arr.length;i++){
            //start //
            for(int j=i;j<arr.length;j++){
                //end//
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }System.out.println("");
            }
            System.out.println("");
        }
    }

     public static void max_min_sub_array(int arr[]){
        
        int max_sum=Integer.MIN_VALUE; 
        int min_sum=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            //start //
            for(int j=i;j<arr.length;j++){

                int currentsum=0;
                //end//                
                for(int k=i;k<=j;k++){
                    currentsum+=arr[k];
                }
                System.out.println(currentsum);
            
            if(max_sum<currentsum){
                max_sum=currentsum;
            }
            max_sum=Math.max(max_sum, currentsum);
            if(min_sum>currentsum){
                min_sum=currentsum;
            }
            min_sum=Math.min(max_sum, currentsum);

            }
        }
            System.out.println("maxsum="+max_sum);
            System.out.println("minsum="+min_sum);     
    }


    public static void max_min_sub_array_prefixsum(int arr[]){
        
        int max_sum=Integer.MIN_VALUE; 
        int min_sum=Integer.MAX_VALUE;

        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }

        for(int i=0;i<arr.length;i++){
            //start //
            for(int j=i;j<arr.length;j++){
                //end//                

                int currentsum= (i==0)? prefix[j]: prefix[j]-prefix[i-1];
                     
                if(max_sum<currentsum){
                    max_sum=currentsum;
                    }
                if(min_sum>currentsum){
                    min_sum=currentsum;
                }

            }
        }

            System.out.println("maxsum="+max_sum);
            System.out.println("minsum="+min_sum);
        
    }

    public static void max_subarray_kadane_algorithm(int arr[]){

        int maxsum=Integer.MIN_VALUE;
        int currentsum=0;
        for(int i=0;i<arr.length;i++){
            currentsum+=arr[i];
            if(currentsum<0){
                currentsum=0;
            }
            maxsum=Math.max(currentsum,maxsum);
        }
        System.out.println("max sum ="+ maxsum);

    }

    public static void min_subarray_kadane_algorithm(int arr[]){
        // if array has atleast one element negative //
        int minsum=Integer.MAX_VALUE;
        int currentsum=0;
        for(int i=0;i<arr.length;i++){
            currentsum+=arr[i];
            if(currentsum>0){
                currentsum=0;
            }
            minsum=Math.min(currentsum,minsum);
        }
        System.out.println("min sum ="+ minsum);
    }

    public static int stocks(int arr[]){
        int buy=Integer.MAX_VALUE;
        int sell=Integer.MIN_VALUE;
        int maxprofit=0;
        int maxloss=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
               int profit=arr[j]-arr[i];
               if(profit>maxprofit){
                maxprofit=profit;
               }
               if(profit<maxloss){
                maxloss=profit;
               }
            }
        }
        return maxprofit;        
    }

    public static int trapwater(int arr[]){

        int n=arr.length;
        if(n<3){
            return 0;
        }

        int left_max[]=new int[n];
        left_max[0]=arr[0];
        for(int i=1;i<n;i++){
            left_max[i]=Math.max(left_max[i-1],arr[i]);
        }

        int right_max[]=new int [n];
        right_max[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            right_max[i]=Math.max(right_max[i+1],arr[i]);
        }

        int trapped_water=0;  
        for(int i=0;i<n;i++){
            int waterlevel=Math.min(left_max[i],right_max[i]);
            trapped_water+=waterlevel-arr[i];
        }

        return trapped_water;
        
    }


    public static int largestnumber(int arr[]){
        int large=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>large){
                large=arr[i];
            }
        }
        return large;
    }

    public static void arrayoutput (int marks[]){
        for(int i=0;i<marks.length;i++ ){
            System.out.println(marks[i]);
            }
    }

    public static void arrayinput(int marks[]){
        Scanner sb=new Scanner(System.in);
        for(int i=0;i<marks.length;i++ ){
            marks[i]=sb.nextInt();
            }
    }

    public static boolean linearsearch(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return true;
            }
        } return false;
    }

     public static int linearsearchindex(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i+1;
            }
        } return -1;
    }


    public static void reverse_array(int arr[]){
        int n=arr.length;
        for(int i=0;i<=(n/2);i++){
            int temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
    }


    public static int binarysearch(int arr[],int key){
        int first=0;
        int last=arr.length-1;
        int mid=(first+last)/2;
        for(int i=0;first<=last;i++){            
            if(arr[mid]== key){   
                return mid+1;
            }else if(arr[mid]<key){
                first=mid+1;
                mid=(first+last)/2;
            }else {
                last=mid-1;
                mid=(first+last)/2;
            }
        }
        return -1;
    }

    public static void main(String args[]){

        int marks[]=new int[5];
        Scanner sc=new Scanner(System.in);

        // input arrary //
        for(int i=0;i<marks.length;i++ ){
            marks[i]=sc.nextInt();
            System.out.println("marks["+ (i+1) +"]="+ marks[i]);
            }

            update(marks);
            for (int i = 0; i < marks.length; i++) {
                System.out.println(marks[i]);
            }

            int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
            int prices[]={7,6,4,3,1};

            System.out.println(stocks(prices));
            System.out.println( trapwater(height));

            max_subarray_kadane_algorithm(marks);
            max_min_sub_array(marks);
            max_min_sub_array_prefixsum(marks);
            sub_array(marks);
            array_pairs(marks);
            reverse_array(marks);
            arrayoutput(marks);
            System.out.println(binarysearch(marks,4));

            System.out.println(largestnumber(marks));
            System.out.println(linearsearchindex(marks,4));

            update(marks);
            for(int i=0;i<marks.length;i++ ){
            
            System.out.println("marks["+ (i+1) +"]="+marks[i]);
            }
            
        int num[]={1,2,3,4,5,6,7,8,9};
        String fruit[]={"apple","mango","orange"};

        min_subarray_kadane_algorithm(num);
    }
    }