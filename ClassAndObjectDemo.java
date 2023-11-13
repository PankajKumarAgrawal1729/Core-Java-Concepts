class Calculator {
    int a;

    public int add(int num1, int num2) {
        int r = num1 + num2;
        return r;
    }
}

public class ClassAndObjectDemo {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 4;

        Calculator calc = new Calculator();
        int result = calc.add(num1, num2);
        System.out.println(result);
    }
}

// Class: A class in programming is a blueprint or a template for creating
// objects. It encapsulates data for the object and methods to manipulate that
// data. It defines the properties and behaviors that the objects created from
// the class can have.

// Object: An object is an instance of a class. When a class is defined, no
// memory is allocated until an object is created from the class blueprint, at
// which point a block of memory is reserved for the object. An object includes
// data and behavior that represent something from the real world within the
// context of the program.