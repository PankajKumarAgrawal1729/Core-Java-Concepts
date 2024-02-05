// we can't write object of abstract class, but their are 2 solution for this
// 1. create an seprate class and extends and implments the abstarct class methods
// 2. using anonymous class

abstract class A{
    public abstract void show();
}

class B extends A{
    public void show(){
        System.out.println("in B show");
    }
}

public class AbstractAndAnonymousInnerClassDemo {
    public static void main(String[] args) {
        A obj = new A(){
            public void show(){
                System.out.println("in anonymous class A");
            }
        };

        obj.show();
    }
}
