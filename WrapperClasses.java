// int - Integer
// char - Character and so on

public class WrapperClasses {
    public static void main(String[] args) {
        int num = 7;
        Integer num1 = num; // Auto-boxing
        int num2 = num1.intValue();
        int num3 = num1; // auto-unboxing
        System.out.println(num1 + " " + num2 + " " + num3);
    }
}