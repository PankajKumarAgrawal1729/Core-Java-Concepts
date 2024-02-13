@FunctionalInterface
interface A {
    void show();
}

interface B {
    void show(int n);
}

interface C {
    int add(int a, int b);
}

public class LamdaExpression {
    public static void main(String[] args) {
        // A obj = new A() {
        // public void show(){
        // System.out.println("in show");
        // }
        // };
        // obj.show();

        // A obj = () -> {
        // System.out.println("in show");
        // };
        A obj = () -> System.out.println("in show");
        obj.show();

        // B obj1 = (int n) -> System.out.println("in show: " + n);
        B obj1 = n -> System.out.println("in show: " + n);
        obj1.show(5);

        // C obj2 = new C(){
        // public int add(int a, int b){
        // return a + b;
        // }
        // };

        // C obj2 = (int a, int b) -> {
        //     return a + b;
        // };

        // C obj2 = (int a, int b) -> a + b;

        C obj2 = (a, b) -> a + b;

        System.out.println(obj2.add(3, 22));
    }
}
