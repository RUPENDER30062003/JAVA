import java.util.*;

public class twodarray{

    public static void input(int matrix[][]){

        int n=matrix.length;
        int m=matrix[0].length;
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
    }

    public static int no_of_key(int arr[][],int key){

        int number=0;
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==key){
                    number++;
                }
            }
        }
        System.out.println(number);
        return number;

    }

    public static int row_sum(int arr[][],int row){
        row--;
        int sum=0;
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==row){
                    sum += arr[i][j];
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static void transpose(int arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }

    public static void output(int matrix[][]){
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println("matrix["+(i+1)+"]["+(j+1)+"]="+ matrix[i][j]);
            }
        }
    }

    public static boolean search(int matrix[][],int key){
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (matrix[i][j]==key){
                    System.out.println("key found at cell("+(i+1)+","+(j+1)+")");
                    return true;
                }
            }
        }
        return false;
    }

    public static void spiral_matrix(int arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        int startrow=0;
        int startcolumn=0;
        int endrow=n-1;
        int endcolumn=m-1;

        while (startrow <= endrow && endcolumn >= startcolumn){
            // top //
            for(int j=startcolumn;j<=endcolumn;j++){
                System.out.print(arr[startrow][j]+" ");
            }
            for(int j=startrow+1;j<=endrow;j++ ){
                System.out.print(arr[j][endcolumn] +" ");
            }
            for(int j=endcolumn-1;j>=startcolumn;j--){
                if(startrow == endrow){
                    break ;}
                System.out.print(arr[endrow][j] +" ");
            }
            for(int j=endrow-1;j>startrow;j--){
                if(startcolumn == endcolumn){
                    break ;
                }
                System.out.print(arr[j][startcolumn]+ " ");
            }
            startrow++;
            endcolumn--;
            endrow--;
            startcolumn++;
        }
    }

    public static int diagnol_sum(int arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        int diagnol_sum=0;
        if(n==m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==j){
                    diagnol_sum += arr[i][j];                   
                }
                if(i+j == n-1){
                    diagnol_sum +=arr[i][j];
                }
            }   
            }
            if(n%2==1){
                int mid=(int)n/2;
                diagnol_sum -= arr[mid][mid];
            }
            return diagnol_sum;
        }else{
        return 0;}
    }

    public static int optimized_diagnol_sum (int arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        int sum=0;
        if(n==m){
            for(int i=0;i<n;i++){
                sum +=arr[i][i];
                if(i != n-i-1){
                sum +=arr[i][n-i-1];
                }
            }
            return sum;
        }else{
            return 0;
        }
    }

     public static int max(int matrix[][]){
        int n=matrix.length;
        int m=matrix[0].length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (matrix[i][j]>max){
                    max=matrix[i][j];
                }
                if (matrix[i][j]<min){
                    min=matrix[i][j];
                }
            }
        }
        System.out.println("max="+ max);
        System.out.println("min="+ min);
        return max;
    }

    public static boolean stair_case_search(int arr[][],int key){
        int row=0;
        int column=arr[0].length-1;

        while(row < arr.length && column >= 0){
            if(arr[row][column]==key){
                System.out.println("FOUND KEY AT (" + (row+1) +","+ (column+1)+")");
                return true;
            }else if(key<arr[row][column]){
                column--;
            }else{
                row++;
            }
        }   
        System.out.println("key not found !");
        return false;  
    }


    public static void main(String args[]){

        int matrix[][]=new int [3][3];
        int spiral[][]=new int [4][4];

        int sorted[][]={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        row_sum(sorted,1);
        no_of_key(sorted,20);
        stair_case_search(sorted,33);

        input(matrix);
        
        System.out.println(optimized_diagnol_sum(matrix));
        spiral_matrix(spiral);
        input(matrix);
        output(matrix);
        search(matrix,5);
        max(matrix);
    }
}