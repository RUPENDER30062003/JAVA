import java.util.*;
public class maxthree{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a,b,c;
        System.out.println("enter first number");
        a=sc.nextInt();
        System.out.println("enter second number");
        b=sc.nextInt();
        System.out.println("enter third number");
        c=sc.nextInt();

        if(a>b){
            if(c>a){
                System.out.println(c);
            }else{
                System.out.println(a);
            }
        }
        else{
            if(b>c){
                System.out.println(b);
            }else{
                System.out.println(c);
            }
        }

    }
}