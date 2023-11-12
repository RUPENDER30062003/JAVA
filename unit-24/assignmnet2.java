import java.util.*;
public class assignmnet2 {
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node deleteleaves(Node root,int n){

        if(root==null){
            return null;
        }
        root.left=deleteleaves(root.left,n);
        root.right=deleteleaves(root.right,n);
        if(root.left==null &&root.right==null && root.data==n){
            root=null;
        }
        return root;
    }

    public static void inorder(Node root){

        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }
    public static void main(String srgs[]){

        Node root = new Node(10);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(1);
        root.right.right = new Node(3);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(3);
        deleteleaves(root, 3);
        System.out.println("Inorder traversal after deletion : ");
        inorder(root);

    }
}
