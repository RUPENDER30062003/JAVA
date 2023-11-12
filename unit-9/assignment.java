import java.util.*;
public class assignment{

    public static boolean repeat(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
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


    public static void rotated_array(int arr[],int pivot){
        int n=arr.length;
        int arrA[]=new int [n];
        int i=0;
        int p=pivot;
        while(pivot<n){
            arrA[i]=arr[pivot];
            pivot++;
            i++;
        }
        for(int j=0;j<p;j++){
            arrA[i]=arr[j];
            i++;
        }
        for(int k=0;k<n;k++){
            arr[k]=arrA[k];
        }


    }
    public static int factorial(int n){
        int factorial=1;
        for(int i=1;i<=n;i++){
            factorial*=i;
        }
        return factorial;
    }

   

    public static void duplicate_triplate(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
             for(int j=i+1;j<n;j++){
                 for(int k=j+1;k<n;k++){
            if(arr[i]+arr[j]+arr[k]==0){
                if((factorial(i)==j) && (factorial(j)==k) && (factorial(i)==k)){
                    System.out.println(i+","+j+","+k);
                }
            }
        }
        }
        }
    }


    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6,7,8,9};
       System.out.println(repeat(arr));
       rotated_array(arr,3);
       for(int k=0;k<arr.length;k++){
            System.out.print(arr[k]+" ");
        }
        int arrC[]={-1,0,1,2,-1,-4};
        System.out.println("");
        duplicate_triplate(arrC);
       
       


    }
}