import java.util.*;

public class assignment2{

    class TrieNode{

        List<String>data;
        TrieNode children[];
        boolean isEnd;

        TrieNode(){
            data=newArrayList<>();
            children=new TrieNode[26];
            isEnd=false;
        }

    }

    static TrieNode root;
    List<List<String>>ans;
    
    public List<List<String>>groupAnagrams(String[] strs) {
        ans=new ArrayList<>();
        root=newTrieNode();
        
        for(String word:strs){
            build(word);
        }
        dfs(root);returnans;
    }
    
    public void build(Strings){
        TrieNode temp=root;
        char[]word=s.toCharArray();
        Arrays.sort(word);
        for(char c:word){
            TrieNode child=temp.children[c-'a'];
            if(child==null){
                temp.children[c-'a']=new TrieNode();
            }
            temp=temp.children[c-'a'];
        }
        temp.isEnd=true;
        temp.data.add(s);
    }
    
    public void dfs(TrieNode rt){
        if(rt.isEnd){
            ans.add(rt.data);
        }
        for(inti=0;i<26;i++){
            if(rt.children[i] !=null){
                dfs(rt.children[i]);
            }
        }
    }
}
