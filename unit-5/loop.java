import java.util.*;
public class loop{
    public static void main(String args[]){
        
        int i=1;
        while(i<10){
            System.out.print("helloworld ");
            i++;
        } 

        System.out.println("enter value of n ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        for(int j=1;j<=n;j++){
            System.out.print(j+" ");
        }

        int sum=0;
        for(int k=1;k<=n;k++){
            sum=sum+k;}
            System.out.println(sum);

        for(int l=0;l<n;l++){
            for(int m=0;m<n;m++ ){
                System.out.print("*");
            }
            System.out.println("");
        }

        System.out.println("enter value of a ");
        Scanner sce=new Scanner(System.in);
        int a=sce.nextInt();
        System.out.println("enter digits in number a");
        Scanner scee=new Scanner(System.in);
        int digits=scee.nextInt();

        int remainder=0;
        int reverse=0;
        for(int o=0;o<digits;o++){
            remainder=a%10;
            a=a/10;
            reverse=reverse*10+remainder;
        }
        System.out.println(reverse);


        for(int q=1; ;q++){
            System.out.println("enter number");
            Scanner sa=new Scanner(System.in);
            int w=sa.nextInt();
            System.out.println("your number is ="+ w);
            if(w%100==0){
                break;
            }

        }

        for(int ie=1;ie<10;ie++){
            if(ie==3){
                break;
            }
            System.out.println(ie);
        }

        for(int r=1;r<4;r++){
            System.out.println("enter number");
            Scanner sae=new Scanner(System.in);
            int t=sae.nextInt();
            if(t%10==0){
                continue;
            }
                System.out.println(t);
            
        } 

        System.out.println("enter number to check whether prime number or not");
        Scanner sb= new Scanner(System.in);
        int prime=sb.nextInt();
        for(int u=2;u<prime;u++){
            if(prime%u==0){
                System.out.println("the given number is not prime number");
                break;
            }else if(u==prime-1){
                System.out.println("the given number is prime number");
            }
        }


    }}
