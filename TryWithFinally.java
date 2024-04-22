import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryWithFinally {
    public static void main(String[] args) throws IOException {
        int num = 0;
        // BufferedReader bf = null;
        // try {
        //     InputStreamReader isr = new InputStreamReader(System.in);
        //     bf = new BufferedReader(isr);
        //     num = Integer.parseInt(bf.readLine());
        //     System.out.println(num);
        // } catch (Exception e) {
        //     System.out.println("Something went wrong.");
        // } finally{
        //     bf.close();
        //     System.out.println("Done!!");
        // }

        // try-with-resources
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) { // here this resource is automatically closed
            num = Integer.parseInt(bf.readLine());
            System.out.println(num);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }
}
