import java.util.*;

public class assignment {
    
    static class Node{

        Node children[]=new Node[26];
        boolean eow=false;
        int freq;

        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            freq=1;
        }
    }

    public static Node root=new Node();

    public static void insert(String word){  

        // T.C- O(L) //

        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }else{
                curr.children[idx].freq++;
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public static boolean search(String word){

        // T.C- O(L) //

        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }

        return curr.eow == true;

    }

    public static void main(String[] args) {

        String str[]={"eat","tea","tan","ate","nat","bat"};
        for (String string : str) {
            insert(string);
        }

    }
}
