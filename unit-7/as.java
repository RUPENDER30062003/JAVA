import java.util.*;
public class as{
    
    public static int average(int a,int b,int c){
        return (a+b+c)/3;
    }

    public static int sum_of_digit_in_integer(int n){
        int sum=0;
        for(int i=0;n>0;i++){
            int remainder=n%10;
            sum+=remainder;
            n/=10;
        }
        return sum;
    }

    public static boolean evenodd(int n){
        if(n%2==0){
            return true;
        }else{
            return false;
        }
    }

    public static boolean palindrome(int n){
        int real=n;
        int reverse=0;
        for(int i=0;n>0;i++){
            int remainder=n%10;
            reverse=reverse*10+remainder;
            n/=10;
        }
        if(real==reverse){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String args[]){

        System.out.println("");

        System.out.println("enter an integer");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("");
        

        System.out.println("enter an integer");
        int m=sc.nextInt();
        System.out.println("");

        System.out.println("enter an integer");
        int o=sc.nextInt();
        System.out.println("");

        System.out.println("average ="+ average(n,m,o));
        System.out.println("");

        System.out.println("palindrome ="+palindrome(n));
        System.out.println("");

        System.out.println(sum_of_digit_in_integer(n));
        System.out.println("");

    

    }}
