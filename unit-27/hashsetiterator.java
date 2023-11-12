import java.util.*;

public class hashsetiterator{
    public static void main(String[] args){

        HashSet<String> cities=new HashSet<>();
        cities.add("Bangalore");
        cities.add("Chennai");
        cities.add("Delhi");
        cities.add("Hyderabad");
        System.out.println(cities);

        Iterator it=cities.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        for(String city:cities){
            System.out.println(city);
        }

        LinkedHashSet<String> lhs=new LinkedHashSet<>();
        lhs.add("Chennai");
        lhs.add("Delhi");
        lhs.add("Bangalore");
        lhs.add("Hyderabad");
        System.out.println(lhs);

        lhs.remove("Delhi");
        System.out.println(lhs);

        TreeSet<String> ts=new TreeSet<>();
        ts.add("Chennai");
        ts.add("Delhi");
        ts.add("Bangalore");
        ts.add("Hyderabad");
        
        System.out.println(ts);


    }
}
