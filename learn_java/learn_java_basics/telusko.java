import tools.*;
import tools.other.*;
import java.util.*; //importing util package for Scanner class
import java.lang.*; //importing lang package is optional as it is imported by default
import java.lang.classfile.Interfaces;

class Student{
    int rollno;
    String name;
    int marks;
}
class Mobile{
    String brand;
    int price;
    static String name;
    //A static block is executed only once when the class is loaded into memory, regardless of how many objects are created.
    //     Why is it called only once?
    // Static blocks belong to the class, not to objects
    // A class is loaded only once by the JVM
    // When the class is loaded, the static block runs immediately
    // Creating objects later does not re-run the static block

    //A static block is executed when the class is loaded by the JVM. Creating an object is one way to load the class, but accessing static members or calling static methods can also load the class even without object creation.
    static{
        name="StaticBlockPhone";
        System.out.println("in static block"+ name);

    }
    public Mobile(){
        brand="";
        price=200;
        name="Phone";
        System.out.println("in constructor");
    }
    public void show(){
        System.out.println(brand+":"+price+":"+name);
    }
    public static void show1(Mobile obj){
        //don't use non static variable under static method 
        System.out.println("in static method");
        System.out.println(obj.brand+":"+ obj.price+":"+name);
    } 

}

class Human{
    private int age=11; // accessible in same class
    private String name="kavi gupta";
    public Human(int age,String name){
        this.age=age;
        this.name=name;
    }
    public Human() {
        // default constructor
    }

    public void setAge(int age, Human obj){
        Human obj1 = obj; // obj1 and obj point to SAME object (hum3)
        obj1.age=age;   // modifies hum3.age
    }

    //Inside an instance method, we should use this to access or modify the current object; passing the same object as a parameter is redundant and poor design.

