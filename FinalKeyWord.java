//if we make any class as final then no class is inherited or extends(stopping inheritance)
final class Calc {
    public void add(int a, int b) {
        System.out.println(a + b);
    }

    public void show() {
        System.out.println("in Calc");
    }
}

class A {
    public void show1() {
        System.out.println("in A show");
    }

    // if we make a method as final then it's not overide
    public final void show2() {
        System.out.println("in A final show");
    }
}

class B extends A {
    // public void show2(){ give error
    // System.out.println("in B show");
    // }
}

public class FinalKeyWord {
    public static void main(String[] args) {
        // if we make any variable as final then it's act as constant. so, we can't
        // change its value;

        double pi = 22.4;
        System.out.println(pi);

        Calc obj = new Calc();
        obj.show();
        obj.add(2, 4);
    }
}
