import java.util.*;

public class climbing_stair {

    public static int  countWays(int n){

        if (n==0) {
            return 1;
        }

        if (n<0) {
            return 0;
        }
        return countWays(n-1)+countWays(n-2);
    }

    public static int  countWays_Variation(int n){

        if (n==0) {
            return 1;
        }

        if (n<0) {
            return 0;
        }

        return countWays_Variation(n-1)+countWays_Variation(n-2)+countWays_Variation(n-3);
    }
 
    public static int  countWays_memoization(int n,int w[]){

        if (n==0) {
            return 1;
        }

        if (n<0) {
            return 0;
        }

        if(w[n]!= -1){ // already calulated //
            return w[n];
        }

        w[n]=countWays_memoization(n-1,w)+countWays_memoization(n-2,w);
        return w[n];
    }

    public static int countWays_tabulation(int n) {

        int w[]=new int[n+1];
        w[0]=1;
        for (int i = 1; i < w.length; i++) {
            if(i ==1){
                w[i]=w[i-1]+0;
            }else{
                w[i]=w[i-1]+w[i-2];
            }
        }
        return w[n];
    }

    public static void main(String[] args) {

        int n=5;
        System.out.println(countWays(n));

        int w[]=new int[n+1]; // 0,0,0,0,0 //
        Arrays.fill(w,-1);   // -1,-1,-1,-1,-1 //
        System.out.println(countWays_memoization(n,w));

        System.out.println(countWays_Variation(n));
        System.out.println(countWays_tabulation(n));
    }
    
}
