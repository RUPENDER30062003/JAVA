import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class arraylist{

    public static boolean pairsum1(ArrayList<Integer>list ,int target){
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)+list.get(j)==target){
                    return true;
                }
            }
        }
        return false;
    }

    public static int most_water_container_two_pointer_optimized(int height[]){
        int max=0;
        int lp=0;
        int rp=height.length-1;

        while(lp<rp){

            int ht=Math.min(height[lp],height[rp]);
            int weidth=rp-lp;
            int curr=ht*weidth;
            max=Math.max(max,curr);

            if(height[lp]<height[rp]){
                lp++;
            }else{
                rp--;
            }
        }
        System.out.println(max);
        return max;
    }

    public static int most_water_container(int height[]){
        int n=height.length;
        int c=0;
        int d=0;
        int max=0;
        if(n>1){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int a=height[i];
                int b=height[j];
                int diff=j-i;
                int heightmin=Math.min(a,b);
                if(heightmin<0){
                    heightmin=(-heightmin);
                }
                int volume_of_water=diff*heightmin;
                if(volume_of_water>max){
                    max=volume_of_water;
                    c=i;
                    d=j;
                }
            }
            }
            System.out.println(max+" between"+(c+1)+" and "+(d+1));
            return max;
        }

        System.out.println(0);
        return 0;
    }

    public static void max_water_brute_force(int arr[]){
        int max_water=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(i!=j){
                    max_water=Math.max(max_water,Math.min(arr[i],arr[j])*(j-i));
                }
            }
        }
        System.out.println(max_water);
    }

    public static void swap(ArrayList<Integer>list,int index1,int index2){
        int temp=list.get(index1);
        list.set(index1,list.get(index2));
        list.set(index2,temp);
        System.out.println(list);
    }

    public static boolean pairsum1_optimized(ArrayList<Integer>list,int target){

        int lp=0;
        int rp=list.size()-1;
        while(lp!=rp){

            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            if(list.get(lp)+list.get(rp)<target){
                lp++;
            }
            if(list.get(lp)+list.get(rp)>target){
                rp--;
            }  

        }
        return false;
    }

    public static boolean pairsum2(ArrayList<Integer>list,int target){
        
        int pivot=-1;
        int n=list.size();

        for(int i=0;i<list.size();i++){
            if(list.get(i)>list.get(i+1)){
                pivot=i;
                break;
            }
        }

        int lp=pivot+1;
        int rp=pivot;

        while(lp!=rp){

            if(list.get(lp)+list.get(rp)==target){
                return true;
            }

            if(list.get(lp)+list.get(rp)<target){
                lp=(lp+1)%n;
            }else{
                rp=(n+rp-1)%n;
            }
            
        }
        return false;
    }

    

    public static void main(String args[]){
        // vector in c++ do same thing as Arraylist //
        // Arraylist is part of java collection frame work // 
        // String Boolean Float :class name is capital always // 
        // ClassName object name=new ClassName(); // 

        ArrayList<Integer>list=new ArrayList<>();
        ArrayList<String>list2=new ArrayList<>();
        ArrayList<Boolean>list3=new ArrayList<>();

        // add operation //
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);


        list.add(1,9);
        System.out.println(list);

        // get operation  //
        int element =list.get(2);
        System.out.println(element);

        // delete //
        list.remove(1);
        System.out.println(list);

        // set element at index //
        list.set(2,10);
        System.out.println(list);

        // contains element //
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));


        System.out.println(list.size());

        // print the arraylist//
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //reverse print  O(n) //
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        // max and min numbe in array list //
        int max=list.get(0);
        int min=list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)>max){
                max=list.get(i);
                }
                // Math.max(max,list.get(i));
            if(list.get(i)<min){
                min=list.get(i);
                }
                // Math.min(min,list.get(i));
        }
        System.out.println(max+","+min);

        swap(list,2,3);

        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);


        ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();
        ArrayList<Integer>list4=new ArrayList<>();
        list4.add(1);
        list4.add(2);
        list4.add(6);
        mainList.add(list4);

        ArrayList<Integer>list5=new ArrayList<>();
        list5.add(4);
        list5.add(5);
        mainList.add(list5);

        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer>currList=mainList.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }
        System.out.println(mainList);

        ArrayList<ArrayList> mainList1=new ArrayList<>();
        ArrayList<Integer>list6=new ArrayList<>();
        ArrayList<Integer>list7=new ArrayList<>();
        ArrayList<Integer>list8=new ArrayList<>();

        for(int i=1;i<=5;i++){
            list6.add(i*1);
            list7.add(i*2);
            list8.add(i*3);
        }

        System.out.println(list6+" "+list7+" "+list8);

        mainList1.add(list6);
        mainList1.add(list7);
        mainList1.add(list8);
        System.out.println(mainList1);

        for(int i=0;i<mainList1.size();i++){
            ArrayList<Integer>currList1 =mainList1.get(i);
            for(int j=0;j<currList1.size();j++){
                System.out.print(currList1.get(j)+" ");
            }
            System.out.println();
        }

        int height[]={1,8,6,2,5,4,8,3,7};
        most_water_container(height);
        most_water_container_two_pointer_optimized(height);
        max_water_brute_force(height);


        ArrayList<Integer> list9=new ArrayList<>();
        list9.add(1);
        list9.add(2);
        list9.add(3);
        list9.add(4);
        list9.add(5);
        list9.add(6);
        int target=5;
        System.out.println(pairsum1(list9,target));
        System.out.println(pairsum1_optimized(list9,target));

        ArrayList<Integer> list10=new ArrayList<>();
        list10.add(11);
        list10.add(12);
        list10.add(6);
        list10.add(7);
        list10.add(8);
        list10.add(9);
        list10.add(10);

        int target1=15;
        System.out.println(pairsum2(list10,target1));


    }
}