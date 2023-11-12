import java.util.*;
public class assignment {
    public static void main(String args[]){

        System.out.println("enter an integer");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        String type= a>=0?"positive":"negative";
        System.out.println(type);

        System.out.println("enter temprature in celcius");
        Scanner sce=new Scanner(System.in);
        int temprature=sce.nextInt();
        if(temprature<100){
            System.out.println("you are healthy");
        }else{
            System.out.println("you are suffering from fever");
        }

        System.out.println("enter an integer");
        Scanner scd=new Scanner(System.in);
        int day=scd.nextInt();

        switch(day){
            case 1: System.out.println("sunday");
            break;
            case 2: System.out.println("monday");
            break;
            case 3: System.out.println("tuesday");
            break;
            case 5: System.out.println("thursday");
            break;
            case 6: System.out.println("friday");
            break;
            case 7: System.out.println("sunday");
            break;
            case 4: System.out.println("wednesday");
            break;
            default:System.out.println("you have enter wrong number");
        }

        System.out.println("enter an year");
        Scanner scdf=new Scanner(System.in);
        int year=scdf.nextInt();
        if(year%4==0){
            System.out.println("leap year");
        }else{
            System.out.println("not an leap year");
        }

        System.out.println("enter new year ");
        Scanner scdfg=new Scanner(System.in);
        int newyear=scdfg.nextInt();
        if (newyear % 4 == 0) {
           if(newyear % 100 == 0 ){
              if (newyear % 400 == 0) {
                System.out.println(" leap year");
              } else {
                System.out.println("not a leap year");                
              }
           }else{
            System.out.println("leap year");
           }
        } else{
            System.out.println("not a leap year");
        }
    }
}