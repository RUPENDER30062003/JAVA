import java.util.*;

public class abstraction{
    public static void main(String args[]){

        Horse h1=new Horse();
        h1.eat();
        h1.walk();
        System.out.println(h1.colour);
        h1.changecolour();
        System.out.println(h1.colour);

        Chicken c1=new Chicken();
        c1.eat();
        c1.walk();
        System.out.println(c1.colour);
        c1.changecolour();
        System.out.println(c1.colour);

        //  Animals a1=new Animals();  cannot create object for abstract class     //

        Mustang mus=new Mustang();
        //Animals->Horse->Mustang  constructor calling order //


    }
}

abstract class Animals{                    // rule-1  ->  abstract class of animal name and we cannot create object means Animals.a1=new Animals  in the abstract class//
    
    String colour;
    Animals(){                            // constructors //
        colour="brown";                   // intialize variable of there derived class //
        System.out.println("animal constructor called");   // constructor work is not just to initilize the object but also to intilize the variable of child class(derived class )object.
    }

    void eat(){
        System.out.println("animal eats"); // non-abstract method or non-abstract function //
    }


    abstract void walk();                  // abstract method or abstract function because here we didnot define implementation there subclass define walk look like and it is necessary or there subclass define them OR derived class  define abstract function//
    // in short abstract function or abstract method give idea not implementation means it just define that there is walk function in the derived class of the animals.  //
    
    
}

class Horse extends Animals{
    Horse(){
        System.out.println("horse constructor calledd");
    }
    void walk(){
        System.out.println("WALK ON 4 LEGS");  //abstraction function or abstraction methods implementation //
    }

    void changecolour(){
        colour="dark brown";
    }    
    
}
class Chicken extends Animals{
    void walk(){
        System.out.println("walk in 2 legs");  //abstraction function or abstraction methods implementation//
    }

    void changecolour(){
        colour="yellow";
    }
}

class Mustang extends Horse{
    Mustang(){
        System.out.println("mustang constructor called");
    }
}