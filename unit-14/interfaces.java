import java.util.*;


public class interfaces{
    public static void main(String args[]){

        Queen q=new Queen();
        q.moves();

        Bear b1=new Bear();
        b1.eat();
        b1.legs();

        Student s1=new Student();
        s1.schoolName="JMV";
        s1.returnpercentage(99,98,97);
        System.out.println(s1.schoolName);

        Student s2=new Student();
        s2.returnpercentage(96,95,94);
        System.out.println(s2.schoolName);

        Student s3=new Student();
        s3.returnpercentage(93,92,91);
        s3.schoolName="GVM";  // school name change for all three s1 s2 s3 class //
        System.out.println(s3.schoolName);
        System.out.println(s1.schoolName +" "+ s2.schoolName+" " +s3.schoolName);


        Horse h1=new Horse();
        System.out.println(h1.colour);


        complex_number c=new complex_number(4,5);
        complex_number d=new complex_number(9,4);
        complex_number e=complex_number.add(c,d);
        complex_number f=complex_number.diff(c,d);
        complex_number g=complex_number.product(c,d);
        e.printComplex();
        f.printComplex();
        g.printComplex();

        System.out.println(Book.count);
        Book b10=new Book(150);
        System.out.println(b10.count);
        Book b20=new Book(200);
        System.out.println(b20.count);
        System.out.println(Book.count);

    }

}

interface ChessPlayers {    //interface//
    void moves();
}

class Queen implements ChessPlayers{
    public void moves(){
        System.out.println("up, down,left,right,diagonal -(in all four direction)");
    }
}


class Rook implements ChessPlayers{
    public void moves(){
        System.out.println("up, down,left,right");
    }
}

class king implements ChessPlayers{
    public void moves(){         // we have to public keyword because if we do not write then moves function become default type and chess player interface also make move function public .//       
        System.out.println("up, down,left,right,diagnol- (by one step)");
    }
}



// multiple inheritance //

interface Herbivore{
    void eat();
}

interface carnivore{
    void legs();
}

class Bear implements carnivore,Herbivore{
    public void eat(){
        System.out.println("eat both grass and meat");
    }

    public void legs(){
        System.out.println("have 4 legs");
    }
}



class Student {

    static int returnpercentage(int math,int phy,int chem){ // create only once in student class parameters vary for different class but logic remain same hence we use static keyword//
        return (math+phy+chem)/3;
    }

    String name;
    int roll;

    static String schoolName;

    void setName(String name){
        this.name=name;
    }

    String getName(){
        return this.name;
    }
}


class Animal{
    String colour;
    Animal(){
        System.out.println("Animal constructor is called");
    }
}

class Horse extends Animal{
    Horse(){
        super();         // to access the immediate parent constructor.//
        super.colour="brown";  //to access the immediate parent properties. //
        System.out.println("horse constructor is called");
    }

}

class complex_number{

    int real;
    int imag;
    public complex_number(){

    }

    public complex_number(int real,int imag){
        this.real=real;
        this.imag=imag;
    }

    public static complex_number add(complex_number a,complex_number b){
        return new complex_number((a.real+b.real),(a.imag+b.imag));
    }

    public static complex_number diff(complex_number a,complex_number b){
        return new complex_number((a.real-b.real),(a.imag-b.imag));
    }
        
    public static complex_number product(complex_number a,complex_number b){
        return new complex_number(((a.real*b.real)-(a.imag*b.imag)),((a.real*b.imag)+(a.imag*b.real)));
    }
    
    public void printComplex(){
        if(real==0&&imag!=0){
            System.out.println(imag+"i");
            }else if(imag==0&&real!=0){
                System.out.println(real);
                }else{
                    System.out.println(real+"+"+imag+"i");
                    }
                    }
}

class Book{
    int price;
    static int count;

    public Book(int price){
        this.price=price;
        count++;
    }
}


