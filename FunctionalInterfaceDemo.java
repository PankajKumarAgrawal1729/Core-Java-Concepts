/*
Interfaces are of 3 types: 
1. Normal Interface: Interface which contains 2 or more methods
2. Functional Interface or SAM(Single abstract Method) : Interface which contains only one method
3. Marker Interface: Interface which doesn't contains any method. they are used serialization (storing data in memory(harddrive)) e.g.: games(storing the current state of game in memory when we close it so, that next time we get our all stats)
 */

 // SAM
 @FunctionalInterface
interface A {
    void show();
}

class B implements A{
    public void show(){
        System.out.println("in B Show");
    }
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        A obj = new B();
        obj.show();

        // by anonymous 
        A obj1 = new A(){
            public void show(){
                System.out.println("in anonymous show");
            }
        };
        obj1.show();
    }
}
