import java.util.*;

public class height {

    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static int height(Node root){

        // T.c: O(n)
        if(root==null){
            return 0;
        }

        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }

    public static int count(Node root){

        // T.c:O(n)
        if(root==null){
            return 0;
        }

        int lc=count(root.left);
        int rc=count(root.right);

        return lc+rc+1;
    }

    public static int sumtree(Node root){

        // T.C:O(n)
        if(root==null){
            return 0;
        }

        int ls=sumtree(root.left);
        int rs=sumtree(root.right);

        return root.data+ls+rs;
    }
.
    public static int diameter2(Node root){

        if(root==null){
            return 0;
        }

        int leftdiameter=diameter2(root.left);
        int leftheight=height(root.left);
        int rightdiameter=diameter2(root.right);
        int rightheight=height(root.right);

        int selfdiameter=leftheight+rightheight+1;

        return Math.max(selfdiameter,Math.max(rightdiameter,leftdiameter));

    }

    public static class Info{

        int diam;
        int ht;

        public Info(int diam,int ht ){
            this.diam=diam;
            this.ht=ht;
        }

    }

    public static Info diameter(Node root){

        if(root==null){
            return new Info(0,0);
        }

        Info leftinfo=diameter(root.left);
        Info rightinfo=diameter(root.right);
        int selfdiameter=leftinfo.ht+rightinfo.ht+1;

        int diameter=Math.max(Math.max(leftinfo.diam,rightinfo.diam),selfdiameter);
        int height=Math.max(leftinfo.ht,rightinfo.ht)+1;

        return new Info(diameter,height);

    }

    public static void main(String args[]){

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        System.out.println(height(root));
        System.out.println(count(root));
        System.out.println(sumtree(root));

        System.out.println(diameter2(root));
        System.out.println(diameter(root).diam);

    }
}
