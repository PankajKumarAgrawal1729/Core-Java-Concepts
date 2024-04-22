import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<>();
        nums.add(2);
        nums.add(5);
        nums.add(2);
        nums.add(3);

        System.out.println("Simple Set Data: ");

        for (Integer integer : nums) {
            System.out.println(integer); // not sorted, not in sequance, not support index value
        }

        Set<Integer> set = new TreeSet<>();

        set.add(2);
        set.add(5);
        set.add(2);
        set.add(3);

        System.out.println("Tree Set Data: ");
        for (Integer integer : set) {
            System.out.println(integer); // in sorted, in sequance, not support index value
        }

        System.out.println("Set Data iterate using Iterator Interface: ");
        Iterator<Integer> values = nums.iterator();

        while (values.hasNext()) {
            System.out.println(values.next());
        }
    }
}
