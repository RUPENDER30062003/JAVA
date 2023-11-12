import java.util.*;

public class divide_conquer{

    public static void array_output(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

    public static void quick_sort(int arr[],int si,int ei){

        if(si<ei){

        int p=partition(arr,si,ei);
        quick_sort(arr,si,p-1);
        quick_sort(arr,p+1,ei);

        }

    }

    public static int partition(int arr[], int start, int end) {

    int pivot = arr[start];
    int i = start + 1; // index of the left partition
    int j = end; // index of the right partition
    

    while(i<=j){

        // Find the first element from the left that is greater than the pivot
        while (i <= end && arr[i] <= pivot) {
            i++;
        }

        // Find the first element from the right that is less than or equal to the pivot
        while (j >= start && arr[j] > pivot) {
            j--;
        }

        // Swap the elements at indices i and j
        if (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }else{
            break;
        }
    }

        arr[start]=arr[j];
        arr[j]=pivot;

        return j;

    }

        public static int partition_new(int arr[],int start,int end){
        
        int pivot=arr[start];
        int i=start + 1;
        int j=end;

        while(i<=j){

            while( i<=end && arr[i]<=pivot){

            i++;}

            while(j>=start && arr[j]>pivot){
            j--;}

            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }else{
                break;
            }
        }

            arr[start]=arr[j];
            arr[j]=pivot;

            return j;
        }

      public static void mergesort(int arr[],int si,int ei){

        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        mergesort(arr,si,mid);
        mergesort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }

    public static void merge(int arr[],int si,int mid,int ei){

        // left(0,3)=4  right(4,6)=3  -> 6-0+1 //
        int temp[]=new int [ei-si+1];
        int i=si;// iterator for left part //
        int j=mid+1;//iterator for right part//
        int k=0; //iterator for temp arr//

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
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


    public static void quick_sort_piovt_end(int arr[],int si,int ei){

        if(si>=ei){
            return ;
        }
        
        int p=partition_quick(arr,si,ei);
        quick_sort_piovt_end(arr,si,p-1);
        quick_sort_piovt_end(arr,p+1,ei);
    }

    public static int partition_quick(int arr[],int si,int ei){
        int pivot=arr[ei];
        int i=si-1;

        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
                int temp=pivot;
                arr[ei]=arr[i];
                arr[i]=temp;
                return i;
    }

    public static int search_rotated_search(int arr[],int target,int si,int ei){

        if(si>ei){
            return -1;
        }

        int mid=(si+ei)/2;
        // case found //
        if(arr[mid]==target){
            return mid;
        }

        // mid on line one //
        if(arr[si]<=arr[mid]){
            // case a:left //
            if(arr[si]<=target && target<=arr[mid]){
                return search_rotated_search(arr,target,si,mid-1);
            }else{
            // case b:right //
                return search_rotated_search(arr,target,mid+1,ei);
            }
        }
        //mid on line two //
        else{
            // case c : right //
            if(arr[mid]<=target && target<=arr[ei]){
                return search_rotated_search(arr,target,mid+1,ei);
            }else{
            // case d: left //
            return search_rotated_search(arr,target,si,mid-1);
            }
        }
    }

    public static void main(String args[]){
        int arr[]={6,3,9,5,2,8,-2};
        mergesort(arr,0,arr.length-1);
        array_output(arr);

        int arrr[]={6,3,9,5,2,8,-2};
        quick_sort(arrr,0,arrr.length-1);
        array_output(arrr);

        int arrrr[]={6,3,9,5,2,8,-2};
        quick_sort_piovt_end(arrrr,0,arrrr.length-1);
        array_output(arrrr);

        int arrA[]={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(search_rotated_search(arrA,target,0,arrA.length-1));
    }
}