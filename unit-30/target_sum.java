import java.util.*;

public class target_sum {

    public static void print(boolean arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == true) {
                    System.out.print("1 ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static boolean target_sum_subset(int arr[],int sum) {

        int n=arr.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        // i-iteam  and j- target_sum //

        for (int i = 0; i < n+1; i++) {
            dp[i][0]=true;
        }

        for (int j = 1; j < sum+1; j++){
            dp[0][j]=false;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++){

                int v=arr[i-1];
                // include //
                if(v <= j && dp[i-1][j-v] ==true){
                    dp[i][j]=true;
                }
                 // exclude //
                else if(dp[i-1][j] ==true){
                    dp[i][j]=true;
                }

            }
        }

        print(dp);
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int arr[]={4,2,7,1,3};
        int sum=10;
        System.out.println(target_sum_subset(arr, sum));
    }
}
