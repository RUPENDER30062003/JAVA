import java.util.*;

public class avltree {

    static class Node {

        int data,height;
        Node left, right;
        
        Node(int data) {
            this.data=data;
            height=1;
        }
    }

    public static Node root;

    public static int height(Node root){

        if(root==null){
            return 0;
        }

        return root.height;

    }

    public static int max(int a,int b){
        return (a>b)?a:b;
    }

    public static void preorder(Node root){

        if(root==null){
            return ;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }

    // get balance factor of node //
    public static int getBalance(Node root){

        if(root==null){
            return 0;
        }   
        
        return height(root.left)-height(root.right);

    }
    
    // Left rotate subtree rooted with x //
    public static Node leftRotate(Node x){

        Node y=x.right;
        Node T2=y.left;

        // Perform rotation
        y.left=x;
        x.right=T2;
        
        // Update heights
        x.height=max(height(x.left),height(x.right))+1;
        y.height=max(height(y.left),height(y.right))+1;
        
        // Return new root
        return y;

    }

    // right rotate subtree rooted with x //
    public static Node rightRotate(Node y){

        Node x=y.left;
        Node T2=x.right;
        
        // Perform rotation
        x.right=y;
        y.left=T2;
        
        // Update heights
        x.height=max(height(x.left),height(x.right))+1;
        y.height=max(height(y.left),height(y.right))+1;
        
        // Return new root
        return x;

    }

    public static Node insert(Node root,int key){

        if(root==null){
            return new Node(key);
        }

        if(key<root.data){
            root.left=insert(root.left,key);
        }else if(key>root.data){
            root.right=insert(root.right, key);
        }else{
            return root; // duplicate keys not allowed //
        }

        // update root height
        root.height=1+Math.max(height(root.left),height(root.right));

        // get root's balance factor //
        int bf=getBalance(root);


        // left left case//
        if(bf>1 && key<root.left.data){
            return rightRotate(root);
        }

        // right right case //
        if(bf<-1 && key>root.right.data){
            return leftRotate(root);
        }

        // left right case //
        if(bf>1 && key>root.left.data){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }

        // right left case //
        if(bf<-1 && key<root.right.data){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }

        return root; // returned if avl balanced //
    }

    //for non-empty BST, return the node with MIN data
    public static Node getMinNode(Node root){

        Node curr = root;
        
        //MIN data is at left-most node
        
        while (curr.left != null){
            curr = curr.left;
        }

        return curr;
    }

    public static Node deleteNode(Node root, int key){

        // perform usual BST delete
        if(root==null){
            return root;
        }

        // key < root's data => then it lies in left subtree
        if (key < root.data){
            root.left = deleteNode(root.left, key);
        }

        // key > root's data => then it lies in right subtree
        else if (key > root.data){
            root.right = deleteNode(root.right, key);
        }
        // key = root's data => then this is the node to be deleted
        else{

            // node with only one child or no child
            if ((root.left == null) || (root.right == null)){

                Node temp = null;
                if (temp == root.left){
                    temp=root.right;
                }else{
                    temp = root.left;
                }

                // No child case
                if (temp == null){
                    temp = root;
                    root = null;
                }else{
                    // One child case
                    root = temp;// Copy the contents of the non-empty child
                }
            }
            else{

                // node with two children: Get the inorder

                // successor (smallest in the right subtree)
                Node temp = getMinNode(root.right);

                // Copy the inorder successor's data to this node
                root.data = temp.data;

                // Delete the inorder successor
                root.right = deleteNode(root.right,temp.data);

            }
        }

        // If the tree had only one node then return
        if (root == null){
            return root;
        }

        // update height of curr node
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        
        // get balance factor of this node (to check for unbalanced)
        int bf = getBalance(root);
        
        // If this node becomes unbalanced, then there are 4 cases
        
        // Left Left Case
        if (bf > 1 && getBalance(root.left) >= 0){
            return rightRotate(root);
        }

        // Left Right Case
        if (bf > 1 && getBalance(root.left) < 0){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        
        // Right Right Case
        if(bf < -1 && getBalance(root.right) <= 0){
            return leftRotate(root);
        }
        

        // Right Left Case
        if (bf < -1 && getBalance(root.right) > 0){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
        

    public static void main(String args[]){

        root=insert(root,10);
        root=insert(root,20);
        root=insert(root,30);
        root=insert(root,40);
        root=insert(root,50);
        root=insert(root,25);
        root=deleteNode(root, 30);

        /*   AVL TREE 
         
               30
              /  \
             20   40
            / \    \
          10  25   50

        */

        preorder(root);

    }
}
