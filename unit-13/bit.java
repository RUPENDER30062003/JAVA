import java.util.*;

public class bit{

    public static int set_ith_bit(int n, int i){
        int bitmask=1<<i;
        System.out.println(n|bitmask);
        return n|bitmask;
    }

    public static int clear_ith_bit(int n,int i){
        int bitmask= ~(1<<i);
        System.out.println(n&bitmask);
        return n&bitmask;
        }
    
    public static boolean is_power_of_two(int n){
        return (n&(n-1)) == 0;
    }

    public static int clear_range_of_bit(int n,int i,int j){
        int a=((~0)<<(j+1));
        int b=(1<<i)-1;
        int bitmask=a|b;
        System.out.println(n&bitmask);
        return n&bitmask;
    }

    public static int clear_last_ith_term(int n,int i){
        int bitmask=(~0)<<i;
        System.out.println(n& bitmask);
        return n & bitmask;
    }

    public static int update_ith_bit(int n,int i,int update){
        if(update ==1 ){
            int bitmask=1<<i;
            System.out.println(n|bitmask);
        return n|bitmask;
        }else{
            int bitmask= ~(1<<i);
            System.out.println(n&bitmask);
        return n&bitmask;
        }
    }

    public static int count_no_of_set_bits(int n){
        int count=0;
        while(n>0){
            if((n&1)!=0){
                count++;
            }
            n>>=1;
        }
        System.out.println(count);
        return count;
    }

    public static int update_ith_bit_OPTIMIZED(int n,int i,int update){

        n=clear_ith_bit(n,i);
        int bitmask=update<<i;
        return n|bitmask;
    }

    public static int ith_bit(int n,int i){
        int bitmask=1<<i;
        if((n & bitmask) == 0){
            System.out.println("0");
            return 0;
        }else{
            System.out.println("1");
            return 1;
        }
    }

    public static boolean even_odd(int n){
        int bitmask =1;
        if((n & bitmask) ==0 ){
            System.out.println("the number is even number");
            return true;
        }else{
            System.out.println("the number is odd number");
            return false;
        }
    }

    public static int fast_exponentiation(int n,int power){
        int ans=1;
        while (power>0){
            if((power&1) != 0){
                ans=ans*n;
            }
            n=n*n;
            power=power>>1;
        }
        System.out.println(ans);
        return ans;
    }

    public static void swap(int x,int y){
        System.out.println(x+" "+y);
        x=x^y;
        y=y^x;
        x=x^y;
        System.out.println(x+" "+y);
    }

    public static void uppercase_to_lowercase(){
        
        for(char ch='A';ch<='Z';ch++) {
            System.out.print((char)(ch |' '));
        }

    }

    public static void positive_or_negative( ) {
        int x=6;
        System.out.println(x+" + "+1+" is "+ -~x);
        x= -4;
        System.out.println(x+" + "+1+" is "+ -~x);
        x=0;
        System.out.println(x+" + "+1+" is "+ -~x);
    }

    public static void main(String args[]){
        uppercase_to_lowercase();
        positive_or_negative();
        fast_exponentiation(5,3);
        System.out.println(is_power_of_two(15));
        count_no_of_set_bits(679);
        int binary;
        Scanner sc=new Scanner(System.in);
        binary=sc.nextInt();
        clear_range_of_bit(10,2,4);
        set_ith_bit(15,2);
        clear_ith_bit(15,2);
        update_ith_bit(15,2,0);
        update_ith_bit_OPTIMIZED(15,2,0);
        clear_last_ith_term(15,1);
        even_odd(4);
        ith_bit(10,3);

        int e=5;
        System.out.println((~5));

        
    }
}