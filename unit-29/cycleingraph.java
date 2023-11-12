import java.util.*;

public class cycleingraph {

    static class Edge{

        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w) {
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){

        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1)); 
        graph[0].add(new Edge(0, 2, 1));
        

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));


        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[5].add(new Edge(6, 5, 1));
        

    }

    public static void  bfs(ArrayList<Edge>[] graph){

        boolean vis[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++){
            if(!vis[i]){
                bfsUtil(graph, vis);
            }
            
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph ,boolean vis[]){

        // T.C - O(V+E) //
        // T.C - O(v^2) for matrix problem implementation //

        Queue<Integer> q=new LinkedList<>();
        q.add(0); //source =0 //

        while(!q.isEmpty()){

            int curr=q.remove();

            if(!vis[curr]){
                // visit curr//

                System.out.print(curr+" ");
                vis[curr]=true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++){
            if (!vis[i]) {    
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph,int curr,boolean vis[]){

        // visit //
        System.out.print(curr+" ");
        vis[curr]=true;

        for (int i = 0; i < graph[curr].size(); i++){

            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph,e.dest, vis);
            }
        }
    }

    // O(V+E) //
    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean vis[]){

        if(src== dest){
            return true;
        }
        vis[src]=true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e=graph[src].get(i);
            
            // e.dest == neighbour //
            if ( !vis[e.dest] && hasPath(graph,e.dest, dest, vis)) {
                return true;
            }
        }

        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){

        boolean vis[]=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                    // cycle esist in one of the parts //
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean vis[],int curr,int par ){

        // O(V+E) //
        vis[curr]=true;

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e=graph[curr].get(i);
            // case-3
            if(!vis[e.dest]){
                if(detectCycleUtil(graph, vis, e.dest, curr)){
                    return true;
                }
            }else if(vis[e.dest] && e.dest !=par){
            // case-1    
                return true;
            }
            // case-2 -> do nothing -> continue //
        }
        return false;

    }

    public static void main(String[] args) {

        int V=7;

        /*
            1------3
           /       | \
          0        |  5--6
           \       | /
            2------4
         */


        // array of arraylist //
        ArrayList<Edge>[] graph=new ArrayList[V];// null ->empty arraylist //
        createGraph(graph);
        dfs(graph);
        System.out.println();
        bfs(graph);
        System.out.println();
        System.out.println(hasPath(graph, 0, 5,new boolean[V]));

        System.out.println(detectCycle(graph));
        
    }
}

