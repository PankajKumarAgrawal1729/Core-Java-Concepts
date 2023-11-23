public class StringBufferAndStringbuilderDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(); // it is thread safe
        System.out.println(sb.capacity()); // default capacity is 16

        StringBuffer sb1 = new StringBuffer("Ram");
        System.out.println(sb1.capacity()); // capacity = 16(default) + 3(size of string) = 19
        System.out.println(sb1.length()); // 3

        sb1.append(" Krishna");

        System.out.println(sb1);

        StringBuilder sbu = new StringBuilder("Hello");
        System.out.println(sbu);

    }
}
