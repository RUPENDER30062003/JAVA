import java.util.*;
public class assignment{

    public static void rat_maze_a(int rat[][], int row, int col, String sol) {
    if (row == rat.length - 1 && col == rat.length - 1 && rat[row][col] == 1) {
        System.out.println(sol);
        return ;
    }

    if (rat[row][col] == 1) {
        rat[row][col] = 0; // mark current cell as visited
        if (row + 1 < rat.length && rat[row + 1][col] == 1) {
            rat_maze_a(rat, row + 1, col, sol + "D");
        }
        if (col + 1 < rat.length && rat[row][col + 1] == 1) {
            rat_maze_a(rat, row, col + 1, sol + "R");
        }
        if (col - 1 >= 0 && rat[row][col - 1] == 1) {
            rat_maze_a(rat, row, col - 1, sol + "L");
        }
        if (row - 1 >= 0 && rat[row - 1][col] == 1) {
            rat_maze_a(rat, row - 1, col, sol + "U");
        }

        rat[row][col] = 1; // backtrack: mark current cell as unvisited
    }
    }

    public static boolean rat_maze(int rat[][], int row, int col, String sol) {
    if(row < 0 || row >= rat.length || col < 0 || col >= rat.length || rat[row][col] == 0) {
        return false;
    }

    if(row==rat.length-1 && col==rat.length-1 && rat[row][col]==1) {
        System.out.println(sol);
        return true;
    }

    if(rat[row][col]==1) {
        if(rat_maze(rat,row+1,col,sol+"D")) {
            return true;
        }
        if(rat_maze(rat,row,col+1,sol+"R")) {
            return true;
        }
        if(rat_maze(rat,row,col-1,sol+"L")) {
            return true;
        }
        if(rat_maze(rat,row-1,col,sol+"U")) {
            return true;
        }
    }
    return false;
    }
        
    static String helper[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    

    public static void main(String args[]){
        int rat[][]={
            {1,0,0,0},
            {1,1,0,0},
            {0,1,0,0},
            {1,1,1,1}};
            rat_maze_a(rat,0,0,"");
            System.out.println(rat_maze(rat,0,0,""));



    }
}