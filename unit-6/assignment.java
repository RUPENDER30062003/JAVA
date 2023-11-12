import java.util.*;
public class assignment {
    public static void main(String args[]){

        System.out.println("enter an integer");
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        System.out.println("");

        //star pattern//
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("");

        //inverted star //
        for(int i=n;i>=1;i--){
            for(int j=i;j>=1;j--){
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("");


        // half pyramid//
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println("");
        }
        System.out.println("");

        //character pattern //
        char alphabat='A';
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(alphabat);
                alphabat++;
            }
            System.out.println("");
        }
        System.out.println("");

        // hollow rectangle //
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n+1;j++){
                if(i==1 || i==n || j==1 || j==n+1){
                System.out.print("*");
                }else if(i!=1 || i!=n || j!=1 || j!=n+1 ){
                 System.out.print(" ");   
                }            }
            System.out.println("");
        }
        System.out.println("");

        // inverted half pyramid//
        for(int i=n;i>=1;i--){
            int num=1;
            for(int j=i;j>=1;j--){
                System.out.print(num);
                num++;
            }
            System.out.println("");
        }
        System.out.println("");

        // floy's traiangle //
        int numb=1;
        for(int i=1;i<=n;i++){            
            for(int j=1;j<=i;j++){
                System.out.print(numb +" ");
                numb++;
            }
            System.out.println(" ");
        }
        System.out.println("");

        //0-1 traingle //
        
        for(int i=1;i<=n;i++){            
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println(" ");
        }
        System.out.println("");


        //inverted and rotated half-pyramid pattern//

        for(int i=1;i<=n;i++){            
            for(int j=1;j<=n;j++){
                if((i+j)>n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
        System.out.println("");

        // inerted and rotated half-pyramid pattern//
        for(int i=1;i<=n;i++){                        
                for(int k=1;k<=n-i;k++){
                    System.out.print(" ");
                }
                for(int k=1;k<=i;k++){
                    System.out.print("*");
                }
                System.out.println(" ");
                }
        System.out.println("");


        //butterfly //

        for(int i=1;i<=n;i++){            
            
                for(int k=1;k<=i;k++){
                    System.out.print("*");
                }
                for(int k=1;k<=(2*(n-i));k++){
                    System.out.print(" ");
                }

                for(int k=1;k<=i;k++){
                    System.out.print("*");
                }
                System.out.println(" ");

        }


            for(int i=n;i>=1;i--){            
            
            for(int k=1;k<=i;k++){
                    System.out.print("*");
                }
                for(int k=1;k<=(2*(n-i));k++){
                    System.out.print(" ");
                }

                for(int k=1;k<=i;k++){
                    System.out.print("*");
                }
            System.out.println(" ");
            }

        System.out.println("");

        //solid rhombus//

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
            }

            //hollow rhombus //

            for(int i=1;i<=n;i++){

                for(int k=1;k<=n-i;k++){
                    System.out.print(" ");
                }

            for(int j=1;j<=n+1;j++){
                if(i==1 || i==n || j==1 || j==n+1){
                System.out.print("*");
                }else if(i!=1 || i!=n || j!=1 || j!=n+1 ){
                 System.out.print(" ");   
                }            }
            System.out.println("");
        }
        System.out.println("");


        // hollow rhombus //
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
                if (i==1 || i==n) {
                    for (int j2 = 1; j2 <= n; j2++) {
                        System.out.print("*");
                    }
                } else {
                    System.out.print("*");
                    for (int j = 1; j <= n-2 ; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                }
            System.out.println();
            }


            System.out.println();

        // diamond pattern //
         
         for(int i=1;i<=n;i++ ){

            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int k=1;k<=(2*(i-1))+1;k++){
                System.out.print("*");
            }
            System.out.println("");

         }
         for(int i=n;i>=1;i-- ){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int k=1;k<=(2*(i-1))+1;k++){
                System.out.print("*");
            }
            System.out.println("");
         }

         //number pyramid //
         int count=1;
         for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++ ){
                System.out.print(count+" ");
            }
            System.out.println();
            count++;
         }

         int count2=1;
         for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(count2+" ");
            }
            System.out.println();
            count2++;
         }

         //palindrome pattern//
         for(int i=1;i<=n;i++){

            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            for(int j=2;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
            
         }
         










        


    }}