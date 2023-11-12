import java.util.*;

public class coin_change {

    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int coin_change(int coin[],int sum) {

        int W=sum;
        int n=coin.length;
        int dp[][]=new int[n+1][W+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0]=1;
        }
        for (int j = 1; j < W+1; j++) {
            dp[0][j]=0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
    
                if(coin[i-1] <= j){
                    // valid //
                    dp[i][j]= dp[i][j-coin[i-1]]+dp[i-1][j];
                }else{
                    // invalid //
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        print(dp);
        return dp[n][W];

    }
    public static void main(String[] args) {
        int coin[]={2,5,3,6};
        int coin1[]={1,2,3};
        int sum1=4;
        int sum=10;
        System.out.println(coin_change(coin1, sum1));
        
    }
}
