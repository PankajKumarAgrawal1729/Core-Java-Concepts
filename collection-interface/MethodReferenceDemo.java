import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceDemo {
public static void main(String[] args) {
    List<String> names = Arrays.asList("radha", "krishna", "sita", "ram");

    // List<String> uNames = names.stream().map(String::toUpperCase).toList(); // work in java16 and upper

    // List<String> uNames = names.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());

    // here we pass toUpperCase as method reference  which is equivalent of lambda expression  className::methodName     
    // Using method reference to simplify the code

    List<String> uNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
    System.out.println(uNames);

    uNames.forEach(System.out::println);
}    
}
