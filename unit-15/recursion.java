import java.util.*;
public class recursion{
    static int count=0;

    public static void tower_of_hanoi(int n,String src,String helper,String dest){
        if(n==1){
            //System.out.println("transfer disk"+ n+"from"+src+"to"+dest);
            count++;
            return ;
        }

        tower_of_hanoi(n-1,src,dest,helper);
        //System.out.println("transfer disk" +n +"from "+src +"to"+dest);
        count++;
        tower_of_hanoi(n-1,helper,src,dest);
    }

    public static int length(String str){
        if(str.length()==0){
            return 0;
        }
        return length(str.substring(1))+1;
    }

    public static int countSubstrs(String str,int i,int j,int n){

        if(n==1){
            return 1;
        }

        if(n<=0){
            return 0;
        }

        int res = countSubstrs(str,i+1,j,n-1)+countSubstrs(str,i,j-1,n-1)-countSubstrs(str,i+1,j-1,n-2);

        if(str.charAt(i) ==str.charAt(j)){
            res++;
        }
        
        return res;

    }

    public static void printDigits(int number){
        String digits[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
        if(number==0){
            return;
            }
        int lastDigit=number%10;
        printDigits(number/10);
        System.out.print(digits[lastDigit]+" ");
        }
    

    public static void key_occurence_in_array(int arr[],int key,int index){

        if(index==arr.length){
            return;
        }  
        if(arr[index]==key){
            System.out.print(index+" ");
        }
        key_occurence_in_array(arr,key,index+1);
    }

    public static void number_to_String(int n,String number_str){
        if(n==0){
            System.out.println(number_str);
            return ;
        }
        
        switch(n%10){
            case 1: number_str="one "+ number_str;
            break;
            case 2: number_str="two "+ number_str;
            break;
            case 3: number_str="three "+ number_str;
            break;
            case 4: number_str="four "+ number_str;
            break;
            case 5: number_str="five "+ number_str;
            break;
            case 6: number_str="six "+ number_str;
            break;
            case 7: number_str="seven "+ number_str;
            break;
            case 8: number_str="eight "+ number_str;
            break;
            case 9: number_str="nine "+ number_str;
            break;
            case 0: number_str="zero "+ number_str;
            break;
        }
        number_to_String(n/10,number_str);
    }


    public static int search(int arr[],int key,int i){
        if(i==arr.length){
            return -1 ;
        }
        if(arr[i]==key){
            return i;
        }
        return search(arr,key,i+1);

    }

    public static int tillingproblem(int n){
        //base case//
        if(n== 0 || n==1){
            return 1;
        }
        //vertical choice //
        int fnm1=tillingproblem(n-1);

        //horizomtal choice //
        int fnm2=tillingproblem(n-2);

        int twoways=fnm1+fnm2;
        return twoways;
    }

    public static int x_power_n(int x,int n){

        if(n==0){
            return 1;
        }
        int power=x*x_power_n(x,n-1);
        return power;

    }

    public static int x_power_n_optimized(int x,int n){

        if (n==0){
            return 1;
        }

        int halfPowerSq=x_power_n_optimized(x,n/2)*x_power_n_optimized(x,n/2);

        if(n%2 != 0){
            halfPowerSq= halfPowerSq*x;
        }

        return halfPowerSq;
    }

    public static int last_search(int arr[],int key,int i){
        
        if(i==arr.length){
            return -1;
        }
        int isfound=last_search(arr,key,i+1);

         if(isfound != -1){
            return isfound;
         }
         if(arr[i]==key){
            return i;
         }
         return isfound;
    }

    public static int factorial(int n){

        if(n<0){
            return -1;
        }
        if(n==0){
            return 1;
        }
        int fn=n*factorial(n-1);
        return fn;
        
    }

    public static boolean array_sorted(int arr[],int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return array_sorted(arr,i+1);
    }

    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        int fibonacci_n=fibonacci(n-1)+fibonacci(n-2);
        return fibonacci_n;
    }

    public static int sum_of_n(int n){
        if(n==0){
            return 0;
        }
        int sumn=n+sum_of_n(n-1);
        return sumn;
        
    }

    public static void remove_duplicate(String str,int index,StringBuilder new_string,boolean map[]){
        if(index == str.length()){
            System.out.println(new_string);
            return  ;
        }
        char curr_char=str.charAt(index);
        if(map[curr_char-'a']==true){
            remove_duplicate(str,index+1,new_string,map);
        }else{
            map[curr_char-'a']=true;
            remove_duplicate(str,index+1,new_string.append(curr_char),map);
        }

    }

    public static void consecutive_one(String str,int n,int lastplace){
        //base case//
        if(n==0){
            System.out.println(str);
            return;
        }

        // work//
        if(lastplace == 0){
            consecutive_one(str+("0"),n-1,0);
            consecutive_one(str+("1"),n-1,1);
        }else{
            consecutive_one(str+("0"),n-1,0);
        }

        // consecutive_one(str+("0"),n-1,0);//
        // if(lastplace == 0){consecutive_one(str+("1"),n-1,1);}
    }

    public static int friends_pairing(int n){

        // base case//
        if(n==2 || n==1){
            return n;
        }

        //choice //
        //single//
        int fnm1=friends_pairing(n-1);

        //pair //
        int fnm2=(n-1)*friends_pairing(n-2);

        //two_ways//
        int two_ways=fnm1+fnm2;

        return two_ways;
    }
    
    public static void print_n(int n){
       if(n == 0){
       return ;
       }
        System.out.print(n+" ");
        print_n(n-1);

    }

    public static void print_one_n(int n){
        if(n == 0 ){
        return;
        }
        print_one_n(n-1);
        System.out.print(n+" ");

    }
    public static void main(String args[]){
        print_n(10);
        System.out.println("");
        print_one_n(10);
        System.out.println();
        System.out.println(factorial(4));
        System.out.println(sum_of_n(5));
        System.out.println(fibonacci(20));

        int arr[]={1,2,3,4};
        System.out.println(array_sorted(arr,0));

        int arrA[]={8,3,6,9,5,10,2,5,3};
        System.out.println(search(arrA,5,0));
        System.out.println(last_search(arrA,5,0));

        System.out.println(x_power_n(2,10));
        System.out.println(x_power_n_optimized(2,10));

        System.out.println(tillingproblem(3));

        String str="appnnacollege";
        remove_duplicate(str,0,new StringBuilder(""),new boolean[26]);

        System.out.println(friends_pairing(3));

        consecutive_one("",3,0);

        int arrB[]={3,2,4,5,6,2,7,2,2};
        key_occurence_in_array(arrB,2,0);

        number_to_String(92345,(""));
        printDigits(2014);

        System.out.println();
        System.out.println(length("abcdefgh"));

        String strC="abcab";
        int m=strC.length();
        System.out.println(countSubstrs(strC,0,m-1,m));


        int l=64;
        tower_of_hanoi(l,"S","H","D");
        System.out.println(count);

    }
}