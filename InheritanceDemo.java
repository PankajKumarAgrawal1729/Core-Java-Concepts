class Calc {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }
}

class AdvCalc extends Calc { // inheritance
    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }
}

class ScientificCalc extends AdvCalc {
    public double power(int n1, int n2) {
        return Math.pow(n1, n2);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Calc obj = new Calc();
        int r1 = obj.add(3, 4);
        int r2 = obj.add(6, 4);
        System.out.println(r1 + " " + r2);

        AdvCalc obj2 = new AdvCalc();
        int val1 = obj2.add(6, 3);
        int val2 = obj2.sub(6, 3);
        int val3 = obj2.mul(6, 3);
        int val4 = obj2.div(6, 3);
        System.out.println(val1 + " " + val2 + " " + val3 + " " + val4);

        ScientificCalc obj3 = new ScientificCalc();
        int v1 = obj3.add(6, 3);
        int v2 = obj3.sub(6, 3);
        int v3 = obj3.mul(6, 3);
        int v4 = obj3.div(6, 3);
        double v5 = obj3.power(6, 3);
        System.out.println(v1 + " " + v2 + " " + v3 + " " + v4 + " " + v5);
    }
}


// Multiple Inheritance is not working in java due to ambiguity problem.