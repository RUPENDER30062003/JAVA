import java.util.*;

public class longestwordwithprefixes {

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

    public static String ans="";

    public static void longestword(Node root,StringBuilder temp){
        
        if(root == null){
            return ;
        }

        for (int i = 0; i < 26; i++) {

            if(root.children[i] != null && root.children[i].eow == true){
                char ch=(char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestword(root.children[i], temp);
                // backtrack //
                temp.deleteCharAt(temp.length()-1);
            }

        }
    }


    public static void main(String[] args) {
        String words[]={"a","ap","app","appl","apply","apple","banana"};

        for (String string : words) {
            insert(string);
        }
        longestword(root, new StringBuilder(""));
        System.out.println(ans);

    }
}
