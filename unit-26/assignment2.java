import java.util.*;

public class assignment2 {

    static String decode(String str){

        Stack<Integer> integerstack = new Stack<>();
        Stack<Character> stringstack = new Stack<>();

        String temp = "", result = "";

        for (int i = 0; i < str.length(); i++){

            int count = 0;

            if (Character.isDigit(str.charAt(i))){

                while (Character.isDigit(str.charAt(i))){
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                integerstack.push(count);

            }else if (str.charAt(i) == ']'){

                temp = "";
                count = 0;
                if (!integerstack.isEmpty()){
                    count = integerstack.peek();
                    integerstack.pop();
                }
                while (!stringstack.isEmpty() && stringstack.peek()!='[' ){
                    temp = stringstack.peek() + temp;stringstack.pop();
                }
                if (!stringstack.empty() && stringstack.peek() == '['){
                    stringstack.pop();
                }
                for (int j = 0; j < count; j++){
                    result = result + temp;
                }
                for (int j = 0; j < result.length(); j++){
                    stringstack.push(result.charAt(j));
                }
                result = "";

            }else if (str.charAt(i) == '['){

                if (Character.isDigit(str.charAt(i-1))){
                    stringstack.push(str.charAt(i));
                }else{
                    stringstack.push(str.charAt(i));
                    integerstack.push(1);
                }

            }else{

                stringstack.push(str.charAt(i));

            }
        }

        while (!stringstack.isEmpty()){

            result = stringstack.peek() + result;
            stringstack.pop();

        }

        return result;

    }

    static int min_cost=Integer.MAX_VALUE;
    static String answer="";

    public static void pathwithmin_effort(int arr[][],int i,int j,int val,String ans){
        if(i==arr.length-1 && j==arr[0].length-1){
            if(min_cost<val){
                min_cost=val+arr[i][j];
                answer=ans;
            }
            return;
        }

        if(i+1<arr.length){
            pathwithmin_effort(arr, i+1, j, val+arr[i][j], ans+'R');
        }
        if(j+1<arr[0].length){
            pathwithmin_effort(arr, i, j+1, val+arr[i][j], ans+'D');
        }
        if(i-1<arr.length){
            pathwithmin_effort(arr, i-1, j, val+arr[i][j], ans+'L');
        }
        if(j-1<arr.length){
            pathwithmin_effort(arr, i, j-1, val+arr[i][j], ans+'U');
        }

    }

    public static void main(String args[]){

        // String str = "3[b2[ca]]";
        // System.out.println(decode(str));
        

        int arr[][]={{ 31, 100, 65, 12, 18 },
                    { 10, 13, 47, 157, 6 },
                    { 100, 113, 174, 11, 33 },
                    { 88, 124, 41, 20, 140 },
                    { 99, 32, 111, 41, 20 }};
        pathwithmin_effort(arr,0, 0, arr[0][0], "");
        System.out.print(answer);
        System.out.print(min_cost);
        
    }
}
