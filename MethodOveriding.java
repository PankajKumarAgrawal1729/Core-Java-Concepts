class A{
    public void show(){
        System.out.println("in A show");
    }
    public void config(){
        System.out.println("in A Config");
    }
}

class B extends A{
    public void show(){
        System.out.println("in B Show");
    }
}

public class MethodOveriding {
    public static void main(String[] args) {
        // A obj = new A();
        // obj.show();
        B obj = new B();
        obj.show();   // in B Show
        obj.config(); // in A Config 
    }
}