    public void setAge(int age){
        this.age=age;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
}
//Anonymous Object
class A{
    public A(){
        System.out.println("in class A");
    }
    public void show(){
        System.out.println("in show method");
    }
}


//Inheritance
//Multiple Inheritance is not supported in Java to avoid complexity and ambiguity, such as the "Diamond Problem," where a class could inherit conflicting methods from multiple parent classes. Instead, Java uses interfaces to achieve similar functionality without these issues.

class VeryAdvCalc extends AdvCalc{
    public int mod(int a,int b){
        return a%b;
    }
    public int pow(int a,int b){
    //     int res=1;
    //     for(int i=1;i<=b;i++){
    //         res=res*a;
    //     }
    //     return res;
    // }
    return (int)Math.pow(a,b);
    }   
}

//Method Overriding
class Animal{
    public void sound(){
        System.out.println("Animal sound");
    }
}
class Dog extends Animal{
    @Override
    public void sound(){
        System.out.println("Bark");
    }
}   

//super keyword
//this keyword

//The super keyword in Java is used to refer to the immediate parent class object, allowing access to parent class methods and constructors from a subclass.
// The super keyword is used to access the immediate parent class, and in constructors it ensures the parent class is initialized before the child class.

//Constructor Chaining with super()
// What is super?
// super refers to the immediate parent class object.
// It is used to:
// Call parent class constructor
// Access parent class methods
// Access parent class variables

//super() is always the first statement 
// If you don’t write super(), Java inserts it
// public BB() {
//     // super(); ← added automatically
// }

//IMPORTANT:
// super() can be used only in constructor
// super can be used in methods and constructors
//EVERY CLASS IN JAVA ULTIMATELY INHERITS FROM OBJECT CLASS
//means -> class AA extends Object{}
class AA extends Object{
    public AA(){
        //super(); //calls Object class constructor of Object class //by default super() is called if not written
        System.out.println("in AA default constructor");
    }
    public AA(int x){
        //super(); //calls Object class constructor
        System.out.println("in AA parameterized constructor");
    }
}
class BB extends AA{
    public BB(){
        super(); //calls parent class constructor //by default super() is called if not written
        //this(10); //calls own class parameterized constructor

        System.out.println("in BB default constructor");
    }
    public BB(int x){
        //super(x); //calls parent class parameterized constructor
        this(); //calls own class default constructor
        System.out.println("in BB parameterized constructor");
    }
}

//Final Keyword
//The final keyword in Java is used to declare constants, prevent method overriding, and restrict inheritance. 
// When a variable is declared as final, its value cannot be changed once initialized.
// When a method is declared as final, it cannot be overridden by subclasses.
// When a class is declared as final, it cannot be subclassed.
final class FinalClass{ //no one can inherit this class
    public void display(){
        System.out.println("in final class method");
    }
}
//final method
class Example{
    //IMPORTANT:
    // A final method cannot be overridden by subclasses.
    //public final void show(){  //❌ cannot override final method
    public void show(){
        System.out.println("in example class");
    }
 }
class Example1 extends Example{
    public void show(){ //cannot override final method
       System.out.println("in example1 class");
    }
 }  


//toString() method
// The toString() method in Java is used to provide a string representation of an object. It is defined in the Object class and can be overridden in user-defined classes to return meaningful information about the object.    
class Laptop{
    String brand;
    int price;
    public String toString(){ //overriding toString() method
        return "Brand: "+brand+", Price: "+price;
        //return "Hey";
    }
    public boolean equals(Laptop obj){ //overriding equals() method
        // if(this.brand.equals(obj.brand) && this.price==obj.price){
        //     return true;
        // }
        // return false;
        return this.brand.equals(obj.brand) && this.price==obj.price;
    }
    //IMPORTANT:
    // When overriding equals(), always override hashCode() to maintain the general contract for the hashCode method, which states that equal objects must have the same hash code.
    //Generate hashCode() and equals() methods using IDE or write manually as below:
    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + ((brand == null) ? 0 : brand.hashCode());
    //     result = prime * result + price;
    //     return result;
    // }
    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (obj == null)
    //         return false;
    //     if (getClass() != obj.getClass())
    //         return false;
    //     Laptop other = (Laptop) obj;
    //     if (brand == null) {
    //         if (other.brand != null)
    //             return false;
    //     } else if (!brand.equals(other.brand))
    //         return false;
    //     if (price != other.price)
    //         return false;
    //     return true;
    // }
    
}  

//Type Casting
class UDcast{
    //Upcasting and Downcasting methods can be defined here if needed
    public void show(){
        System.out.println("in UDcast class");
    }
}
class UDcast1 extends UDcast{
    public void show(){
        System.out.println("in UDcast1 class");
    }
}


//abstract class
//abstract method must be declared inside abstract class only
abstract class Car{
    public abstract void drive();
    public abstract void fly();
    public void playMusic(){
        System.out.println("Playing music");
    }
}
//compulsory to override abstract method in child class
//Important: if we not override abstract method in child class then child class must be declared as abstract
abstract class WagonR extends Car{
    @Override
    public void drive(){
        System.out.println("Driving WagonR");
    }  
}
class UpdatedWagonR extends WagonR{ //concrete class
    @Override
    public void fly(){
        System.out.println("Flying WagonR");
    }
}

//INNER CLASS vs NESTED CLASS
// A nested class is any class defined within another class. It can be static or non-static.
// An inner class is a non-static nested class that is associated with an instance of the outer class.
// Inner classes can access instance members of the outer class, while static nested classes cannot.    
class Inner{
    int data=10; //instance variable of outer class
    public void show(){
        System.out.println("in outer class");
    }
    class Inner1{ //inner class
        public void config(){
            System.out.println("in inner class");
        }
        class InnerInner1{
            public void display(){
                System.out.println("in inner inner class");
            }
        }
    }
    static class Inner2{ //static nested class
        public void display(){
            System.out.println("in static nested class");
        }
    }
}
//Anonymous Inner Class
//An anonymous inner class in Java is a class without a name that is defined and instantiated in a single expression, typically used to provide a concise implementation of an interface or extend a class for one-time use.  
class AnonymousInner{
    public void show(){
        System.out.println("in anonymous inner class");
    }
}  



//abstract class and anonymous inner class example
abstract class A4{
    public abstract void display();
}
//Interfaces
// An interface in Java is a reference type that defines a contract of methods that implementing classes must provide, allowing for abstraction and multiple inheritance of type.
//by default all methods in interface are public and abstract
//variables in interface are public static final by default

interface A5 {
    // public abstract void show();
    // public abstract void config();
    int age=10; //public static final by default
    String name="krishna"; //public static final by default
    void show(); //public and abstract by default
    void config(); //public and abstract by default

}
//we compulsorily need to override all methods of interface in implementing class and if we fail to do so then implementing class must be declared as abstract
class B5 implements A5{
    @Override
    public void show(){
        System.out.println("in show method of interface A5");
    }
    @Override
    public void config(){
        System.out.println("in config method of interface A5");
    }
}

abstract class C5 implements A5{
    @Override
    public void show(){
        System.out.println("in show method of interface A5 in abstract class C5");
    }
    //we are not overriding config() method so C5 must be declared as abstract
}
class UpdatedC5 extends C5{
    @Override
    public void config(){
        System.out.println("in config method of interface A5 in UpdatedC5 class");
    }
}


//dependency injection using interface
abstract class Computer {
    abstract public void code();
}

class Mac extends Computer{
    public void code(){
        System.out.println("Coding in laptop");
    }
}
class Desktop extends Computer{
    public void code(){
        System.out.println("Coding in desktop");
    }
}
class Developer{
    public void devApp(Computer comp){
        comp.code(); //developer is not concerned about which computer is used
        System.out.println("Developing app");
    }
}

//multiple inhertiance using interfaces

interface A6{
    int age=20; //public static final by default
    String name="kavi"; //public static final by default
    void display();
    void show();
}
interface B6{
    void run();
}
//if interface extends another interface then it is called interface inheritance
//and the child interface inherits all methods of parent interface too
//D6 extends both A6 and B6 interfaces
interface D6 extends A6,B6{
    void walk(); 
}
interface E6 {
    void jump();
}
class C6 implements D6,E6{ //multiple inheritance using interfaces
    @Override
    public void display(){
        System.out.println("in display method of interface A6");
    }
    @Override
    public void show(){
        System.out.println("in show method of interface A6");
    }
    @Override
    public void run(){
        System.out.println("in run method of interface B6");
    }
    @Override
    public void walk(){
        System.out.println("in walk method of interface D6");
    }
    @Override
    public void jump(){ 
        System.out.println("in jump method of interface E6");
    }
    
}

//enum 
// An enum in Java is a special data type that defines a set of named constants, providing type safety and a clear way to represent fixed sets of related values.
enum Status{
    Running, Failed, Completed, Pending, Success;
}

//Enum constants are public static final objects, and the enum constructor is called once for each constant when the enum is loaded.
// enum = fixed set of objects
// Each value = object
// Constructor runs once per object
// You cannot create new enum objects
// Enum constructors are always private

//enum is a class but we cannot create object of enum class using new keyword
//enum can have methods and variables
enum Laps{
    MACBOOK(2000),
    XPS(1500),
    THINKPAD(1800),
    LATITUDES,
    SURFACE;
    //these are the objects of enum Laps
    ////  ✅ These are enum objects (instances)
    //// Each one is:
    // public static final Laptops MACBOOK;
    //// So internally Java does something like:
    // MACBOOK = new Laps(2000);
    // XPS     = new Laps(1500);

