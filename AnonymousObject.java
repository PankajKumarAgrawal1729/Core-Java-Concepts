class A {
    public A(){
        System.out.println("Object Created!!");
    }

    public void show(){
        System.out.println("in show");
    }
}

public class AnonymousObject {
    public static void main(String[] args) { 
        A obj = new A(); //referenced Object
        obj.show();

        new A(); //anonymous object
    }
}