import java.util.*;

public class topviewofbinarytree{

    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        } 
    }

    static class Info{
        Node node;
        int hd;

        public Info(Node node,int hd){
            this.node=node;
            this.hd=hd;

        }
    }

    public static void topview(Node root){

        Queue<Info> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();

        int min=0,max=0;
        q.add(new Info(root,0));
        q.add(null);

        while(!q.isEmpty()){

            Info curr=q.remove();

            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{

                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }
    
                if(curr.node.left!=null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min=Math.min(min,curr.hd-1);
                }
    
                if(curr.node.right!=null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max=Math.max(max,curr.hd+1);
                }
            }
        }

        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }

    }

    public static void levelorder(Node root,int k){
        // T.C=O(n)
        // iterator_kth_level
        if(root==null){
            return;
        }

        int i=1;

        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){

            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    i++;
                    q.add(null);
                }
            }else{
                if(k==i){
                System.out.print(currNode.data);
                }
                if(currNode.left !=null ){
                    q.add(currNode.left);
                }
                if(currNode.right !=null){
                    q.add(currNode.right);
                }
            }

        }
    }

    public static void preorder(Node root,int k,int i){

        // preorder_kth_level
        //T.C: O(n)
        if(root==null){
            return;
        }

        if(i==k){
        System.out.print(root.data+" ");
        return;
        }

        preorder(root.left,k,i+1);
        preorder(root.right,k,i+1);
    }

    public static boolean getPath(Node root,int n,ArrayList <Node> path){

        if(root==null){
            return false;
        }
        path.add(root);

        if(root.data==n){
            return true;
        }

        boolean foundleft=getPath(root.left,n,path);
        boolean foundright=getPath(root.right,n,path);

        if(foundright || foundleft){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root,int n1,int n2){

        ArrayList <Node> path1=new ArrayList<>();
        ArrayList <Node> path2=new ArrayList<>();
        getPath(root,n1,path1);
        getPath(root,n2,path2);
        int i=0;
        for (;i<path1.size()&& i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lca=path1.get(i-1);
        return lca;
    }

    public static Node lca2(Node root,int n1,int n2){

        if(root==null){
            return null;
        }

        if(root.data==n1 || root.data==n2){
            return root;
        }

        Node leftlca=lca2(root.left,n1,n2);
        Node rightlca=lca2(root.right,n1,n2);

        if(rightlca==null){
            return leftlca;
        }

        if(leftlca==null){
            return rightlca;
        }
        return root;
    }

    public static int locDist(Node root,int n){

        // T.c: O(n)
        if(root==null){
            return -1;
        }

        if(root.data==n){
            return 0;
        }

        int ld=locDist(root.left,n);
        int rd=locDist(root.right,n);

        if(ld==-1 && rd==-1){
            return -1;
        }else if(ld==-1){
            return rd+1;
        }else{
            return ld+1;
        }
    }

    public static int mindist(Node root,int n1,int n2){

        Node lca=lca2(root,n1,n2);
        int dis1=locDist(lca,n1);
        int dis2=locDist(lca,n2);

        return dis1+dis2;
    }

    public static int Kancestor(Node root,int n,int k){

        if(root==null){
            return -1;
        }

        if(root.data==n){
            return 0;
        }

        int leftdist=Kancestor(root.left,n,k);
        int rightdist=Kancestor(root.right,n,k);

        if(leftdist==-1 && rightdist==-1){
            return -1;
        }

        int max=Math.max(leftdist,rightdist);

        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int  sumtransform(Node root){

        if(root==null){
            return 0;
        }

        int leftchild=sumtransform(root.left);
        int rightchild=sumtransform(root.right);

        int data=root.data;

        int newleft=root.left==null? 0:root.left.data;
        int newright=root.right==null?0:root.right.data;

        root.data=leftchild+newleft+rightchild+newright;

        return data;

    }

    public static void preorder(Node root){

        if(root==null){
            return ;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void main(String args[]){

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        topview(root);
        System.out.println();
        levelorder(root, 1);
        // kth_level 
        preorder(root, 1, 1);
        System.out.println();

        int n1=4,n2=5;
        System.out.println(lca(root,4,5).data);

        System.out.println(lca2(root,4,6).data);

        System.out.println(mindist(root,4,6));

        Kancestor(root,5,1);
        sumtransform(root);
        preorder(root);



        
    }
}