import java.util.*;

public class graphtraverse {

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

    static void createGraph1(ArrayList<Edge> graph[]){

        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));

    }

    static void createGraph2(ArrayList<Edge> graph[]){

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


    public static void bfs(ArrayList<Edge>[] graph){

        // T.C - O(V+E) //
        // T.C - O(v^2) for matrix problem implementation //

        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[graph.length];
        q.add(0); //source =0 //

        while(!q.isEmpty()){

            int curr=q.remove();

            if(!vis[curr]){
                // visit curr//
                System.out.print(curr+" ");
                vis[curr]=true;
                for (int i = 0; i<graph[curr].size(); i++) {
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    public static void dfs(ArrayList<Edge>[] graph,int curr,boolean vis[]){

        // visit //
        System.out.print(curr+" ");
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest, vis);
            }
        }

    }
    

    public static void main(String[] args) {

        int V1=5;
        int V2=7;

        /*  V2 
            1------3
           /       | \
          0        |  5--6
           \       | /
            2------4
         */

        /*      2
              / |
             /  |
        0---1   |
             \  |
              \ |
                3
         */

        // array of arraylist //
        ArrayList<Edge>[] graph=new ArrayList[V2];// null ->empty arraylist //
        createGraph2(graph);

        bfs(graph);
        System.out.println();
        dfs(graph, 0, new boolean[V2]);
        
    }
}
