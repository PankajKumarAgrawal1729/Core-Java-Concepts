import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> student = new HashMap<>();  // not - synchronize(or asynchronize)
        // Map<String, Integer> student = new Hashtable()<>();  //  synchronize(thread safe)

        student.put("Abc", 45);
        student.put("xyz", 34);
        student.put("pqr", 45);
        student.put("pga", 94);

        System.out.println(student);

        System.out.println(student.get("pga"));

        for(String key : student.keySet()){
            System.out.println(student.get(key));
        }
    }
}
