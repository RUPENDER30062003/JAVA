import java.util.*;
public class knights{

    public static int count = 0;
    
    public static int ans_count=0;

    public static void print_board(int ans[][]) {
    // Prints the current state of the solution matrix
    for (int i = 0; i < ans.length; i++) {
        for (int j = 0; j < ans.length; j++) {
            System.out.print(ans[i][j] + " ");
        }
        System.out.println();
    }
    System.out.println();
    }

    public static boolean allfill(int ans[][]) {
    // Checks if all cells are filled
    for (int i = 0; i < ans.length; i++) {
        for (int j = 0; j < ans.length; j++) {
            if (ans[i][j] == 0) {
                return false;
            }
        }
    }
    return true;
    }

    public static void knights(int n[][], int x, int y, int ans[][]) {

    if(ans_count==1){
        return ;}


    // If all cells are filled, print the solution and return
    if (allfill(ans)){
        ans_count=1;
        System.out.println();
        print_board(ans);
        return;
    }

    // Check if current cell is valid and not yet filled
    if (x >= 0 && x < ans.length && y >= 0 && y < ans.length && ans[x][y] == 0 && ans_count==0) {
        // Try all possible moves
        count++;
        ans[x][y] = count;
        knights(n, x + 1, y + 2, ans);
        knights(n, x + 2, y + 1, ans);
        knights(n, x + 2, y - 1, ans);
        knights(n, x + 1, y - 2, ans);
        knights(n, x - 1, y - 2, ans);
        knights(n, x - 2, y - 1, ans);
        knights(n, x - 2, y + 1, ans);
        knights(n, x - 1, y + 2, ans);
        count--;
        ans[x][y] = 0;
    }
    }

    final static char L[][]={
        {},
        {},
        {'a','b','c'},
        {'d','e','f'},
        {'g','h','i'},
        {'j','k','l'},
        {'m','n','o'},
        {'p','q','r','s'},
        {'t','u','v'},
        {'w','x','y','z'}
    };

    public static void letter_combination(String D){
        int len=D.length();
        if(len==0){
            System.out.println("");
            return ;
        }
        bfs(0,len,new StringBuilder(),D);
    }

    public static void bfs(int pos ,int len,StringBuilder sb,String D){

        if(pos==len){
            System.out.println(sb.toString());
        }else{
            char letters[]=L[Character.getNumericValue(D.charAt(pos))];  // Character.getNumericValue(D.charAt(pos)): This retrieves the numeric value of the character at position pos in the string D. The getNumericValue() method returns the int value that represents the numeric value of the specified Unicode character.//
            for(int i=0;i<letters.length;i++){
            bfs(pos+1,len,new StringBuilder(sb).append(letters[i]),D);
            }
        }
    }

    public static int number(char c){
        switch(c){
            case '0': return 0 ;
            
            case '1': return 1;
    
            case '2': return 2;
            
            case '3': return 3;
            
            case '4': return 4;

            case '5': return 5;
        
            case '6': return 6;
            
            case '7': return 7;
            
            case '8': return 8;
            
            case '9': return 9;
        
            default: return 0 ;
        }

    }

    static String key[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void letter_combination_(String d){
        int index=0;
        int ans=0;
        for (int i = 0; i < d.length(); i++) {
            char ch=d.charAt(i);
            int num=number(ch);
            if(num == 0 || num == 1){
                continue;
            }
            ans=ans*10+num;
            index++;
        }
        System.out.println(ans+" "+index);
        letter_combination_helper(ans,new StringBuilder(""),index);
        return ;
    }

    public static void letter_combination_helper(int n,StringBuilder ans,int index){

        if(index==0){
            System.out.println(ans.toString());
            return;
        }

            int remainder=n%10;
            String help=key[remainder];
            for (int i = 0; i < help.length(); i++) {
                char ch=help.charAt(i);
                letter_combination_helper(n/10, new StringBuilder(ans).append(ch),index-1);
            }
    }

    public static void main(String args[]){
        //letter_combination("23");
        letter_combination_("2301");

        int n[][] = new int[8][8]; // Create an 8x8 board
        int ans[][] = new int[8][8];

        knights(n, 0, 0, ans); 

    }
}