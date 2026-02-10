public interface A{
    void show();
}
class B{
    void display(){
        System.out.println("in display of B");
    }
}
class C extends B implements A{
    public void show(){
        System.out.println("in show of C");
    }
} 
public class logical_questions {
    public static void main(String[] args) {
        A obj = new C();
        obj.show();
        // obj.display(); // ERROR

        B obj2 = new C();
        obj2.display();
        // obj2.show(); // ERROR
    }
    
    
}
