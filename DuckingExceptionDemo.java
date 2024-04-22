// throws 

class A{
    public void show() throws ClassNotFoundException{ // here we ducking(throws the exception fr their calling class)
        Class.forName("Calc"); // try to load Calc class
    }

}

public class DuckingExceptionDemo {
    public static void main(String[] args) {
        A obj = new A();
        try {
            obj.show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
