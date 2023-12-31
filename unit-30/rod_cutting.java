import java.util.*;  

public class rod_cutting {

    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]<10) {
                    System.out.print(arr[i][j]+"  ");
                }else{
                    System.out.print(arr[i][j]+" ");
                }
                    
            }
            System.out.println();
        }
    }

    public static int rod(int price[],int length[],int totalrodlength) {

        // weight -> length  ; val-> price ; W-> totalrodlength // 

        int W=totalrodlength;
        int n=price.length;
        int dp[][]=new int[n+1][W+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0]=0;
        }

        for (int j = 0; j < W+1; j++) {
            dp[0][j]=0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if(length[i-1] <= j){
                    // valid //
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
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
        int length[]={1,2,3,4,5,6,7,8};
        int price[]={1,5,8,9,10,17,17,20};
        int rodlength=8;
        
        System.out.println(rod(price,length,rodlength));
    }
    
}
