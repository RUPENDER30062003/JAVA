import java.util.*;
public class assignment {
    
    public static int product(int n,int m){
        return n*m;
    }

    public static int factorial(int n){
        int factorial=1;
        for(int i=1;i<=n;i++){
            factorial*=i;
        }
        return factorial;
    }

    public static boolean prime(int n){

        if(n==1){
            return false;
        }
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static boolean primeoptimized(int n){

        if(n==1){
            return false;
        }
        
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n==2){
                return true;
            }
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void primerange (int n){
        for(int i=1;i<=n;i++){
            if(primeoptimized(i)==true){
                System.out.print(i+" ");
            }
        }
    }


    public static double bionomial(int n,int r){
        int bionomial=0;
        if (n>r){
            bionomial=(factorial(n)/(factorial(r)*factorial(n-r)));
            return bionomial;
        }else{
            return bionomial;
        }
    }

    public static int binarytodecimal(int binary){
        int decimalnumber=0;
        for(int i=0;binary>0;i++){
            int remainder=binary%10;
            decimalnumber=decimalnumber + remainder*((int)Math.pow(2,i));
            binary/=10;
        }
        return decimalnumber;

    }

    public static int decimaltobinary(int decimal){
        int binary=0;
        for(int i=0;decimal>0;i++){
            int remainder=decimal%2;
            binary=binary+(remainder*((int)Math.pow(10,i)));
            decimal/=2;
        }
        return binary;
        
    }

    public static void main(String args[]){

        System.out.println("");

        System.out.println("enter an integer");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("");
        

        System.out.println("enter an integer");
        int m=sc.nextInt();
        System.out.println("");
/*
        System.out.println("factorial of n ="+ factorial(n));
        System.out.println("");

        System.out.println("bionomial of n^c^r="+ bionomial(n,m));
        System.out.println("");

        System.out.println("n is prime no.="+ prime(n));
        System.out.println("");

        System.out.println("n is prime no.="+ primeoptimized(n));
        System.out.println("");

        primerange(n);
        System.out.println("");
*/
        System.out.println("decimal number ="+ binarytodecimal(n));
        System.out.println("");

        System.out.println("binary number ="+ decimaltobinary(m));
        System.out.println("");







        
        
        }}