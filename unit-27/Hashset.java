import java.util.*;

public class Hashset {

    public static void main(String[] args) {

         HashSet<Integer>hs=new HashSet<>();
         hs.add(1);
         hs.add(2);
         hs.add(3);
         hs.add(4);
         hs.add(1);
         hs.add(2);

         System.out.println(hs);

         if(hs.contains(1)){
            System.out.println("contain 1");
         }
         if(hs.contains(5)){
            System.out.println("contain 5");
         }else{
            System.out.println("not cointain 5");
         }

         hs.remove(2);
         if(hs.contains(2)){
            System.out.println("contain 2");
         }else{
            System.out.println("not cointain 2");
         }

         System.out.println(hs.size()+" ");

         hs.clear();

         System.out.println(hs.size());

         if(hs.isEmpty()){
            System.out.println("is empty");
         }

    }
}
