public class Stringdemo {
    public static void main(String[] args) {
        String name = "Rohit";
        name = name + " Sharma"; // string is immutable, so this name is created new in memory

        String s1 = "Virat";
        String s2 = "Virat";

        System.out.println(s1 == s2); // true, in string constant pool for s1 and s2 only one value is created and
                                      // both contain the same refernce adress
    }
}
