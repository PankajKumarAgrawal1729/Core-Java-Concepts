import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClassDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "Krishna", "Sita", "Radha");

        // Optional<String> name = names.stream()
        // .filter(str -> str.contains("d")).findFirst();

        // System.out.println(name.get()); // if no string is found which contains
        // character then it will throw NoSuchElementException
        // System.out.println(name.orElse("Not found")); // if no string is found which
        // contains character then it will print "Not Found"

        String name = names.stream()
                .filter(str -> str.contains("d")).findFirst().orElse("Not Found");
        System.out.println(name);
    }
}
