import java.util.*;

public class bst {

    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }

        if(root.data>val){
            //left subtree //
            root.left=insert(root.left, val);
        }else{
            root.right=insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){

        if(root==null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean searchbst(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            System.out.println();
            System.out.println("found");
            return true;
        }
        if(root.data>key){
            return searchbst(root.left, key);
        }else if(root.data<key){
            return searchbst(root.right, key);
        }

        return false;
    
    }

    public static void main(String args[]){
        int val[]={5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<val.length;i++){
            root=insert(root,val[i]);
        }
        inorder(root);
        searchbst(root,7);
    }
}
