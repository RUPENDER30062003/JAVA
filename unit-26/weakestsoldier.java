import java.util.*;

public class weakestsoldier{

    static class row implements Comparable<row>{
        int soldier;
        int idx;

        public row(int soldier,int idx){
            this.soldier=soldier;
            this.idx=idx;
        }

        @Override
        public int compareTo(row r2){

            if(this.soldier==r2.soldier){
                return this.idx-r2.idx;
            }else{
                return this.soldier-r2.soldier;
            }
        }
        
    }

    public static void main(String[] args){

        int soldier[][]={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int m=soldier.length;
        int n=soldier[0].length;
        int k=2;

        PriorityQueue<row> pq=new PriorityQueue<>();
        
        for(int i=0;i<m;i++){
            int count=0;
            for(int j=0;j<n;j++){
                count += soldier[i][j] == 1 ? 1 : 0  ;
            }
            pq.add(new row(count,i));
        }

        for(int i=0;i<k;i++){
            System.out.println("R"+pq.remove().idx);
        }
        
    }
    
}