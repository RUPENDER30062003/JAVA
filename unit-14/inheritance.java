
import java.util.*;
public class inheritance{

    public static void main(String args[]){

        Fish tuna=new Fish();
        tuna.eat();


        Dog dooby=new Dog();
        dooby.eat();
        dooby.legs=4;
        System.out.println(dooby.legs);
        
        Calculator calc=new Calculator();
        System.out.println(calc.sum(1,2));
        System.out.println(calc.sum((float)5.6,(float)7.2));
        System.out.println(calc.sum(5,4,7));

        Deer d=new Deer();  // polymorphism function overriding //
        d.eat();
        Animals a=new Animals();
        a.eat();
        

    }

}

// base class//
class Animals{
    String colour;

    void eat(){
        System.out.println("eats everthing");
    }

    void breathe(){
        System.out.println("breathes");
    }
}

class Deer extends Animals{
    void eat(){
        System.out.println("eats grass");  // polymorhism  function overriding//
    }
}

class Mammals extends Animals {     // derivedd class //
    int legs;  
    void walk(){
        System.out.println("walk");
    }                     //single level inheritance//
}

class Dog extends Mammals{          //derived class-2 //
    String breads;                  //two level inheritance //
}

class Fish extends Animals{
    void swim(){
        System.out.println("swim");   // hierarchial inheritanace //
    }
}

class Birds extends Animals{
    void fly(){
        System.out.println("fly");
    }
}

class Calculator{   // polymorphism function overloading//
    int sum(int a,int b){
        return a+b;
    }

    int sum(int a,int b,int c){
        return a+b+c;
    }

    float sum(float a,float b){
        return a+b;
    }
}
