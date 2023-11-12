import java.util.*;
public class assignment1{

    static class Node {
        int val;
        Node left;
        Node right;
    
        public Node(int val) {
            this.val = val;
            this.left=null;
            this.right=null;
        }
    }
    
    public static Node mirrorTree(Node root) {

        if (root == null) {
            return null;
        }
        Node left = mirrorTree(root.left);
        Node right = mirrorTree(root.right);

        root.left = right;
        root.right = left;
        return root;

    }
    public static void main(String args[]){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node mirror = mirrorTree(root);

        System.out.println(mirror.right.right.val);
    }
}