    //or
    //public static final Laps MACBOOK = new Laps(2000);

    //     Why constructor is private?
    // new Laptops(2500); // ❌ // Because this is ❌ NOT allowed:
    // Enums are fixed and controlled

    //IMPORTANT:
    //     Each enum constant is an OBJECT
    // The constructor runs ONCE for each constant

    private int price;
    //default constructor is private
    private Laps(){
        price=500;
        //this constructor is called for each enum constant but we are not using it as we have parameterized constructor
        System.out.println("in enum default constructor: "+ this.name() + " : "+ price);
    }

    private Laps(int price){ //enum constructor
        this.price=price;
        //this constructor is called for each enum constant
        System.out.println("in enum parameterized constructor: "+ this.name() + " : "+ price);
    }
    public int getPrice() {
        return price;
    }
    //     One small design warning (important)
    // You added:
    // public void setPrice(int price) // This is NOT recommended ❌
    // --->>>>>Enums should be immutable.
    // ✅ Better:
    // // remove setter

    public void setPrice(int price) {
        this.price = price;
    }
}

//Annotations
// Annotations in Java are metadata that provide information about the program but do not affect its execution.
//for example: @Override, @Deprecated, @SuppressWarnings etc.
class A7{
    public void showTheDataWhichBelongsToThisClass(){
        System.out.println("in A7 method");
    }
}
class B7 extends A7{
    @Override //annotation
    public void showTheDataWhichBelongsToThisClass(){
        System.out.println("in B7 method");
    }
}

//Functional Interfae 
@FunctionalInterface
interface A8{
    // void display();
    //void show(); //❌ cannot do this as functional interface can have only one abstract method
    //but we can have default and static methods in functional interface
    void display(int a);
    default void show(){
        System.out.println("in default method of functional interface");
    }
    static void config(){
        System.out.println("in static method of functional interface");
    }
}
class B8 implements A8{
    @Override
    public void display(int a){
        System.out.println("in display method of functional interface A8 with value: " + a);
    }
}
//LAMBDA
//lambda expression can be used only with functional interface
interface A9{
    int display(int a,int b);
    
}

//Main Class
public class telusko { 
    static final double PI=3.14; //final static variable declared at class level  

