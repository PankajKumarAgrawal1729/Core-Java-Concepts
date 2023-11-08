public class ConditionStatementDemo {
    public static void main(String[] args) {
        // if-else
        // greatest among 2 number
        int x = 18;
        int y = 34;

        if (x > y) {
            System.out.println("X greater than Y");
        } else {
            System.out.println("Y greater than X");
        }

        // if-else-if
        // greatest among 3 number
        int a = 2;
        int b = 3;
        int c = 4;

        if (a > b && a > c) {
            System.out.println("a is greater than b and c");
        } else if (b > c && b > a) {
            System.out.println("b is greater than a and c");
        } else {
            System.out.println("c is greater than a and b");
        }

        // ternary operator
        // check number is even or odd
        int num = 4;
        String result = (num & 1) == 1 ? "odd" : "even";
        System.out.println("Number is " + result);

        // switch statement
        // check day of the week
        int n = 1;
        switch (n) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Enter valid number");
                break;
        }
    }
}
