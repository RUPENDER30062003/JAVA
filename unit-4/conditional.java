import java.util.*;

public class conditional{
     
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        Scanner scd=new Scanner(System.in);
        int b=scd.nextInt();
        if(a>b){
            if(a%2==0){
                System.out.println("a is even");
            }else{
                System.out.println("a is odd");
            }
            System.out.println("a is largest");
        }else{
             if(b%2==0){
                System.out.println("b is even");
            }else{
                System.out.println("b is odd");
            }
            System.out.println("b is largest");
        }

        System.out.println("enter your age");
        Scanner sce=new Scanner(System.in);
        int age=sce.nextInt();

        if(age<13){
            System.out.println("you are children");
        }else if(13<=age && age<18){
            System.out.println("you are teenager");
        }else if(18<=age && age<60){
            System.out.println("you are young");
        }else{
            System.out.println("you are old");
        }

        System.out.println("enter your income ");
        Scanner sced=new Scanner(System.in);
        int income=sced.nextInt();
        if(income<500000){
            System.out.println("your inocme tax= 0" );
        }else if(income<1000000){
            System.out.println("your inocme tax= " + income*0.2 );
        }else {
            System.out.println("your inocme tax= "+ income*0.3 );
        }

        int number =6;
        String type = number%2==0 ? "even"  :"odd"; 
        System.out.println(type);

        int marks=45;
        String result= marks<33? "fail":"pass";
        System.out.println(result);

        
    }
}