public class DataTypes {
    public static void main(String[] args) {
        // Primative Data type:
        // 1. Integer: byte(1 byte), short(2 byte), int(4 byte), long(8 byte)
        // 2. Float(double): float, double
        // 3. Character: char(2 byte)
        // 4. Boolean: boolean(true/false)

        byte val1 = 3;
        int val2 = 24;
        short val3 = 234;
        long val4 = 39_458_493L;

        float val5 = 9.5f;
        double val6 = 9453.34;

        char val7 = 'P';

        boolean val8 = true;

        System.out.println(val1 + " " + val2 + " " + val3 + " " + val4);
        System.out.println(val5 + " " + val6);
        System.out.println(val7);
        System.out.println(val8);
    }
}
