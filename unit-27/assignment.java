import java.util.*;
           
public class assignment{

    static class Node{

        int data;
        int hd;
        Node left;
        Node right;

        public Node(int key){
            this.data=key;
            this.hd=Integer.MAX_VALUE;
            this.left=null;
            this.right=null;
        }
    }

        public static void bottomViewHelper(Node root,int curr,int hd,TreeMap<Integer,int[]>m){

            if(root ==null){
                return ;
            }

            // If node for a particular HD is not present,add to the map.//

            if(!m.containsKey(hd)){
                m.put(hd,new int[]{root.data, curr });
            }

            // Compare height for already//
            // present node at similar horizontal//
            // distance//

            else{

                int p[]=m.get(hd);

                if(p[1] <= curr){
                    p[1] = curr;
                    p[0] =root.data;
                }
                m.put(hd, p);
                
            }
            // call for left subtree// 
            bottomViewHelper(root.left, curr +1, hd -1, m);
            // call for right subtree//
            bottomViewHelper(root.right, curr +1, hd +1, m);
        }

        public static void printBottomView(Node root){

            // Map to store Horizontal Distance, Heightand Data.//
            TreeMap<Integer,int[]> m=new TreeMap<>();
            bottomViewHelper(root,0,0, m);
            // Prints the values stored by printBottomViewUtil()//

            for(int val[]:m.values()){
                System.out.print(val[0] +" ");
            }
        }

        public static int[] twoSum(int arr[],int target){

            Map <Integer,Integer> visited = new HashMap <>();
            
            for(int i=0; i<arr.length; i++){

                //diff = given target - number given at ith index//

                int diff= target - arr[i];

                // check if found difference is presentin the MAP list//

                if(visited.containsKey(diff)){
                    //if difference in map matches withthe ith index element in array//
                    return new int[]{ i, visited.get(diff)};
                }

                //add arr element in map to match withfuture element if forms a pair//

                visited.put(arr[i],i);
            }

            //if no matches are found //

            return new int[]{0,0};

        }
        
        public static String frequency_sort(String str){

            TreeMap<Character,Integer> thm=new TreeMap<>();
            int n=str.length();

            for(int i=0;i<n;i++){
                thm.put(str.charAt(i),thm.getOrDefault(str.charAt(i),0)+1);
            }

            StringBuilder ans=new StringBuilder();

            while (!thm.isEmpty()){

                char maxChar = ' ';
                int maxCount = 0;
                
                // Find the character with maximum frequency
                for (char c : thm.keySet()) {
                    int frequency = thm.get(c);
                    if (frequency > maxCount) {
                        maxChar = c;
                        maxCount = frequency;
                    }
                }
        
                // Append the character maxChar maxCount times to the answer
                for (int i = 0; i < maxCount; i++) {
                    ans.append(maxChar);
                }
        
                thm.remove(maxChar); // Remove the character from the TreeMap
            }
            return ans.toString();
        }
    
    public static void main(String[] args){

        Node root=new Node(20);
        root.left=new Node(8);
        root.right=new Node(22);
        root.left.left=new Node(5);
        root.left.right=new Node(3);
        root.right.left=new Node(4);
        root.right.right =new Node(25);
        root.left.right.left=new Node(10);
        root.left.right.right=new Node(14);

        System.out.println("Bottom view of the given binary tree:");

        printBottomView(root);
        System.out.println(frequency_sort("tree"));
    }
}
