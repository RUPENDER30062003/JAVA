import java.util.*;

public class flowchart {

    public static void prime(int n){
        if( n == 0 ){
            System.out.println("not prime");
            return ;
        }
        for (int i = 2; i < n; i++) {
            if(n % i ==0){
                System.out.print(" not prime");
                return ;
            }
        }
        System.out.println("prime");
        return ;
    }

    public static void main(String[] args) {
        int a=5;
        int b=6;
        int sum=a+b;
        System.out.println(sum);
        prime(0);
        
    }
}
