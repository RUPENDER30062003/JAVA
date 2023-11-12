import java.util.*;

public class Assignments{

   

    public static void mergeSort(String arr[], int si, int ei) {

        if(si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(String arr[], int si, int mid, int ei) {

        String temp[] = new String[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= ei) {
            if(arr[i].compareTo(arr[j]) < 0) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while(j <= ei) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for(k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static int inverse_count(int arr[]){

        int count=0;
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            int smallest = i;
            for (int j = i+1; j < n; j++) {
                if(arr[smallest]>arr[j]){
                    smallest=j;
                }
            }
            if (i!=smallest) {
                int temp=arr[i];
                arr[i]=arr[smallest];
                arr[smallest]=temp;
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String args[]) {

        String str[] = {"sun", "earth", "mars", "mercury"};
        mergeSort(str, 0, str.length - 1);

        // Print the sorted array
        for(int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }

        System.out.println();
        int arr[]={2,4,1,3,5};
        inverse_count(arr);
    }
}
