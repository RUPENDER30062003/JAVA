import java.util.*;

public class assignment{

    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

        public void inOrder() {
        }

        public void mirror() {
        }
    }

    public static boolean isUnivalTree(Node root){
        if(root==null){
            return true;
        }

        if(root.left!=null && root.data!=root.left.data){
            return false;
        }

        if(root.right!=null && root.data!=root.right.data){
            return false;
        }

        return isUnivalTree(root.left)&&isUnivalTree(root.right);
    }
    public static void main(String args[]){
        Node root =new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left =new Node(7);
        root.right.right = new Node(6);

        if(isUnivalTree(root)){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }


    }
}