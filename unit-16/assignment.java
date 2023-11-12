import java.util.*;
public class assignment{

     public static int majority_element_in_array(int arr[]){
        int count[]=new int[arr.length];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count[i]++;
                }
            }
        }
        int max=count[0];
        int index=0;
        for(int i=1;i<count.length;i++){
            if(count[i]>max){
                max=count[i];
                index=i;
            }
        }
        
        System.out.println(arr[index]);
        return arr[index];

    }
    
    public static void mergesort(String arr[],int si,int ei){

    if(si>=ei){
        return;
    }

        int mid=si+(ei-si)/2;
        mergesort(arr,si,mid);
        mergesort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }

    public static void merge(String arr[],int si,int mid,int ei){

        // left(0,3)=4  right(4,6)=3  -> 6-0+1 //
        String temp[]=new String[ei-si+1];
        int i=si;// iterator for left part //
        int j=mid+1;//iterator for right part//
        int k=0; //iterator for temp arr//

        while(i<=mid && j<=ei){
            if(arr[i].compareTo(arr[j])<0){
                temp[k]=arr[i];
                i++;
                k++;
            }else{
                temp[k]=arr[j];
                j++;
                k++;
            }
            // k++; can also come there because k come for both cases. //
        }

        // left part //
        while(i<=mid){
            temp[k++]=arr[i++];
        }

        //right part//
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        //copy temp to orignal arr //
        for(k=0,i=si;k<temp.length;k++,i++){
               arr[i]=temp[k];
        }
    }

    public static void main(String args[]){
        String str[]={"sun","earth","mars","mercury"};
        mergesort(str,0,str.length-1);
        for(int i=0;i<str.length;i++){
            System.out.print(str[i]+" ");
        }

        int arr[]={2,2,2,1,1,1,1};
        majority_element_in_array(arr);

    }
} 