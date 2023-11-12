import java.util.*;
public class oops{
    public static void main(String args[]){

         Pen p1=new Pen(); // created a pen object called p1 //
         p1.setcolour("blue");
         System.out.println(p1.colour);
         p1.setTip(5);
         System.out.println(p1.gettip());
         p1.colour="yellow";


         bankaccount account1=new bankaccount();
         account1.username="rupender";
         // account1.password="abcd"; not work//
         account1.setpassword("abcd");


         SchoolStudent s1=new SchoolStudent("rupender");
         System.out.println(s1.name);

         SchoolStudent s2=new SchoolStudent(20);
         System.out.println(s2.roll);

         SchoolStudent s3=new SchoolStudent(); //if wants that this constructor run automatically then you have to make no constructor in the School student class else you have to define that constructor. //

         SchoolStudent s4=new SchoolStudent("rupenders",20);


         Student S1=new Student("rupendersingh",19);
         System.out.println(S1.name);
         System.out.println(S1.roll);

           // define s1 marks //
         for(int i=0;i<3;i++){
            s1.marks[i]=i*10;
         }
         SchoolStudent s5 = new SchoolStudent(s1);
         

         for(int i=0;i<3;i++){
            System.out.println(s1.marks[i]);
         }

         s1.marks[2]=50;

         for(int i=0;i<3;i++){
            System.out.println(s5.marks[i]);// it doesn't pass any value in array marks it pass reference of s1.marks in s5.marks and any change in s1 result in change in value of s5 also because there is no deep copy there is shallow copy means no new array is formed for s5 there is reference of s1 array and if new array is formed instead of reference that is deep copy//
         }

         for(int i=0;i<3;i++){
            System.out.println(s1.marks[i]);
         }

         Fish shark= new Fish();
         shark.eat();


         
        
            }
        }

class bankaccount{
     public String username;
     private String password;
     public void setpassword(String pwd){
        this.password=pwd;
     }
}

class SchoolStudent {
    String name;
    int roll;
    int marks[];

    // deep copy instructor//
    SchoolStudent(SchoolStudent s1){
        marks=new int[3];
        this.name=s1.name;
        this.roll=s1.roll;
        for(int i=0;i<marks.length;i++){
            this.marks[i]=s1.marks[i];
        }
    }

    /*
    SchoolStudent(SchoolStudent s1){
        // shallow copy//
        // copy constructor //
        marks=new int[3];
        this.name=s1.name;
        this.roll=s1.roll;
        this.marks=s1.marks;
    }
    */

    SchoolStudent(){
        System.out.println("constructor is called.....");
    }

    SchoolStudent(int roll){
        marks=new int[3];
        this.roll=roll;
    }
    SchoolStudent(String name){  //constructor //
        marks=new int[3];
        System.out.println("constructor is called....");
        // System.out.println();//
        this.name=name;
    }
    SchoolStudent(String name,int roll){
        marks=new int[3]; // we have to write marks size to every  constructor so that every constructor can ensure that there is marks of only three subjects // 
        this.name=name;
        this.roll=roll;
    }


}

class Pen{

    String colour;
    private int tip;  //pen inside tip//

    int gettip(){
        return this.tip;
    }

    String getColour(){ // getters //
        return this.colour;  //pen inside tip//
    }

    void setcolour(String newcolour){
        colour=newcolour; // setters //
    }

    void setTip(int newTip ){
        tip=newTip;  //setters//
    }

    void settip(int tip ){ // pen newtip//
        this.tip= tip;  //this is pen inside tip and tip is pen new tip//
    }
}


class Student{
    String name;
    int age;
    float percentage;
    void calculate_percentage(int phy,int chem,int math){
        percentage=(phy+chem+math)/3;
    }


    Student (){
        System.out.println("constructor is called");
    }

    Student (String name,int age){
        this.name=name;
        this.age=age;
        System.out.println("constructro is called.....");
    }

}


// base class//
class Animals{
    String colour;

    void eat(){
        System.out.println("eats");
    }

    void breathe(){
        System.out.println("breathes");
    }

}


/*
//derived class  OR subclass//
class Fish extends Animals{   //single level inheritence //
    int fins;

    void swim(){
        System.out.println("swim");
    }
}
*/


