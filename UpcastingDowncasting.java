class A {
    public void aShow() {
        System.out.println("in A show");
    }
}

class B extends A {
    public void bShow() {
        System.out.println("in B show");
    }
}

public class UpcastingDowncasting {
    public static void main(String[] args) {
        A obj = (A) new B(); // Upcasting it's default (A obj = new B();)
        obj.aShow();

        // B obj1 = obj; error obj is of type "A" which is parent of B so we can't
        // assign parent type object in child type object

        B obj1 = (B) obj; // downcasting
        obj1.bShow();
    }
}
