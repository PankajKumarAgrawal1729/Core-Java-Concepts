class A {
    public A() {
        System.out.println("in A");
    }

    public A(int n) {
        System.out.println("in A parameter");
    }
}

class B extends A {
    public B() {
        // every constructor have the method which is "super()", it call the parent
        // class constructor
        super();
        System.out.println("in B");
    }

    public B(int n) {
        // it will call the parents parameterised constructor
        // super(7);

        // it will call the constructor of same class
        this();
        System.out.println("in B parameter");
    }
}

public class ThisAndSuperKeyword {
    public static void main(String[] args) {
        // they called the constructor of 'A' class also
        // B obj = new B();
        B obj1 = new B(5);
    }
}