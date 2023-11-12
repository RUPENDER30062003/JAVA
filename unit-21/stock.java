import java.util.*;

public class stock{

    public static void stockSpan(int stocks[],int span[]){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1;i<stocks.length;i++){
            int currPrice=stocks[i];
            while(!s.isEmpty() && currPrice>stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1; 
            }else{
                int prevHigh=s.peek();
                span[i]=i-prevHigh;
            }
            s.push(i);
        }
    }

    public static void nextgreaterright(int arr[],int next[]){
        
        Stack <Integer> s=new Stack<>();

        for (int i = arr.length; i > 0; i--) {

            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                next[i]=-1;
            }else{
                next[i]=arr[s.peek()];
            }
            s.push(i);
        }

        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i]+" ");
        }
        System.out.println();
    }

    public static boolean isValid(String str){

        Stack <Character> s=new Stack<>();

        for(int i=0;i<str.length();i++){

            char ch=str.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){

                s.push(ch);

            }else{

                if(s.isEmpty()){
                    return false;
                }

                if((s.peek()=='(' && ch==')')|| (s.peek()=='{'&& ch=='}') || (s.peek()=='[' && ch==']') ){
                    s.pop();
                }else{
                    return false;
                }

            }
    
        }

        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }

    }

    public static boolean duplicateparentheses(String str){

        Stack <Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch !=')'){
                s.push(ch);
            }else{
                int count=0;
                while(s.peek() !='(' && !s.isEmpty()){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }
                s.pop();
            }
        }
        return false;
        
    }

    public static void maxarea(int arr[]){
        int maxarea=0;
        int nsr[]=new int[arr.length];
        int nsl[]=new int[arr.length];

        // next smaller right //
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        // next smaller left //
        s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }

        // current area  weidth=j-i-1//
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int currArea=height*width;
            maxarea=Math.max(currArea,maxarea);
        }

        System.out.println("max area in histogram="+ maxarea);
    }

    public static void main(String args[]){
        int stocks[]={100,80,60,70,60,85,100};
        int span[]=new int[stocks.length];
        stockSpan(stocks,span);

        for(int i=0;i<span.length;i++){
            System.out.println(span[i]+" ");
        }

        int arr[]={6,8,0,1,3};
        Stack <Integer> s=new Stack<>();
        int nextGreater[]=new int [arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nextGreater[i]=-1;
            }else{
                nextGreater[i]=arr[s.peek()];
            }
            s.push(i);
        }

        for(int i=0;i<nextGreater.length;i++){
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();

        String strr="({})[]";
        System.out.println(isValid(strr));

        String stra="(((a+(b)))+(c+d))";
        String strb="((a+b)+(c+d))";

        System.out.println(duplicateparentheses(strb));

        int arrA[]={2,1,5,6,2,3};
        maxarea(arrA);

    }
}