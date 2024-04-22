import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamApiDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 2, 7);

        Stream<Integer> s1 = nums.stream();  // we can using Stream only once(not re-used)
        // s1.forEach(n -> System.out.println(n));
        // s1.forEach(n -> System.out.println(n));  give error

        Stream<Integer> s2 =  s1.filter(n -> (n & 1) == 0);
        // s2.forEach(n -> System.out.println(n));

        Stream<Integer> s3 = s2.map(n -> n * 2);
        // s3.forEach(n -> System.out.println(n));

        int result = s3.reduce(0, (c, e) -> c + e);
        System.out.println(result);   // output: 12

        int ans = nums.stream().filter(n -> n % 2 == 0).map(n -> n * 2).reduce(0, (c, e) -> c + e);
        System.out.println(ans);
        // Consumer<Integer> con = new Consumer<Integer>() {
        //     public void accept(Integer n){
        //         System.out.println(n);
        //     }
        // };

        // Consumer<Integer> con = n -> System.out.println(n);
        // nums.forEach(con);

        // nums.forEach(n -> System.out.println(n));
    }
}
