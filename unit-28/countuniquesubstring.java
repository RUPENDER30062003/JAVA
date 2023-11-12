import java.util.*;

public class countuniquesubstring {

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

    public static int countNode(Node root){

        if(root==null){
            return 0;
        }

        int count=0;
        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null){
                count+=countNode(root.children[i]);
            }
        }
        return count+1;

    }

    public static void main(String[] args) {

        String str="ababa"; //ans = 10 //

        //suffix ->insert in tries //
    
        for(int i=0;i<str.length();i++) {
            String suffix=str.substring(i);
            insert(suffix);
        }

        System.out.println(countNode(root));
        
    }
}
