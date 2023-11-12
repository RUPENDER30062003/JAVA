import java.util.*;

public class majorityelement {

    public static void main(String args[]){

        int nums[]={1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer>hm=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){

            /* 
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
            */

            // hashmap.put(nums[i],hashmap.getOrDefault(key,defaultValue)) //
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);

        }
        
        float n=nums.length/3;
        Set <Integer> keySet=hm.keySet();
        
        for(Integer key:keySet){
            if(hm.get(key)>n){
                System.out.println(key);
            }
        }

        for(Integer key:hm.keySet()){
            if(hm.get(key)>n){
                System.out.println(key);
            }
        }
    }
}
