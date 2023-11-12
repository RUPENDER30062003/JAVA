import java.util.*; 
public class operator{
    public static void main (String args[]){
        int a=2;
        int b=++a;
        int c=++a;
        System.out.println( b+ " "+ c);
        a+=10;
        System.out.println(a);

        int x =2;
        int y =5;
        int exp1 = (x * y / x);
        int exp2 = (x * (y / x));
        System.out.println(exp1);
        System.out.println(exp2);


    }}