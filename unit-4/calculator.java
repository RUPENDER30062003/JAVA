import java.util.*;
public class calculator{

    public static void main(String args[]){
        System.out.println("enter value of a");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();

        System.out.println("enter value of b");
        Scanner sce=new Scanner(System.in);
        int b=sce.nextInt();

        System.out.println("enter operator");
        Scanner scd=new Scanner(System.in);
        char operator=scd.next().charAt(0);
        

        switch(operator){
            case '+':System.out.println(a+b)  ;
            break;
             case '-': System.out.println(a-b) ;
            break;
             case '*': System.out.println(a*b) ;
            break;
             case '/': System.out.println(a/b) ;
            break;
             case '%': System.out.println(a%b) ;
            break;
             default:System.out.println("you have enter wrong operator");

        }






    }
}