import java.util.*;
import java.util.Collections;

public class sorting{

    public static int bubble(int arr[]){
        int n=arr.length;
        int swap=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    swap++;
                }
            }
        }
        return swap;
    }

    public static int bubble_optimized(int arr[]){
        int n=arr.length;
        int swap=0;
        boolean b=false;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    b=true;
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    swap++;
                }
            }
            if(b == false){
            System.out.println("array is already sorted");
             return swap;}
        }
        return swap;
    }

    public static void countsort(int arr[]){

        int n=arr.length;
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            largest=Math.max(largest,arr[i]);
        }

        int count[]=new int[largest+1];
        for(int i=0;i<count.length;i++){
            count[arr[i]]++;
        }

        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }

    }

    public static void insertion (int arr[]){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int key=arr[i];
            for(int j=i-1;j>=0 && arr[j]>key;j--){
                arr[j+1]=arr[j];
                arr[j]=key;
            }
        }    
    }

    public static void insertionsort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int curr=arr[i];
            int previous=i-1;
            //find out correct position to insert//
            while(previous>=0 && arr[previous]>curr){
                arr[previous+1]=arr[previous];
                previous--;
            }
            //insertion//
            arr[previous+1]=curr;
        }
    }

    public static int selection(int arr[]){
        int n=arr.length;
        int swap=0;
        for(int i=0;i<n-1;i++){

            int smallest=i;
            for(int j=i;j<n;j++){
                if(arr[j]<arr[smallest]){
                    smallest=j;                    
                }
            }
            swap++;
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
        }
        return swap;
    }

    public static void main(String args[]){
        int arr[]={9,8,8,7,6,5,4,3,2,1};
        countsort(arr);
        
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        int arrA[]={1,2,3,4,5,6,7,8,9};
        bubble_optimized(arrA);
        for(int i=0;i<arrA.length;i++){
            System.out.println(arrA[i]);
        }

        Integer arrr[]={4,5,3,2,1,0,6,7,10,9,8};
        Arrays.sort(arrr);
        for (int i = 0; i < arrr.length; i++) {
            System.out.print( arrr[i]+" ");
        }

        System.out.println();
        Arrays.sort(arrr,Collections.reverseOrder()); 
        // can be applied on objects only //
        for (int i = 0; i < arrr.length; i++) {
            System.out.print( arrr[i]+" ");
        }
    }

}