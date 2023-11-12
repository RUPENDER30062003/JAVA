import java.util.*;

public class assignment{

    public static boolean checkPalindrome(LinkedList <Integer> ll){
        
        Stack<Integer> s=new Stack<>();
        int n=ll.size();
        if(n%2==0){
            for(int i=0;i<n/2;i++){
                s.push(ll.removeFirst());
            } 
            for(int i=0;i<n/2;i++){
                if(s.pop()!=ll.removeFirst()){
                   return false;
                }
            }
            return true;
        }else{
            for(int i=0;i<n/2;i++){
                s.push(ll.removeFirst());
            }
            ll.removeFirst();
            for(int i=0;i<n/2;i++){
                if(s.pop()!=ll.removeFirst()){
                   return false;
                }
            }
            return true;
        }
    }

    public static void path(String str){

        int n=str.length();
        
        StringBuilder pair[]=new StringBuilder[n];
        
        int j=0;

        for(int i=0;i<n;i++){
            
            StringBuilder s=new StringBuilder("");
        
            while(str.charAt(i) != '/' && i < n){
                s.append(str.charAt(i));
                i++;
            }

            pair[j]=s;
            j++;
        }

        Stack <StringBuilder> sta=new Stack<>();

        int i=0;

        while(pair[i]!=null){
            if(pair[i].toString().equals("..")){
                if(!sta.isEmpty()){
                sta.pop();
                }
            }else if(pair[i].toString().equals(".")){
            
            }else{
                sta.push(pair[i]);
                
            }
            i++;
        }

        while(!sta.isEmpty()){
            System.out.print("/"+sta.pop());
        }
        System.out.println();

    }

    public static String simplify(String A){
        Stack<String> st = new Stack<String>();
        String res = "";
        res += "/";
        int len_A = A.length();
        for (int i = 0; i < len_A; i++){
            String dir = "";
            while (i < len_A && A.charAt(i) == '/'){
                i++;
            }
            while (i < len_A && A.charAt(i) != '/'){
                dir += A.charAt(i);
                i++;
            }
            if(dir.equals("..") == true){
                if (!st.empty()){
                    st.pop();
                }
            }else if (dir.equals(".") == true){
                continue;
            }else if (dir.length() != 0){
                st.push(dir);
            }
        }

            Stack<String> st1 = new Stack<String>();
            while (!st.empty()){
                st1.push(st.pop());
            }

            while (!st1.empty()){
                if (st1.size() != 1){
                    res += (st1.pop() + "/");
                }else {
                    res += st1.pop();
                }
            }
        return res; 
    }

    public static boolean alphabat(String str){
        for(char ch='a';ch<='z';ch++){
            if(str.charAt(0)==ch){
                return true;
            }
        }
        return false;
    }

    public static String decode(String str){
        Stack<Integer> integerstack = new Stack<>();
        Stack<Character> stringstack = new Stack<>();
        String temp = "",result="";
        for (int i=0;i<str.length();i++){

            int count = 0;

            if(Character.isDigit(str.charAt(i))){
                while(Character.isDigit(str.charAt(i))){
                    count=count*10+str.charAt(i)-'0';
                    i++;
                }
                i--;
                integerstack.push(count);
            }else if(str.charAt(i)==']'){
                temp="";
                count=0;
                if(!integerstack.isEmpty()){
                    count = integerstack.peek();
                    integerstack.pop();
                }
                while(!stringstack.isEmpty() && stringstack.peek()!='['){
                    temp+=stringstack.peek();
                    stringstack.pop();
                }
                if(!stringstack.empty() && stringstack.peek() == '['){
                    stringstack.pop();
                }
                for(int j=0;j<count;j++){
                    result = result + temp;
                }
                for(int j=0;j<result.length();j++){
                    stringstack.push(result.charAt(j));
                }
                result = "";
            }else if(str.charAt(i) == '['){
                if(Character.isDigit(str.charAt(i-1))){
                    stringstack.push(str.charAt(i));
                }else{
                    stringstack.push(str.charAt(i));
                    integerstack.push(1);
                }
            }else{
                stringstack.push(str.charAt(i));
            }
        }

        while(!stringstack.isEmpty()){
            result=stringstack.peek()+result;
            stringstack.pop();
        }

        return result;
    }

    public static int maxWater(int height[]){

        Stack<Integer> stack =new Stack<>();
        int n = height.length;
        int ans = 0;
        for (int i = 0; i < n; i++){
            while((!stack.isEmpty()) && (height[stack.peek()]<height[i])){
                int pop_height = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int distance = i-stack.peek()-1;
                int min_height= Math.min(height[stack.peek()],height[i])-pop_height;
                ans += distance * min_height;
                }
            stack.push(i);
        }
        return ans;
    }

    public static int trapwater(int arr[]){

        int n=arr.length;
        if(n<3){
            return 0;
        }

        int left_max[]=new int[n];
        left_max[0]=arr[0];
        for(int i=1;i<n;i++){
            left_max[i]=Math.max(left_max[i-1],arr[i]);
        }

        int right_max[]=new int [n];
        right_max[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            right_max[i]=Math.max(right_max[i+1],arr[i]);
        }

        int trapped_water=0;  
        for(int i=0;i<n;i++){
            int waterlevel=Math.min(left_max[i],right_max[i]);
            trapped_water+=waterlevel-arr[i];
        }

        return trapped_water;
        
    }

    
    public static void main(String args[]){

        LinkedList<Integer> ll=new LinkedList<>();
            ll.addLast(1);
            ll.addLast(2);
            ll.addLast(3);
            ll.addLast(2);
            ll.addLast(1);
        System.out.println(checkPalindrome(ll));


        String strr = new String("/a/./b/../../c/");
        path(strr);
        System.out.println(simplify(strr));
        String str = "3[b2[ca]]";

        System.out.println(decode(str));

        int arr[] ={7,0,4,2,5,0,6,4,0,6};
        int arrr[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(trapwater(arrr));
    }
}