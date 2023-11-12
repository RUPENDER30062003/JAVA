import java.util.*;

public class flood_fill_algorithm {

    //O(M+N)

    public static int [][] flood_fill(int image[][],int sr,int sc,int color){
        //O(1)//
        boolean vis[][]=new boolean[image.length][image[0].length];
        helper_flood_fill(image ,sr ,sc ,color,vis, image[sr][sc]);
        return image;

    }

    public static void helper_flood_fill (int image[][],int sr,int sc,int color,boolean vis[][],int orgcolor){


        // O(M+N) //
        if(sr<0 || sc<0 || sr>= image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc] !=orgcolor){
            return ;
        }
        image[sr][sc]=2;
        // left //
        helper_flood_fill(image, sr, sc-1, color,vis, orgcolor);

        // right //
        helper_flood_fill(image ,sr ,sc+1 ,color,vis, orgcolor);

        // up //
        helper_flood_fill(image ,sr-1 ,sc ,color,vis, orgcolor);

        // down //
        helper_flood_fill(image ,sr+1 ,sc ,color,vis, orgcolor);
    }
    public static void main(String args[]){

        int image[][]={{1,1,1},
                       {1,1,0},
                       {1,0,1}};

        flood_fill(image,1,1,1);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}
