import java.util.*;

public class backtracking{ 

  public static void findpermutation(String str,String ans){

    // base //
    if(str.length()==0){
      System.out.println(ans);
      return;
    }

    // recursion //
    for(int i=0;i<str.length();i++){
      char curr=str.charAt(i);
      String Newstr=str.substring(0,i)+str.substring(i+1);
      findpermutation(Newstr,ans+curr);
    }
    
  }

  public static void subset_string(String str,String ans,int i){

    // base case 
    if(i==str.length()){
      if(ans.length()==0){
      System.out.println("null");
      }else{
        System.out.println(ans);
      }
      return ;
    }

    //recursion //
    // yes choice // 
    subset_string(str,ans+str.charAt(i),i+1);
    // no choice //
    subset_string(str,ans,i+1);
  }


  public static void change_array(int arr[],int i,int val){
    
    // base case //
    if(i==arr.length){
      print_array(arr);
      return;
    }

    // recursion //
    arr[i]=val;
    change_array(arr,i+1,val+1);   // function call //
    arr[i]=arr[i]-2;               // backtracking step //
  }

  public static void print_array(int arr[]){

    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }

  public static void main(String args[]){

    int arr[]=new int [5];
    change_array(arr,0,1);
    print_array(arr);

    String str="abc";
    subset_string(str,"",0);

    findpermutation(str,"");
  }
}