public class TypeConversion {
    public static void main(String[] args) {
        // Type Conversion
        byte b = 127;
        int a = 2343;

        // explicit
        a = b;
        System.out.println(a + " " + b); // 127 127

        // Implicit
        a = 2343;
        b = (byte) a;
        System.out.println(a + " " + b); // 2343 39
    }
}
