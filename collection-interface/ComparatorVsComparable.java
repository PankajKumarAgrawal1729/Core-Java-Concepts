import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    int age;
    String name;
    Student(int age, String name){
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }

    
    public int compareTo(Student that){
        if(this.age > that.age){
            return 1;
        }
        return -1;
    }
    
}

public class ComparatorVsComparable {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(); // if we can't mention type then they are of Object type

        nums.add(17);
        nums.add(42);
        nums.add(32);
        nums.add(46);

        System.out.println("Before Sort: " + nums);

        // sort on the basis of last digit
        Collections.sort(nums, new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {
                if ((a % 10) > (b % 10)) {
                    return 1;
                }
                return -1;
            }
        });

        System.out.println("After Sort: " + nums);


        List<String> leafs = new ArrayList<>();
        leafs.add("Naruto");
        leafs.add("Sasuke");
        leafs.add("Sakura");
        leafs.add("Kakashi");
        
        // sorting based on length of string
        Collections.sort(leafs, new Comparator<String>() {
            public int compare(String s1, String s2){
                if(s1.length() > s2.length()){
                    return 1;
                }
                return -1;
            }
        });

        System.out.println(leafs);

        List<Student> students = new ArrayList<>();
        students.add(new Student(12, "Naruto"));
        students.add(new Student(13, "Sasuke"));
        students.add(new Student(12, "Sakura"));
        students.add(new Student(17, "Sai"));

        // Collections.sort(students, new Comparator<Student>() {
        //     @Override
        //     public int compare(Student s1, Student s2){
        //         if(s1.age > s2.age){
        //             return 1;
        //         }
        //         return -1;
        //     }
        // });

        Collections.sort(students);

        System.out.println(students);
    }
}
