import java.util.ArrayList;
import java.util.Collection;

public class ArrayListDemo {
    public static void main(String[] args) {
        Collection<Integer> nums = new ArrayList<>(); // if we can't mention type then they are of Object type

        nums.add(17);
        nums.add(42);
        nums.add(32);
        nums.add(46);

        System.out.println(nums);

        for (int n : nums) {
            System.out.println(n);
        }
    }
}