    public static void main(String args[]) throws ClassNotFoundException{


        int i=0;
        for(;i<5;){
            System.out.println(i);
            i++;
        }
        //System.out.println("Value of c: "+c);

        Student s1=new Student();
        s1.rollno=1;
        s1.name="krishna";
        s1.marks=98;

        Student s2=new Student();
        s2.rollno=2;
        s2.name="krishnaa";
        s2.marks=98;

        Student s3=new Student();
        s3.rollno=3;
        s3.name="krishnaaa";
        s3.marks=98;

        Student studs[]=new Student[3];
        studs[0]=s1;
        studs[1]=s2;
        studs[2]=s3;

        // for(int i=0;i<studs.length;i++){
        //     System.out.println(studs[i].name+":"+studs[i].marks);
        // }
        // for(Student s:studs){
        //     System.out.println(s.name+":"+s.marks);

        // }
        
        System.out.println("\n--------String vs StringBuffer-------\n");
        String name1=new String("krishna");
        //System.out.println("hello"+name1);

        String str1="hello";
        String str2="hello";
        //System.out.println(str1==str2); //true

        StringBuffer sb=new StringBuffer("Kavi");
        
        // System.out.println(sb.capacity()); //default 16
        // System.out.println(sb.length());
        String str=sb.toString();
        //System.out.println("string: "+str);
        sb.append(" gupta");
        sb.deleteCharAt(2);
        //System.out.println(sb);
        sb.insert(2,"v");
        //System.out.println(sb);

        sb.ensureCapacity(100);
        sb.setLength(4);
        //System.out.println(sb);


        StringBuffer sb2 = new StringBuffer();
        sb2.append("abcdefghijklmnopq"); // 17 characters
        //System.out.println(sb2.capacity()); //newCapacity = (oldCapacity * 2) + 2
        sb2.trimToSize();
        //System.out.println(sb2.capacity());
        //System.out.println(sb2);
        
        System.out.println("\n--------Static Keyword-------\n");
       
        // Mobile mob1=new Mobile();
        // mob1.brand="Apple";
        // mob1.price=10000;
        // mob1.name="Smartphone";
        
        // Mobile mob2=new Mobile();
        // mob2.brand="Samsung";
        // mob2.price=10000;
        // mob2.name="Smartphone";

        //static variables must be accessed by using the class name not by object name
        //Static variables belong to the class, so although they can be accessed using an object reference, they should always be accessed using the class name to avoid confusion.
        
        //mob1.name="Phone";
        //Mobile.name="Phone";

        // mob1.show();
        // mob2.show();
    
        
        // We pass an object to a static method because static methods cannot access instance members directly, so the object must be provided explicitly as a parameter.
        // Why is the object passed here?
        // ❌ Not to avoid confusion
        // ❌ Not because we are calling via class name
        // ✅ Because the static method has no this reference
        // Instance methods have this
        // Static methods do not belong to any object
        // So Java forces you to tell explicitly which object you want to work with
        
        
        // Mobile.show1(mob1);
        // Mobile.show1(mob2);
        // Mobile mob3=new Mobile();
        
        // A static block executes only when the class is loaded. If the class is never used (no object creation, no static access, no explicit loading), the JVM will not load it, and the static block will not run. Class.forName("ClassName") can be used to force class loading without creating an object.
        
        //Class.forName("Mobile");
        System.out.println("\n--------Encapsulation using Getter and Setter-------\n");

        //Encapsulaiton using Getter and Setter
        Human hum1=new Human();
        // hum1.age=11;
        // hum1.name="krishna";

        hum1.setAge(12);
        hum1.setName("kavi");
        //1
        System.out.println("Getter Setter: "+hum1.getAge()+":"+ hum1.getName());
        //2
        Human hum2=new Human(13,"krishna gupta");
        System.out.println("Constructor: "+hum2.getAge()+":"+ hum2.getName());
        //3
        Human hum3=new Human();
        hum3.setAge(30,hum3);

        //Anonymous Object->they don't have a name and we can't resue them later
        //An anonymous object is an object created without assigning it to a reference variable.
        //         Why anonymous objects are used?
        // ✔ When an object is needed only once
        // ✔ To reduce variables
        // ✔ For quick method calls
        new A();
        new A().show();


        Calc cal=new Calc();
        int r1=cal.add(10,5);
        int r2=cal.sub(10,5);
        System.out.println("Addition: "+r1);
        System.out.println("Subtraction: "+r2);
        System.out.println("\n--------Advanced Calculator-------\n");
        AdvCalc advCal=new AdvCalc();
        int r3=advCal.mul(10,5);
        int r4=advCal.div(10,5);
        int r5=advCal.add(10,5); //inherited method
        int r6=advCal.sub(10,5); //inherited method
        System.out.println("Multiplication: "+r3);
        System.out.println("Division: "+r4);
        System.out.println("Addition using advcalc: "+r5);
        System.out.println("Subtraction using advcalc: "+r6);
        System.out.println("\n--------Very Advanced Calculator-------\n");

        VeryAdvCalc vac=new VeryAdvCalc();
        int r7=vac.mod(10,3);
        int r8=vac.pow(2,3);
        int r9=vac.add(10,5); //inherited method
        int r10=vac.mul(10,5); //inherited method
        System.out.println("Modulus: "+r7);
        System.out.println("Power: "+r8);
        System.out.println("Addition using very advcalc: "+r9);
        System.out.println("Multiplication using very advcalc: "+r10);

        System.out.println("\n--------Method Overriding-------\n");
        //Method overriding allows a child class to provide a specific implementation of a method already defined in its parent class, enabling runtime polymorphism.
        Animal a=new Animal();
        a.sound(); //Animal sound   
        Dog d=new Dog();
        d.sound(); //Bark
        Animal a1=new Dog(); 
        a1.sound(); //Bark
        Animal a2=new Animal();
        a2.sound(); //Animal sound
        
        //Dog d1=new Animal(); // ❌ cannot do this
        

        //                 Runtime Polymorphism
        // ✔ JVM decides at runtime which method to call
        // ✔ Object type (Dog) matters, not reference type (Animal)
        // Why does this happen?
        // Because Java uses Dynamic Method Dispatch.
        // The method call is resolved at runtime based on the actual object, not the reference variable.

        //         What is NOT method overriding ❌
        // public static void sound() { }  // ❌ static → method hiding
        // private void sound() { }        // ❌ private → not inherited
        // final void sound() { }          // ❌ cannot override


        System.out.println("\n--------super keyword-------\n");
        BB b=new BB();
        BB b1=new BB(10);


        System.out.println("\n--------Accessing AAAA class from other package-------");
        AAAA obj=new AAAA();
        obj.marks=95;
        System.out.println("Marks from AAAA class: "+obj.marks);
        //if marks is not public then it will give error like this:
        //Marks from AAAA class: telsuko.java:201: error: marks has private access in AAAA
        // so to avoid it make marks public in AAAA class 
        // or create getter and setter methods in AAAA class 
        // or make marks default and put telsuko.java and AAAA.java in same package
        //IMPORTANT:
        //Private members - of a class are not accessible outside their own class, even from subclasses 
        // or classes in the same package 
        // or different packages 
        // or using import statements or any other means.
        obj.display();
        //or
        System.out.println("Grade from AAAA class using getter: "+obj.getGrade());
        //private < default < protected < public

        //overloading vs overriding
        
        //1. Method Overloading:
        // ✔ Same method name in the same class
        // ✔ Different parameter list (type, number, order)
        // ✔ Compile-time polymorphism     
        
        //2. Method Overriding:
        // ✔ Same method name in parent and child class
        // ✔ Same parameter list
        // ✔ Runtime polymorphism
         

        System.out.println("\n--------final keyword-------\n");
        FinalClass fc=new FinalClass();
        fc.display();
        //Final class cannot be inherited
        //class SubFinalClass extends FinalClass{  ❌ cannot do this
        //}
        final int x=10;
        //x=20;  //❌ cannot do this  
        System.out.println("Final variable x: "+x);

        // static vs final vs static final
        // static → belongs to class, shared
        // final → cannot be changed   
        // static final → constant

        //IMPORTANT:
        // static final double PI=3.14; // ❌ NOT ALLOWED inside method
        System.out.println("Static Final PI: "+PI);

        // static final variables must be declared at class level, not inside methods.
        // To fix this, declare static final variables outside methods, within the class body.

        Example ex=new Example();
        ex.show();
        Example1 ex1=new Example1();
        ex1.show();


        Laptop lap1=new Laptop();
        lap1.brand="Dell";
        lap1.price=50000;
        System.out.println("Laptop 1: "+lap1.brand+":"+ lap1.price);
        
        System.out.println(lap1.toString()); //prints class name@hashcode in hexadecimal
        System.out.println(lap1); //toString() is called implicitly

        System.out.println(lap1.toString()); //getClass() method returns the runtime class of an object 

        // now all returns "Hey" because we have overridden toString() method in Laptop class
        // or
        // now all returns "Brand: Dell, Price: 50000" because we have overridden toString() method in Laptop class

        Laptop lap2=new Laptop();
        lap2.brand="Dell";
        lap2.price=50000;   

        System.out.println("Laptop 2: "+lap2); //toString() is called implicitly
        System.out.println(lap2.toString());    

        boolean isEqual=lap1.equals(lap2); //equals() method compares references by default
        //when we override equals() method in Laptop class then it compares values
        //equals() method compares object contents if overridden, otherwise compares references by default
        boolean isEqual1=lap1==lap2; //compares references
        System.out.println("\n\nAre lap1 and lap2 equal? "+isEqual);
        System.out.println("Are lap1 and lap2 equal using '==' operator? "+isEqual1);
        // how to compare two objects in Java?
        // ✔ Use equals() method for content comparison (override if needed)
        // ✔ Use '==' operator for reference comparison     

        System.out.println("\n--------Type Casting-------\n");
        //Upcasting vs Downcasting
        // Upcasting:
        // ✔ Converting subclass to superclass
        // ✔ Implicit, safe, no risk of ClassCastException
        // Downcasting:
        // ✔ Converting superclass to subclass
        // ✔ Explicit, risky, may throw ClassCastException     
         

        //A obj-new B(); //upcasting
        UDcast ud=(UDcast) new UDcast1(); //upcasting
        //upcasting is done automatically so no need to write (UDcast)
        //UDcast ud=new UDcast1(); //upcasting
        ud.show(); //in UDcast1 class

        //B obj1=(B)obj; //❌ cannot do this -> downcasting
        UDcast1 ud1=(UDcast1)ud; //downcasting -> explicit
        //downcasting must be done explicitly 
        // parent class reference to child class reference
        //UDcast1 ud1=ud; //❌ cannot do this -> downcasting
        ud1.show(); //in UDcast1 class  

        System.out.println("\n--------Class.forName()-------\n");
        //Class.forName() is used to load a class dynamically at runtime using its fully qualified name as a string.
        Class.forName("Mobile");

        System.out.println("\n--------Wrapper Classes vs Primitive Data Types-------\n");
        //Primitive Data Types vs Wrapper Classes
        // Primitive Data Types:
        // ✔ Basic data types (int, char, etc.)
        // ✔ Store simple values directly
        // ✔ No methods or properties
        // Wrapper Classes:
        // ✔ Object representations of primitive types (Integer, Character, etc.)
        // ✔ Provide methods for conversion and manipulation 
        
        //wrapper classes vs primitive data types
        //Wrapper classes in Java are object representations of primitive data types, providing additional functionality such as methods for conversion and manipulation, while primitive data types are basic data types that store simple values directly without any methods or properties.

        int prim=10; //primitive data type
        //Integer wrap=new Integer(prim); // deprecated way
        Integer wrap=Integer.valueOf(prim); //boxing -> converting primitive to wrapper class object
        int y=wrap.intValue(); //unboxing -> converting wrapper class object to primitive 
        System.out.println("Primitive: "+prim);
        System.out.println("Wrapper: "+wrap);
        System.out.println("Unboxed Primitive: "+y);

        Integer xx = 20;   // autoboxing
        int yy = xx;        // auto-unboxing
        System.out.println("Autoboxed Integer: "+xx);
        System.out.println("Auto-unboxed int: "+yy);

        //  == vs .equals() with wrappers (IMPORTANT)
        // Integer a = 100;
        // Integer b = 100;
        // System.out.println(a == b);      // true (cached)

        // Integer x = 200;
        // Integer y = 200;
        // System.out.println(x == y);      // false

        // 👉 == compares references, not values.
        // ✔ Correct comparison:
        // x.equals(y); // true

        // Integer Cache (important detail)
        // * Java caches Integer values from -128 to 127
        // * Same object reused → == may return true in that range

        int n = Integer.parseInt("123");   // String → int
        String s = Integer.toString(50);   // int → String
        System.out.println("Parsed int: "+n);
        System.out.println("Integer to String: "+s);
        Integer.max(10, 20); //wrapper class method
        Double.parseDouble("3.14"); //better than using Double.valueOf() which returns Double object
        Character.isDigit('5'); //better than using Character.valueOf() which returns Character object
        System.out.println("Max of 10 and 20: "+Integer.max(10, 20));   
        System.out.println("Parsed double: "+Double.parseDouble("3.14"));
        System.out.println("Is '5' a digit? "+Character.isDigit('5'));
        // parseDouble() is preferred over valueOf() when a primitive is sufficient because it avoids unnecessary object creation, improving performance and clarity. Similarly, Character.isDigit() directly performs validation without creating wrapper objects.


        System.out.println("\n--------Abstract Class-------\n");
        //abstract class
        //we can't create object of abstract class
        //  Car c=new Car(); //❌ cannot do this    
        UpdatedWagonR wr=new UpdatedWagonR();
        wr.drive();
        wr.playMusic();
        wr.fly(); 
        
        System.out.println("\n--------INNER CLASS vs NESTED CLASS-------\n");   
        //inner class vs nested class
        Inner out=new Inner(); //outer class object
        out.show();
        //Inner.Inner1 in=new Inner.Inner1(); //❌ cannot do this -> inner class object creation needs outer class object
        Inner.Inner1 in = out.new Inner1(); //inner class object
        in.config();

        Inner.Inner1.InnerInner1 inn = in.new InnerInner1();
        inn.display();

        //static nested class-> doesn't need outer class object to create its object as it is static because static members belong to class not to object
        Inner.Inner2 in2 = new Inner.Inner2(); //static nested class object
        in2.display();

        System.out.println("\n--------Anonymous Inner Class-------\n");
        //Anonymous Inner Class
        AnonymousInner ai=new AnonymousInner(){
            @Override
            public void show(){
                System.out.println("in overridden anonymous inner class");
            }
        };
        ai.show();
 
        System.out.println("\n--------Abstract Class with Anonymous Inner Class-------\n");
        //abstract class and anonymous inner class example

        A4 a4=new A4(){ //this is not the object of abstract class A4 but of its anonymous subclass
            @Override
            public void display(){
                System.out.println("in anonymous inner class of abstract class");
            }
        };
        a4.display();

        //interfaces
        System.out.println("\n--------Interfaces-------\n");
        //we can't create object of interface
        // A5 a5=new A5(); //❌ cannot do this
        //important:
        // An interface cannot be instantiated directly because it is an abstract contract that defines methods without implementations.
        // To use an interface, a class must implement it and provide concrete implementations for its methods
        //
        A5 a5=new A5(){ //anonymous inner class implementing interface A5
            @Override
            public void show(){ 
                System.out.println("Anonymous inner class show method of interface A5");
            }
            @Override
            public void config(){
                System.out.println("Anonymous inner class  config method of interface A5");
            }
        };
        a5.show();
        a5.config();

        A5 b5;  //not B5 b5
        //Class reference = fixed behavior
        //Interface reference = flexible behavior
        // B5 b5 = new B5(); → Works
        // A5 b5 = new B5(); → Better design
        // 💡 Interfaces are for flexibility, not necessity.
        
        b5=new B5();
        b5.show();
        b5.config();
        System.out.println(A5.age); //accessing interface variable
        System.out.println(A5.name); //accessing interface variable
        //since by default interface variables are public static final so we can access them by using interface name
    
        C5 c5;
        c5=new UpdatedC5();
        c5.show();  
        c5.config();


        System.out.println("\n--------Dependency Injection using Interface-------\n");
        //dependency injection using interface
        //developer doesn't depend upon specific computer he can code irrespective of computer type
        Computer mac=new Mac();
        Computer desktop=new Desktop();
        Developer dev=new Developer();
        dev.devApp(mac); //dependency injection
        dev.devApp(desktop); //dependency injection


        System.out.println("\n--------Multiple Inheritance using Interfaces-------\n");
        //multiple inheritance using interfaces
        A6 a6=new C6();
        a6.display();
        a6.show();
        //a6.run(); //❌ cannot do this -> a6 is reference of A6 interface which doesn't have run() method
        B6 b6=new C6();
        b6.run();
        //b6.display(); //❌ cannot do this -> b6 is reference of B6 interface which doesn't have display() method
        E6 e6=new C6();
        e6.jump();
        //e6.walk(); //❌ cannot do this -> e6 is reference of E6 interface which doesn't have walk() method
        D6 d6=new C6();
        d6.display();
        d6.show();
        d6.run(); 
        d6.walk();

        //enum
        System.out.println("\n--------enum-------\n");
        //enum in Java is a special data type that defines a set of named constants, providing type safety and a clear way to represent fixed sets of related values.
        //enum is used when we have a fixed set of related constants
        //eg. days of week, months of year
        //enum is a special data type that enables for a variable to be a set of predefined constants
        //the variable must be equal to one of the values that have been predefined for it
        //enum improves code readability and maintainability by providing meaningful names for constant values  

        int en=2;
        Status status= Status.Pending;
        System.out.println(status);
        System.out.println("Ordinal number for the enum or index: " + status.ordinal()); //prints index of enum constant starting from 0
        //enum values are static and final by default and bydefault enum extends Enum class
        // has indexing starting from 0
        System.out.println("prints the status at index 2 : " + Status.values()[en]); //getting enum constant by index
        System.out.println("prints the enum const name: " + status.name()); //prints name of enum constant
        System.out.println("\n"+status.getClass().getSuperclass()+"\n"); //prints superclass of enum -> Enum

        Status[] ss = Status.values(); //getting enum constant by index
        for(Status stat : ss){
            System.out.println("Status at index "+stat.ordinal()+": "+stat);
        }
        switch(status){
            case Running:
                System.out.println("Status is Running");
                break;
            case Failed:
                System.out.println("Status is Failed");
                break;
            case Completed:
                System.out.println("Status is Completed");
                break;
            case Pending:
                System.out.println("Status is Pending");
                break;
            case Success:
                System.out.println("Status is Success");
                break;
            default:
                System.out.println("Invalid Status");
        }
        Laps lap=Laps.MACBOOK;
        System.out.println("\nLaptop: "+lap); //MACBOOK
        //lap.setPrice(1000);
        System.out.println("Index: "+lap.ordinal()+ ", Price: "+lap.getPrice() +" : "+lap); //prints index and name of enum constant
        //to get price we need to define a method in enum Laps
        // System.out.println("Price: "+lap.getPrice()); //❌ cannot do this
        //so we can use switch case to get price


        //BUGS
        System.out.println("\n--------Annotations-------\n");
        //Annotations in Java are metadata that provide information about the program but do not affect its execution.
        // They are used for various purposes such as documentation, code analysis, and runtime processing.
        // Annotations can be applied to classes, methods, variables, parameters, and packages.
        B7 b7=new B7();
        b7.showTheDataWhichBelongsToThisClass(); //in B7 method


        System.out.println("\n--------Functional Interface-------\n");
        //Functional Interfae
        // A functional interface in Java is an interface that contains exactly one abstract method, making it suitable for use with lambda expressions and method references.
        A8 a8=new A8(){
            @Override
            public void display(int a){
                System.out.println("in anonymous inner class of functional interface with value: " + a);
            }
        };
        B8 b8=new B8();
        b8.display(8);
        b8.show(); //default method of functional interface
        A8.config(); //static method of functional interface

        //lambda expression can be used only with functional interface
        // Lambda Expression Syntax:   
        // (parameters) -> { body }
        
        // A8 funcInterface = (int xxxx) -> {
        //     System.out.println("in lambda expression of functional interface with value: " + xxxx);
        // };
        //or short
        A8 funcInterface = xxxx -> System.out.println("in lambda expression of functional interface with value: " + xxxx);
        funcInterface.display(10);

        //another example
        A9 a9= (int i9,int j9) -> { // A9 a9= (i9,j9) ->i9+j9; //short way
            System.out.println("\nin lambda expression of functional interface A9 with values: " + i9 + " and " + j9);
            return i9+j9;
        };
        int result=a9.display(9,10);
        System.out.println("Returned value from lambda: " + result);


        System.out.println("\n\n--------End of Program-------\n\n");

    }
}
