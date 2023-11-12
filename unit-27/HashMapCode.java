import java.util.*;

public class HashMapCode{ 

    static class HashMap<K,V>{ // generic -where K and V are data type which are not known to use and they can be  of any data type //

        private class Node{

            K key;
            V value;
            public Node(K key, V value) {
                this.key=key;
                this.value=value;
            }

        }

        private int n; // total nodes in HashMap //

        private int N; // N=buckets.length //

        private LinkedList<Node> buckets[]; 

        @SuppressWarnings("unchecked")

        public HashMap(){

            this.N= 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++) {
                this.buckets[i] = new LinkedList<>();
            }

        }

        private int hashfunction(K key){
            int hc=key.hashCode();
            return Math.abs(hc)% N;
        }

        private int SearchInLL(K key,int bi){

            LinkedList<Node> ll=buckets[bi];
            int di=0;

            for(int i=0;i<ll.size();i++){

                Node node=ll.get(i);
                if(node.key==key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){

            LinkedList<Node> oldBuck[]=buckets;

            buckets=new LinkedList[N*2];
            N=N*2;

            for(int i=0; i<buckets.length; i++){
                buckets[i]=new LinkedList<>();
            }

            // nodes ->add in buckets //
            for(int i=0; i<oldBuck.length;i++){
                LinkedList<Node> ll=oldBuck[i];
                for(int j=0;j<ll.size();j++){
                    Node node=ll.remove();
                    put(node.key,node.value);
                }
            }
        }

        public void put(K key,V value){ // O(lambda)  or O(1) //

            int bi=hashfunction(key); // 0 to 3//
            int di=SearchInLL(key , bi); // valid ; -1//

            if(di !=-1){
                Node node=buckets[bi].get(di);
                node.value=value;
            }else{
                buckets[bi].add(new Node(key,value));
                n++;
            }

            double lambda=(double)n/N;
            if(lambda>2.0){
                rehash();
            }
        }

        public boolean cointainKey(K key){

            int bi=hashfunction(key); // 0 to 3//
            int di=SearchInLL(key,bi); // valid ; -1//

            if(di !=-1){
                return true;
            }else{
                return false;
            }
        }

        public V remove(K key){

            int bi=hashfunction(key); // 0 to 3//
            int di=SearchInLL(key,bi); // valid ; -1//

            if(di !=-1){
                Node node=buckets[bi].remove(di);
                return node.value;
            }else{
                return null;
            }

        }

        public V get(K key){

            int bi=hashfunction(key); // 0 to 3//
            int di=SearchInLL(key,bi); // valid ; -1//

            if(di !=-1){
                Node node=buckets[bi].get(di);
                n--;
                return node.value;
            }else{
                return null;
            }

        }

        public ArrayList<K>keySet(){

            ArrayList<K> keys=new ArrayList<>();

            for( int i=0 ; i<buckets.length ; i++ ){
                LinkedList <Node> ll=buckets[i];
                for(Node node:ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0 ;
        } 
        
    }

    public static void main(String args[]){

        HashMap<String,Integer> hm=new HashMap<>();

        hm.put("a",1);
        hm.put("b",2);
        hm.put("c",3);
        hm.put("d",4);

        ArrayList<String> keys=hm.keySet();
        for(String key : keys){
            System.out.println(key);
        }

        System.out.println(hm.isEmpty()+""+hm.get("a"));
        hm.remove("a");
        System.out.print(hm.get("a"));
    
        
    }
}
