import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student{
    private String name;
    private int age;
    
    public Student(String name) {  
        this.name = name;  
    }

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
    
}

public class ConstructorReferenceDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("radha", "krishna", "sita", "ram");

        List<Student> students = new ArrayList<>();

        // for(String name : names){
        //     students.add(new Student(name));
        // }

        // students = names.stream().map(name -> new Student(name))
        //                     .collect(Collectors.toList());

        students = names.stream().map(Student::new).collect(Collectors.toList());  // Constructor reference way of doing it

        System.out.println(students);
    }
}

class MyClass {

    private final int myVariable;
    
    {
    
    myVariable = 10;
    
    }
    
    }