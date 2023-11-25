class Human {

    // encapsulate the variable and only access by methods
    private int age;
    private String name;

    // getter : methos who give the value
    public int getAge() {
        return age;
    }

    // setter : method who set the value
    public void setAge(int age) {
        //this is a keyword and it represent hte current calling object
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        Human obj = new Human();
        obj.setAge(24);
        obj.setName("Ram");
        System.out.println(obj.getName() + " : " + obj.getAge());
    }
}

// Encapsulation in Java is a concept that combines data and the methods that
// manipulate that data into a single unit, typically a class. It helps in
// protecting the data from outside interference and misuse by restricting
// direct access to it, promoting data integrity and security.
