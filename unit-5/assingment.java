import java.util.*;
public class assingment{
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        int number,choice,evensum,oddsum;
        evensum=oddsum=0;
        for(int i=0;;i++){
            System.out.println("enter number");
            number=sc.nextInt();
            if(number%2==0){
                evensum+=number;
            }else{
                oddsum+=number;
            }
            System.out.println("enter your choice whether you want to enter more number press 1 and not press 0");
            choice=sc.nextInt();
            if(choice==0){
                break;
            }
        }
        System.out.println("odd sum ="+ oddsum );
        System.out.println("even sum ="+ evensum );

        System.out.println("enter number you want to factorial ");
        Scanner sb=new Scanner(System.in);
        int factorialnumber=sb.nextInt();
        int factorial=1;
        for(int i=1;i<=factorialnumber;i++){
            factorial*=i;
        }
        System.out.println("factorial of a number="+ factorial);

        System.out.println("enter number which you want table ");
        Scanner sa=new Scanner(System.in);
        int table=sa.nextInt();
        for(int i=1;i<=10;i++){
            System.out.println(table+"*"+i+"="+(table*i));
        }

    }
}