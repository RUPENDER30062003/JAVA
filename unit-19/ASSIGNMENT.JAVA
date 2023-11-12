import java.util.*;
public class ASSIGNMENT{

    public static boolean monotonic(ArrayList<Integer>a){

        boolean t=true;
        boolean s=true;
        for(int i=0;i<a.size()-1;i++){
            if(a.get(i)>a.get(i+1)){
                t=false;
            }
            if(a.get(i)<a.get(i+1)){
                s=false;
            }
        }
        System.out.println(t||s);
        return t||s;
    }

    public static ArrayList<Integer> findLonely(ArrayList<Integer>nums){
        Collections.sort(nums);
        ArrayList<Integer>list=new ArrayList<>();

        for(int i=1;i<nums.size()-1;i++){
            if(nums.get(i-1)+1<nums.get(i) && nums.get(i)+1<nums.get(i+1)){
                list.add(nums.get(i));
            }
        }
            
        if(nums.size()==1){
            list.add(nums.get(0));
        }

        if(nums.size()>1){

            if(nums.get(0)+1<nums.get(1)){
                list.add(nums.get(0));
            }
            if(nums.get(nums.size()-2)+1<nums.get(nums.size()-1)){
                list.add(nums.get(nums.size()-1));
            }

        }

        System.out.println(list);
        
        return list;
    }


    public static int mostFrequent(ArrayList<Integer>nums,int key){
        int result[]=new int[1000];
        for(int i=0;i<nums.size()-1;i++){
            if(nums.get(i)==key){
                result[nums.get(i+1)-1]++;
            }
        }
        int max=Integer.MIN_VALUE;
        int ans=0;
                
        for(int i=0;i<1000;i++){
            if(result[i]>max){
                max=result[i];
                ans=i+1;
            }    
        }     
        return ans;
    }

    public static ArrayList<Integer> beautifulArray(int n){
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(1);
        while(ans.size()<n){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int ei : ans){
                if(2*ei-1<=n){
                    temp.add(2*ei-1);
                }
            }
            for(int ei :ans){
                if(2*ei <= n){
                    temp.add(2*ei);
                }
            }
            ans=temp;
        }
        return ans;
    }



    public static void main(String args[]){

        ArrayList<Integer>a=new ArrayList<>();
        a.add(10);
        a.add(6);
        a.add(5);
        a.add(8);

        findLonely(a);
        System.out.println(beautifulArray(100));



    }
}