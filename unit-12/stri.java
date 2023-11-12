import java.util.*;

public class stri{

    public static boolean string_palindrome(String str){
        int n=str.length();
        for(int i=0;i<=((int)n/2);i++){
            if(str.charAt(i)!=str.charAt(n-1-i) ){
                System.out.println("the String is not palindrome");
                return false;
            }
        }
        System.out.println("the String is palindrome");
        return true;
    }

    public static String substring(String str,int start,int end){
        String substring="";
        for(int i=start;i<end;i++){
            substring +=str.charAt(i);
        }
        System.out.println(substring);
        return substring;
    }

    public static double shortest_path(String str){
        int n=str.length();
        int x=0;
        int y=0;
        double displacement=0.0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='W'){
                x--;
            }else if(str.charAt(i)=='E'){
                x++;
            }else if(str.charAt(i)=='N'){
                y++;
            }else if (str.charAt(i)=='S'){
                y--;
            }else{
                System.out.println("you have enter wrong direction");
            }
        }
        displacement=Math.sqrt((x*x)+(y*y));
        System.out.println(displacement);
        return displacement;
    }

    public static int vowels(String str){
        int count=0;
        for(int i=0;i<str.length();i++){
         char ch=str.charAt(i);
         if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            count++;}
          }
          System.out.println("count of vowels is :"+count);
          return count;
    }

    public static String compresion(String str){
        String sc="";
        
        for(int i=0;i<str.length();i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sc +=str.charAt(i) ;
            if(count> 1){
                sc+= count.toString();
            }
        }
        System.out.println(sc);
        return sc;
         
    }

    public static boolean anagrams(String s1,String s2){
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();

        if(s1.length()==s2.length() ){
            char s1chararray[]=s1.toCharArray();
            char s2chararray[]=s2.toCharArray();

            Arrays.sort(s1chararray);
            Arrays.sort(s2chararray);

            if(Arrays.equals(s1chararray,s2chararray)){
                System.out.println("stringgs are anagrams");
                return true;
            }else{
                System.out.println("strings are not anagrams");
                return false;
            }
        }else{
            System.out.println("strings are not anagrams");
            return false;
        }

    }

    public static String uppercase(String str ){
        
        StringBuilder sb=new StringBuilder("");
        char ch=Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1;i<str.length();i++){
            if( str.charAt(i) ==' '&& i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb);
        return sb.toString(); 
    }
    
    public static void output_string(String str){
        int n=str.length();
        for(int i=0;i<n;i++){
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }

    public static String largest_String(String str[]){
        int n=str.length;
        String largest=str[0];
        for(int i=0;i<n;i++){
            if(largest.compareTo(str[i] )< 0){
                largest=str[i];
            }
        }
        System.out.println(largest);
        return largest;

    }
    public static void main(String args[]){
        String s1="heart";
        String s2="earth";
        String s3= new String("hello");
        anagrams(s1,s2);

        String strin="abcd";
        compresion(strin);
        String stri="hi i am rupender ";
        uppercase(stri);
        StringBuilder sb=new StringBuilder("");
        for(char i='a';i<='z';i++){
            sb.append(i);
        }
        System.out.println(sb);
        String fruits[]={"mango","apple","banana"};
        largest_String(fruits);
        String str=new String(); 
        int n=str.length();
        Scanner sc=new Scanner(System.in);
        str=sc.nextLine();
        vowels(str);


        String newstr ="rupender";
        substring(str,0,4);
        System.out.println(newstr.substring(0,4));
        shortest_path(str);
        string_palindrome(str);
        output_string(str);
    }
}