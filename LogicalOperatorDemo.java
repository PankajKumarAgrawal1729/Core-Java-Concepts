public class LogicalOperatorDemo {
    public static void main(String[] args) {
        // Logical operators are:
        // 1. and - && (if both the conditions are true then only it return true
        // otherwise it return false)
        // 2. or - || (if any one of the condition is true it will return true otherwise
        // it give false)
        // 3. not - ! (it give opposite of value, true --> false vice versa)

        int a = 3;
        int b = 5;
        int x = 6;
        int y = 9;
        boolean result1 = (x > y) && (a < b);
        boolean result2 = (x > y) || (a < b);
        System.out.println(result1 + " " + result2);
    }
}
