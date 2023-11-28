class Test {
    int num;

    // constructors look like a method itself, but here don't specify the return
    // tyoe and name is same as the class name(neccessary)
    //every time when we create object constructor will be called

    //Default Constructor
    public Test() {
        System.out.println("Deafult Constructor");
    }

    //Parameteriesd Constructor
    Test(int num){
        this.num = num;
        System.out.println("Parameterised Constructor");
    }

}

public class Constructors {
    public static void main(String[] args) {
        Test obj1 = new Test();
        Test obj2 = new Test(5);
    }
}
