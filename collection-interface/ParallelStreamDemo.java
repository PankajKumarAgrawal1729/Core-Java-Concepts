import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStreamDemo {    
    public static void main(String[] args) {
        int size = 10_000;
        List<Integer> nums = new ArrayList<>(size);
        Random ran = new Random();
        

        
        for (int i = 0; i < size; i++) {
            nums.add(ran.nextInt(100));
        }

        // long startSeq1 = System.currentTimeMillis();
        // int sum1 = nums.stream().map(n -> n * 2).reduce(0, (c, e) -> c + e);
        // long endSeq1 = System.currentTimeMillis();
        
        // // map to int convert value into int
        // long startSeq2 = System.currentTimeMillis();
        // int sum2 = nums.stream().map(n -> n * 2).mapToInt(i -> i).sum();
        // long endSeq2 = System.currentTimeMillis();

        // long startSeq3 = System.currentTimeMillis();
        // int sum3 = nums.parallelStream().map(n -> n * 2).mapToInt(i -> i).sum();
        // long endSeq3 = System.currentTimeMillis();

        long startSeq1 = System.currentTimeMillis();
        int sum1 = nums.stream().map(n -> n * 2).reduce(0, (c, e) -> c + e);
        long endSeq1 = System.currentTimeMillis();

        // map to int convert value into int
        long startSeq2 = System.currentTimeMillis();
        int sum2 = nums.stream().map(n -> {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
            }
            return n * 2;
        }).mapToInt(i -> i).sum();
        long endSeq2 = System.currentTimeMillis();

        long startSeq3 = System.currentTimeMillis();
        int sum3 = nums.parallelStream().map(n -> {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
            }
            return n * 2;
        }).mapToInt(i -> i).sum();
        long endSeq3 = System.currentTimeMillis();

        System.out.println(sum1 + " " + sum2 + " " + sum3);
        System.out.println("Time taken 1: " + (endSeq1 - startSeq1));  // Time taken 1: 19 slower
        System.out.println("Time taken 2: " + (endSeq2 - startSeq2));  // Time taken 2: 5  fast
        System.out.println("Time taken 3: " + (endSeq3 - startSeq3));  // Time taken 3: 8  slow

        // parallelStream is faster if we add Delay otherwise normal Stream(Sequencial Stream) is Faster
    }
}
