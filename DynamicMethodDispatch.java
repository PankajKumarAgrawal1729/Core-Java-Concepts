class A {
    public void show() {
        System.out.println("in A");
    }
}

class B extends A {
    public void show() {
        System.out.println("in B");
    }
}

class C extends A {
    public void show() {
        System.out.println("in C");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {
        // B obj = new B();
        A obj = new A();
        obj.show();

        obj = new B();
        obj.show();

        obj = new C();
        obj.show();
    }
}

// it is also known as run-time polymorphism or overriding.
