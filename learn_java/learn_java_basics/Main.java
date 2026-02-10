class A {
    class B {
        int data = 10;
    }
    class C  {
        int data = 20;

    }
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        System.out.println(b.data);
        A.C c = a.new C();
        System.out.println(c.data);
    }
}