import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInputDemo {
    public static void main(String[] args) throws IOException {
        // println belongs to PrintStream class, whose object created inside System
        // class as static variable(out)
        System.out.println("Enter a number: ");
        // it read only one character
        // int num = System.in.read();
        // System.out.println(num - 48);

        // BufferReader - it's a class which belongs to io package
        // we need to pass InputStreamStreamReader as argument and which is also take InputStream as argument
        
        // InputStreamReader isr = new InputStreamReader(System.in);
        // BufferedReader bf = new BufferedReader(isr); // it's a resourcenn 
        // int num1 = Integer.parseInt(bf.readLine());
        // System.out.println(num1);
        // bf.close();

        Scanner sc = new Scanner(System.in);
        int num2 = sc.nextInt();
        System.out.println(num2);

        sc.close();
    }
}
