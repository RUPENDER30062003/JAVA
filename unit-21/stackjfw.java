
import java.util.*;

public class stackjfw{

    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return ;
        }
        int top=s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }

    public static String reverseString(String str){
        Stack <Character> s=new Stack<>();
        int index=0;
        while(index<str.length()){
            s.push(str.charAt(index));
            index++;
        }
        StringBuilder result=new StringBuilder("");
        while(!s.isEmpty()){
            char curr=s.pop();
            result.append(curr);
        }
        str=result.toString();
        return str;
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return ;
        }
        int top=s.pop();
        reverseStack(s);
        pushAtBottom(s,top);
    }

    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    public static void main(String args[]){

        Stack<Integer> ss=new Stack<>();

        ss.push(1);
        ss.push(2);
        ss.push(3);

        while(!ss.isEmpty()){
            System.out.println(ss.peek());
            ss.pop();
        } 

         Stack <Integer> s=new Stack<>();
         s.push(1);
         s.push(2);
         s.push(3);
        pushAtBottom(s,4);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }

        String str="abcdefghi";
        String result=reverseString(str);
        System.out.println(result);

        Stack <Integer>sb=new Stack<>();
        sb.push(1);
        sb.push(2);
        sb.push(3);

        reverseStack(sb);
        printStack(sb);

    }
}