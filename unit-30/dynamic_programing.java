import java.util.*;

public class dynamic_programing {

    public static int fibonaci(int n){

        // O(2^n) //
        if(n==0 || n==1){
            return n;
        }

        return fibonaci(n-1)+fibTabulation(n-2);
    }

    public static int fib(int n,int f[]){

        // O(n+1) //

        if(n==0 || n==1){
            return n;
        }

        if (f[n] != 0) {
            return f[n];
        }

        f[n]=fib(n-1,f)+fib(n-2,f);
        return f[n];

    }

    public static int fibTabulation(int n) {

        // O(n) //
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n]; // ans //
    }

    public static void main(String[] args) {
        int n=6;
        int f[]=new int[n+1];  // 0,0,0,0,0 //
        System.out.println(fib(n,f));
        System.out.println(fibTabulation(n));

    }
}
