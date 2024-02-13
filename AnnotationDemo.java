class A{
    public void show(){
        System.out.println("A's Show");
    }
}

class B extends A {
    @Override
    public void show(){
        System.out.println("B's Show");
    }
    
}

public class AnnotationDemo {
    public static void main(String[] args) {
        B obj = new B();
        obj.show();
    }
}
