import java.util.*;

public class cycledetect {

        static class Edge{

            int src;
            int dest;

            public Edge(int src,int dest){
                this.src = src;
                this.dest = dest;
            }

        }

        public static void createGraph(ArrayList<Edge> graph[]){

            for (int i = 0; i < graph.length; i++) {
                graph[i]=new ArrayList<>();
            }

            graph[0].add(new Edge(0,2));
            graph[1].add(new Edge(1,0));
            graph[2].add(new Edge(2,3));
            graph[3].add(new Edge(3,0));
            
        }

        public static void createGraph1(ArrayList<Edge> graph[]){

            for (int i = 0; i < graph.length; i++) {
                graph[i]=new ArrayList<>();
            }

            graph[0].add(new Edge(0,2));
            graph[0].add(new Edge(0,1));
            graph[1].add(new Edge(1,3));
            graph[2].add(new Edge(2,3));

        }

        public static void createGraph2(ArrayList<Edge> graph[]){

            for (int i = 0; i < graph.length; i++){
                graph[i]=new ArrayList<>();
            }

            graph[0].add(new Edge(0,1));
            graph[2].add(new Edge(2,1));
            graph[2].add(new Edge(2,3));
            graph[3].add(new Edge(3,4));
            graph[4].add(new Edge(4,2));

        }

        public static boolean isCycle(ArrayList<Edge>[] graph){

            boolean vis[]=new boolean[graph.length];
            boolean stack[]=new boolean[graph.length];

            for (int i = 0; i < graph.length; i++) {
                if(!vis[i]){
                        if(isCycleUtil(graph,i,vis,stack)){
                            return true;
                        }
                }
            }
            return false;

        }

        public static boolean isCycleUtil(ArrayList<Edge>[] graph,int curr,boolean vis[],boolean stack[]){

            // O(V+E) //

            vis[curr]=true;
            stack[curr]=true;

            for (int i = 0; i < graph[curr].size(); i++){
                Edge e=graph[curr].get(i);
                if(stack[e.dest]){ // cycle //
                    return true;
                }
                if(!vis[e.dest] && isCycleUtil(graph,e.dest,vis,stack)){
                        return true;
                }
            }
            stack[curr]=false;
            return false;
        }

        public static void main(String[] args) {
            int V=4;
            int V2=5;
            ArrayList<Edge> graph[]=new ArrayList[V2];
            createGraph2(graph);
            System.out.println(isCycle(graph));
        }



        
        

}
