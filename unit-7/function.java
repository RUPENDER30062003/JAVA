import java.util.*;

public class function {

    public static void swap(int n,int m){
        int temp=n;
       n=m;
       m=temp;
        System.out.println(n+"  "+m);
      
    }
    public static void calculatesum(){
         Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int sum=a+b;
        System.out.println(sum);
         
    } 
    public static void sumab(int a,int b){
        int sum=a+b;
        System.out.println(sum);
    }

    public static int  suma_b(int a,int b){
        int sum=a+b;
        return sum;
    }


    public static void hello(){
        System.out.println("hello wrold");
    }
    public static int hell(){
        System.out.println("hell wrold");
        return 1;
    }
    public static void main(String args[]){
         Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int sum=a+b;
        System.out.println(sum);
         
       calculatesum();
       sumab(a,b);
       int suma=suma_b(a,b);
       System.out.println(suma);
       System.out.println(suma_b(a,b));

       int n=5;
       int m=6;
       int temp=n;
       swap (n,m);
        System.out.println(n+"  "+m);
       n=m;
       m=temp;
       System.out.println(n+"  "+m);


    }
}