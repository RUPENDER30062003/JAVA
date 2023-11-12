import java.util.*;

public class union_and_intersaction_of_two_array {
    public static void main(String[] args) {


        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};
        HashSet<Integer> hs=new HashSet<>();

        // union //
        for(int i:arr1){
            hs.add(i);
        }

        for (int i : arr2) {
            hs.add(i);
        }

        System.out.println(hs);

        // intersection //
        hs.clear();
        for(int i:arr1){
            hs.add(i);
        }

        int count=0;
        for (int i : arr2){
            if(hs.contains(i)){
                count++;
                System.out.print(i+" ");
                hs.remove(i); 
            }
        }
        System.out.println();

        System.out.println(count);

        

    }
}
