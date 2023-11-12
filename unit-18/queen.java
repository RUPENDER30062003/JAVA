import java.util.*;

public class queen{

    public static void print_array_two(int arr[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(arr[i][j]+" ");
            }System.out.println();
        }
    }

    public static boolean isSafe_sudoku(int sudoku[][],int row,int col,int digit){
        
        for(int i=0;i<=8;i++){
            if(sudoku[i][col]== digit){
                return false;
            }
        }

        for(int j=0;j<=8;j++){
            if(sudoku[row][j]== digit){
                return false;
            }
        }

        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }

        return true;

    }

    public static boolean sudokuSolver(int sudoku[][],int row,int col){
        
        // base case //
        if(row ==9 && col == 0){
            return true;
        }
        
        // recursion //
        int nextRow=row;
        int nextCol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
        }

        if(sudoku[row][col] !=0){
            return sudokuSolver(sudoku,nextRow,nextCol);
        }

        for(int digit=1;digit<=9;digit++){
            if(isSafe_sudoku(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
                if(sudokuSolver(sudoku,nextRow,nextCol)){  // solution exist //
                    return true;
                }
                sudoku[row][col]=0;
            }
        }

        return false;
    }

    public static int grid_ways(int i,int j,int n,int m){

        if(i==n-1 && j==m-1){
            return 1;
        }else if(i==n || j==m){
            return 0;
        }
        int w1=grid_ways(i+1,j,n,m);
        int w2=grid_ways(i,j+1,n,m);
        return w1+w2;

    }

    public static boolean isSafe(char board[][],int row,int col){

        // vertical up   //
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        // diag left up  //
        for(int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // diag right up //
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }

    public static void nQueen(char board[][],int row){

        // base//
        if(row == board.length){
            count++;
            printBoard(board);
            return ;
        }

        // column loop //
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)==true)
            {
            board[row][j]='Q';
            nQueen(board,row+1);  // function call //
            board[row][j]='x';    // backtracking step //
            }
        }

    }

    public static void printBoard(char board[][]){
        System.out.println("--------chess board----------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int count=0;

    public static void main(String args[]){

        int n=4;

        char board[][]=new char[n][n];
        // initialize //
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='x';
            }
        }

        nQueen(board,0);
        System.out.println(count);

        System.out.println(grid_ways(0,0,3,3));

        int sudoku1[][]=new int[9][9];
        
        int sudoku[][]= 
       {{0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3}};

        if(sudokuSolver(sudoku,0,0)){
            System.out.println("solution exist");
            print_array_two(sudoku);
        }else{
            System.out.println("solution doesnot exist");
        }

    }
}