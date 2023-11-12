import java.util.*;
public class invest {

    public static void main(String args[]){

        System.out.println("enter basic ammount then no of times");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int total=0;
        for(int i=0;i<m;i++){
            total=total+n;
            n=n*2;
        }

        System.out.println(total);



    }
}
