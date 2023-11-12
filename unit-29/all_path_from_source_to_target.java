import java.util.*;

public class all_path_from_source_to_target {

    static class Edge{

        int src;
        int dest;

        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }



    public static void all_path(ArrayList<Edge>[] graph,int s,int t,String path) {
    // exponential time complexity //    
    // O(v^v) time complexity //
        if(s == t){
            System.out.println(path+ t);
            return ;
        }

        for (int i = 0; i < graph[s].size(); i++) {
            Edge e=graph[s].get(i);
            all_path(graph, e.dest, t, path+s);
        } 
    }
    

    


    public static void main(String args[]) {

        int V=6;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        all_path(graph, 5, 1,"");
        
        
    }
}
