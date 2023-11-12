import java.util.*;

public class Linkedhashmap{

    public static void main(String[] args) {
        LinkedHashMap<String,Integer>lhm=new LinkedHashMap<>();
        lhm.put("c",3);
        lhm.put("a",1);
        lhm.put("b",2);

        System.out.println(lhm);

        HashMap<String,Integer>hm=new HashMap<>();
        hm.put("d",4);
        hm.put("a",2);
        hm.put("b",3);
        hm.put("c",1);

        System.out.println(hm);

        TreeMap<String,Integer>tm=new TreeMap<>();
        tm.put("b",2);
        tm.put("a",1);
        tm.put("c",3);

        System.out.println(tm);



    }
}
