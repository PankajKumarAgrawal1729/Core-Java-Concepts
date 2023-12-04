class   Calc{
    public int add(int a, int b){
        return a + b;
    }
    public int sub(int a, int b){
        return a - b;
    }
}

class AdvCalc extends Calc{  //inheritance
    public int mul(int a, int b){
        return a * b;
    }
    public int div(int a, int b){
        return a / b;
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
    }
}
