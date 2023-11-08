public class LoopsDemo {
    public static void main(String[] args) {
        // loops

        int i = 1;
        // while(condition){...}
        // While loop: it will execute util condition is true(only)
        System.out.println("While Loop");
        while (i <= 5) {
            System.out.println(i);
            i++;
        }

        System.out.println("------------------");

        // do-while : it will execute at least one time no matter condition is true or
        // false and after that execute only if condition is true
        System.out.println("do-while loop");

        i = 1;
        do {
            System.out.println("Hi"); // print Hi but condition inside while is false
            i++;
        } while (i > 2);

        System.out.println("----------------");

        i = 1;
        do {
            System.out.println("Hello");
            i++;
        } while (i <= 5);

        System.out.println("------------------------");

        // for loop
        System.out.println("for loop");
        for (int j = 1; j < 5; j++) {
            System.out.println("Hello for");
        }

        int i, j;

i = 100;

j = 300;

while(++i < --j);

System.out.println(i);

}
    }
}
