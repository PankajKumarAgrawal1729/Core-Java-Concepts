// class - class -> extends
// class - interface -> implements
// interface - interface -> extends

interface A {
    // all variable are final and static
    int age = 23;  
    
    // every method in interface bu-default (public abstract)
    void show();

    void config();
}

interface X{
    void run();
}

interface Y extends X{
    void code();
}

class B implements A, Y{
    public void show(){
        System.out.println("in B show");
    }

    public void config(){
        System.out.println("in B Config");
    }

    public void run(){
        System.out.println("running");
    }

    
    public void code() {
        System.out.println("Coding...");
    }
}

interface Computer{
    void code();
}

class Laptop implements Computer{
    public void code() {
        System.out.println("Code, complie, run.");
    }
}

class Desktop implements Computer{
    public void code() {
        System.out.println("Code, complie, run : Faster");
    }
}

class Developer{
    public void devApp(Computer com){
       com.code();
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        // B obj = new B();
        // obj.show();
        // obj.config();
        // obj.run();
        // obj.code();
        // System.out.println(A.age);

        Developer dev = new Developer();
        Computer lap = new Laptop();
        Computer desk = new Desktop();
        dev.devApp(lap);
        dev.devApp(desk);
    }
}
