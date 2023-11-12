import java.util.*;

public class numcourse {


    public static void calcIndeg( int  graph[][] , int indeg[] ) {
        
        for (int i = 0; i < graph.length; i++) {
                indeg[graph[i][1]]++;
        }  

    }

    public static void topsort(int graph[][]){

        int indeg[]=new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q=new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        // bfs //

        while(!q.isEmpty()){

            int curr=q.remove();
            System.out.print(curr+" ");// topological sort //

            for (int i = 0 ; i < graph.length; i++) {
                if(curr==graph[i][0] && graph[i][2]==-1){
                    indeg[graph[i][1]]--;
                    graph[i][2]=0;
                }

                if (indeg[graph[i][1]] == 0 ) {
                    q.add(graph[i][1]);
                    indeg[graph[i][1]]=-1;
                }
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("enter number of course");
        int numcourse=sc.nextInt();

        int prerequistic[][]=new int[numcourse][3];

        for (int i = 0; i < prerequistic.length; i++) {
            Scanner sb=new Scanner(System.in);
            System.out.println("enter="+(i+1)+",1");
            prerequistic[i][0]=sb.nextInt();
            System.out.println("enter="+(i+1)+",2");
            prerequistic[i][1]=sb.nextInt();
            prerequistic[i][2]=-1;
        }

        topsort(prerequistic);

    }
}
