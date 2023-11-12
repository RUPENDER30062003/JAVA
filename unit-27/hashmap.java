
import java.util.*;

public class hashmap {
    public static void main(String[] args) {
        // create //
        HashMap<String,Integer>hm=new HashMap<>();

        // insert -O(1)//

        hm.put("India", 100);
        hm.put("USA", 150);
        hm.put("china", 50);

        System.out.println(hm);

        // get -O(1)//
        System.out.println(hm.get("India"));
        System.out.println(hm.get("UEA"));

        // containskey -O(1)//
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("UEA"));

        // remove -O(1) //
        System.out.println(hm.remove("India"));
        System.out.println(hm.remove("UEA"));
        System.out.println(hm);

        // size //

        System.out.println(hm.size());

        // isempty//

        System.out.println(hm.isEmpty());

        // clear or format //
        hm.clear();
        System.out.println(hm.isEmpty());

        HashMap<String, Integer> hmn = new HashMap<>();
        hmn.put("India",100);
        hmn.put("USA",50);
        hmn.put("china",150);
        hmn.put("Indonesia", 6);
        hmn.put("Nepal",5);
        System.out.println(hmn.entrySet());

        // iteration //
        Set<String>keys=hmn.keySet();
        System.out.println(keys);
        
        
        for (String k : keys) {
            System.out.println("key="+k+",value="+hmn.get(k));
        }

        // iteration hm.entrySet(); //
        for(HashMap.Entry<String,Integer> entry : hmn.entrySet()) {
            System.out.print(entry);
            System.out.print(",");
        }

    }
}

