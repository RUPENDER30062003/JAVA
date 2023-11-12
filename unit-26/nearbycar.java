
import java.util.*;

public class nearbycar {

    static class Point implements Comparable<Point>{
        int x,y;
        int distSqrt;
        int idx;

        public Point(int x,int y,int distSqrt,int idx){
            this.x=x;
            this.y=y;
            this.distSqrt=distSqrt;
            this.idx=idx;
        }

        public Point(int x,int y,int idx){
            this.x=x;
            this.y=y;
            this.distSqrt=(int)Math.sqrt(x*x+y*y);
            this.idx=idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSqrt-p2.distSqrt; // ascending order //
        }

    }
    public static void main(String[] args) {
        int pts[][]={{3,3},{5,-1},{-2,4}};
        int k=2;

        PriorityQueue<Point> pq=new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq,i));
        }

        // nearest k cars //
        for (int i = 0; i < k; i++) {
            System.out.println("C"+pq.remove().idx);
        }
    



    }
}
