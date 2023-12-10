package AccessModifier;

import AccessModifier.other.A;

class Launch {
    public void abc() {
        A obj = new A();
        System.out.println(obj.marks);
    }

}

public class AccessModifierDemo {
    public static void main(String[] args) {
        A obj = new A();
        System.out.println(obj.marks);

        B obj1 = new B();
        System.out.println(obj1.marks);
    }
}

// public : Access from Anywhere
// private: Access with-in the class only(same class only)
// default: Access in the same package
// protected: Access in same class, same package subclass, same package
// non-subclass, different package subclass