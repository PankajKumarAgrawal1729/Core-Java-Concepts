class Calculator {
    // here we have two method with same name as add but have different
    // parameters(different in number of parameter/ type of parameter)
    // it's called method overloading
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class MethodOverloadingDemo {
    public static void main(String[] args) {
        Calculator obj = new Calculator();
        System.out.println(obj.add(1, 4));
        System.out.println(obj.add(4, 5, 6));
    }
}
